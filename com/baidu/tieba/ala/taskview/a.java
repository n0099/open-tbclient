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
import com.baidu.live.data.an;
import com.baidu.live.data.ao;
import com.baidu.live.data.w;
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
/* loaded from: classes4.dex */
public class a implements com.baidu.live.ah.b {
    private w aFN;
    private TBLottieAnimationView gUM;
    private PendantChildView hUW;
    private ImageView hUX;
    private int hUZ;
    private ao hVa;
    private Context mContext;
    private String otherParams;
    private boolean gBW = true;
    private boolean hUY = false;
    private HttpMessageListener hUM = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    ao aoVar = liveFlowerTaskRewardResponsedMessage.hUJ;
                    if (aoVar == null) {
                        a.this.oE(false);
                    } else if (a.this.hVa != null) {
                        a.this.hVa.aOZ = aoVar.aOZ;
                        a.this.hVa.aPa = aoVar.aPa;
                        a.this.a(a.this.hVa.aOZ, a.this.hVa);
                    } else {
                        a.this.a(aoVar.aOZ, aoVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener hVb = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.hUW.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private Animator.AnimatorListener hVc = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.6
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
            if (!a.this.hUY) {
                a.this.hUY = true;
                a.this.gUM.setMinFrame(31);
                a.this.gUM.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_task_view, (ViewGroup) null);
        this.hUW = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.taskview.a.1
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
        this.hUW.addView(inflate);
        this.hUX = (ImageView) this.hUW.findViewById(a.f.alaFlowerImg);
        this.gUM = (TBLottieAnimationView) this.hUW.findViewById(a.f.animation_view);
        this.gUM.setAnimation("flower_entry.json");
        this.gUM.setImageAssetsFolder("images/");
        this.gUM.setVisibility(4);
        this.gUM.addAnimatorListener(this.hVc);
        coX();
        MessageManager.getInstance().registerListener(this.hUM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coW() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
    }

    @Override // com.baidu.live.ah.b
    public PendantChildView UC() {
        return this.hUW;
    }

    @Override // com.baidu.live.ah.b
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Oj() {
        return this.otherParams;
    }

    private void coX() {
        this.hUW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                    alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                    alaStaticItem.addParams("other_params", a.this.Oj());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                a.this.coZ();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.coW();
                }
            }
        });
    }

    @Override // com.baidu.live.ah.b
    public void i(w wVar) {
        if (wVar == null || wVar.aKF == null) {
            oE(false);
            return;
        }
        this.aFN = wVar;
        this.hVa = wVar.aKF;
        a(this.hVa.aOZ, this.hVa);
    }

    @Override // com.baidu.live.ah.b
    public void R(JSONObject jSONObject) {
        if (jSONObject == null) {
            oE(false);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
        an anVar = new an();
        if (optJSONObject != null) {
            anVar.parseJson(optJSONObject);
        }
        a(anVar.status, anVar);
    }

    @Override // com.baidu.live.ah.b
    public void setCanVisible(boolean z) {
        this.gBW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ao aoVar) {
        if (i >= 1 && i <= 3) {
            this.hUZ = i;
        }
        if (aoVar != null) {
            if (!ListUtils.isEmpty(aoVar.aPa)) {
                if (this.hUZ == 2 || aoVar.FJ()) {
                    if (this.gBW) {
                        this.hUW.setVisibility(0);
                        oE(true);
                        cpa();
                        coY();
                        return;
                    }
                    oE(false);
                    return;
                }
                oE(false);
                return;
            }
            oE(false);
            return;
        }
        oE(false);
    }

    private void a(int i, an anVar) {
        if (i >= 1 && i <= 3) {
            this.hUZ = i;
        }
        if (this.hVa != null) {
            this.hVa.aOZ = this.hUZ;
            if (this.hVa.aPa != null && anVar != null) {
                Iterator<an> it = this.hVa.aPa.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    an next = it.next();
                    if (next.aOS == anVar.aOS) {
                        next.status = anVar.status;
                        break;
                    }
                }
            }
        }
        if (i == 2) {
            if (this.gBW) {
                this.hUW.setVisibility(0);
                oE(true);
                cpa();
                coY();
                return;
            }
            oE(false);
            return;
        }
        oE(false);
        if (i == 1 && anVar != null && anVar.FG() && anVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void coY() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coZ() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void cpa() {
        if (TbConfig.FLOWER_GUIDE_STATUS == 1) {
            this.hUW.post(new Runnable() { // from class: com.baidu.tieba.ala.taskview.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hUW.getLocationOnScreen(r0);
                    int[] iArr = {iArr[0] + (a.this.hUW.getWidth() / 2), iArr[1] + (a.this.hUW.getHeight() / 2)};
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913110, iArr));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oE(boolean z) {
        if (z) {
            if (!this.gUM.isAnimating()) {
                this.gUM.cancelAnimation();
                this.gUM.loop(true);
                this.gUM.setMinFrame(0);
                this.gUM.setMaxFrame(80);
                this.gUM.addAnimatorListener(this.hVc);
                this.gUM.removeAnimatorListener(this.hVb);
                this.gUM.playAnimation();
                this.hUY = false;
            }
        } else if (this.gUM.isAnimating()) {
            this.gUM.cancelAnimation();
            this.gUM.loop(false);
            this.gUM.addAnimatorListener(this.hVb);
            this.gUM.removeAnimatorListener(this.hVc);
            this.gUM.setMaxFrame(95);
            this.gUM.setMinFrame(80);
            this.gUM.playAnimation();
        } else {
            this.gUM.cancelAnimation();
            this.hUW.setVisibility(8);
        }
    }

    private void xL(int i) {
        if (i == 8) {
            this.hUX.setImageResource(a.e.icon_liveshow_flowerless);
            this.hUX.setVisibility(0);
            this.gUM.setVisibility(4);
        } else if (i == 0) {
            this.hUX.setImageResource(a.e.icon_liveshow_flower);
            this.hUX.setVisibility(4);
            this.gUM.setVisibility(0);
        }
    }

    @Override // com.baidu.live.ah.b
    public void UD() {
        if (!TbadkCoreApplication.isLogin()) {
            xL(8);
        } else {
            xL(0);
        }
    }

    @Override // com.baidu.live.ah.b
    public void UE() {
        this.hVa = null;
        if (this.gUM != null) {
            this.gUM.cancelAnimation();
        }
    }

    @Override // com.baidu.live.ah.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hUM);
    }
}
