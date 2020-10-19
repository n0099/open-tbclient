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
    private String aHf;
    private z aIM;
    private String dTu;
    private TbImageView htc;
    private LinearLayout htd;
    private LinearLayout hte;
    private TextView htf;
    private ViewGroup htg;
    private TbImageView hth;
    private TextView hti;
    private int htj;
    private AnimatorSet htk;
    private AnimatorSet htl;
    private AnimatorSet htm;
    private AnimatorSet htn;
    private ObjectAnimator hto;
    private AnimatorSet htp;
    private int htq;
    private boolean htr;
    private boolean htt;
    private long liveId;
    private Context mContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private boolean hts = true;
    private Runnable htu = new Runnable() { // from class: com.baidu.tieba.ala.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.hts) {
                if (c.this.mRootView == null || c.this.mRootView.getParent() != null) {
                    c.this.cfX();
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
        this.htc = (TbImageView) this.mRootView.findViewById(a.g.alaPkLevel);
        this.htg = (ViewGroup) this.mRootView.findViewById(a.g.ll_kingStar_container);
        this.hth = (TbImageView) this.mRootView.findViewById(a.g.kingstar_icon);
        this.hti = (TextView) this.mRootView.findViewById(a.g.kingstar_msg);
        this.htd = (LinearLayout) this.mRootView.findViewById(a.g.alaPkLevelStar);
        this.hte = (LinearLayout) this.mRootView.findViewById(a.g.integralToast);
        this.htf = (TextView) this.mRootView.findViewById(a.g.textInfo);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cc(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(View view) {
        if (!TextUtils.isEmpty(this.aHf)) {
            com.baidu.live.af.c cVar = new com.baidu.live.af.c();
            cVar.url = this.aHf;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void setId(int i) {
        this.mRootView.setId(i);
    }

    public void G(u uVar) {
        if (uVar != null && uVar.aIj != null && uVar.aIj.aIM != null && !H(uVar)) {
            cancelAnimation();
            if (uVar.mLiveInfo != null) {
                this.liveId = uVar.mLiveInfo.live_id;
            }
            this.aIM = uVar.aIj.aIM;
            I(uVar);
            this.dTu = uVar.aIj.msg;
            this.htt = uVar.aIj.DN();
            if (this.htt) {
                this.hts = false;
                com.baidu.live.data.k kVar = uVar.aIj.aIL;
                if (kVar != null) {
                    this.hth.startLoad(kVar.iconUrl, 10, false);
                    this.hti.setText(kVar.msg);
                    cfV();
                    return;
                }
                cfU();
                cfW();
                return;
            }
            cfU();
            cfW();
            this.hts = TextUtils.isEmpty(this.dTu) ? false : true;
            if (this.hts) {
                this.mHandler.removeCallbacks(this.htu);
                this.mHandler.postDelayed(this.htu, 9000L);
            }
        }
    }

    private boolean H(u uVar) {
        return this.aIM != null && uVar.mLiveInfo != null && this.liveId == uVar.mLiveInfo.live_id && this.aIM.aII == uVar.aIj.aIM.aII && TextUtils.equals(this.aIM.division, uVar.aIj.aIM.division) && TextUtils.equals(this.dTu, uVar.aIj.msg) && this.aIM.maxStar == uVar.aIj.aIM.maxStar && this.htt == uVar.aIj.DN();
    }

    private void cfU() {
        this.htg.setVisibility(8);
        this.htc.setVisibility(0);
        this.htd.setVisibility(0);
    }

    private void cfV() {
        this.htg.setVisibility(0);
        this.htc.setVisibility(4);
        this.hte.setVisibility(4);
        this.htd.setVisibility(4);
    }

    private void I(u uVar) {
        long j;
        long j2;
        long j3;
        if (uVar.mLiveInfo == null || uVar.aHD == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
        } else {
            long j4 = uVar.aHD.userId;
            long j5 = uVar.mLiveInfo.room_id;
            j = uVar.mLiveInfo.live_id;
            j2 = j5;
            j3 = j4;
        }
        long j6 = uVar.aIf != null ? uVar.aIf.userId : 0L;
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)));
        this.aHf = com.baidu.live.utils.b.a(1, uVar.aIj.aHf, uVar.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(j6)), ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)), String.valueOf(j2), String.valueOf(j), hashMap);
    }

    private void cfW() {
        if (this.aIM != null && !TextUtils.isEmpty(this.aIM.division) && this.aIM.aII > 0 && this.aIM.maxStar > 0) {
            int i = this.aIM.maxStar - this.aIM.aII;
            this.htc.startLoad(this.aIM.iconUrl, 10, false);
            bS(this.aIM.aII, i);
        }
    }

    private void bS(int i, int i2) {
        int i3;
        int i4;
        if (this.htd != null && this.hte != null) {
            this.htd.removeAllViews();
            this.htd.setVisibility(0);
            this.hte.setVisibility(4);
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
                this.htd.addView(getSolidStarView(), layoutParams);
            }
            for (int i6 = 0; i6 < i2; i6++) {
                this.htd.addView(getBlankStarView(), layoutParams);
            }
            this.htf.setText(this.dTu);
            this.htq = BdUtilHelper.getTextWidth(this.htf.getPaint(), this.dTu);
            ViewGroup.LayoutParams layoutParams2 = this.htf.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = this.htq;
                this.htf.setLayoutParams(layoutParams2);
            }
            this.htf.setTranslationX(0.0f);
            this.htd.setTranslationY(0.0f);
            this.hte.setTranslationY(0.0f);
            this.htd.setAlpha(1.0f);
            this.htd.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfX() {
        this.htr = true;
        cgd();
        cge();
        cgc();
        cga();
        cfZ();
        this.htp = new AnimatorSet();
        this.htp.play(this.htm).before(this.htn);
        this.htp.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.htp.removeAllListeners();
                c.this.htp.cancel();
                c.this.cfY();
            }
        });
        this.htp.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfY() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.htr && c.this.hto != null) {
                    c.this.hto.start();
                }
            }
        }, 300L);
    }

    private void cfZ() {
        if (this.htl == null) {
            this.htl = ce(this.htd);
            this.htl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.htd.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (c.this.htr) {
                        c.this.htr = false;
                        c.this.mHandler.postDelayed(c.this.htu, 9000L);
                    }
                }
            });
        }
    }

    private void cga() {
        if (this.hte != null && this.htk == null) {
            this.htk = cd(this.hte);
            this.htk.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.hte.setVisibility(4);
                    c.this.htf.setTranslationX(0.0f);
                    c.this.cgb();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgb() {
        if (this.htr && this.htl != null) {
            this.htl.start();
        }
    }

    private void cgc() {
        if (this.hte != null) {
            this.htj = this.hte.getWidth();
            this.hto = ObjectAnimator.ofFloat(this.htf, "translationX", 0.0f, -(this.htq - this.htj));
            this.hto.setDuration(IMConnection.RETRY_DELAY_TIMES);
            this.hto.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.cgf();
                }
            });
        }
    }

    private void cgd() {
        if (this.htm == null) {
            this.htm = cd(this.htd);
        }
    }

    private void cge() {
        if (this.htn == null) {
            this.htn = ce(this.hte);
            this.htn.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.hte.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgf() {
        if (this.htr) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.htr && c.this.htk != null) {
                        c.this.htk.start();
                    }
                }
            }, 7000L);
        }
    }

    private AnimatorSet cd(final View view) {
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

    private AnimatorSet ce(View view) {
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
        if (this.htr) {
            this.htr = false;
            if (this.htk != null) {
                this.htk.cancel();
            }
            if (this.htl != null) {
                this.htl.cancel();
            }
            if (this.htm != null) {
                this.htm.cancel();
            }
            if (this.htn != null) {
                this.htn.cancel();
            }
            if (this.hto != null) {
                this.hto.cancel();
            }
            if (this.htp != null) {
                this.htp.cancel();
            }
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void JQ() {
        this.aIM = null;
        this.liveId = 0L;
        cancelAnimation();
    }

    public void onDestroy() {
        cancelAnimation();
    }
}
