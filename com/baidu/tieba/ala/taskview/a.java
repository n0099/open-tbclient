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
import com.baidu.live.data.am;
import com.baidu.live.data.an;
import com.baidu.live.data.w;
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
public class a implements com.baidu.live.ad.b {
    private w aES;
    private TBLottieAnimationView gLS;
    private PendantChildView hKv;
    private ImageView hKw;
    private int hKy;
    private an hKz;
    private Context mContext;
    private String otherParams;
    private boolean gtL = true;
    private boolean hKx = false;
    private HttpMessageListener hKl = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    an anVar = liveFlowerTaskRewardResponsedMessage.hKi;
                    if (anVar == null) {
                        a.this.oh(false);
                    } else if (a.this.hKz != null) {
                        a.this.hKz.aNN = anVar.aNN;
                        a.this.hKz.aNO = anVar.aNO;
                        a.this.a(a.this.hKz.aNN, a.this.hKz);
                    } else {
                        a.this.a(anVar.aNN, anVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener hKA = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.hKv.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private Animator.AnimatorListener hKB = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.6
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
            if (!a.this.hKx) {
                a.this.hKx = true;
                a.this.gLS.setMinFrame(31);
                a.this.gLS.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_task_view, (ViewGroup) null);
        this.hKv = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.taskview.a.1
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
        this.hKv.addView(inflate);
        this.hKw = (ImageView) this.hKv.findViewById(a.f.alaFlowerImg);
        this.gLS = (TBLottieAnimationView) this.hKv.findViewById(a.f.animation_view);
        this.gLS.setAnimation("flower_entry.json");
        this.gLS.setImageAssetsFolder("images/");
        this.gLS.setVisibility(4);
        this.gLS.addAnimatorListener(this.hKB);
        clp();
        MessageManager.getInstance().registerListener(this.hKl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clo() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
    }

    @Override // com.baidu.live.ad.b
    public PendantChildView SN() {
        return this.hKv;
    }

    @Override // com.baidu.live.ad.b
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String MD() {
        return this.otherParams;
    }

    private void clp() {
        this.hKv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                    alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                    alaStaticItem.addParams("other_params", a.this.MD());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                a.this.clr();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.clo();
                }
            }
        });
    }

    @Override // com.baidu.live.ad.b
    public void i(w wVar) {
        if (wVar == null || wVar.aJE == null) {
            oh(false);
            return;
        }
        this.aES = wVar;
        this.hKz = wVar.aJE;
        a(this.hKz.aNN, this.hKz);
    }

    @Override // com.baidu.live.ad.b
    public void V(JSONObject jSONObject) {
        if (jSONObject == null) {
            oh(false);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
        am amVar = new am();
        if (optJSONObject != null) {
            amVar.parseJson(optJSONObject);
        }
        a(amVar.status, amVar);
    }

    @Override // com.baidu.live.ad.b
    public void setCanVisible(boolean z) {
        this.gtL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, an anVar) {
        if (i >= 1 && i <= 3) {
            this.hKy = i;
        }
        if (anVar != null) {
            if (!ListUtils.isEmpty(anVar.aNO)) {
                if (this.hKy == 2 || anVar.EH()) {
                    if (this.gtL) {
                        this.hKv.setVisibility(0);
                        oh(true);
                        cls();
                        clq();
                        return;
                    }
                    oh(false);
                    return;
                }
                oh(false);
                return;
            }
            oh(false);
            return;
        }
        oh(false);
    }

    private void a(int i, am amVar) {
        if (i >= 1 && i <= 3) {
            this.hKy = i;
        }
        if (this.hKz != null) {
            this.hKz.aNN = this.hKy;
            if (this.hKz.aNO != null && amVar != null) {
                Iterator<am> it = this.hKz.aNO.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    am next = it.next();
                    if (next.aNG == amVar.aNG) {
                        next.status = amVar.status;
                        break;
                    }
                }
            }
        }
        if (i == 2) {
            if (this.gtL) {
                this.hKv.setVisibility(0);
                oh(true);
                cls();
                clq();
                return;
            }
            oh(false);
            return;
        }
        oh(false);
        if (i == 1 && amVar != null && amVar.EE() && amVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void clq() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clr() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void cls() {
        if (TbConfig.FLOWER_GUIDE_STATUS == 1) {
            this.hKv.post(new Runnable() { // from class: com.baidu.tieba.ala.taskview.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hKv.getLocationOnScreen(r0);
                    int[] iArr = {iArr[0] + (a.this.hKv.getWidth() / 2), iArr[1] + (a.this.hKv.getHeight() / 2)};
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913110, iArr));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oh(boolean z) {
        if (z) {
            if (!this.gLS.isAnimating()) {
                this.gLS.cancelAnimation();
                this.gLS.loop(true);
                this.gLS.setMinFrame(0);
                this.gLS.setMaxFrame(80);
                this.gLS.addAnimatorListener(this.hKB);
                this.gLS.removeAnimatorListener(this.hKA);
                this.gLS.playAnimation();
                this.hKx = false;
            }
        } else if (this.gLS.isAnimating()) {
            this.gLS.cancelAnimation();
            this.gLS.loop(false);
            this.gLS.addAnimatorListener(this.hKA);
            this.gLS.removeAnimatorListener(this.hKB);
            this.gLS.setMaxFrame(95);
            this.gLS.setMinFrame(80);
            this.gLS.playAnimation();
        } else {
            this.gLS.cancelAnimation();
            this.hKv.setVisibility(8);
        }
    }

    private void wH(int i) {
        if (i == 8) {
            this.hKw.setImageResource(a.e.icon_liveshow_flowerless);
            this.hKw.setVisibility(0);
            this.gLS.setVisibility(4);
        } else if (i == 0) {
            this.hKw.setImageResource(a.e.icon_liveshow_flower);
            this.hKw.setVisibility(4);
            this.gLS.setVisibility(0);
        }
    }

    @Override // com.baidu.live.ad.b
    public void SO() {
        if (!TbadkCoreApplication.isLogin()) {
            wH(8);
        } else {
            wH(0);
        }
    }

    @Override // com.baidu.live.ad.b
    public void SP() {
        this.hKz = null;
        if (this.gLS != null) {
            this.gLS.cancelAnimation();
        }
    }

    @Override // com.baidu.live.ad.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hKl);
    }
}
