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
import com.baidu.live.data.ac;
import com.baidu.live.data.q;
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
public class a implements com.baidu.live.x.b {
    private q avf;
    private PendantChildView gMG;
    private ImageView gMH;
    private TBLottieAnimationView gMI;
    private int gMK;
    private ac gML;
    private Context mContext;
    private String otherParams;
    private boolean fCW = true;
    private boolean gMJ = false;
    private HttpMessageListener gMw = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    ac acVar = liveFlowerTaskRewardResponsedMessage.gMt;
                    if (acVar == null) {
                        a.this.mt(false);
                    } else if (a.this.gML != null) {
                        a.this.gML.aCv = acVar.aCv;
                        a.this.gML.aCw = acVar.aCw;
                        a.this.a(a.this.gML.aCv, a.this.gML);
                    } else {
                        a.this.a(acVar.aCv, acVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener gMM = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.gMG.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private Animator.AnimatorListener gMN = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.6
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
            if (!a.this.gMJ) {
                a.this.gMJ = true;
                a.this.gMI.setMinFrame(31);
                a.this.gMI.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.gMG = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.taskview.a.1
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
        this.gMG.addView(inflate);
        this.gMH = (ImageView) this.gMG.findViewById(a.g.alaFlowerImg);
        this.gMI = (TBLottieAnimationView) this.gMG.findViewById(a.g.animation_view);
        this.gMI.setAnimation("flower_entry.json");
        this.gMI.setImageAssetsFolder("images/");
        this.gMI.setVisibility(4);
        this.gMI.addAnimatorListener(this.gMN);
        bPU();
        MessageManager.getInstance().registerListener(this.gMw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPT() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
    }

    @Override // com.baidu.live.x.b
    public PendantChildView HJ() {
        return this.gMG;
    }

    @Override // com.baidu.live.x.b
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Et() {
        return this.otherParams;
    }

    private void bPU() {
        this.gMG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                    alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                    alaStaticItem.addParams("other_params", a.this.Et());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                a.this.bPW();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.bPT();
                }
            }
        });
    }

    @Override // com.baidu.live.x.b
    public void j(q qVar) {
        if (qVar == null || qVar.azf == null) {
            mt(false);
            return;
        }
        this.avf = qVar;
        this.gML = qVar.azf;
        a(this.gML.aCv, this.gML);
    }

    @Override // com.baidu.live.x.b
    public void L(JSONObject jSONObject) {
        if (jSONObject == null) {
            mt(false);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
        ab abVar = new ab();
        if (optJSONObject != null) {
            abVar.parseJson(optJSONObject);
        }
        a(abVar.status, abVar);
    }

    @Override // com.baidu.live.x.b
    public void setCanVisible(boolean z) {
        this.fCW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ac acVar) {
        if (i >= 1 && i <= 3) {
            this.gMK = i;
        }
        if (acVar != null) {
            if (!ListUtils.isEmpty(acVar.aCw)) {
                if (this.gMK == 2 || acVar.xm()) {
                    if (this.fCW) {
                        this.gMG.setVisibility(0);
                        mt(true);
                        bPX();
                        bPV();
                        return;
                    }
                    mt(false);
                    return;
                }
                mt(false);
                return;
            }
            mt(false);
            return;
        }
        mt(false);
    }

    private void a(int i, ab abVar) {
        if (i >= 1 && i <= 3) {
            this.gMK = i;
        }
        if (this.gML != null) {
            this.gML.aCv = this.gMK;
            if (this.gML.aCw != null && abVar != null) {
                Iterator<ab> it = this.gML.aCw.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ab next = it.next();
                    if (next.aCo == abVar.aCo) {
                        next.status = abVar.status;
                        break;
                    }
                }
            }
        }
        if (i == 2) {
            if (this.fCW) {
                this.gMG.setVisibility(0);
                mt(true);
                bPX();
                bPV();
                return;
            }
            mt(false);
            return;
        }
        mt(false);
        if (i == 1 && abVar != null && abVar.xj() && abVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void bPV() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPW() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void bPX() {
        if (TbConfig.FLOWER_GUIDE_STATUS == 1) {
            this.gMG.post(new Runnable() { // from class: com.baidu.tieba.ala.taskview.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gMG.getLocationOnScreen(r0);
                    int[] iArr = {iArr[0] + (a.this.gMG.getWidth() / 2), iArr[1] + (a.this.gMG.getHeight() / 2)};
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913110, iArr));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mt(boolean z) {
        if (z) {
            if (!this.gMI.isAnimating()) {
                this.gMI.cancelAnimation();
                this.gMI.loop(true);
                this.gMI.setMinFrame(0);
                this.gMI.setMaxFrame(80);
                this.gMI.addAnimatorListener(this.gMN);
                this.gMI.removeAnimatorListener(this.gMM);
                this.gMI.playAnimation();
                this.gMJ = false;
            }
        } else if (this.gMI.isAnimating()) {
            this.gMI.cancelAnimation();
            this.gMI.loop(false);
            this.gMI.addAnimatorListener(this.gMM);
            this.gMI.removeAnimatorListener(this.gMN);
            this.gMI.setMaxFrame(95);
            this.gMI.setMinFrame(80);
            this.gMI.playAnimation();
        } else {
            this.gMI.cancelAnimation();
            this.gMG.setVisibility(8);
        }
    }

    private void sN(int i) {
        if (i == 8) {
            this.gMH.setImageResource(a.f.icon_liveshow_flowerless);
            this.gMH.setVisibility(0);
            this.gMI.setVisibility(4);
        } else if (i == 0) {
            this.gMH.setImageResource(a.f.icon_liveshow_flower);
            this.gMH.setVisibility(4);
            this.gMI.setVisibility(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void HK() {
        if (!TbadkCoreApplication.isLogin()) {
            sN(8);
        } else {
            sN(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void HL() {
        this.gML = null;
        if (this.gMI != null) {
            this.gMI.cancelAnimation();
        }
    }

    @Override // com.baidu.live.x.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gMw);
    }
}
