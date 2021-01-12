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
/* loaded from: classes10.dex */
public class a implements com.baidu.live.ai.b {
    private TBLottieAnimationView hbV;
    private PendantChildView icN;
    private ImageView icO;
    private int icQ;
    private aq icR;
    private Context mContext;
    private String otherParams;
    private boolean gJe = true;
    private boolean icP = false;
    private HttpMessageListener icD = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    aq aqVar = liveFlowerTaskRewardResponsedMessage.icA;
                    if (aqVar == null) {
                        a.this.oZ(false);
                    } else if (a.this.icR != null) {
                        a.this.icR.aKT = aqVar.aKT;
                        a.this.icR.aKU = aqVar.aKU;
                        a.this.a(a.this.icR.aKT, a.this.icR);
                    } else {
                        a.this.a(aqVar.aKT, aqVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener icS = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.icN.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private Animator.AnimatorListener icT = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.6
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
            if (!a.this.icP) {
                a.this.icP = true;
                a.this.hbV.setMinFrame(31);
                a.this.hbV.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_task_view, (ViewGroup) null);
        this.icN = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.taskview.a.1
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
        this.icN.addView(inflate);
        this.icO = (ImageView) this.icN.findViewById(a.f.alaFlowerImg);
        this.hbV = (TBLottieAnimationView) this.icN.findViewById(a.f.animation_view);
        this.hbV.setAnimation("flower_entry.json");
        this.hbV.setImageAssetsFolder("images/");
        this.hbV.setVisibility(4);
        this.hbV.addAnimatorListener(this.icT);
        coa();
        MessageManager.getInstance().registerListener(this.icD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnZ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
    }

    @Override // com.baidu.live.ai.b
    public PendantChildView RO() {
        return this.icN;
    }

    @Override // com.baidu.live.ai.b
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String JQ() {
        return this.otherParams;
    }

    private void coa() {
        this.icN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                    alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                    alaStaticItem.addParams("other_params", a.this.JQ());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                a.this.coc();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.cnZ();
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
        this.gJe = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, aq aqVar) {
        if (i >= 1 && i <= 3) {
            this.icQ = i;
        }
        if (aqVar != null) {
            if (!ListUtils.isEmpty(aqVar.aKU)) {
                if (this.icQ == 2 || aqVar.Be()) {
                    if (this.gJe) {
                        this.icN.setVisibility(0);
                        oZ(true);
                        cod();
                        cob();
                        return;
                    }
                    oZ(false);
                    return;
                }
                oZ(false);
                return;
            }
            oZ(false);
            return;
        }
        oZ(false);
    }

    private void cob() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coc() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void cod() {
        if (TbConfig.FLOWER_GUIDE_STATUS == 1) {
            this.icN.post(new Runnable() { // from class: com.baidu.tieba.ala.taskview.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.icN.getLocationOnScreen(r0);
                    int[] iArr = {iArr[0] + (a.this.icN.getWidth() / 2), iArr[1] + (a.this.icN.getHeight() / 2)};
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913110, iArr));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oZ(boolean z) {
        if (z) {
            if (!this.hbV.isAnimating()) {
                this.hbV.cancelAnimation();
                this.hbV.loop(true);
                this.hbV.setMinFrame(0);
                this.hbV.setMaxFrame(80);
                this.hbV.addAnimatorListener(this.icT);
                this.hbV.removeAnimatorListener(this.icS);
                this.hbV.playAnimation();
                this.icP = false;
            }
        } else if (this.hbV.isAnimating()) {
            this.hbV.cancelAnimation();
            this.hbV.loop(false);
            this.hbV.addAnimatorListener(this.icS);
            this.hbV.removeAnimatorListener(this.icT);
            this.hbV.setMaxFrame(95);
            this.hbV.setMinFrame(80);
            this.hbV.playAnimation();
        } else {
            this.hbV.cancelAnimation();
            this.icN.setVisibility(8);
        }
    }

    private void ws(int i) {
        if (i == 8) {
            this.icO.setImageResource(a.e.icon_liveshow_flowerless);
            this.icO.setVisibility(0);
            this.hbV.setVisibility(4);
        } else if (i == 0) {
            this.icO.setImageResource(a.e.icon_liveshow_flower);
            this.icO.setVisibility(4);
            this.hbV.setVisibility(0);
        }
    }

    @Override // com.baidu.live.ai.b
    public void RP() {
        if (!TbadkCoreApplication.isLogin()) {
            ws(8);
        } else {
            ws(0);
        }
    }

    @Override // com.baidu.live.ai.b
    public void RQ() {
        this.icR = null;
        if (this.hbV != null) {
            this.hbV.cancelAnimation();
        }
    }

    @Override // com.baidu.live.ai.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.icD);
    }
}
