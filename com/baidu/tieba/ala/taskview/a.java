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
import com.baidu.live.b.d;
import com.baidu.live.data.p;
import com.baidu.live.data.q;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.ala.tasklist.model.AlaTaskRewardHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements com.baidu.live.m.b {
    private ImageView eDo;
    private TBLottieAnimationView eDp;
    private int eDr;
    private Context mContext;
    private View mRootView;
    private final int eDl = 95;
    private final int eDm = 31;
    private final int eDn = 80;
    private boolean dYO = true;
    private boolean eDq = false;
    private HttpMessageListener eDb = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    a.this.a(alaTaskRewardHttpResponsedMessage.eCY);
                }
            }
        }
    };
    private Animator.AnimatorListener eDs = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.4
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
    private Animator.AnimatorListener eDt = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
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
            if (!a.this.eDq) {
                a.this.eDq = true;
                a.this.eDp.setMinFrame(31);
                a.this.eDp.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.eDo = (ImageView) this.mRootView.findViewById(a.g.alaFlowerImg);
        this.eDp = (TBLottieAnimationView) this.mRootView.findViewById(a.g.animation_view);
        this.eDp.setAnimation("flower_entry.json");
        this.eDp.setImageAssetsFolder("images/");
        this.eDp.setVisibility(4);
        this.eDp.addAnimatorListener(this.eDt);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.aRV();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.eDb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRV() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new d(this.mContext)));
    }

    @Override // com.baidu.live.m.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.m.b
    public void a(q qVar) {
        if (qVar != null) {
            a(qVar.SB, qVar);
        }
    }

    @Override // com.baidu.live.m.b
    public void y(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            p pVar = new p();
            if (optJSONObject != null) {
                pVar.parseJson(optJSONObject);
            }
            a(pVar.status, pVar);
        }
    }

    @Override // com.baidu.live.m.b
    public void setCanVisible(boolean z) {
        this.dYO = z;
    }

    private void a(int i, q qVar) {
        if (i >= 1 && i <= 3) {
            this.eDr = i;
        }
        if (qVar != null && !ListUtils.isEmpty(qVar.SC)) {
            if (qVar.os()) {
                if (this.dYO) {
                    this.mRootView.setVisibility(0);
                    ix(true);
                    aYS();
                    return;
                }
                return;
            }
            ix(false);
        }
    }

    private void a(int i, p pVar) {
        if (i >= 1 && i <= 3) {
            this.eDr = i;
        }
        if (i == 2) {
            if (this.dYO) {
                this.mRootView.setVisibility(0);
                ix(true);
                aYS();
            }
        } else if (i == 1 && pVar != null && pVar.op() && pVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void aYS() {
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

    private void ix(boolean z) {
        if (z) {
            if (!this.eDp.isAnimating()) {
                this.eDp.cancelAnimation();
                this.eDp.loop(true);
                this.eDp.setMinFrame(0);
                this.eDp.setMaxFrame(80);
                this.eDp.addAnimatorListener(this.eDt);
                this.eDp.removeAnimatorListener(this.eDs);
                this.eDp.playAnimation();
                this.eDq = false;
            }
        } else if (this.eDp.isAnimating()) {
            this.eDp.cancelAnimation();
            this.eDp.loop(false);
            this.eDp.addAnimatorListener(this.eDs);
            this.eDp.removeAnimatorListener(this.eDt);
            this.eDp.setMaxFrame(95);
            this.eDp.setMinFrame(80);
            this.eDp.playAnimation();
        } else {
            this.eDp.cancelAnimation();
            this.mRootView.setVisibility(8);
        }
    }

    private void or(int i) {
        if (i == 8) {
            this.eDo.setImageResource(a.f.icon_liveshow_flowerless);
            this.eDo.setVisibility(0);
            this.eDp.setVisibility(4);
        } else if (i == 0) {
            this.eDo.setImageResource(a.f.icon_liveshow_flower);
            this.eDo.setVisibility(4);
            this.eDp.setVisibility(0);
        }
    }

    @Override // com.baidu.live.m.b
    public void uM() {
        if (!TbadkCoreApplication.isLogin()) {
            or(8);
        } else {
            or(0);
        }
    }

    @Override // com.baidu.live.m.b
    public void uN() {
        if (this.eDp != null) {
            this.eDp.cancelAnimation();
        }
    }

    @Override // com.baidu.live.m.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eDb);
    }
}
