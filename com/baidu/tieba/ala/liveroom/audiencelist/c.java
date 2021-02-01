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
import com.baidu.live.data.ab;
import com.baidu.live.data.u;
import com.baidu.live.data.v;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
/* loaded from: classes11.dex */
public class c {
    private ab aDd;
    private ViewGroup bRb;
    private com.baidu.live.liveroom.a.a htH;
    private a htI;
    public FrameLayout htJ;
    public FrameLayout htK;
    private AlphaGradientHListView htL;
    private String htM;
    private boolean htN;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private int hsl = a.C0195a.anim_fade_in_and_out;
    private AdapterView.c htO = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            u uVar = (u) c.this.htI.getItem(i);
            if (uVar != null && uVar.aId.disableClick == 0) {
                if (c.this.htH != null) {
                    c.this.htH.dF(5);
                }
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(uVar.aId.userId), uVar.aId.userName, uVar.aId.portrait, uVar.aId.sex, uVar.aId.levelId, null, null, 0L, uVar.aId.fansCount, uVar.aId.followCount, uVar.aId.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.htN, c.this.htM, uVar.aId.appId, uVar.aId.userName);
                alaPersonCardActivityConfig.setOtherParams(c.this.otherParams);
                alaPersonCardActivityConfig.setExtInfo(uVar.aId.extInfoJson);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aDd.mLiveInfo.feed_id, i, c.this.Lo());
            }
        }
    };
    CustomMessageListener gNs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.htH = aVar;
        this.htN = z;
        MessageManager.getInstance().registerListener(this.gNs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, ab abVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.htM = str3;
        this.aDd = abVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.htJ == null) {
                this.htJ = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.bRb != null && this.bRb.indexOfChild(this.htJ) > 0) {
                this.bRb.removeView(this.htJ);
            }
            this.bRb = viewGroup;
            this.htJ.setId(a.f.ala_liveroom_audience);
            this.htK = (FrameLayout) this.htJ.findViewById(a.f.content_layout);
            this.htL = (AlphaGradientHListView) this.htJ.findViewById(a.f.ala_live_guest_listview);
            this.htL.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds0));
            this.htI = new a(getPageContext().getPageActivity());
            this.htL.setAdapter((ListAdapter) this.htI);
            this.htL.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.htL.setOnItemClickListener(this.htO);
            this.htL.setColor(getPageContext().getResources().getColor(a.c.sdk_white_alpha100), getPageContext().getResources().getColor(a.c.sdk_white_alpha0));
            this.htL.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            ccq();
            this.bRb.addView(this.htJ, layoutParams);
        }
    }

    public void cr(int i) {
    }

    public void e(v vVar) {
        if (this.htI != null) {
            this.htI.d(vVar);
            this.htI.notifyDataSetChanged();
        }
    }

    public boolean c(u uVar) {
        if (this.htI == null || !this.htI.b(uVar)) {
            return false;
        }
        this.htI.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gNs);
    }

    public String Lo() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void ccq() {
        if (this.htL != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), this.hsl);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.htL.setAnimation(loadAnimation);
        }
    }
}
