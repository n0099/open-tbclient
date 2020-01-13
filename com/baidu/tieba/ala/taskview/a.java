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
import com.baidu.live.data.t;
import com.baidu.live.data.u;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.ala.tasklist.model.AlaTaskRewardHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements com.baidu.live.u.b {
    private ImageView fxn;
    private TBLottieAnimationView fxo;
    private int fxq;
    private Context mContext;
    private View mRootView;
    private final int fxk = 95;
    private final int fxl = 31;
    private final int fxm = 80;
    private boolean ePt = true;
    private boolean fxp = false;
    private HttpMessageListener fxa = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    a.this.a(alaTaskRewardHttpResponsedMessage.fwX);
                }
            }
        }
    };
    private Animator.AnimatorListener fxr = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.4
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
    private Animator.AnimatorListener fxs = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
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
            if (!a.this.fxp) {
                a.this.fxp = true;
                a.this.fxo.setMinFrame(31);
                a.this.fxo.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.fxn = (ImageView) this.mRootView.findViewById(a.g.alaFlowerImg);
        this.fxo = (TBLottieAnimationView) this.mRootView.findViewById(a.g.animation_view);
        this.fxo.setAnimation("flower_entry.json");
        this.fxo.setImageAssetsFolder("images/");
        this.fxo.setVisibility(4);
        this.fxo.addAnimatorListener(this.fxs);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.bkp();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.fxa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkp() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(this.mContext)));
    }

    @Override // com.baidu.live.u.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.u.b
    public void a(u uVar) {
        if (uVar == null) {
            jZ(false);
        } else {
            a(uVar.Zl, uVar);
        }
    }

    @Override // com.baidu.live.u.b
    public void v(JSONObject jSONObject) {
        if (jSONObject == null) {
            jZ(false);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
        t tVar = new t();
        if (optJSONObject != null) {
            tVar.parseJson(optJSONObject);
        }
        a(tVar.status, tVar);
    }

    @Override // com.baidu.live.u.b
    public void setCanVisible(boolean z) {
        this.ePt = z;
    }

    private void a(int i, u uVar) {
        if (i >= 1 && i <= 3) {
            this.fxq = i;
        }
        if (uVar != null) {
            if (!ListUtils.isEmpty(uVar.Zm)) {
                if (uVar.pR()) {
                    if (this.ePt) {
                        this.mRootView.setVisibility(0);
                        jZ(true);
                        brT();
                        return;
                    }
                    jZ(false);
                    return;
                }
                jZ(false);
                return;
            }
            jZ(false);
            return;
        }
        jZ(false);
    }

    private void a(int i, t tVar) {
        if (i >= 1 && i <= 3) {
            this.fxq = i;
        }
        if (i == 2) {
            if (this.ePt) {
                this.mRootView.setVisibility(0);
                jZ(true);
                brT();
                return;
            }
            jZ(false);
            return;
        }
        jZ(false);
        if (i == 1 && tVar != null && tVar.pO() && tVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void brT() {
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

    private void jZ(boolean z) {
        if (z) {
            if (!this.fxo.isAnimating()) {
                this.fxo.cancelAnimation();
                this.fxo.loop(true);
                this.fxo.setMinFrame(0);
                this.fxo.setMaxFrame(80);
                this.fxo.addAnimatorListener(this.fxs);
                this.fxo.removeAnimatorListener(this.fxr);
                this.fxo.playAnimation();
                this.fxp = false;
            }
        } else if (this.fxo.isAnimating()) {
            this.fxo.cancelAnimation();
            this.fxo.loop(false);
            this.fxo.addAnimatorListener(this.fxr);
            this.fxo.removeAnimatorListener(this.fxs);
            this.fxo.setMaxFrame(95);
            this.fxo.setMinFrame(80);
            this.fxo.playAnimation();
        } else {
            this.fxo.cancelAnimation();
            this.mRootView.setVisibility(8);
        }
    }

    private void qP(int i) {
        if (i == 8) {
            this.fxn.setImageResource(a.f.icon_liveshow_flowerless);
            this.fxn.setVisibility(0);
            this.fxo.setVisibility(4);
        } else if (i == 0) {
            this.fxn.setImageResource(a.f.icon_liveshow_flower);
            this.fxn.setVisibility(4);
            this.fxo.setVisibility(0);
        }
    }

    @Override // com.baidu.live.u.b
    public void xc() {
        if (!TbadkCoreApplication.isLogin()) {
            qP(8);
        } else {
            qP(0);
        }
    }

    @Override // com.baidu.live.u.b
    public void xd() {
        if (this.fxo != null) {
            this.fxo.cancelAnimation();
        }
    }

    @Override // com.baidu.live.u.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fxa);
    }
}
