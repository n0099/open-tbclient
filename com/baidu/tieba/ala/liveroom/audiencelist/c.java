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
import com.baidu.live.data.q;
import com.baidu.live.data.r;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
/* loaded from: classes10.dex */
public class c {
    private x aBr;
    private ViewGroup bNl;
    private AlphaGradientHListView hpA;
    private String hpB;
    private boolean hpC;
    private com.baidu.live.liveroom.a.a hpw;
    private a hpx;
    public FrameLayout hpy;
    public FrameLayout hpz;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private int hoa = a.C0194a.anim_fade_in_and_out;
    private AdapterView.c hpD = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            q qVar = (q) c.this.hpx.getItem(i);
            if (qVar != null && qVar.aFH.disableClick == 0) {
                if (c.this.hpw != null) {
                    c.this.hpw.dz(5);
                }
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(qVar.aFH.userId), qVar.aFH.userName, qVar.aFH.portrait, qVar.aFH.sex, qVar.aFH.levelId, null, null, 0L, qVar.aFH.fansCount, qVar.aFH.followCount, qVar.aFH.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.hpC, c.this.hpB, qVar.aFH.appId, qVar.aFH.userName);
                alaPersonCardActivityConfig.setOtherParams(c.this.otherParams);
                alaPersonCardActivityConfig.setExtInfo(qVar.aFH.extInfoJson);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aBr.mLiveInfo.feed_id, i, c.this.JQ());
            }
        }
    };
    CustomMessageListener gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.hpw = aVar;
        this.hpC = z;
        MessageManager.getInstance().registerListener(this.gKM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, x xVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.hpB = str3;
        this.aBr = xVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.hpy == null) {
                this.hpy = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.bNl != null && this.bNl.indexOfChild(this.hpy) > 0) {
                this.bNl.removeView(this.hpy);
            }
            this.bNl = viewGroup;
            this.hpy.setId(a.f.ala_liveroom_audience);
            this.hpz = (FrameLayout) this.hpy.findViewById(a.f.content_layout);
            this.hpA = (AlphaGradientHListView) this.hpy.findViewById(a.f.ala_live_guest_listview);
            this.hpA.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds0));
            this.hpx = new a(getPageContext().getPageActivity());
            this.hpA.setAdapter((ListAdapter) this.hpx);
            this.hpA.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.hpA.setOnItemClickListener(this.hpD);
            this.hpA.setColor(getPageContext().getResources().getColor(a.c.sdk_white_alpha100), getPageContext().getResources().getColor(a.c.sdk_white_alpha0));
            this.hpA.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            cbv();
            this.bNl.addView(this.hpy, layoutParams);
        }
    }

    public void co(int i) {
    }

    public void e(r rVar) {
        if (this.hpx != null) {
            this.hpx.d(rVar);
            this.hpx.notifyDataSetChanged();
        }
    }

    public boolean c(q qVar) {
        if (this.hpx == null || !this.hpx.b(qVar)) {
            return false;
        }
        this.hpx.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gKM);
    }

    public String JQ() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void cbv() {
        if (this.hpA != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), this.hoa);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.hpA.setAnimation(loadAnimation);
        }
    }
}
