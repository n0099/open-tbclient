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
    private ImageView gfp;
    private TBLottieAnimationView gfq;
    private int gfs;
    private Context mContext;
    private View mRootView;
    private boolean fyG = true;
    private boolean gfr = false;
    private HttpMessageListener gff = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    a.this.a(alaTaskRewardHttpResponsedMessage.gfc);
                }
            }
        }
    };
    private Animator.AnimatorListener gft = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.4
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
    private Animator.AnimatorListener gfu = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
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
            if (!a.this.gfr) {
                a.this.gfr = true;
                a.this.gfq.setMinFrame(31);
                a.this.gfq.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.gfp = (ImageView) this.mRootView.findViewById(a.g.alaFlowerImg);
        this.gfq = (TBLottieAnimationView) this.mRootView.findViewById(a.g.animation_view);
        this.gfq.setAnimation("flower_entry.json");
        this.gfq.setImageAssetsFolder("images/");
        this.gfq.setVisibility(4);
        this.gfq.addAnimatorListener(this.gfu);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                    return;
                }
                a.this.bvy();
                a.this.bvA();
            }
        });
        MessageManager.getInstance().registerListener(this.gff);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvA() {
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
            a(xVar.atO, xVar);
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
        this.fyG = z;
    }

    private void a(int i, x xVar) {
        if (i >= 1 && i <= 3) {
            this.gfs = i;
        }
        if (xVar != null) {
            if (!ListUtils.isEmpty(xVar.atP)) {
                if (xVar.uX()) {
                    if (this.fyG) {
                        this.mRootView.setVisibility(0);
                        lj(true);
                        bDp();
                        bDo();
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
            this.gfs = i;
        }
        if (i == 2) {
            if (this.fyG) {
                this.mRootView.setVisibility(0);
                lj(true);
                bDp();
                bDo();
                return;
            }
            lj(false);
            return;
        }
        lj(false);
        if (i == 1 && wVar != null && wVar.uU() && wVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void bDo() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1394", "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvy() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", "liveroom", "petal_clk"));
    }

    private void bDp() {
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
            if (!this.gfq.isAnimating()) {
                this.gfq.cancelAnimation();
                this.gfq.loop(true);
                this.gfq.setMinFrame(0);
                this.gfq.setMaxFrame(80);
                this.gfq.addAnimatorListener(this.gfu);
                this.gfq.removeAnimatorListener(this.gft);
                this.gfq.playAnimation();
                this.gfr = false;
            }
        } else if (this.gfq.isAnimating()) {
            this.gfq.cancelAnimation();
            this.gfq.loop(false);
            this.gfq.addAnimatorListener(this.gft);
            this.gfq.removeAnimatorListener(this.gfu);
            this.gfq.setMaxFrame(95);
            this.gfq.setMinFrame(80);
            this.gfq.playAnimation();
        } else {
            this.gfq.cancelAnimation();
            this.mRootView.setVisibility(8);
        }
    }

    private void rr(int i) {
        if (i == 8) {
            this.gfp.setImageResource(a.f.icon_liveshow_flowerless);
            this.gfp.setVisibility(0);
            this.gfq.setVisibility(4);
        } else if (i == 0) {
            this.gfp.setImageResource(a.f.icon_liveshow_flower);
            this.gfp.setVisibility(4);
            this.gfq.setVisibility(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void EA() {
        if (!TbadkCoreApplication.isLogin()) {
            rr(8);
        } else {
            rr(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void EB() {
        if (this.gfq != null) {
            this.gfq.cancelAnimation();
        }
    }

    @Override // com.baidu.live.x.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gff);
    }
}
