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
import com.baidu.live.data.f;
import com.baidu.live.data.g;
import com.baidu.live.data.k;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
/* loaded from: classes2.dex */
public class c {
    private k aio;
    private com.baidu.tieba.ala.liveroom.b eNX;
    private a eNY;
    public FrameLayout eNZ;
    private AlphaGradientHListView eOa;
    private String eOb;
    private boolean eOc;
    private ViewGroup eqG;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private AdapterView.c eOd = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            f fVar = (f) c.this.eNY.getItem(i);
            if (fVar != null) {
                if (c.this.eNX != null) {
                    c.this.eNX.pq(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(fVar.VP.userId), fVar.VP.userName, fVar.VP.portrait, fVar.VP.sex, fVar.VP.levelId, null, null, 0L, fVar.VP.fansCount, fVar.VP.followCount, fVar.VP.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.eOc, c.this.eOb, fVar.VP.appId, fVar.VP.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aio.mLiveInfo.feed_id, i, c.this.vi());
            }
        }
    };
    CustomMessageListener eqn = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.eNX = bVar;
        this.eOc = z;
        MessageManager.getInstance().registerListener(this.eqn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, k kVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.eOb = str3;
        this.aio = kVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.eNZ == null) {
                this.eNZ = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.eqG != null && this.eqG.indexOfChild(this.eNZ) > 0) {
                this.eqG.removeView(this.eNZ);
            }
            this.eqG = viewGroup;
            this.eNZ.setId(a.g.ala_liveroom_audience);
            this.eOa = (AlphaGradientHListView) this.eNZ.findViewById(a.g.ala_live_guest_listview);
            this.eOa.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.eNY = new a(getPageContext().getPageActivity());
            this.eOa.setAdapter((ListAdapter) this.eNY);
            this.eOa.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.eOa.setOnItemClickListener(this.eOd);
            this.eOa.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.eOa.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.eqG.addView(this.eNZ, layoutParams);
        }
    }

    public void bN(int i) {
        if (i != 2 && i == 1) {
        }
    }

    public void f(g gVar) {
        if (this.eNY != null) {
            this.eNY.e(gVar);
            this.eNY.notifyDataSetChanged();
        }
    }

    public boolean c(f fVar) {
        if (this.eNY == null || !this.eNY.b(fVar)) {
            return false;
        }
        this.eNY.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eqn);
    }

    public String vi() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
