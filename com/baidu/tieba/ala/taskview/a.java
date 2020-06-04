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
import com.baidu.live.data.aa;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.tasklist.model.AlaTaskRewardHttpResponsedMessage;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.x.b {
    private ImageView gus;
    private TBLottieAnimationView gut;
    private int guv;
    private ab guw;
    private Context mContext;
    private View mRootView;
    private boolean fMS = true;
    private boolean guu = false;
    private HttpMessageListener gui = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    ab abVar = alaTaskRewardHttpResponsedMessage.guf;
                    if (abVar == null) {
                        a.this.lF(false);
                    } else if (a.this.guw != null) {
                        a.this.guw.ayR = abVar.ayR;
                        a.this.guw.ayS = abVar.ayS;
                        a.this.a(a.this.guw.ayR, a.this.guw);
                    } else {
                        a.this.a(abVar.ayR, abVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener gux = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.4
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
    private Animator.AnimatorListener guy = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
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
            if (!a.this.guu) {
                a.this.guu = true;
                a.this.gut.setMinFrame(31);
                a.this.gut.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.gus = (ImageView) this.mRootView.findViewById(a.g.alaFlowerImg);
        this.gut = (TBLottieAnimationView) this.mRootView.findViewById(a.g.animation_view);
        this.gut.setAnimation("flower_entry.json");
        this.gut.setImageAssetsFolder("images/");
        this.gut.setVisibility(4);
        this.gut.addAnimatorListener(this.guy);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                    return;
                }
                a.this.bBz();
                a.this.bBB();
            }
        });
        MessageManager.getInstance().registerListener(this.gui);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBB() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new f(this.mContext)));
    }

    @Override // com.baidu.live.x.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.live.x.b
    public void a(ab abVar) {
        if (abVar == null) {
            lF(false);
            return;
        }
        this.guw = abVar;
        a(abVar.ayR, abVar);
    }

    @Override // com.baidu.live.x.b
    public void G(JSONObject jSONObject) {
        if (jSONObject == null) {
            lF(false);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
        aa aaVar = new aa();
        if (optJSONObject != null) {
            aaVar.parseJson(optJSONObject);
        }
        a(aaVar.status, aaVar);
    }

    @Override // com.baidu.live.x.b
    public void setCanVisible(boolean z) {
        this.fMS = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ab abVar) {
        if (i >= 1 && i <= 3) {
            this.guv = i;
        }
        if (abVar != null) {
            if (!ListUtils.isEmpty(abVar.ayS)) {
                if (this.guv == 2 || abVar.wm()) {
                    if (this.fMS) {
                        this.mRootView.setVisibility(0);
                        lF(true);
                        bJI();
                        bJH();
                        return;
                    }
                    lF(false);
                    return;
                }
                lF(false);
                return;
            }
            lF(false);
            return;
        }
        lF(false);
    }

    private void a(int i, aa aaVar) {
        if (i >= 1 && i <= 3) {
            this.guv = i;
        }
        if (this.guw != null) {
            this.guw.ayR = this.guv;
            if (this.guw.ayS != null && aaVar != null) {
                Iterator<aa> it = this.guw.ayS.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    aa next = it.next();
                    if (next.ayK == aaVar.ayK) {
                        next.status = aaVar.status;
                        break;
                    }
                }
            }
        }
        if (i == 2) {
            if (this.fMS) {
                this.mRootView.setVisibility(0);
                lF(true);
                bJI();
                bJH();
                return;
            }
            lF(false);
            return;
        }
        lF(false);
        if (i == 1 && aaVar != null && aaVar.wj() && aaVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void bJH() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBz() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void bJI() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void lF(boolean z) {
        if (z) {
            if (!this.gut.isAnimating()) {
                this.gut.cancelAnimation();
                this.gut.loop(true);
                this.gut.setMinFrame(0);
                this.gut.setMaxFrame(80);
                this.gut.addAnimatorListener(this.guy);
                this.gut.removeAnimatorListener(this.gux);
                this.gut.playAnimation();
                this.guu = false;
            }
        } else if (this.gut.isAnimating()) {
            this.gut.cancelAnimation();
            this.gut.loop(false);
            this.gut.addAnimatorListener(this.gux);
            this.gut.removeAnimatorListener(this.guy);
            this.gut.setMaxFrame(95);
            this.gut.setMinFrame(80);
            this.gut.playAnimation();
        } else {
            this.gut.cancelAnimation();
            this.mRootView.setVisibility(8);
        }
    }

    private void rW(int i) {
        if (i == 8) {
            this.gus.setImageResource(a.f.icon_liveshow_flowerless);
            this.gus.setVisibility(0);
            this.gut.setVisibility(4);
        } else if (i == 0) {
            this.gus.setImageResource(a.f.icon_liveshow_flower);
            this.gus.setVisibility(4);
            this.gut.setVisibility(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void Gr() {
        if (!TbadkCoreApplication.isLogin()) {
            rW(8);
        } else {
            rW(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void Gs() {
        this.guw = null;
        if (this.gut != null) {
            this.gut.cancelAnimation();
        }
    }

    @Override // com.baidu.live.x.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gui);
    }
}
