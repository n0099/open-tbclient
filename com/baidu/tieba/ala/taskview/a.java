package com.baidu.tieba.ala.taskview;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.ai;
import com.baidu.live.data.aj;
import com.baidu.live.data.u;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.ala.tasklist.model.LiveFlowerTaskRewardResponsedMessage;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.z.b {
    private u aAP;
    private PendantChildView hdB;
    private ImageView hdC;
    private TBLottieAnimationView hdD;
    private int hdF;
    private aj hdG;
    private Context mContext;
    private String otherParams;
    private boolean fRC = true;
    private boolean hdE = false;
    private HttpMessageListener hdr = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    aj ajVar = liveFlowerTaskRewardResponsedMessage.hdo;
                    if (ajVar == null) {
                        a.this.nc(false);
                    } else if (a.this.hdG != null) {
                        a.this.hdG.aJb = ajVar.aJb;
                        a.this.hdG.aJc = ajVar.aJc;
                        a.this.a(a.this.hdG.aJb, a.this.hdG);
                    } else {
                        a.this.a(ajVar.aJb, ajVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener hdH = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.hdB.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private Animator.AnimatorListener hdI = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.6
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
            if (!a.this.hdE) {
                a.this.hdE = true;
                a.this.hdD.setMinFrame(31);
                a.this.hdD.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.hdB = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.taskview.a.1
            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPkPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getHorizontalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getHorizontalFullPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public int getPriority() {
                return 40;
            }
        };
        this.hdB.addView(inflate);
        this.hdC = (ImageView) this.hdB.findViewById(a.g.alaFlowerImg);
        this.hdD = (TBLottieAnimationView) this.hdB.findViewById(a.g.animation_view);
        this.hdD.setAnimation("flower_entry.json");
        this.hdD.setImageAssetsFolder("images/");
        this.hdD.setVisibility(4);
        this.hdD.addAnimatorListener(this.hdI);
        ccq();
        MessageManager.getInstance().registerListener(this.hdr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccp() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
    }

    @Override // com.baidu.live.z.b
    public PendantChildView Of() {
        return this.hdB;
    }

    @Override // com.baidu.live.z.b
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String KD() {
        return this.otherParams;
    }

    private void ccq() {
        this.hdB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                    alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                    alaStaticItem.addParams("other_params", a.this.KD());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                a.this.ccs();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.ccp();
                }
            }
        });
    }

    @Override // com.baidu.live.z.b
    public void k(u uVar) {
        if (uVar == null || uVar.aFm == null) {
            nc(false);
            return;
        }
        this.aAP = uVar;
        this.hdG = uVar.aFm;
        a(this.hdG.aJb, this.hdG);
    }

    @Override // com.baidu.live.z.b
    public void Q(JSONObject jSONObject) {
        if (jSONObject == null) {
            nc(false);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
        ai aiVar = new ai();
        if (optJSONObject != null) {
            aiVar.parseJson(optJSONObject);
        }
        a(aiVar.status, aiVar);
    }

    @Override // com.baidu.live.z.b
    public void setCanVisible(boolean z) {
        this.fRC = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, aj ajVar) {
        if (i >= 1 && i <= 3) {
            this.hdF = i;
        }
        if (ajVar != null) {
            if (!ListUtils.isEmpty(ajVar.aJc)) {
                if (this.hdF == 2 || ajVar.Df()) {
                    if (this.fRC) {
                        this.hdB.setVisibility(0);
                        nc(true);
                        cct();
                        ccr();
                        return;
                    }
                    nc(false);
                    return;
                }
                nc(false);
                return;
            }
            nc(false);
            return;
        }
        nc(false);
    }

    private void a(int i, ai aiVar) {
        if (i >= 1 && i <= 3) {
            this.hdF = i;
        }
        if (this.hdG != null) {
            this.hdG.aJb = this.hdF;
            if (this.hdG.aJc != null && aiVar != null) {
                Iterator<ai> it = this.hdG.aJc.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ai next = it.next();
                    if (next.aIU == aiVar.aIU) {
                        next.status = aiVar.status;
                        break;
                    }
                }
            }
        }
        if (i == 2) {
            if (this.fRC) {
                this.hdB.setVisibility(0);
                nc(true);
                cct();
                ccr();
                return;
            }
            nc(false);
            return;
        }
        nc(false);
        if (i == 1 && aiVar != null && aiVar.Dc() && aiVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void ccr() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccs() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void cct() {
        if (TbConfig.FLOWER_GUIDE_STATUS == 1) {
            this.hdB.post(new Runnable() { // from class: com.baidu.tieba.ala.taskview.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hdB.getLocationOnScreen(r0);
                    int[] iArr = {iArr[0] + (a.this.hdB.getWidth() / 2), iArr[1] + (a.this.hdB.getHeight() / 2)};
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913110, iArr));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc(boolean z) {
        if (z) {
            if (!this.hdD.isAnimating()) {
                this.hdD.cancelAnimation();
                this.hdD.loop(true);
                this.hdD.setMinFrame(0);
                this.hdD.setMaxFrame(80);
                this.hdD.addAnimatorListener(this.hdI);
                this.hdD.removeAnimatorListener(this.hdH);
                this.hdD.playAnimation();
                this.hdE = false;
            }
        } else if (this.hdD.isAnimating()) {
            this.hdD.cancelAnimation();
            this.hdD.loop(false);
            this.hdD.addAnimatorListener(this.hdH);
            this.hdD.removeAnimatorListener(this.hdI);
            this.hdD.setMaxFrame(95);
            this.hdD.setMinFrame(80);
            this.hdD.playAnimation();
        } else {
            this.hdD.cancelAnimation();
            this.hdB.setVisibility(8);
        }
    }

    private void vu(int i) {
        if (i == 8) {
            this.hdC.setImageResource(a.f.icon_liveshow_flowerless);
            this.hdC.setVisibility(0);
            this.hdD.setVisibility(4);
        } else if (i == 0) {
            this.hdC.setImageResource(a.f.icon_liveshow_flower);
            this.hdC.setVisibility(4);
            this.hdD.setVisibility(0);
        }
    }

    @Override // com.baidu.live.z.b
    public void Og() {
        if (!TbadkCoreApplication.isLogin()) {
            vu(8);
        } else {
            vu(0);
        }
    }

    @Override // com.baidu.live.z.b
    public void Oh() {
        this.hdG = null;
        if (this.hdD != null) {
            this.hdD.cancelAnimation();
        }
    }

    @Override // com.baidu.live.z.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hdr);
    }
}
