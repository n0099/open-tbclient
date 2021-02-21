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
    private com.baidu.live.liveroom.a.a htV;
    private a htW;
    public FrameLayout htX;
    public FrameLayout htY;
    private AlphaGradientHListView htZ;
    private String hua;
    private boolean hub;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private int hsz = a.C0195a.anim_fade_in_and_out;
    private AdapterView.c huc = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            u uVar = (u) c.this.htW.getItem(i);
            if (uVar != null && uVar.aId.disableClick == 0) {
                if (c.this.htV != null) {
                    c.this.htV.dF(5);
                }
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(uVar.aId.userId), uVar.aId.userName, uVar.aId.portrait, uVar.aId.sex, uVar.aId.levelId, null, null, 0L, uVar.aId.fansCount, uVar.aId.followCount, uVar.aId.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.hub, c.this.hua, uVar.aId.appId, uVar.aId.userName);
                alaPersonCardActivityConfig.setOtherParams(c.this.otherParams);
                alaPersonCardActivityConfig.setExtInfo(uVar.aId.extInfoJson);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aDd.mLiveInfo.feed_id, i, c.this.Lo());
            }
        }
    };
    CustomMessageListener gNG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.htV = aVar;
        this.hub = z;
        MessageManager.getInstance().registerListener(this.gNG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, ab abVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.hua = str3;
        this.aDd = abVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.htX == null) {
                this.htX = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.bRb != null && this.bRb.indexOfChild(this.htX) > 0) {
                this.bRb.removeView(this.htX);
            }
            this.bRb = viewGroup;
            this.htX.setId(a.f.ala_liveroom_audience);
            this.htY = (FrameLayout) this.htX.findViewById(a.f.content_layout);
            this.htZ = (AlphaGradientHListView) this.htX.findViewById(a.f.ala_live_guest_listview);
            this.htZ.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds0));
            this.htW = new a(getPageContext().getPageActivity());
            this.htZ.setAdapter((ListAdapter) this.htW);
            this.htZ.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.htZ.setOnItemClickListener(this.huc);
            this.htZ.setColor(getPageContext().getResources().getColor(a.c.sdk_white_alpha100), getPageContext().getResources().getColor(a.c.sdk_white_alpha0));
            this.htZ.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            ccx();
            this.bRb.addView(this.htX, layoutParams);
        }
    }

    public void cr(int i) {
    }

    public void e(v vVar) {
        if (this.htW != null) {
            this.htW.d(vVar);
            this.htW.notifyDataSetChanged();
        }
    }

    public boolean c(u uVar) {
        if (this.htW == null || !this.htW.b(uVar)) {
            return false;
        }
        this.htW.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gNG);
    }

    public String Lo() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void ccx() {
        if (this.htZ != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), this.hsz);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.htZ.setAnimation(loadAnimation);
        }
    }
}
