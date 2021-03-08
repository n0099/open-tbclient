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
import com.baidu.live.data.ab;
import com.baidu.live.data.au;
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
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.ag.b {
    private TBLottieAnimationView hgB;
    private PendantChildView ijD;
    private ImageView ijE;
    private int ijG;
    private au ijH;
    private Context mContext;
    private String otherParams;
    private boolean gNH = true;
    private boolean ijF = false;
    private HttpMessageListener ijt = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    au auVar = liveFlowerTaskRewardResponsedMessage.ijq;
                    if (auVar == null) {
                        a.this.pj(false);
                    } else if (a.this.ijH != null) {
                        a.this.ijH.aPp = auVar.aPp;
                        a.this.ijH.aPq = auVar.aPq;
                        a.this.a(a.this.ijH.aPp, a.this.ijH);
                    } else {
                        a.this.a(auVar.aPp, auVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener ijI = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.ijD.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private Animator.AnimatorListener ijJ = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.6
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
            if (!a.this.ijF) {
                a.this.ijF = true;
                a.this.hgB.setMinFrame(31);
                a.this.hgB.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_task_view, (ViewGroup) null);
        this.ijD = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.taskview.a.1
            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPkPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalBBChattingPosition() {
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
        this.ijD.addView(inflate);
        this.ijE = (ImageView) this.ijD.findViewById(a.f.alaFlowerImg);
        this.hgB = (TBLottieAnimationView) this.ijD.findViewById(a.f.animation_view);
        this.hgB.setAnimation("flower_entry.json");
        this.hgB.setImageAssetsFolder("images/");
        this.hgB.setVisibility(4);
        this.hgB.addAnimatorListener(this.ijJ);
        cps();
        MessageManager.getInstance().registerListener(this.ijt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
    }

    @Override // com.baidu.live.ag.b
    public PendantChildView Ty() {
        return this.ijD;
    }

    @Override // com.baidu.live.ag.b
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Lr() {
        return this.otherParams;
    }

    private void cps() {
        this.ijD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                    alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                    alaStaticItem.addParams("other_params", a.this.Lr());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                a.this.cpu();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.cpr();
                }
            }
        });
    }

    @Override // com.baidu.live.ag.b
    public void j(ab abVar) {
    }

    @Override // com.baidu.live.ag.b
    public void ad(JSONObject jSONObject) {
    }

    @Override // com.baidu.live.ag.b
    public void setCanVisible(boolean z) {
        this.gNH = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, au auVar) {
        if (i >= 1 && i <= 3) {
            this.ijG = i;
        }
        if (auVar != null) {
            if (!ListUtils.isEmpty(auVar.aPq)) {
                if (this.ijG == 2 || auVar.Cu()) {
                    if (this.gNH) {
                        this.ijD.setVisibility(0);
                        pj(true);
                        cpv();
                        cpt();
                        return;
                    }
                    pj(false);
                    return;
                }
                pj(false);
                return;
            }
            pj(false);
            return;
        }
        pj(false);
    }

    private void cpt() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpu() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void cpv() {
        if (TbConfig.FLOWER_GUIDE_STATUS == 1) {
            this.ijD.post(new Runnable() { // from class: com.baidu.tieba.ala.taskview.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ijD.getLocationOnScreen(r0);
                    int[] iArr = {iArr[0] + (a.this.ijD.getWidth() / 2), iArr[1] + (a.this.ijD.getHeight() / 2)};
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913110, iArr));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pj(boolean z) {
        if (z) {
            if (!this.hgB.isAnimating()) {
                this.hgB.cancelAnimation();
                this.hgB.loop(true);
                this.hgB.setMinFrame(0);
                this.hgB.setMaxFrame(80);
                this.hgB.addAnimatorListener(this.ijJ);
                this.hgB.removeAnimatorListener(this.ijI);
                this.hgB.playAnimation();
                this.ijF = false;
            }
        } else if (this.hgB.isAnimating()) {
            this.hgB.cancelAnimation();
            this.hgB.loop(false);
            this.hgB.addAnimatorListener(this.ijI);
            this.hgB.removeAnimatorListener(this.ijJ);
            this.hgB.setMaxFrame(95);
            this.hgB.setMinFrame(80);
            this.hgB.playAnimation();
        } else {
            this.hgB.cancelAnimation();
            this.ijD.setVisibility(8);
        }
    }

    private void wE(int i) {
        if (i == 8) {
            this.ijE.setImageResource(a.e.icon_liveshow_flowerless);
            this.ijE.setVisibility(0);
            this.hgB.setVisibility(4);
        } else if (i == 0) {
            this.ijE.setImageResource(a.e.icon_liveshow_flower);
            this.ijE.setVisibility(4);
            this.hgB.setVisibility(0);
        }
    }

    @Override // com.baidu.live.ag.b
    public void Tz() {
        if (!TbadkCoreApplication.isLogin()) {
            wE(8);
        } else {
            wE(0);
        }
    }

    @Override // com.baidu.live.ag.b
    public void TA() {
        this.ijH = null;
        if (this.hgB != null) {
            this.hgB.cancelAnimation();
        }
    }

    @Override // com.baidu.live.ag.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ijt);
    }
}
