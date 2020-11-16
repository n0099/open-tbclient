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
    private w aDh;
    private TBLottieAnimationView gLz;
    private PendantChildView hKc;
    private ImageView hKd;
    private int hKf;
    private an hKg;
    private Context mContext;
    private String otherParams;
    private boolean gts = true;
    private boolean hKe = false;
    private HttpMessageListener hJS = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.taskview.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0) {
                    an anVar = liveFlowerTaskRewardResponsedMessage.hJP;
                    if (anVar == null) {
                        a.this.oi(false);
                    } else if (a.this.hKg != null) {
                        a.this.hKg.aMc = anVar.aMc;
                        a.this.hKg.aMd = anVar.aMd;
                        a.this.a(a.this.hKg.aMc, a.this.hKg);
                    } else {
                        a.this.a(anVar.aMc, anVar);
                    }
                }
            }
        }
    };
    private Animator.AnimatorListener hKh = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.5
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.hKc.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    };
    private Animator.AnimatorListener hKi = new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.taskview.a.6
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
            if (!a.this.hKe) {
                a.this.hKe = true;
                a.this.gLz.setMinFrame(31);
                a.this.gLz.setMaxFrame(80);
            }
        }
    };

    public a(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_task_view, (ViewGroup) null);
        this.hKc = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.taskview.a.1
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
        this.hKc.addView(inflate);
        this.hKd = (ImageView) this.hKc.findViewById(a.f.alaFlowerImg);
        this.gLz = (TBLottieAnimationView) this.hKc.findViewById(a.f.animation_view);
        this.gLz.setAnimation("flower_entry.json");
        this.gLz.setImageAssetsFolder("images/");
        this.gLz.setVisibility(4);
        this.gLz.addAnimatorListener(this.hKi);
        ckI();
        MessageManager.getInstance().registerListener(this.hJS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckH() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913220));
    }

    @Override // com.baidu.live.ad.b
    public PendantChildView Se() {
        return this.hKc;
    }

    @Override // com.baidu.live.ad.b
    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String LU() {
        return this.otherParams;
    }

    private void ckI() {
        this.hKc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.taskview.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_FLOWER);
                    alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                    alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                    alaStaticItem.addParams("other_params", a.this.LU());
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
                a.this.ckK();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(a.this.mContext);
                } else {
                    a.this.ckH();
                }
            }
        });
    }

    @Override // com.baidu.live.ad.b
    public void i(w wVar) {
        if (wVar == null || wVar.aHT == null) {
            oi(false);
            return;
        }
        this.aDh = wVar;
        this.hKg = wVar.aHT;
        a(this.hKg.aMc, this.hKg);
    }

    @Override // com.baidu.live.ad.b
    public void P(JSONObject jSONObject) {
        if (jSONObject == null) {
            oi(false);
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
        this.gts = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, an anVar) {
        if (i >= 1 && i <= 3) {
            this.hKf = i;
        }
        if (anVar != null) {
            if (!ListUtils.isEmpty(anVar.aMd)) {
                if (this.hKf == 2 || anVar.DY()) {
                    if (this.gts) {
                        this.hKc.setVisibility(0);
                        oi(true);
                        ckL();
                        ckJ();
                        return;
                    }
                    oi(false);
                    return;
                }
                oi(false);
                return;
            }
            oi(false);
            return;
        }
        oi(false);
    }

    private void a(int i, am amVar) {
        if (i >= 1 && i <= 3) {
            this.hKf = i;
        }
        if (this.hKg != null) {
            this.hKg.aMc = this.hKf;
            if (this.hKg.aMd != null && amVar != null) {
                Iterator<am> it = this.hKg.aMd.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    am next = it.next();
                    if (next.aLV == amVar.aLV) {
                        next.status = amVar.status;
                        break;
                    }
                }
            }
        }
        if (i == 2) {
            if (this.gts) {
                this.hKc.setVisibility(0);
                oi(true);
                ckL();
                ckJ();
                return;
            }
            oi(false);
            return;
        }
        oi(false);
        if (i == 1 && amVar != null && amVar.DV() && amVar.status == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913035, -1));
        }
    }

    private void ckJ() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "petal_show"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckK() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_clk"));
    }

    private void ckL() {
        if (TbConfig.FLOWER_GUIDE_STATUS == 1) {
            this.hKc.post(new Runnable() { // from class: com.baidu.tieba.ala.taskview.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hKc.getLocationOnScreen(r0);
                    int[] iArr = {iArr[0] + (a.this.hKc.getWidth() / 2), iArr[1] + (a.this.hKc.getHeight() / 2)};
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913110, iArr));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi(boolean z) {
        if (z) {
            if (!this.gLz.isAnimating()) {
                this.gLz.cancelAnimation();
                this.gLz.loop(true);
                this.gLz.setMinFrame(0);
                this.gLz.setMaxFrame(80);
                this.gLz.addAnimatorListener(this.hKi);
                this.gLz.removeAnimatorListener(this.hKh);
                this.gLz.playAnimation();
                this.hKe = false;
            }
        } else if (this.gLz.isAnimating()) {
            this.gLz.cancelAnimation();
            this.gLz.loop(false);
            this.gLz.addAnimatorListener(this.hKh);
            this.gLz.removeAnimatorListener(this.hKi);
            this.gLz.setMaxFrame(95);
            this.gLz.setMinFrame(80);
            this.gLz.playAnimation();
        } else {
            this.gLz.cancelAnimation();
            this.hKc.setVisibility(8);
        }
    }

    private void xf(int i) {
        if (i == 8) {
            this.hKd.setImageResource(a.e.icon_liveshow_flowerless);
            this.hKd.setVisibility(0);
            this.gLz.setVisibility(4);
        } else if (i == 0) {
            this.hKd.setImageResource(a.e.icon_liveshow_flower);
            this.hKd.setVisibility(4);
            this.gLz.setVisibility(0);
        }
    }

    @Override // com.baidu.live.ad.b
    public void Sf() {
        if (!TbadkCoreApplication.isLogin()) {
            xf(8);
        } else {
            xf(0);
        }
    }

    @Override // com.baidu.live.ad.b
    public void Sg() {
        this.hKg = null;
        if (this.gLz != null) {
            this.gLz.cancelAnimation();
        }
    }

    @Override // com.baidu.live.ad.b
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hJS);
    }
}
