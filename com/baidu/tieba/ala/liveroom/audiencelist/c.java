package com.baidu.tieba.ala.liveroom.audiencelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.d;
import com.baidu.live.data.e;
import com.baidu.live.data.i;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
/* loaded from: classes6.dex */
public class c {
    private i aaj;
    private com.baidu.tieba.ala.liveroom.b dXZ;
    private a dYa;
    public FrameLayout dYb;
    private AlphaGradientHListView dYc;
    private String dYd;
    private ViewGroup dYe;
    private boolean dYf;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private AdapterView.c dYg = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) c.this.dYa.getItem(i);
            if (dVar != null) {
                if (c.this.dXZ != null) {
                    c.this.dXZ.mZ(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(dVar.OR.userId), dVar.OR.userName, dVar.OR.portrait, dVar.OR.sex, dVar.OR.levelId, null, null, 0L, dVar.OR.fansCount, dVar.OR.followCount, dVar.OR.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.dYf, c.this.dYd, dVar.OR.appId, dVar.OR.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aaj.mLiveInfo.feed_id, i, c.this.tn());
            }
        }
    };
    CustomMessageListener dEz = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                c.this.otherParams = str;
            }
        }
    };

    public c(TbPageContext tbPageContext, com.baidu.tieba.ala.liveroom.b bVar, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.dXZ = bVar;
        this.dYf = z;
        MessageManager.getInstance().registerListener(this.dEz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, i iVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.dYd = str3;
        this.aaj = iVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.dYb == null) {
                this.dYb = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.dYe != null && this.dYe.indexOfChild(this.dYb) > 0) {
                this.dYe.removeView(this.dYb);
            }
            this.dYe = viewGroup;
            this.dYb.setId(a.g.ala_liveroom_audience);
            this.dYc = (AlphaGradientHListView) this.dYb.findViewById(a.g.ala_live_guest_listview);
            this.dYc.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.dYa = new a(getPageContext().getPageActivity());
            this.dYc.setAdapter((ListAdapter) this.dYa);
            this.dYc.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.dYc.setOnItemClickListener(this.dYg);
            this.dYc.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.dYc.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.dYe.addView(this.dYb, layoutParams);
        }
    }

    public void bw(int i) {
        if (i != 2 && i == 1) {
        }
    }

    public void e(e eVar) {
        if (this.dYa != null) {
            this.dYa.d(eVar);
            this.dYa.notifyDataSetChanged();
        }
    }

    public boolean c(d dVar) {
        if (this.dYa == null || !this.dYa.b(dVar)) {
            return false;
        }
        this.dYa.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dEz);
    }

    public String tn() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
