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
import com.baidu.live.data.r;
import com.baidu.live.data.s;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.ala.tasklist.model.AlaTaskRewardHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements com.baidu.live.s.b {
    private ImageView fuc;
    private TBLottieAnimationView fud;
    private int fuf;
    private Context mContext;
    private View mRootView;
    private final int ftZ = 95;
    private final int fua = 31;
    private final int fub = 80;
    private boolean eNV = true;
    private boolean fue = false;
    private HttpMessageListener ftP = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    a.this.a(alaTaskRewardHttpResponsedMessage.ftM);
                }
            }
        }
    };
    private Animator.AnimatorListener fug = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.4
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
    private Animator.AnimatorListener fuh = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
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
            if (!a.this.fue) {
                a.this.fue = true;
                a.this.fud.setMinFrame(31);
                a.this.fud.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.fuc = (ImageView) this.mRootView.findViewById(a.g.alaFlowerImg);
        this.fud = (TBLottieAnimationView) this.mRootView.findViewById(a.g.animation_view);
        this.fud.setAnimation("flower_entry.json");
        this.fud.setImageAssetsFolder("images/");
        this.fud.setVisibility(4);
        this.fud.addAnimatorListener(this.fuh);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.bjt();
                }
            }
        });
        MessageManager.getInstance().registerListener(this.ftP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjt() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(this.mContext)));
    }

    @Override // com.baidu.live.s.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.s.b
    public void a(s sVar) {
        if (sVar != null) {
            a(sVar.YX, sVar);
        }
    }

    @Override // com.baidu.live.s.b
    public void v(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
            r rVar = new r();
            if (optJSONObject != null) {
                rVar.parseJson(optJSONObject);
            }
            a(rVar.status, rVar);
        }
    }

    @Override // com.baidu.live.s.b
    public void setCanVisible(boolean z) {
        this.eNV = z;
    }

    private void a(int i, s sVar) {
        if (i >= 1 && i <= 3) {
            this.fuf = i;
        }
        if (sVar != null && !ListUtils.isEmpty(sVar.YY)) {
            if (sVar.pN()) {
                if (this.eNV) {
                    this.mRootView.setVisibility(0);
                    jO(true);
                    bqR();
                    return;
                }
                return;
            }
            jO(false);
        }
    }

    private void a(int i, r rVar) {
        if (i >= 1 && i <= 3) {
            this.fuf = i;
        }
        if (i == 2) {
            if (this.eNV) {
                this.mRootView.setVisibility(0);
                jO(true);
                bqR();
            }
        } else if (i == 1 && rVar != null && rVar.pK() && rVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void bqR() {
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

    private void jO(boolean z) {
        if (z) {
            if (!this.fud.isAnimating()) {
                this.fud.cancelAnimation();
                this.fud.loop(true);
                this.fud.setMinFrame(0);
                this.fud.setMaxFrame(80);
                this.fud.addAnimatorListener(this.fuh);
                this.fud.removeAnimatorListener(this.fug);
                this.fud.playAnimation();
                this.fue = false;
            }
        } else if (this.fud.isAnimating()) {
            this.fud.cancelAnimation();
            this.fud.loop(false);
            this.fud.addAnimatorListener(this.fug);
            this.fud.removeAnimatorListener(this.fuh);
            this.fud.setMaxFrame(95);
            this.fud.setMinFrame(80);
            this.fud.playAnimation();
        } else {
            this.fud.cancelAnimation();
            this.mRootView.setVisibility(8);
        }
    }

    private void qK(int i) {
        if (i == 8) {
            this.fuc.setImageResource(a.f.icon_liveshow_flowerless);
            this.fuc.setVisibility(0);
            this.fud.setVisibility(4);
        } else if (i == 0) {
            this.fuc.setImageResource(a.f.icon_liveshow_flower);
            this.fuc.setVisibility(4);
            this.fud.setVisibility(0);
        }
    }

    @Override // com.baidu.live.s.b
    public void wL() {
        if (!TbadkCoreApplication.isLogin()) {
            qK(8);
        } else {
            qK(0);
        }
    }

    @Override // com.baidu.live.s.b
    public void wM() {
        if (this.fud != null) {
            this.fud.cancelAnimation();
        }
    }

    @Override // com.baidu.live.s.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ftP);
    }
}
