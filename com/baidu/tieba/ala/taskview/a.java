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
    private ImageView fzL;
    private TBLottieAnimationView fzM;
    private int fzO;
    private Context mContext;
    private View mRootView;
    private boolean eTv = true;
    private boolean fzN = false;
    private HttpMessageListener fzB = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    a.this.a(alaTaskRewardHttpResponsedMessage.fzy);
                }
            }
        }
    };
    private Animator.AnimatorListener fzP = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.4
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
    private Animator.AnimatorListener fzQ = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
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
            if (!a.this.fzN) {
                a.this.fzN = true;
                a.this.fzM.setMinFrame(31);
                a.this.fzM.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.fzL = (ImageView) this.mRootView.findViewById(a.g.alaFlowerImg);
        this.fzM = (TBLottieAnimationView) this.mRootView.findViewById(a.g.animation_view);
        this.fzM.setAnimation("flower_entry.json");
        this.fzM.setImageAssetsFolder("images/");
        this.fzM.setVisibility(4);
        this.fzM.addAnimatorListener(this.fzQ);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.bmd();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.fzB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmd() {
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
        this.eTv = z;
    }

    private void a(int i, v vVar) {
        if (i >= 1 && i <= 3) {
            this.fzO = i;
        }
        if (vVar != null) {
            if (!ListUtils.isEmpty(vVar.abf)) {
                if (vVar.qC()) {
                    if (this.eTv) {
                        this.mRootView.setVisibility(0);
                        kb(true);
                        btx();
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
            this.fzO = i;
        }
        if (i == 2) {
            if (this.eTv) {
                this.mRootView.setVisibility(0);
                kb(true);
                btx();
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

    private void btx() {
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
            if (!this.fzM.isAnimating()) {
                this.fzM.cancelAnimation();
                this.fzM.loop(true);
                this.fzM.setMinFrame(0);
                this.fzM.setMaxFrame(80);
                this.fzM.addAnimatorListener(this.fzQ);
                this.fzM.removeAnimatorListener(this.fzP);
                this.fzM.playAnimation();
                this.fzN = false;
            }
        } else if (this.fzM.isAnimating()) {
            this.fzM.cancelAnimation();
            this.fzM.loop(false);
            this.fzM.addAnimatorListener(this.fzP);
            this.fzM.removeAnimatorListener(this.fzQ);
            this.fzM.setMaxFrame(95);
            this.fzM.setMinFrame(80);
            this.fzM.playAnimation();
        } else {
            this.fzM.cancelAnimation();
            this.mRootView.setVisibility(8);
        }
    }

    private void qW(int i) {
        if (i == 8) {
            this.fzL.setImageResource(a.f.icon_liveshow_flowerless);
            this.fzL.setVisibility(0);
            this.fzM.setVisibility(4);
        } else if (i == 0) {
            this.fzL.setImageResource(a.f.icon_liveshow_flower);
            this.fzL.setVisibility(4);
            this.fzM.setVisibility(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void zu() {
        if (!TbadkCoreApplication.isLogin()) {
            qW(8);
        } else {
            qW(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void zv() {
        if (this.fzM != null) {
            this.fzM.cancelAnimation();
        }
    }

    @Override // com.baidu.live.x.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fzB);
    }
}
