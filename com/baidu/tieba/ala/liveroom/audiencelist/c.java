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
    private w aFN;
    private ViewGroup bNk;
    private com.baidu.live.liveroom.a.a hig;
    private a hih;
    public FrameLayout hii;
    public FrameLayout hij;
    private AlphaGradientHListView hik;
    private String hil;
    private boolean him;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private int hgR = a.C0205a.anim_fade_in_and_out;
    private AdapterView.c hin = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            p pVar = (p) c.this.hih.getItem(i);
            if (pVar != null && pVar.aJV.disableClick == 0) {
                if (c.this.hig != null) {
                    c.this.hig.fh(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(pVar.aJV.userId), pVar.aJV.userName, pVar.aJV.portrait, pVar.aJV.sex, pVar.aJV.levelId, null, null, 0L, pVar.aJV.fansCount, pVar.aJV.followCount, pVar.aJV.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.him, c.this.hil, pVar.aJV.appId, pVar.aJV.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aFN.mLiveInfo.feed_id, i, c.this.Oj());
            }
        }
    };
    CustomMessageListener gDG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.hig = aVar;
        this.him = z;
        MessageManager.getInstance().registerListener(this.gDG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, w wVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.hil = str3;
        this.aFN = wVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.hii == null) {
                this.hii = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.bNk != null && this.bNk.indexOfChild(this.hii) > 0) {
                this.bNk.removeView(this.hii);
            }
            this.bNk = viewGroup;
            this.hii.setId(a.f.ala_liveroom_audience);
            this.hij = (FrameLayout) this.hii.findViewById(a.f.content_layout);
            this.hik = (AlphaGradientHListView) this.hii.findViewById(a.f.ala_live_guest_listview);
            this.hik.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds0));
            this.hih = new a(getPageContext().getPageActivity());
            this.hik.setAdapter((ListAdapter) this.hih);
            this.hik.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.hik.setOnItemClickListener(this.hin);
            this.hik.setColor(getPageContext().getResources().getColor(a.c.sdk_white_alpha100), getPageContext().getResources().getColor(a.c.sdk_white_alpha0));
            this.hik.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            ccw();
            this.bNk.addView(this.hii, layoutParams);
        }
    }

    public void dX(int i) {
    }

    public void e(q qVar) {
        if (this.hih != null) {
            this.hih.d(qVar);
            this.hih.notifyDataSetChanged();
        }
    }

    public boolean c(p pVar) {
        if (this.hih == null || !this.hih.b(pVar)) {
            return false;
        }
        this.hih.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gDG);
    }

    public String Oj() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void ccw() {
        if (this.hik != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), this.hgR);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.hik.setAnimation(loadAnimation);
        }
    }
}
