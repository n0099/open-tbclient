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
    private w aDh;
    private ViewGroup bIc;
    private String gYA;
    private boolean gYB;
    private com.baidu.live.liveroom.a.a gYv;
    private a gYw;
    public FrameLayout gYx;
    public FrameLayout gYy;
    private AlphaGradientHListView gYz;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private int gXm = a.C0195a.anim_fade_in_and_out;
    private AdapterView.c gYC = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            p pVar = (p) c.this.gYw.getItem(i);
            if (pVar != null && pVar.aHk.disableClick == 0) {
                if (c.this.gYv != null) {
                    c.this.gYv.eK(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(pVar.aHk.userId), pVar.aHk.userName, pVar.aHk.portrait, pVar.aHk.sex, pVar.aHk.levelId, null, null, 0L, pVar.aHk.fansCount, pVar.aHk.followCount, pVar.aHk.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.gYB, c.this.gYA, pVar.aHk.appId, pVar.aHk.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aDh.mLiveInfo.feed_id, i, c.this.LU());
            }
        }
    };
    CustomMessageListener guV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.gYv = aVar;
        this.gYB = z;
        MessageManager.getInstance().registerListener(this.guV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, w wVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.gYA = str3;
        this.aDh = wVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.gYx == null) {
                this.gYx = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.bIc != null && this.bIc.indexOfChild(this.gYx) > 0) {
                this.bIc.removeView(this.gYx);
            }
            this.bIc = viewGroup;
            this.gYx.setId(a.f.ala_liveroom_audience);
            this.gYy = (FrameLayout) this.gYx.findViewById(a.f.content_layout);
            this.gYz = (AlphaGradientHListView) this.gYx.findViewById(a.f.ala_live_guest_listview);
            this.gYz.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds0));
            this.gYw = new a(getPageContext().getPageActivity());
            this.gYz.setAdapter((ListAdapter) this.gYw);
            this.gYz.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.gYz.setOnItemClickListener(this.gYC);
            this.gYz.setColor(getPageContext().getResources().getColor(a.c.sdk_white_alpha100), getPageContext().getResources().getColor(a.c.sdk_white_alpha0));
            this.gYz.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            bYA();
            this.bIc.addView(this.gYx, layoutParams);
        }
    }

    public void dE(int i) {
    }

    public void e(q qVar) {
        if (this.gYw != null) {
            this.gYw.d(qVar);
            this.gYw.notifyDataSetChanged();
        }
    }

    public boolean c(p pVar) {
        if (this.gYw == null || !this.gYw.b(pVar)) {
            return false;
        }
        this.gYw.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.guV);
    }

    public String LU() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void bYA() {
        if (this.gYz != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), this.gXm);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.gYz.setAnimation(loadAnimation);
        }
    }
}
