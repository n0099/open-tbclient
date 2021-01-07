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
import com.baidu.live.data.aq;
import com.baidu.live.data.x;
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
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.ai.b {
    private TBLottieAnimationView hgB;
    private int ihB;
    private aq ihC;
    private PendantChildView ihy;
    private ImageView ihz;
    private Context mContext;
    private String otherParams;
    private boolean gNK = true;
    private boolean ihA = false;
    private HttpMessageListener iho = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    aq aqVar = liveFlowerTaskRewardResponsedMessage.ihl;
                    if (aqVar == null) {
                        a.this.pd(false);
                    } else if (a.this.ihC != null) {
                        a.this.ihC.aPG = aqVar.aPG;
                        a.this.ihC.aPH = aqVar.aPH;
                        a.this.a(a.this.ihC.aPG, a.this.ihC);
                    } else {
                        a.this.a(aqVar.aPG, aqVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener ihD = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.ihy.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private Animator.AnimatorListener ihE = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.6
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
            if (!a.this.ihA) {
                a.this.ihA = true;
                a.this.hgB.setMinFrame(31);
                a.this.hgB.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_task_view, (ViewGroup) null);
        this.ihy = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.taskview.a.1
            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPkPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalBBChattingPosition() {
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
        this.ihy.addView(inflate);
        this.ihz = (ImageView) this.ihy.findViewById(a.f.alaFlowerImg);
        this.hgB = (TBLottieAnimationView) this.ihy.findViewById(a.f.animation_view);
        this.hgB.setAnimation("flower_entry.json");
        this.hgB.setImageAssetsFolder("images/");
        this.hgB.setVisibility(4);
        this.hgB.addAnimatorListener(this.ihE);
        crS();
        MessageManager.getInstance().registerListener(this.iho);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crR() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
    }

    @Override // com.baidu.live.ai.b
    public PendantChildView VH() {
        return this.ihy;
    }

    @Override // com.baidu.live.ai.b
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String NL() {
        return this.otherParams;
    }

    private void crS() {
        this.ihy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                    alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                    alaStaticItem.addParams("other_params", a.this.NL());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                a.this.crU();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.crR();
                }
            }
        });
    }

    @Override // com.baidu.live.ai.b
    public void j(x xVar) {
    }

    @Override // com.baidu.live.ai.b
    public void Z(JSONObject jSONObject) {
    }

    @Override // com.baidu.live.ai.b
    public void setCanVisible(boolean z) {
        this.gNK = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, aq aqVar) {
        if (i >= 1 && i <= 3) {
            this.ihB = i;
        }
        if (aqVar != null) {
            if (!ListUtils.isEmpty(aqVar.aPH)) {
                if (this.ihB == 2 || aqVar.EZ()) {
                    if (this.gNK) {
                        this.ihy.setVisibility(0);
                        pd(true);
                        crV();
                        crT();
                        return;
                    }
                    pd(false);
                    return;
                }
                pd(false);
                return;
            }
            pd(false);
            return;
        }
        pd(false);
    }

    private void crT() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crU() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void crV() {
        if (TbConfig.FLOWER_GUIDE_STATUS == 1) {
            this.ihy.post(new Runnable() { // from class: com.baidu.tieba.ala.taskview.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ihy.getLocationOnScreen(r0);
                    int[] iArr = {iArr[0] + (a.this.ihy.getWidth() / 2), iArr[1] + (a.this.ihy.getHeight() / 2)};
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913110, iArr));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pd(boolean z) {
        if (z) {
            if (!this.hgB.isAnimating()) {
                this.hgB.cancelAnimation();
                this.hgB.loop(true);
                this.hgB.setMinFrame(0);
                this.hgB.setMaxFrame(80);
                this.hgB.addAnimatorListener(this.ihE);
                this.hgB.removeAnimatorListener(this.ihD);
                this.hgB.playAnimation();
                this.ihA = false;
            }
        } else if (this.hgB.isAnimating()) {
            this.hgB.cancelAnimation();
            this.hgB.loop(false);
            this.hgB.addAnimatorListener(this.ihD);
            this.hgB.removeAnimatorListener(this.ihE);
            this.hgB.setMaxFrame(95);
            this.hgB.setMinFrame(80);
            this.hgB.playAnimation();
        } else {
            this.hgB.cancelAnimation();
            this.ihy.setVisibility(8);
        }
    }

    private void xY(int i) {
        if (i == 8) {
            this.ihz.setImageResource(a.e.icon_liveshow_flowerless);
            this.ihz.setVisibility(0);
            this.hgB.setVisibility(4);
        } else if (i == 0) {
            this.ihz.setImageResource(a.e.icon_liveshow_flower);
            this.ihz.setVisibility(4);
            this.hgB.setVisibility(0);
        }
    }

    @Override // com.baidu.live.ai.b
    public void VI() {
        if (!TbadkCoreApplication.isLogin()) {
            xY(8);
        } else {
            xY(0);
        }
    }

    @Override // com.baidu.live.ai.b
    public void VJ() {
        this.ihC = null;
        if (this.hgB != null) {
            this.hgB.cancelAnimation();
        }
    }

    @Override // com.baidu.live.ai.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iho);
    }
}
