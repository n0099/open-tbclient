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
    private r aAj;
    private PendantChildView gZB;
    private ImageView gZC;
    private TBLottieAnimationView gZD;
    private int gZF;
    private ae gZG;
    private Context mContext;
    private String otherParams;
    private boolean fOr = true;
    private boolean gZE = false;
    private HttpMessageListener gZr = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    ae aeVar = liveFlowerTaskRewardResponsedMessage.gZo;
                    if (aeVar == null) {
                        a.this.mY(false);
                    } else if (a.this.gZG != null) {
                        a.this.gZG.aHH = aeVar.aHH;
                        a.this.gZG.aHI = aeVar.aHI;
                        a.this.a(a.this.gZG.aHH, a.this.gZG);
                    } else {
                        a.this.a(aeVar.aHH, aeVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener gZH = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.gZB.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private Animator.AnimatorListener gZI = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.6
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
            if (!a.this.gZE) {
                a.this.gZE = true;
                a.this.gZD.setMinFrame(31);
                a.this.gZD.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.gZB = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.taskview.a.1
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
        this.gZB.addView(inflate);
        this.gZC = (ImageView) this.gZB.findViewById(a.g.alaFlowerImg);
        this.gZD = (TBLottieAnimationView) this.gZB.findViewById(a.g.animation_view);
        this.gZD.setAnimation("flower_entry.json");
        this.gZD.setImageAssetsFolder("images/");
        this.gZD.setVisibility(4);
        this.gZD.addAnimatorListener(this.gZI);
        cag();
        MessageManager.getInstance().registerListener(this.gZr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caf() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
    }

    @Override // com.baidu.live.y.b
    public PendantChildView NC() {
        return this.gZB;
    }

    @Override // com.baidu.live.y.b
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String JY() {
        return this.otherParams;
    }

    private void cag() {
        this.gZB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                    alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                    alaStaticItem.addParams("other_params", a.this.JY());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                a.this.cai();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.caf();
                }
            }
        });
    }

    @Override // com.baidu.live.y.b
    public void j(r rVar) {
        if (rVar == null || rVar.aEp == null) {
            mY(false);
            return;
        }
        this.aAj = rVar;
        this.gZG = rVar.aEp;
        a(this.gZG.aHH, this.gZG);
    }

    @Override // com.baidu.live.y.b
    public void N(JSONObject jSONObject) {
        if (jSONObject == null) {
            mY(false);
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
        this.fOr = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ae aeVar) {
        if (i >= 1 && i <= 3) {
            this.gZF = i;
        }
        if (aeVar != null) {
            if (!ListUtils.isEmpty(aeVar.aHI)) {
                if (this.gZF == 2 || aeVar.CP()) {
                    if (this.fOr) {
                        this.gZB.setVisibility(0);
                        mY(true);
                        caj();
                        cah();
                        return;
                    }
                    mY(false);
                    return;
                }
                mY(false);
                return;
            }
            mY(false);
            return;
        }
        mY(false);
    }

    private void a(int i, ad adVar) {
        if (i >= 1 && i <= 3) {
            this.gZF = i;
        }
        if (this.gZG != null) {
            this.gZG.aHH = this.gZF;
            if (this.gZG.aHI != null && adVar != null) {
                Iterator<ad> it = this.gZG.aHI.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ad next = it.next();
                    if (next.aHA == adVar.aHA) {
                        next.status = adVar.status;
                        break;
                    }
                }
            }
        }
        if (i == 2) {
            if (this.fOr) {
                this.gZB.setVisibility(0);
                mY(true);
                caj();
                cah();
                return;
            }
            mY(false);
            return;
        }
        mY(false);
        if (i == 1 && adVar != null && adVar.CM() && adVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void cah() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cai() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void caj() {
        if (TbConfig.FLOWER_GUIDE_STATUS == 1) {
            this.gZB.post(new Runnable() { // from class: com.baidu.tieba.ala.taskview.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gZB.getLocationOnScreen(r0);
                    int[] iArr = {iArr[0] + (a.this.gZB.getWidth() / 2), iArr[1] + (a.this.gZB.getHeight() / 2)};
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913110, iArr));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mY(boolean z) {
        if (z) {
            if (!this.gZD.isAnimating()) {
                this.gZD.cancelAnimation();
                this.gZD.loop(true);
                this.gZD.setMinFrame(0);
                this.gZD.setMaxFrame(80);
                this.gZD.addAnimatorListener(this.gZI);
                this.gZD.removeAnimatorListener(this.gZH);
                this.gZD.playAnimation();
                this.gZE = false;
            }
        } else if (this.gZD.isAnimating()) {
            this.gZD.cancelAnimation();
            this.gZD.loop(false);
            this.gZD.addAnimatorListener(this.gZH);
            this.gZD.removeAnimatorListener(this.gZI);
            this.gZD.setMaxFrame(95);
            this.gZD.setMinFrame(80);
            this.gZD.playAnimation();
        } else {
            this.gZD.cancelAnimation();
            this.gZB.setVisibility(8);
        }
    }

    private void vb(int i) {
        if (i == 8) {
            this.gZC.setImageResource(a.f.icon_liveshow_flowerless);
            this.gZC.setVisibility(0);
            this.gZD.setVisibility(4);
        } else if (i == 0) {
            this.gZC.setImageResource(a.f.icon_liveshow_flower);
            this.gZC.setVisibility(4);
            this.gZD.setVisibility(0);
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
        this.gZG = null;
        if (this.gZD != null) {
            this.gZD.cancelAnimation();
        }
    }

    @Override // com.baidu.live.y.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gZr);
    }
}
