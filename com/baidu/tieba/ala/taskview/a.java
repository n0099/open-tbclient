package com.baidu.tieba.ala.taskview;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.ad;
import com.baidu.live.data.ae;
import com.baidu.live.data.r;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.ala.tasklist.model.LiveFlowerTaskRewardResponsedMessage;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements com.baidu.live.y.b {
    private r aAh;
    private int gZB;
    private ae gZC;
    private PendantChildView gZx;
    private ImageView gZy;
    private TBLottieAnimationView gZz;
    private Context mContext;
    private String otherParams;
    private boolean fOn = true;
    private boolean gZA = false;
    private HttpMessageListener gZn = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    ae aeVar = liveFlowerTaskRewardResponsedMessage.gZk;
                    if (aeVar == null) {
                        a.this.mW(false);
                    } else if (a.this.gZC != null) {
                        a.this.gZC.aHF = aeVar.aHF;
                        a.this.gZC.aHG = aeVar.aHG;
                        a.this.a(a.this.gZC.aHF, a.this.gZC);
                    } else {
                        a.this.a(aeVar.aHF, aeVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener gZD = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.gZx.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private Animator.AnimatorListener gZE = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.6
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (!a.this.gZA) {
                a.this.gZA = true;
                a.this.gZz.setMinFrame(31);
                a.this.gZz.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.gZx = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.taskview.a.1
            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPkPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getHorizontalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getHorizontalFullPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public int getPriority() {
                return 40;
            }
        };
        this.gZx.addView(inflate);
        this.gZy = (ImageView) this.gZx.findViewById(a.g.alaFlowerImg);
        this.gZz = (TBLottieAnimationView) this.gZx.findViewById(a.g.animation_view);
        this.gZz.setAnimation("flower_entry.json");
        this.gZz.setImageAssetsFolder("images/");
        this.gZz.setVisibility(4);
        this.gZz.addAnimatorListener(this.gZE);
        caf();
        MessageManager.getInstance().registerListener(this.gZn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cae() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
    }

    @Override // com.baidu.live.y.b
    public PendantChildView NC() {
        return this.gZx;
    }

    @Override // com.baidu.live.y.b
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String JY() {
        return this.otherParams;
    }

    private void caf() {
        this.gZx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                    alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                    alaStaticItem.addParams("other_params", a.this.JY());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                a.this.cah();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.cae();
                }
            }
        });
    }

    @Override // com.baidu.live.y.b
    public void j(r rVar) {
        if (rVar == null || rVar.aEn == null) {
            mW(false);
            return;
        }
        this.aAh = rVar;
        this.gZC = rVar.aEn;
        a(this.gZC.aHF, this.gZC);
    }

    @Override // com.baidu.live.y.b
    public void N(JSONObject jSONObject) {
        if (jSONObject == null) {
            mW(false);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
        ad adVar = new ad();
        if (optJSONObject != null) {
            adVar.parseJson(optJSONObject);
        }
        a(adVar.status, adVar);
    }

    @Override // com.baidu.live.y.b
    public void setCanVisible(boolean z) {
        this.fOn = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ae aeVar) {
        if (i >= 1 && i <= 3) {
            this.gZB = i;
        }
        if (aeVar != null) {
            if (!ListUtils.isEmpty(aeVar.aHG)) {
                if (this.gZB == 2 || aeVar.CP()) {
                    if (this.fOn) {
                        this.gZx.setVisibility(0);
                        mW(true);
                        cai();
                        cag();
                        return;
                    }
                    mW(false);
                    return;
                }
                mW(false);
                return;
            }
            mW(false);
            return;
        }
        mW(false);
    }

    private void a(int i, ad adVar) {
        if (i >= 1 && i <= 3) {
            this.gZB = i;
        }
        if (this.gZC != null) {
            this.gZC.aHF = this.gZB;
            if (this.gZC.aHG != null && adVar != null) {
                Iterator<ad> it = this.gZC.aHG.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ad next = it.next();
                    if (next.aHy == adVar.aHy) {
                        next.status = adVar.status;
                        break;
                    }
                }
            }
        }
        if (i == 2) {
            if (this.fOn) {
                this.gZx.setVisibility(0);
                mW(true);
                cai();
                cag();
                return;
            }
            mW(false);
            return;
        }
        mW(false);
        if (i == 1 && adVar != null && adVar.CM() && adVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void cag() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cah() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void cai() {
        if (TbConfig.FLOWER_GUIDE_STATUS == 1) {
            this.gZx.post(new Runnable() { // from class: com.baidu.tieba.ala.taskview.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gZx.getLocationOnScreen(r0);
                    int[] iArr = {iArr[0] + (a.this.gZx.getWidth() / 2), iArr[1] + (a.this.gZx.getHeight() / 2)};
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913110, iArr));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mW(boolean z) {
        if (z) {
            if (!this.gZz.isAnimating()) {
                this.gZz.cancelAnimation();
                this.gZz.loop(true);
                this.gZz.setMinFrame(0);
                this.gZz.setMaxFrame(80);
                this.gZz.addAnimatorListener(this.gZE);
                this.gZz.removeAnimatorListener(this.gZD);
                this.gZz.playAnimation();
                this.gZA = false;
            }
        } else if (this.gZz.isAnimating()) {
            this.gZz.cancelAnimation();
            this.gZz.loop(false);
            this.gZz.addAnimatorListener(this.gZD);
            this.gZz.removeAnimatorListener(this.gZE);
            this.gZz.setMaxFrame(95);
            this.gZz.setMinFrame(80);
            this.gZz.playAnimation();
        } else {
            this.gZz.cancelAnimation();
            this.gZx.setVisibility(8);
        }
    }

    private void vb(int i) {
        if (i == 8) {
            this.gZy.setImageResource(a.f.icon_liveshow_flowerless);
            this.gZy.setVisibility(0);
            this.gZz.setVisibility(4);
        } else if (i == 0) {
            this.gZy.setImageResource(a.f.icon_liveshow_flower);
            this.gZy.setVisibility(4);
            this.gZz.setVisibility(0);
        }
    }

    @Override // com.baidu.live.y.b
    public void ND() {
        if (!TbadkCoreApplication.isLogin()) {
            vb(8);
        } else {
            vb(0);
        }
    }

    @Override // com.baidu.live.y.b
    public void NE() {
        this.gZC = null;
        if (this.gZz != null) {
            this.gZz.cancelAnimation();
        }
    }

    @Override // com.baidu.live.y.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gZn);
    }
}
