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
    private i aaB;
    private com.baidu.tieba.ala.liveroom.b dYQ;
    private a dYR;
    public FrameLayout dYS;
    private AlphaGradientHListView dYT;
    private String dYU;
    private ViewGroup dYV;
    private boolean dYW;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private AdapterView.c dYX = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            d dVar = (d) c.this.dYR.getItem(i);
            if (dVar != null) {
                if (c.this.dYQ != null) {
                    c.this.dYQ.na(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(dVar.Ps.userId), dVar.Ps.userName, dVar.Ps.portrait, dVar.Ps.sex, dVar.Ps.levelId, null, null, 0L, dVar.Ps.fansCount, dVar.Ps.followCount, dVar.Ps.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.dYW, c.this.dYU, dVar.Ps.appId, dVar.Ps.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aaB.mLiveInfo.feed_id, i, c.this.tm());
            }
        }
    };
    CustomMessageListener dFq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.dYQ = bVar;
        this.dYW = z;
        MessageManager.getInstance().registerListener(this.dFq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, i iVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.dYU = str3;
        this.aaB = iVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.dYS == null) {
                this.dYS = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.dYV != null && this.dYV.indexOfChild(this.dYS) > 0) {
                this.dYV.removeView(this.dYS);
            }
            this.dYV = viewGroup;
            this.dYS.setId(a.g.ala_liveroom_audience);
            this.dYT = (AlphaGradientHListView) this.dYS.findViewById(a.g.ala_live_guest_listview);
            this.dYT.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.dYR = new a(getPageContext().getPageActivity());
            this.dYT.setAdapter((ListAdapter) this.dYR);
            this.dYT.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.dYT.setOnItemClickListener(this.dYX);
            this.dYT.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.dYT.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.dYV.addView(this.dYS, layoutParams);
        }
    }

    public void bw(int i) {
        if (i != 2 && i == 1) {
        }
    }

    public void e(e eVar) {
        if (this.dYR != null) {
            this.dYR.d(eVar);
            this.dYR.notifyDataSetChanged();
        }
    }

    public boolean c(d dVar) {
        if (this.dYR == null || !this.dYR.b(dVar)) {
            return false;
        }
        this.dYR.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dFq);
    }

    public String tm() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
