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
import com.baidu.live.c.f;
import com.baidu.live.data.u;
import com.baidu.live.data.v;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.tasklist.model.AlaTaskRewardHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.x.b {
    private ImageView fAa;
    private TBLottieAnimationView fAb;
    private int fAd;
    private Context mContext;
    private View mRootView;
    private boolean eTJ = true;
    private boolean fAc = false;
    private HttpMessageListener fzQ = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    a.this.a(alaTaskRewardHttpResponsedMessage.fzN);
                }
            }
        }
    };
    private Animator.AnimatorListener fAe = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.4
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.mRootView.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private Animator.AnimatorListener fAf = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
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
            if (!a.this.fAc) {
                a.this.fAc = true;
                a.this.fAb.setMinFrame(31);
                a.this.fAb.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.fAa = (ImageView) this.mRootView.findViewById(a.g.alaFlowerImg);
        this.fAb = (TBLottieAnimationView) this.mRootView.findViewById(a.g.animation_view);
        this.fAb.setAnimation("flower_entry.json");
        this.fAb.setImageAssetsFolder("images/");
        this.fAb.setVisibility(4);
        this.fAb.addAnimatorListener(this.fAf);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.bmg();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.fzQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmg() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(this.mContext)));
    }

    @Override // com.baidu.live.x.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.x.b
    public void a(v vVar) {
        if (vVar == null) {
            kb(false);
        } else {
            a(vVar.abe, vVar);
        }
    }

    @Override // com.baidu.live.x.b
    public void v(JSONObject jSONObject) {
        if (jSONObject == null) {
            kb(false);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
        u uVar = new u();
        if (optJSONObject != null) {
            uVar.parseJson(optJSONObject);
        }
        a(uVar.status, uVar);
    }

    @Override // com.baidu.live.x.b
    public void setCanVisible(boolean z) {
        this.eTJ = z;
    }

    private void a(int i, v vVar) {
        if (i >= 1 && i <= 3) {
            this.fAd = i;
        }
        if (vVar != null) {
            if (!ListUtils.isEmpty(vVar.abf)) {
                if (vVar.qC()) {
                    if (this.eTJ) {
                        this.mRootView.setVisibility(0);
                        kb(true);
                        btA();
                        return;
                    }
                    kb(false);
                    return;
                }
                kb(false);
                return;
            }
            kb(false);
            return;
        }
        kb(false);
    }

    private void a(int i, u uVar) {
        if (i >= 1 && i <= 3) {
            this.fAd = i;
        }
        if (i == 2) {
            if (this.eTJ) {
                this.mRootView.setVisibility(0);
                kb(true);
                btA();
                return;
            }
            kb(false);
            return;
        }
        kb(false);
        if (i == 1 && uVar != null && uVar.qz() && uVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void btA() {
        if (TbConfig.FLOWER_GUIDE_STATUS == 1) {
            this.mRootView.post(new Runnable() { // from class: com.baidu.tieba.ala.taskview.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.mRootView.getLocationOnScreen(r0);
                    int[] iArr = {iArr[0] + (a.this.mRootView.getWidth() / 2), iArr[1] + (a.this.mRootView.getHeight() / 2)};
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913110, iArr));
                }
            });
        }
    }

    private void kb(boolean z) {
        if (z) {
            if (!this.fAb.isAnimating()) {
                this.fAb.cancelAnimation();
                this.fAb.loop(true);
                this.fAb.setMinFrame(0);
                this.fAb.setMaxFrame(80);
                this.fAb.addAnimatorListener(this.fAf);
                this.fAb.removeAnimatorListener(this.fAe);
                this.fAb.playAnimation();
                this.fAc = false;
            }
        } else if (this.fAb.isAnimating()) {
            this.fAb.cancelAnimation();
            this.fAb.loop(false);
            this.fAb.addAnimatorListener(this.fAe);
            this.fAb.removeAnimatorListener(this.fAf);
            this.fAb.setMaxFrame(95);
            this.fAb.setMinFrame(80);
            this.fAb.playAnimation();
        } else {
            this.fAb.cancelAnimation();
            this.mRootView.setVisibility(8);
        }
    }

    private void qW(int i) {
        if (i == 8) {
            this.fAa.setImageResource(a.f.icon_liveshow_flowerless);
            this.fAa.setVisibility(0);
            this.fAb.setVisibility(4);
        } else if (i == 0) {
            this.fAa.setImageResource(a.f.icon_liveshow_flower);
            this.fAa.setVisibility(4);
            this.fAb.setVisibility(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void zw() {
        if (!TbadkCoreApplication.isLogin()) {
            qW(8);
        } else {
            qW(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void zx() {
        if (this.fAb != null) {
            this.fAb.cancelAnimation();
        }
    }

    @Override // com.baidu.live.x.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fzQ);
    }
}
