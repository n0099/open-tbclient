package com.baidu.tieba.ala.liveroom.audiencelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.p;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
/* loaded from: classes4.dex */
public class c {
    private w aEc;
    private ViewGroup bEg;
    private com.baidu.live.liveroom.a.a gSJ;
    private a gSK;
    public FrameLayout gSL;
    public FrameLayout gSM;
    private AlphaGradientHListView gSN;
    private String gSO;
    private boolean gSP;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private int gRz = a.C0195a.anim_fade_in_and_out;
    private AdapterView.c gSQ = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            p pVar = (p) c.this.gSK.getItem(i);
            if (pVar != null) {
                if (c.this.gSJ != null) {
                    c.this.gSJ.eO(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(pVar.aIe.userId), pVar.aIe.userName, pVar.aIe.portrait, pVar.aIe.sex, pVar.aIe.levelId, null, null, 0L, pVar.aIe.fansCount, pVar.aIe.followCount, pVar.aIe.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.gSP, c.this.gSO, pVar.aIe.appId, pVar.aIe.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aEc.mLiveInfo.feed_id, i, c.this.Md());
            }
        }
    };
    CustomMessageListener gpA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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

    public c(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.gSJ = aVar;
        this.gSP = z;
        MessageManager.getInstance().registerListener(this.gpA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, w wVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.gSO = str3;
        this.aEc = wVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.gSL == null) {
                this.gSL = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.bEg != null && this.bEg.indexOfChild(this.gSL) > 0) {
                this.bEg.removeView(this.gSL);
            }
            this.bEg = viewGroup;
            this.gSL.setId(a.g.ala_liveroom_audience);
            this.gSM = (FrameLayout) this.gSL.findViewById(a.g.content_layout);
            this.gSN = (AlphaGradientHListView) this.gSL.findViewById(a.g.ala_live_guest_listview);
            this.gSN.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds0));
            this.gSK = new a(getPageContext().getPageActivity());
            this.gSN.setAdapter((ListAdapter) this.gSK);
            this.gSN.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.gSN.setOnItemClickListener(this.gSQ);
            this.gSN.setColor(getPageContext().getResources().getColor(a.d.sdk_white_alpha100), getPageContext().getResources().getColor(a.d.sdk_white_alpha0));
            this.gSN.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            bWF();
            this.bEg.addView(this.gSL, layoutParams);
        }
    }

    public void dI(int i) {
    }

    public void e(q qVar) {
        if (this.gSK != null) {
            this.gSK.d(qVar);
            this.gSK.notifyDataSetChanged();
        }
    }

    public boolean c(p pVar) {
        if (this.gSK == null || !this.gSK.b(pVar)) {
            return false;
        }
        this.gSK.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gpA);
    }

    public String Md() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void bWF() {
        if (this.gSN != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), this.gRz);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.gSN.setAnimation(loadAnimation);
        }
    }
}
