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
import com.baidu.live.data.al;
import com.baidu.live.data.am;
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
public class a implements com.baidu.live.ac.b {
    private w aEc;
    private TBLottieAnimationView gGg;
    private int hEB;
    private am hEC;
    private PendantChildView hEy;
    private ImageView hEz;
    private Context mContext;
    private String otherParams;
    private boolean gnY = true;
    private boolean hEA = false;
    private HttpMessageListener hEo = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    am amVar = liveFlowerTaskRewardResponsedMessage.hEl;
                    if (amVar == null) {
                        a.this.nY(false);
                    } else if (a.this.hEC != null) {
                        a.this.hEC.aML = amVar.aML;
                        a.this.hEC.aMM = amVar.aMM;
                        a.this.a(a.this.hEC.aML, a.this.hEC);
                    } else {
                        a.this.a(amVar.aML, amVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener hED = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.hEy.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private Animator.AnimatorListener hEE = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.6
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
            if (!a.this.hEA) {
                a.this.hEA = true;
                a.this.gGg.setMinFrame(31);
                a.this.gGg.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.hEy = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.taskview.a.1
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
        this.hEy.addView(inflate);
        this.hEz = (ImageView) this.hEy.findViewById(a.g.alaFlowerImg);
        this.gGg = (TBLottieAnimationView) this.hEy.findViewById(a.g.animation_view);
        this.gGg.setAnimation("flower_entry.json");
        this.gGg.setImageAssetsFolder("images/");
        this.gGg.setVisibility(4);
        this.gGg.addAnimatorListener(this.hEE);
        ciN();
        MessageManager.getInstance().registerListener(this.hEo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciM() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
    }

    @Override // com.baidu.live.ac.b
    public PendantChildView Qd() {
        return this.hEy;
    }

    @Override // com.baidu.live.ac.b
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Md() {
        return this.otherParams;
    }

    private void ciN() {
        this.hEy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                    alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                    alaStaticItem.addParams("other_params", a.this.Md());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                a.this.ciP();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.ciM();
                }
            }
        });
    }

    @Override // com.baidu.live.ac.b
    public void j(w wVar) {
        if (wVar == null || wVar.aIN == null) {
            nY(false);
            return;
        }
        this.aEc = wVar;
        this.hEC = wVar.aIN;
        a(this.hEC.aML, this.hEC);
    }

    @Override // com.baidu.live.ac.b
    public void R(JSONObject jSONObject) {
        if (jSONObject == null) {
            nY(false);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
        al alVar = new al();
        if (optJSONObject != null) {
            alVar.parseJson(optJSONObject);
        }
        a(alVar.status, alVar);
    }

    @Override // com.baidu.live.ac.b
    public void setCanVisible(boolean z) {
        this.gnY = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, am amVar) {
        if (i >= 1 && i <= 3) {
            this.hEB = i;
        }
        if (amVar != null) {
            if (!ListUtils.isEmpty(amVar.aMM)) {
                if (this.hEB == 2 || amVar.El()) {
                    if (this.gnY) {
                        this.hEy.setVisibility(0);
                        nY(true);
                        ciQ();
                        ciO();
                        return;
                    }
                    nY(false);
                    return;
                }
                nY(false);
                return;
            }
            nY(false);
            return;
        }
        nY(false);
    }

    private void a(int i, al alVar) {
        if (i >= 1 && i <= 3) {
            this.hEB = i;
        }
        if (this.hEC != null) {
            this.hEC.aML = this.hEB;
            if (this.hEC.aMM != null && alVar != null) {
                Iterator<al> it = this.hEC.aMM.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    al next = it.next();
                    if (next.aME == alVar.aME) {
                        next.status = alVar.status;
                        break;
                    }
                }
            }
        }
        if (i == 2) {
            if (this.gnY) {
                this.hEy.setVisibility(0);
                nY(true);
                ciQ();
                ciO();
                return;
            }
            nY(false);
            return;
        }
        nY(false);
        if (i == 1 && alVar != null && alVar.Ei() && alVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void ciO() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciP() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void ciQ() {
        if (TbConfig.FLOWER_GUIDE_STATUS == 1) {
            this.hEy.post(new Runnable() { // from class: com.baidu.tieba.ala.taskview.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hEy.getLocationOnScreen(r0);
                    int[] iArr = {iArr[0] + (a.this.hEy.getWidth() / 2), iArr[1] + (a.this.hEy.getHeight() / 2)};
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913110, iArr));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nY(boolean z) {
        if (z) {
            if (!this.gGg.isAnimating()) {
                this.gGg.cancelAnimation();
                this.gGg.loop(true);
                this.gGg.setMinFrame(0);
                this.gGg.setMaxFrame(80);
                this.gGg.addAnimatorListener(this.hEE);
                this.gGg.removeAnimatorListener(this.hED);
                this.gGg.playAnimation();
                this.hEA = false;
            }
        } else if (this.gGg.isAnimating()) {
            this.gGg.cancelAnimation();
            this.gGg.loop(false);
            this.gGg.addAnimatorListener(this.hED);
            this.gGg.removeAnimatorListener(this.hEE);
            this.gGg.setMaxFrame(95);
            this.gGg.setMinFrame(80);
            this.gGg.playAnimation();
        } else {
            this.gGg.cancelAnimation();
            this.hEy.setVisibility(8);
        }
    }

    private void wu(int i) {
        if (i == 8) {
            this.hEz.setImageResource(a.f.icon_liveshow_flowerless);
            this.hEz.setVisibility(0);
            this.gGg.setVisibility(4);
        } else if (i == 0) {
            this.hEz.setImageResource(a.f.icon_liveshow_flower);
            this.hEz.setVisibility(4);
            this.gGg.setVisibility(0);
        }
    }

    @Override // com.baidu.live.ac.b
    public void Qe() {
        if (!TbadkCoreApplication.isLogin()) {
            wu(8);
        } else {
            wu(0);
        }
    }

    @Override // com.baidu.live.ac.b
    public void Qf() {
        this.hEC = null;
        if (this.gGg != null) {
            this.gGg.cancelAnimation();
        }
    }

    @Override // com.baidu.live.ac.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hEo);
    }
}
