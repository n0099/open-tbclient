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
import com.baidu.live.data.w;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.tasklist.model.AlaTaskRewardHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.x.b {
    private ImageView gfj;
    private TBLottieAnimationView gfk;
    private int gfm;
    private Context mContext;
    private View mRootView;
    private boolean fyB = true;
    private boolean gfl = false;
    private HttpMessageListener geZ = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    a.this.a(alaTaskRewardHttpResponsedMessage.geW);
                }
            }
        }
    };
    private Animator.AnimatorListener gfn = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.4
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
    private Animator.AnimatorListener gfo = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
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
            if (!a.this.gfl) {
                a.this.gfl = true;
                a.this.gfk.setMinFrame(31);
                a.this.gfk.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.gfj = (ImageView) this.mRootView.findViewById(a.g.alaFlowerImg);
        this.gfk = (TBLottieAnimationView) this.mRootView.findViewById(a.g.animation_view);
        this.gfk.setAnimation("flower_entry.json");
        this.gfk.setImageAssetsFolder("images/");
        this.gfk.setVisibility(4);
        this.gfk.addAnimatorListener(this.gfo);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                    return;
                }
                a.this.bvA();
                a.this.bvC();
            }
        });
        MessageManager.getInstance().registerListener(this.geZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvC() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(this.mContext)));
    }

    @Override // com.baidu.live.x.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.x.b
    public void a(x xVar) {
        if (xVar == null) {
            lj(false);
        } else {
            a(xVar.atI, xVar);
        }
    }

    @Override // com.baidu.live.x.b
    public void B(JSONObject jSONObject) {
        if (jSONObject == null) {
            lj(false);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
        w wVar = new w();
        if (optJSONObject != null) {
            wVar.parseJson(optJSONObject);
        }
        a(wVar.status, wVar);
    }

    @Override // com.baidu.live.x.b
    public void setCanVisible(boolean z) {
        this.fyB = z;
    }

    private void a(int i, x xVar) {
        if (i >= 1 && i <= 3) {
            this.gfm = i;
        }
        if (xVar != null) {
            if (!ListUtils.isEmpty(xVar.atJ)) {
                if (xVar.uY()) {
                    if (this.fyB) {
                        this.mRootView.setVisibility(0);
                        lj(true);
                        bDq();
                        bDp();
                        return;
                    }
                    lj(false);
                    return;
                }
                lj(false);
                return;
            }
            lj(false);
            return;
        }
        lj(false);
    }

    private void a(int i, w wVar) {
        if (i >= 1 && i <= 3) {
            this.gfm = i;
        }
        if (i == 2) {
            if (this.fyB) {
                this.mRootView.setVisibility(0);
                lj(true);
                bDq();
                bDp();
                return;
            }
            lj(false);
            return;
        }
        lj(false);
        if (i == 1 && wVar != null && wVar.uV() && wVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void bDp() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1394", "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvA() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "petal_clk"));
    }

    private void bDq() {
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

    private void lj(boolean z) {
        if (z) {
            if (!this.gfk.isAnimating()) {
                this.gfk.cancelAnimation();
                this.gfk.loop(true);
                this.gfk.setMinFrame(0);
                this.gfk.setMaxFrame(80);
                this.gfk.addAnimatorListener(this.gfo);
                this.gfk.removeAnimatorListener(this.gfn);
                this.gfk.playAnimation();
                this.gfl = false;
            }
        } else if (this.gfk.isAnimating()) {
            this.gfk.cancelAnimation();
            this.gfk.loop(false);
            this.gfk.addAnimatorListener(this.gfn);
            this.gfk.removeAnimatorListener(this.gfo);
            this.gfk.setMaxFrame(95);
            this.gfk.setMinFrame(80);
            this.gfk.playAnimation();
        } else {
            this.gfk.cancelAnimation();
            this.mRootView.setVisibility(8);
        }
    }

    private void rr(int i) {
        if (i == 8) {
            this.gfj.setImageResource(a.f.icon_liveshow_flowerless);
            this.gfj.setVisibility(0);
            this.gfk.setVisibility(4);
        } else if (i == 0) {
            this.gfj.setImageResource(a.f.icon_liveshow_flower);
            this.gfj.setVisibility(4);
            this.gfk.setVisibility(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void EB() {
        if (!TbadkCoreApplication.isLogin()) {
            rr(8);
        } else {
            rr(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void EC() {
        if (this.gfk != null) {
            this.gfk.cancelAnimation();
        }
    }

    @Override // com.baidu.live.x.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.geZ);
    }
}
