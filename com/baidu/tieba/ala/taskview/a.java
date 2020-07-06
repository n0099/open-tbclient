package com.baidu.tieba.ala.taskview;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.c.g;
import com.baidu.live.data.ab;
import com.baidu.live.data.ac;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.ala.tasklist.model.AlaTaskRewardHttpResponsedMessage;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.x.b {
    private PendantChildView gHf;
    private ImageView gHg;
    private TBLottieAnimationView gHh;
    private int gHj;
    private ac gHk;
    private Context mContext;
    private boolean fxP = true;
    private boolean gHi = false;
    private HttpMessageListener gGV = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    ac acVar = alaTaskRewardHttpResponsedMessage.gGS;
                    if (acVar == null) {
                        a.this.lO(false);
                    } else if (a.this.gHk != null) {
                        a.this.gHk.aBi = acVar.aBi;
                        a.this.gHk.aBj = acVar.aBj;
                        a.this.a(a.this.gHk.aBi, a.this.gHk);
                    } else {
                        a.this.a(acVar.aBi, acVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener gHl = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.gHf.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private Animator.AnimatorListener gHm = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.6
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
            if (!a.this.gHi) {
                a.this.gHi = true;
                a.this.gHh.setMinFrame(31);
                a.this.gHh.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.gHf = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.taskview.a.1
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
        this.gHf.addView(inflate);
        this.gHg = (ImageView) this.gHf.findViewById(a.g.alaFlowerImg);
        this.gHh = (TBLottieAnimationView) this.gHf.findViewById(a.g.animation_view);
        this.gHh.setAnimation("flower_entry.json");
        this.gHh.setImageAssetsFolder("images/");
        this.gHh.setVisibility(4);
        this.gHh.addAnimatorListener(this.gHm);
        this.gHf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                    return;
                }
                a.this.bEH();
                a.this.bEJ();
            }
        });
        MessageManager.getInstance().registerListener(this.gGV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEJ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new g(this.mContext)));
    }

    @Override // com.baidu.live.x.b
    public PendantChildView HD() {
        return this.gHf;
    }

    @Override // com.baidu.live.x.b
    public void a(ac acVar) {
        if (acVar == null) {
            lO(false);
            return;
        }
        this.gHk = acVar;
        a(acVar.aBi, acVar);
    }

    @Override // com.baidu.live.x.b
    public void L(JSONObject jSONObject) {
        if (jSONObject == null) {
            lO(false);
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
        this.fxP = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ac acVar) {
        if (i >= 1 && i <= 3) {
            this.gHj = i;
        }
        if (acVar != null) {
            if (!ListUtils.isEmpty(acVar.aBj)) {
                if (this.gHj == 2 || acVar.wK()) {
                    if (this.fxP) {
                        this.gHf.setVisibility(0);
                        lO(true);
                        bMO();
                        bMN();
                        return;
                    }
                    lO(false);
                    return;
                }
                lO(false);
                return;
            }
            lO(false);
            return;
        }
        lO(false);
    }

    private void a(int i, ab abVar) {
        if (i >= 1 && i <= 3) {
            this.gHj = i;
        }
        if (this.gHk != null) {
            this.gHk.aBi = this.gHj;
            if (this.gHk.aBj != null && abVar != null) {
                Iterator<ab> it = this.gHk.aBj.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ab next = it.next();
                    if (next.aBb == abVar.aBb) {
                        next.status = abVar.status;
                        break;
                    }
                }
            }
        }
        if (i == 2) {
            if (this.fxP) {
                this.gHf.setVisibility(0);
                lO(true);
                bMO();
                bMN();
                return;
            }
            lO(false);
            return;
        }
        lO(false);
        if (i == 1 && abVar != null && abVar.wH() && abVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void bMN() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEH() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void bMO() {
        if (TbConfig.FLOWER_GUIDE_STATUS == 1) {
            this.gHf.post(new Runnable() { // from class: com.baidu.tieba.ala.taskview.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gHf.getLocationOnScreen(r0);
                    int[] iArr = {iArr[0] + (a.this.gHf.getWidth() / 2), iArr[1] + (a.this.gHf.getHeight() / 2)};
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913110, iArr));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(boolean z) {
        if (z) {
            if (!this.gHh.isAnimating()) {
                this.gHh.cancelAnimation();
                this.gHh.loop(true);
                this.gHh.setMinFrame(0);
                this.gHh.setMaxFrame(80);
                this.gHh.addAnimatorListener(this.gHm);
                this.gHh.removeAnimatorListener(this.gHl);
                this.gHh.playAnimation();
                this.gHi = false;
            }
        } else if (this.gHh.isAnimating()) {
            this.gHh.cancelAnimation();
            this.gHh.loop(false);
            this.gHh.addAnimatorListener(this.gHl);
            this.gHh.removeAnimatorListener(this.gHm);
            this.gHh.setMaxFrame(95);
            this.gHh.setMinFrame(80);
            this.gHh.playAnimation();
        } else {
            this.gHh.cancelAnimation();
            this.gHf.setVisibility(8);
        }
    }

    private void sv(int i) {
        if (i == 8) {
            this.gHg.setImageResource(a.f.icon_liveshow_flowerless);
            this.gHg.setVisibility(0);
            this.gHh.setVisibility(4);
        } else if (i == 0) {
            this.gHg.setImageResource(a.f.icon_liveshow_flower);
            this.gHg.setVisibility(4);
            this.gHh.setVisibility(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void HE() {
        if (!TbadkCoreApplication.isLogin()) {
            sv(8);
        } else {
            sv(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void HF() {
        this.gHk = null;
        if (this.gHh != null) {
            this.gHh.cancelAnimation();
        }
    }

    @Override // com.baidu.live.x.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gGV);
    }
}
