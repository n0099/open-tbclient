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
import com.baidu.live.data.ab;
import com.baidu.live.data.au;
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
public class a implements com.baidu.live.ag.b {
    private TBLottieAnimationView heS;
    private PendantChildView ihU;
    private ImageView ihV;
    private int ihX;
    private au ihY;
    private Context mContext;
    private String otherParams;
    private boolean gLY = true;
    private boolean ihW = false;
    private HttpMessageListener ihK = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    au auVar = liveFlowerTaskRewardResponsedMessage.ihH;
                    if (auVar == null) {
                        a.this.pj(false);
                    } else if (a.this.ihY != null) {
                        a.this.ihY.aNP = auVar.aNP;
                        a.this.ihY.aNQ = auVar.aNQ;
                        a.this.a(a.this.ihY.aNP, a.this.ihY);
                    } else {
                        a.this.a(auVar.aNP, auVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener ihZ = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.ihU.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private Animator.AnimatorListener iia = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.6
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
            if (!a.this.ihW) {
                a.this.ihW = true;
                a.this.heS.setMinFrame(31);
                a.this.heS.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_task_view, (ViewGroup) null);
        this.ihU = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.taskview.a.1
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
        this.ihU.addView(inflate);
        this.ihV = (ImageView) this.ihU.findViewById(a.f.alaFlowerImg);
        this.heS = (TBLottieAnimationView) this.ihU.findViewById(a.f.animation_view);
        this.heS.setAnimation("flower_entry.json");
        this.heS.setImageAssetsFolder("images/");
        this.heS.setVisibility(4);
        this.heS.addAnimatorListener(this.iia);
        cpm();
        MessageManager.getInstance().registerListener(this.ihK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpl() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
    }

    @Override // com.baidu.live.ag.b
    public PendantChildView Tv() {
        return this.ihU;
    }

    @Override // com.baidu.live.ag.b
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Lo() {
        return this.otherParams;
    }

    private void cpm() {
        this.ihU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                    alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                    alaStaticItem.addParams("other_params", a.this.Lo());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                a.this.cpo();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.cpl();
                }
            }
        });
    }

    @Override // com.baidu.live.ag.b
    public void j(ab abVar) {
    }

    @Override // com.baidu.live.ag.b
    public void ab(JSONObject jSONObject) {
    }

    @Override // com.baidu.live.ag.b
    public void setCanVisible(boolean z) {
        this.gLY = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, au auVar) {
        if (i >= 1 && i <= 3) {
            this.ihX = i;
        }
        if (auVar != null) {
            if (!ListUtils.isEmpty(auVar.aNQ)) {
                if (this.ihX == 2 || auVar.Cr()) {
                    if (this.gLY) {
                        this.ihU.setVisibility(0);
                        pj(true);
                        cpp();
                        cpn();
                        return;
                    }
                    pj(false);
                    return;
                }
                pj(false);
                return;
            }
            pj(false);
            return;
        }
        pj(false);
    }

    private void cpn() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpo() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void cpp() {
        if (TbConfig.FLOWER_GUIDE_STATUS == 1) {
            this.ihU.post(new Runnable() { // from class: com.baidu.tieba.ala.taskview.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ihU.getLocationOnScreen(r0);
                    int[] iArr = {iArr[0] + (a.this.ihU.getWidth() / 2), iArr[1] + (a.this.ihU.getHeight() / 2)};
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913110, iArr));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pj(boolean z) {
        if (z) {
            if (!this.heS.isAnimating()) {
                this.heS.cancelAnimation();
                this.heS.loop(true);
                this.heS.setMinFrame(0);
                this.heS.setMaxFrame(80);
                this.heS.addAnimatorListener(this.iia);
                this.heS.removeAnimatorListener(this.ihZ);
                this.heS.playAnimation();
                this.ihW = false;
            }
        } else if (this.heS.isAnimating()) {
            this.heS.cancelAnimation();
            this.heS.loop(false);
            this.heS.addAnimatorListener(this.ihZ);
            this.heS.removeAnimatorListener(this.iia);
            this.heS.setMaxFrame(95);
            this.heS.setMinFrame(80);
            this.heS.playAnimation();
        } else {
            this.heS.cancelAnimation();
            this.ihU.setVisibility(8);
        }
    }

    private void wD(int i) {
        if (i == 8) {
            this.ihV.setImageResource(a.e.icon_liveshow_flowerless);
            this.ihV.setVisibility(0);
            this.heS.setVisibility(4);
        } else if (i == 0) {
            this.ihV.setImageResource(a.e.icon_liveshow_flower);
            this.ihV.setVisibility(4);
            this.heS.setVisibility(0);
        }
    }

    @Override // com.baidu.live.ag.b
    public void Tw() {
        if (!TbadkCoreApplication.isLogin()) {
            wD(8);
        } else {
            wD(0);
        }
    }

    @Override // com.baidu.live.ag.b
    public void Tx() {
        this.ihY = null;
        if (this.heS != null) {
            this.heS.cancelAnimation();
        }
    }

    @Override // com.baidu.live.ag.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ihK);
    }
}
