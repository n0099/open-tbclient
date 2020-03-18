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
    private ImageView fAI;
    private TBLottieAnimationView fAJ;
    private int fAL;
    private Context mContext;
    private View mRootView;
    private boolean eUh = true;
    private boolean fAK = false;
    private HttpMessageListener fAy = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    a.this.a(alaTaskRewardHttpResponsedMessage.fAv);
                }
            }
        }
    };
    private Animator.AnimatorListener fAM = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.4
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
    private Animator.AnimatorListener fAN = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
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
            if (!a.this.fAK) {
                a.this.fAK = true;
                a.this.fAJ.setMinFrame(31);
                a.this.fAJ.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.fAI = (ImageView) this.mRootView.findViewById(a.g.alaFlowerImg);
        this.fAJ = (TBLottieAnimationView) this.mRootView.findViewById(a.g.animation_view);
        this.fAJ.setAnimation("flower_entry.json");
        this.fAJ.setImageAssetsFolder("images/");
        this.fAJ.setVisibility(4);
        this.fAJ.addAnimatorListener(this.fAN);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.bml();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.fAy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bml() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(this.mContext)));
    }

    @Override // com.baidu.live.x.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.x.b
    public void a(v vVar) {
        if (vVar == null) {
            kg(false);
        } else {
            a(vVar.abo, vVar);
        }
    }

    @Override // com.baidu.live.x.b
    public void v(JSONObject jSONObject) {
        if (jSONObject == null) {
            kg(false);
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
        this.eUh = z;
    }

    private void a(int i, v vVar) {
        if (i >= 1 && i <= 3) {
            this.fAL = i;
        }
        if (vVar != null) {
            if (!ListUtils.isEmpty(vVar.abp)) {
                if (vVar.qH()) {
                    if (this.eUh) {
                        this.mRootView.setVisibility(0);
                        kg(true);
                        btF();
                        return;
                    }
                    kg(false);
                    return;
                }
                kg(false);
                return;
            }
            kg(false);
            return;
        }
        kg(false);
    }

    private void a(int i, u uVar) {
        if (i >= 1 && i <= 3) {
            this.fAL = i;
        }
        if (i == 2) {
            if (this.eUh) {
                this.mRootView.setVisibility(0);
                kg(true);
                btF();
                return;
            }
            kg(false);
            return;
        }
        kg(false);
        if (i == 1 && uVar != null && uVar.qE() && uVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void btF() {
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

    private void kg(boolean z) {
        if (z) {
            if (!this.fAJ.isAnimating()) {
                this.fAJ.cancelAnimation();
                this.fAJ.loop(true);
                this.fAJ.setMinFrame(0);
                this.fAJ.setMaxFrame(80);
                this.fAJ.addAnimatorListener(this.fAN);
                this.fAJ.removeAnimatorListener(this.fAM);
                this.fAJ.playAnimation();
                this.fAK = false;
            }
        } else if (this.fAJ.isAnimating()) {
            this.fAJ.cancelAnimation();
            this.fAJ.loop(false);
            this.fAJ.addAnimatorListener(this.fAM);
            this.fAJ.removeAnimatorListener(this.fAN);
            this.fAJ.setMaxFrame(95);
            this.fAJ.setMinFrame(80);
            this.fAJ.playAnimation();
        } else {
            this.fAJ.cancelAnimation();
            this.mRootView.setVisibility(8);
        }
    }

    private void qY(int i) {
        if (i == 8) {
            this.fAI.setImageResource(a.f.icon_liveshow_flowerless);
            this.fAI.setVisibility(0);
            this.fAJ.setVisibility(4);
        } else if (i == 0) {
            this.fAI.setImageResource(a.f.icon_liveshow_flower);
            this.fAI.setVisibility(4);
            this.fAJ.setVisibility(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void zD() {
        if (!TbadkCoreApplication.isLogin()) {
            qY(8);
        } else {
            qY(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void zE() {
        if (this.fAJ != null) {
            this.fAJ.cancelAnimation();
        }
    }

    @Override // com.baidu.live.x.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fAy);
    }
}
