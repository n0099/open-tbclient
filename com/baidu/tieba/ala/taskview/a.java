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
    private ImageView guh;
    private TBLottieAnimationView gui;
    private int guk;
    private ab gul;
    private Context mContext;
    private View mRootView;
    private boolean fMH = true;
    private boolean guj = false;
    private HttpMessageListener gtX = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    ab abVar = alaTaskRewardHttpResponsedMessage.gtU;
                    if (abVar == null) {
                        a.this.lF(false);
                    } else if (a.this.gul != null) {
                        a.this.gul.ayR = abVar.ayR;
                        a.this.gul.ayS = abVar.ayS;
                        a.this.a(a.this.gul.ayR, a.this.gul);
                    } else {
                        a.this.a(abVar.ayR, abVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener gum = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.4
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
    private Animator.AnimatorListener gun = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
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
            if (!a.this.guj) {
                a.this.guj = true;
                a.this.gui.setMinFrame(31);
                a.this.gui.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.guh = (ImageView) this.mRootView.findViewById(a.g.alaFlowerImg);
        this.gui = (TBLottieAnimationView) this.mRootView.findViewById(a.g.animation_view);
        this.gui.setAnimation("flower_entry.json");
        this.gui.setImageAssetsFolder("images/");
        this.gui.setVisibility(4);
        this.gui.addAnimatorListener(this.gun);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                    return;
                }
                a.this.bBx();
                a.this.bBz();
            }
        });
        MessageManager.getInstance().registerListener(this.gtX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBz() {
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
        this.gul = abVar;
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
        this.fMH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ab abVar) {
        if (i >= 1 && i <= 3) {
            this.guk = i;
        }
        if (abVar != null) {
            if (!ListUtils.isEmpty(abVar.ayS)) {
                if (this.guk == 2 || abVar.wm()) {
                    if (this.fMH) {
                        this.mRootView.setVisibility(0);
                        lF(true);
                        bJG();
                        bJF();
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
            this.guk = i;
        }
        if (this.gul != null) {
            this.gul.ayR = this.guk;
            if (this.gul.ayS != null && aaVar != null) {
                Iterator<aa> it = this.gul.ayS.iterator();
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
            if (this.fMH) {
                this.mRootView.setVisibility(0);
                lF(true);
                bJG();
                bJF();
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

    private void bJF() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBx() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void bJG() {
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
            if (!this.gui.isAnimating()) {
                this.gui.cancelAnimation();
                this.gui.loop(true);
                this.gui.setMinFrame(0);
                this.gui.setMaxFrame(80);
                this.gui.addAnimatorListener(this.gun);
                this.gui.removeAnimatorListener(this.gum);
                this.gui.playAnimation();
                this.guj = false;
            }
        } else if (this.gui.isAnimating()) {
            this.gui.cancelAnimation();
            this.gui.loop(false);
            this.gui.addAnimatorListener(this.gum);
            this.gui.removeAnimatorListener(this.gun);
            this.gui.setMaxFrame(95);
            this.gui.setMinFrame(80);
            this.gui.playAnimation();
        } else {
            this.gui.cancelAnimation();
            this.mRootView.setVisibility(8);
        }
    }

    private void rU(int i) {
        if (i == 8) {
            this.guh.setImageResource(a.f.icon_liveshow_flowerless);
            this.guh.setVisibility(0);
            this.gui.setVisibility(4);
        } else if (i == 0) {
            this.guh.setImageResource(a.f.icon_liveshow_flower);
            this.guh.setVisibility(4);
            this.gui.setVisibility(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void Gr() {
        if (!TbadkCoreApplication.isLogin()) {
            rU(8);
        } else {
            rU(0);
        }
    }

    @Override // com.baidu.live.x.b
    public void Gs() {
        this.gul = null;
        if (this.gui != null) {
            this.gui.cancelAnimation();
        }
    }

    @Override // com.baidu.live.x.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gtX);
    }
}
