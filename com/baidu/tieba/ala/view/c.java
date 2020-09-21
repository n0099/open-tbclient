package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.u;
import com.baidu.live.data.z;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c {
    private String aEb;
    private z aFI;
    private String dHt;
    private TbImageView hdZ;
    private LinearLayout hea;
    private LinearLayout heb;
    private TextView hec;
    private ViewGroup hed;
    private TbImageView hee;
    private TextView hef;
    private int heg;
    private AnimatorSet heh;
    private AnimatorSet hei;
    private AnimatorSet hej;
    private AnimatorSet hek;
    private ObjectAnimator hel;
    private AnimatorSet hem;
    private int hen;
    private boolean heo;
    private boolean heq;
    private long liveId;
    private Context mContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private boolean hep = true;
    private Runnable her = new Runnable() { // from class: com.baidu.tieba.ala.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.hep) {
                if (c.this.mRootView == null || c.this.mRootView.getParent() != null) {
                    c.this.ccB();
                }
            }
        }
    };

    public c(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = View.inflate(this.mContext, a.h.ala_pk_rank_level_view, null);
        this.hdZ = (TbImageView) this.mRootView.findViewById(a.g.alaPkLevel);
        this.hed = (ViewGroup) this.mRootView.findViewById(a.g.ll_kingStar_container);
        this.hee = (TbImageView) this.mRootView.findViewById(a.g.kingstar_icon);
        this.hef = (TextView) this.mRootView.findViewById(a.g.kingstar_msg);
        this.hea = (LinearLayout) this.mRootView.findViewById(a.g.alaPkLevelStar);
        this.heb = (LinearLayout) this.mRootView.findViewById(a.g.integralToast);
        this.hec = (TextView) this.mRootView.findViewById(a.g.textInfo);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bY(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(View view) {
        if (!TextUtils.isEmpty(this.aEb)) {
            com.baidu.live.ae.c cVar = new com.baidu.live.ae.c();
            cVar.url = this.aEb;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void setId(int i) {
        this.mRootView.setId(i);
    }

    public void F(u uVar) {
        if (uVar != null && uVar.aFf != null && uVar.aFf.aFI != null && !G(uVar)) {
            cancelAnimation();
            if (uVar.mLiveInfo != null) {
                this.liveId = uVar.mLiveInfo.live_id;
            }
            this.aFI = uVar.aFf.aFI;
            H(uVar);
            this.dHt = uVar.aFf.msg;
            this.heq = uVar.aFf.CQ();
            if (this.heq) {
                this.hep = false;
                com.baidu.live.data.k kVar = uVar.aFf.aFH;
                if (kVar != null) {
                    this.hee.startLoad(kVar.iconUrl, 10, false);
                    this.hef.setText(kVar.msg);
                    ccz();
                    return;
                }
                ccy();
                ccA();
                return;
            }
            ccy();
            ccA();
            this.hep = TextUtils.isEmpty(this.dHt) ? false : true;
            if (this.hep) {
                this.mHandler.removeCallbacks(this.her);
                this.mHandler.postDelayed(this.her, 9000L);
            }
        }
    }

    private boolean G(u uVar) {
        return this.aFI != null && uVar.mLiveInfo != null && this.liveId == uVar.mLiveInfo.live_id && this.aFI.aFE == uVar.aFf.aFI.aFE && TextUtils.equals(this.aFI.division, uVar.aFf.aFI.division) && TextUtils.equals(this.dHt, uVar.aFf.msg) && this.aFI.maxStar == uVar.aFf.aFI.maxStar && this.heq == uVar.aFf.CQ();
    }

    private void ccy() {
        this.hed.setVisibility(8);
        this.hdZ.setVisibility(0);
        this.hea.setVisibility(0);
    }

    private void ccz() {
        this.hed.setVisibility(0);
        this.hdZ.setVisibility(4);
        this.heb.setVisibility(4);
        this.hea.setVisibility(4);
    }

    private void H(u uVar) {
        long j;
        long j2;
        long j3;
        if (uVar.mLiveInfo == null || uVar.aEz == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
        } else {
            long j4 = uVar.aEz.userId;
            long j5 = uVar.mLiveInfo.room_id;
            j = uVar.mLiveInfo.live_id;
            j2 = j5;
            j3 = j4;
        }
        long j6 = uVar.aFb != null ? uVar.aFb.userId : 0L;
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)));
        this.aEb = com.baidu.live.utils.b.a(1, uVar.aFf.aEb, uVar.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(j6)), ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)), String.valueOf(j2), String.valueOf(j), hashMap);
    }

    private void ccA() {
        if (this.aFI != null && !TextUtils.isEmpty(this.aFI.division) && this.aFI.aFE > 0 && this.aFI.maxStar > 0) {
            int i = this.aFI.maxStar - this.aFI.aFE;
            this.hdZ.startLoad(this.aFI.iconUrl, 10, false);
            bS(this.aFI.aFE, i);
        }
    }

    private void bS(int i, int i2) {
        int i3;
        int i4;
        if (this.hea != null && this.heb != null) {
            this.hea.removeAllViews();
            this.hea.setVisibility(0);
            this.heb.setVisibility(4);
            if (i + i2 <= 4) {
                i4 = a.e.sdk_ds5;
                i3 = a.e.sdk_ds28;
            } else {
                i3 = a.e.sdk_ds22;
                i4 = a.e.sdk_ds3;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.mContext, i3), BdUtilHelper.getDimens(this.mContext, i3));
            layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, i4);
            layoutParams.gravity = 16;
            for (int i5 = 0; i5 < i; i5++) {
                this.hea.addView(getSolidStarView(), layoutParams);
            }
            for (int i6 = 0; i6 < i2; i6++) {
                this.hea.addView(getBlankStarView(), layoutParams);
            }
            this.hec.setText(this.dHt);
            this.hen = BdUtilHelper.getTextWidth(this.hec.getPaint(), this.dHt);
            ViewGroup.LayoutParams layoutParams2 = this.hec.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = this.hen;
                this.hec.setLayoutParams(layoutParams2);
            }
            this.hec.setTranslationX(0.0f);
            this.hea.setTranslationY(0.0f);
            this.heb.setTranslationY(0.0f);
            this.hea.setAlpha(1.0f);
            this.hea.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccB() {
        this.heo = true;
        ccH();
        ccI();
        ccG();
        ccE();
        ccD();
        this.hem = new AnimatorSet();
        this.hem.play(this.hej).before(this.hek);
        this.hem.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.hem.removeAllListeners();
                c.this.hem.cancel();
                c.this.ccC();
            }
        });
        this.hem.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccC() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.heo && c.this.hel != null) {
                    c.this.hel.start();
                }
            }
        }, 300L);
    }

    private void ccD() {
        if (this.hei == null) {
            this.hei = ca(this.hea);
            this.hei.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.hea.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (c.this.heo) {
                        c.this.heo = false;
                        c.this.mHandler.postDelayed(c.this.her, 9000L);
                    }
                }
            });
        }
    }

    private void ccE() {
        if (this.heb != null && this.heh == null) {
            this.heh = bZ(this.heb);
            this.heh.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.heb.setVisibility(4);
                    c.this.hec.setTranslationX(0.0f);
                    c.this.ccF();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccF() {
        if (this.heo && this.hei != null) {
            this.hei.start();
        }
    }

    private void ccG() {
        if (this.heb != null) {
            this.heg = this.heb.getWidth();
            this.hel = ObjectAnimator.ofFloat(this.hec, "translationX", 0.0f, -(this.hen - this.heg));
            this.hel.setDuration(IMConnection.RETRY_DELAY_TIMES);
            this.hel.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.ccJ();
                }
            });
        }
    }

    private void ccH() {
        if (this.hej == null) {
            this.hej = bZ(this.hea);
        }
    }

    private void ccI() {
        if (this.hek == null) {
            this.hek = ca(this.heb);
            this.hek.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.heb.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccJ() {
        if (this.heo) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.heo && c.this.heh != null) {
                        c.this.heh.start();
                    }
                }
            }, 7000L);
        }
    }

    private AnimatorSet bZ(final View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -BdUtilHelper.getDimens(this.mContext, a.e.sdk_ds12));
        ofFloat.setDuration(625L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(625L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(4);
                view.setAlpha(1.0f);
                view.setTranslationY(0.0f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet ca(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", BdUtilHelper.getDimens(this.mContext, a.e.sdk_ds12), 0.0f);
        ofFloat.setDuration(625L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(625L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        return animatorSet;
    }

    public View getView() {
        return this.mRootView;
    }

    private View getSolidStarView() {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setImageResource(a.f.ala_icon_five_pointed_star);
        return imageView;
    }

    private View getBlankStarView() {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setImageResource(a.f.ala_icon_blank_five_pointed_star);
        return imageView;
    }

    private void cancelAnimation() {
        if (this.heo) {
            this.heo = false;
            if (this.heh != null) {
                this.heh.cancel();
            }
            if (this.hei != null) {
                this.hei.cancel();
            }
            if (this.hej != null) {
                this.hej.cancel();
            }
            if (this.hek != null) {
                this.hek.cancel();
            }
            if (this.hel != null) {
                this.hel.cancel();
            }
            if (this.hem != null) {
                this.hem.cancel();
            }
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void IT() {
        this.aFI = null;
        this.liveId = 0L;
        cancelAnimation();
    }

    public void onDestroy() {
        cancelAnimation();
    }
}
