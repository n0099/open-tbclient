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
import com.baidu.live.data.m;
import com.baidu.live.data.n;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
/* loaded from: classes4.dex */
public class c {
    private u aDU;
    private ViewGroup bBk;
    private com.baidu.live.liveroom.a.a gGU;
    private a gGV;
    public FrameLayout gGW;
    public FrameLayout gGX;
    private AlphaGradientHListView gGY;
    private String gGZ;
    private boolean gHa;
    private AdapterView.c gHb = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            m mVar = (m) c.this.gGV.getItem(i);
            if (mVar != null) {
                if (c.this.gGU != null) {
                    c.this.gGU.eL(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(mVar.aHD.userId), mVar.aHD.userName, mVar.aHD.portrait, mVar.aHD.sex, mVar.aHD.levelId, null, null, 0L, mVar.aHD.fansCount, mVar.aHD.followCount, mVar.aHD.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.gHa, c.this.gGZ, mVar.aHD.appId, mVar.aHD.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aDU.mLiveInfo.feed_id, i, c.this.LI());
            }
        }
    };
    CustomMessageListener gfx = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.gGU = aVar;
        this.gHa = z;
        MessageManager.getInstance().registerListener(this.gfx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, u uVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.gGZ = str3;
        this.aDU = uVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.gGW == null) {
                this.gGW = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.bBk != null && this.bBk.indexOfChild(this.gGW) > 0) {
                this.bBk.removeView(this.gGW);
            }
            this.bBk = viewGroup;
            this.gGW.setId(a.g.ala_liveroom_audience);
            this.gGX = (FrameLayout) this.gGW.findViewById(a.g.content_layout);
            this.gGY = (AlphaGradientHListView) this.gGW.findViewById(a.g.ala_live_guest_listview);
            this.gGY.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.gGV = new a(getPageContext().getPageActivity());
            this.gGY.setAdapter((ListAdapter) this.gGV);
            this.gGY.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.gGY.setOnItemClickListener(this.gHb);
            this.gGY.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.gGY.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            this.bBk.addView(this.gGW, layoutParams);
        }
    }

    public void dI(int i) {
    }

    public void e(n nVar) {
        if (this.gGV != null) {
            this.gGV.d(nVar);
            this.gGV.notifyDataSetChanged();
        }
    }

    public boolean c(m mVar) {
        if (this.gGV == null || !this.gGV.b(mVar)) {
            return false;
        }
        this.gGV.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gfx);
    }

    public String LI() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
