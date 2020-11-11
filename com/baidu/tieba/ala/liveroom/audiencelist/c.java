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
    private w aES;
    private ViewGroup bJN;
    private com.baidu.live.liveroom.a.a gYO;
    private a gYP;
    public FrameLayout gYQ;
    public FrameLayout gYR;
    private AlphaGradientHListView gYS;
    private String gYT;
    private boolean gYU;
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private int gXF = a.C0197a.anim_fade_in_and_out;
    private AdapterView.c gYV = new AdapterView.c() { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.1
        @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            p pVar = (p) c.this.gYP.getItem(i);
            if (pVar != null && pVar.aIV.disableClick == 0) {
                if (c.this.gYO != null) {
                    c.this.gYO.eO(5);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(c.this.getPageContext().getPageActivity(), String.valueOf(pVar.aIV.userId), pVar.aIV.userName, pVar.aIV.portrait, pVar.aIV.sex, pVar.aIV.levelId, null, null, 0L, pVar.aIV.fansCount, pVar.aIV.followCount, pVar.aIV.userStatus, c.this.mGroupId, c.this.mLiveId, c.this.gYU, c.this.gYT, pVar.aIV.appId, pVar.aIV.userName, c.this.otherParams)));
                LogManager.getCommonLogger().doClickTopRightAuthorLog(c.this.aES.mLiveInfo.feed_id, i, c.this.MD());
            }
        }
    };
    CustomMessageListener gvo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.audiencelist.c.2
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
        this.gYO = aVar;
        this.gYU = z;
        MessageManager.getInstance().registerListener(this.gvo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    public void a(String str, String str2, String str3, w wVar) {
        this.mGroupId = str;
        this.mLiveId = str2;
        this.gYT = str3;
        this.aES = wVar;
    }

    public void c(ViewGroup viewGroup, int i, int i2) {
        if (viewGroup != null) {
            if (this.gYQ == null) {
                this.gYQ = (FrameLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_audience_list_layout, (ViewGroup) null);
            }
            if (this.bJN != null && this.bJN.indexOfChild(this.gYQ) > 0) {
                this.bJN.removeView(this.gYQ);
            }
            this.bJN = viewGroup;
            this.gYQ.setId(a.f.ala_liveroom_audience);
            this.gYR = (FrameLayout) this.gYQ.findViewById(a.f.content_layout);
            this.gYS = (AlphaGradientHListView) this.gYQ.findViewById(a.f.ala_live_guest_listview);
            this.gYS.setDividerWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds0));
            this.gYP = new a(getPageContext().getPageActivity());
            this.gYS.setAdapter((ListAdapter) this.gYP);
            this.gYS.setSelector(getPageContext().getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.gYS.setOnItemClickListener(this.gYV);
            this.gYS.setColor(getPageContext().getResources().getColor(a.c.sdk_white_alpha100), getPageContext().getResources().getColor(a.c.sdk_white_alpha0));
            this.gYS.setNeedAlphaShade(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds82));
            layoutParams.addRule(1, i);
            layoutParams.addRule(8, i);
            layoutParams.addRule(0, i2);
            layoutParams.leftMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds10);
            layoutParams.rightMargin = BdUtilHelper.dip2px(getPageContext().getPageActivity(), -6.0f);
            bZh();
            this.bJN.addView(this.gYQ, layoutParams);
        }
    }

    public void dI(int i) {
    }

    public void e(q qVar) {
        if (this.gYP != null) {
            this.gYP.d(qVar);
            this.gYP.notifyDataSetChanged();
        }
    }

    public boolean c(p pVar) {
        if (this.gYP == null || !this.gYP.b(pVar)) {
            return false;
        }
        this.gYP.notifyDataSetChanged();
        return true;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gvo);
    }

    public String MD() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void bZh() {
        if (this.gYS != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), this.gXF);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            this.gYS.setAnimation(loadAnimation);
        }
    }
}
