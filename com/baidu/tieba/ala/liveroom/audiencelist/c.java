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
/* loaded from: classes10.dex */
public class c {
    private ab aED;
    private ViewGroup bSB;
    private com.baidu.live.liveroom.a.a hvE;
    private a hvF;
    public FrameLayout hvG;
    public FrameLayout hvH;
    private AlphaGradientHListView hvI;
    private String hvJ;
    private boolean hvK;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private int hui = a.C0201a.anim_fade_in_and_out;
    private AdapterView.c hvL = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            u uVar = (u) c.this.hvF.getItem(i);
            if (uVar != null && uVar.aJD.disableClick == 0) {
                if (c.this.hvE != null) {
                    c.this.hvE.dG(5);
                }
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(uVar.aJD.userId), uVar.aJD.userName, uVar.aJD.portrait, uVar.aJD.sex, uVar.aJD.levelId, null, null, 0L, uVar.aJD.fansCount, uVar.aJD.followCount, uVar.aJD.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.hvK, c.this.hvJ, uVar.aJD.appId, uVar.aJD.userName);
                alaPersonCardActivityConfig.setOtherParams(c.this.otherParams);
                alaPersonCardActivityConfig.setExtInfo(uVar.aJD.extInfoJson);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aED.mLiveInfo.feed_id, i, c.this.Lr());
            }
        }
    };
    CustomMessageListener gPp = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.hvE = aVar;
        this.hvK = z;
        MessageManager.getInstance().registerListener(this.gPp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, ab abVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.hvJ = str3;
        this.aED = abVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.hvG == null) {
                this.hvG = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.bSB != null && this.bSB.indexOfChild(this.hvG) > 0) {
                this.bSB.removeView(this.hvG);
            }
            this.bSB = viewGroup;
            this.hvG.setId(a.f.ala_liveroom_audience);
            this.hvH = (FrameLayout) this.hvG.findViewById(a.f.content_layout);
            this.hvI = (AlphaGradientHListView) this.hvG.findViewById(a.f.ala_live_guest_listview);
            this.hvI.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds0));
            this.hvF = new a(getPageContext().getPageActivity());
            this.hvI.setAdapter((ListAdapter) this.hvF);
            this.hvI.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.hvI.setOnItemClickListener(this.hvL);
            this.hvI.setColor(getPageContext().getResources().getColor(a.c.sdk_white_alpha100), getPageContext().getResources().getColor(a.c.sdk_white_alpha0));
            this.hvI.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            ccD();
            this.bSB.addView(this.hvG, layoutParams);
        }
    }

    public void cs(int i) {
    }

    public void e(v vVar) {
        if (this.hvF != null) {
            this.hvF.d(vVar);
            this.hvF.notifyDataSetChanged();
        }
    }

    public boolean c(u uVar) {
        if (this.hvF == null || !this.hvF.b(uVar)) {
            return false;
        }
        this.hvF.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gPp);
    }

    public String Lr() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void ccD() {
        if (this.hvI != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), this.hui);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.hvI.setAnimation(loadAnimation);
        }
    }
}
