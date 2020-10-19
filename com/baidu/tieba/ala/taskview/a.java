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
    private u aDU;
    private PendantChildView hsE;
    private ImageView hsF;
    private TBLottieAnimationView hsG;
    private int hsI;
    private aj hsJ;
    private Context mContext;
    private String otherParams;
    private boolean gdU = true;
    private boolean hsH = false;
    private HttpMessageListener hsu = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    aj ajVar = liveFlowerTaskRewardResponsedMessage.hsr;
                    if (ajVar == null) {
                        a.this.nH(false);
                    } else if (a.this.hsJ != null) {
                        a.this.hsJ.aMg = ajVar.aMg;
                        a.this.hsJ.aMh = ajVar.aMh;
                        a.this.a(a.this.hsJ.aMg, a.this.hsJ);
                    } else {
                        a.this.a(ajVar.aMg, ajVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener hsK = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.hsE.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private Animator.AnimatorListener hsL = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.6
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
            if (!a.this.hsH) {
                a.this.hsH = true;
                a.this.hsG.setMinFrame(31);
                a.this.hsG.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_task_view, (ViewGroup) null);
        this.hsE = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.taskview.a.1
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
        this.hsE.addView(inflate);
        this.hsF = (ImageView) this.hsE.findViewById(a.g.alaFlowerImg);
        this.hsG = (TBLottieAnimationView) this.hsE.findViewById(a.g.animation_view);
        this.hsG.setAnimation("flower_entry.json");
        this.hsG.setImageAssetsFolder("images/");
        this.hsG.setVisibility(4);
        this.hsG.addAnimatorListener(this.hsL);
        cfM();
        MessageManager.getInstance().registerListener(this.hsu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfL() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
    }

    @Override // com.baidu.live.z.b
    public PendantChildView Pk() {
        return this.hsE;
    }

    @Override // com.baidu.live.z.b
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String LI() {
        return this.otherParams;
    }

    private void cfM() {
        this.hsE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                    alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                    alaStaticItem.addParams("other_params", a.this.LI());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                a.this.cfO();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.cfL();
                }
            }
        });
    }

    @Override // com.baidu.live.z.b
    public void k(u uVar) {
        if (uVar == null || uVar.aIq == null) {
            nH(false);
            return;
        }
        this.aDU = uVar;
        this.hsJ = uVar.aIq;
        a(this.hsJ.aMg, this.hsJ);
    }

    @Override // com.baidu.live.z.b
    public void P(JSONObject jSONObject) {
        if (jSONObject == null) {
            nH(false);
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
        this.gdU = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, aj ajVar) {
        if (i >= 1 && i <= 3) {
            this.hsI = i;
        }
        if (ajVar != null) {
            if (!ListUtils.isEmpty(ajVar.aMh)) {
                if (this.hsI == 2 || ajVar.Ec()) {
                    if (this.gdU) {
                        this.hsE.setVisibility(0);
                        nH(true);
                        cfP();
                        cfN();
                        return;
                    }
                    nH(false);
                    return;
                }
                nH(false);
                return;
            }
            nH(false);
            return;
        }
        nH(false);
    }

    private void a(int i, ai aiVar) {
        if (i >= 1 && i <= 3) {
            this.hsI = i;
        }
        if (this.hsJ != null) {
            this.hsJ.aMg = this.hsI;
            if (this.hsJ.aMh != null && aiVar != null) {
                Iterator<ai> it = this.hsJ.aMh.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ai next = it.next();
                    if (next.aLZ == aiVar.aLZ) {
                        next.status = aiVar.status;
                        break;
                    }
                }
            }
        }
        if (i == 2) {
            if (this.gdU) {
                this.hsE.setVisibility(0);
                nH(true);
                cfP();
                cfN();
                return;
            }
            nH(false);
            return;
        }
        nH(false);
        if (i == 1 && aiVar != null && aiVar.DZ() && aiVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void cfN() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfO() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void cfP() {
        if (TbConfig.FLOWER_GUIDE_STATUS == 1) {
            this.hsE.post(new Runnable() { // from class: com.baidu.tieba.ala.taskview.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hsE.getLocationOnScreen(r0);
                    int[] iArr = {iArr[0] + (a.this.hsE.getWidth() / 2), iArr[1] + (a.this.hsE.getHeight() / 2)};
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913110, iArr));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nH(boolean z) {
        if (z) {
            if (!this.hsG.isAnimating()) {
                this.hsG.cancelAnimation();
                this.hsG.loop(true);
                this.hsG.setMinFrame(0);
                this.hsG.setMaxFrame(80);
                this.hsG.addAnimatorListener(this.hsL);
                this.hsG.removeAnimatorListener(this.hsK);
                this.hsG.playAnimation();
                this.hsH = false;
            }
        } else if (this.hsG.isAnimating()) {
            this.hsG.cancelAnimation();
            this.hsG.loop(false);
            this.hsG.addAnimatorListener(this.hsK);
            this.hsG.removeAnimatorListener(this.hsL);
            this.hsG.setMaxFrame(95);
            this.hsG.setMinFrame(80);
            this.hsG.playAnimation();
        } else {
            this.hsG.cancelAnimation();
            this.hsE.setVisibility(8);
        }
    }

    private void wa(int i) {
        if (i == 8) {
            this.hsF.setImageResource(a.f.icon_liveshow_flowerless);
            this.hsF.setVisibility(0);
            this.hsG.setVisibility(4);
        } else if (i == 0) {
            this.hsF.setImageResource(a.f.icon_liveshow_flower);
            this.hsF.setVisibility(4);
            this.hsG.setVisibility(0);
        }
    }

    @Override // com.baidu.live.z.b
    public void Pl() {
        if (!TbadkCoreApplication.isLogin()) {
            wa(8);
        } else {
            wa(0);
        }
    }

    @Override // com.baidu.live.z.b
    public void Pm() {
        this.hsJ = null;
        if (this.hsG != null) {
            this.hsG.cancelAnimation();
        }
    }

    @Override // com.baidu.live.z.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hsu);
    }
}
