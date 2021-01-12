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
import com.baidu.live.data.ad;
import com.baidu.live.data.o;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class c {
    private String aEU;
    private ad aHg;
    private String erX;
    private int idA;
    private boolean idB;
    private boolean idD;
    private TbImageView idi;
    private LinearLayout idj;
    private LinearLayout idk;
    private TextView idm;
    private ViewGroup idn;
    private TbImageView ido;
    private TextView idp;
    private int idq;
    private AnimatorSet idr;
    private AnimatorSet idu;
    private AnimatorSet idv;
    private AnimatorSet idw;
    private ObjectAnimator idy;
    private AnimatorSet idz;
    private long liveId;
    private Context mContext;
    private View mRootView;
    private Handler mHandler = new Handler();
    private boolean idC = true;
    private Runnable idE = new Runnable() { // from class: com.baidu.tieba.ala.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.idC) {
                if (c.this.mRootView == null || c.this.mRootView.getParent() != null) {
                    c.this.cok();
                }
            }
        }
    };

    public c(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = View.inflate(this.mContext, a.g.ala_pk_rank_level_view, null);
        this.idi = (TbImageView) this.mRootView.findViewById(a.f.alaPkLevel);
        this.idn = (ViewGroup) this.mRootView.findViewById(a.f.ll_kingStar_container);
        this.ido = (TbImageView) this.mRootView.findViewById(a.f.kingstar_icon);
        this.idp = (TextView) this.mRootView.findViewById(a.f.kingstar_msg);
        this.idj = (LinearLayout) this.mRootView.findViewById(a.f.alaPkLevelStar);
        this.idk = (LinearLayout) this.mRootView.findViewById(a.f.integralToast);
        this.idm = (TextView) this.mRootView.findViewById(a.f.textInfo);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cF(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(View view) {
        if (!TextUtils.isEmpty(this.aEU)) {
            com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
            cVar.url = this.aEU;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void setId(int i) {
        this.mRootView.setId(i);
    }

    public void V(x xVar) {
        if (xVar != null && xVar.aGj != null && xVar.aGj.aHg != null && !W(xVar)) {
            cancelAnimation();
            if (xVar.mLiveInfo != null) {
                this.liveId = xVar.mLiveInfo.live_id;
            }
            this.aHg = xVar.aGj.aHg;
            X(xVar);
            this.erX = xVar.aGj.msg;
            this.idD = xVar.aGj.AP();
            if (this.idD) {
                this.idC = false;
                o oVar = xVar.aGj.aHf;
                if (oVar != null) {
                    this.ido.startLoad(oVar.iconUrl, 10, false);
                    this.idp.setText(oVar.msg);
                    coi();
                    return;
                }
                coh();
                coj();
                return;
            }
            coh();
            coj();
            this.idC = TextUtils.isEmpty(this.erX) ? false : true;
            if (this.idC) {
                this.mHandler.removeCallbacks(this.idE);
                this.mHandler.postDelayed(this.idE, 9000L);
            }
        }
    }

    private boolean W(x xVar) {
        return this.aHg != null && xVar.mLiveInfo != null && this.liveId == xVar.mLiveInfo.live_id && this.aHg.aGZ == xVar.aGj.aHg.aGZ && TextUtils.equals(this.aHg.division, xVar.aGj.aHg.division) && TextUtils.equals(this.erX, xVar.aGj.msg) && this.aHg.maxStar == xVar.aGj.aHg.maxStar && this.idD == xVar.aGj.AP();
    }

    private void coh() {
        this.idn.setVisibility(8);
        this.idi.setVisibility(0);
        this.idj.setVisibility(0);
    }

    private void coi() {
        this.idn.setVisibility(0);
        this.idi.setVisibility(4);
        this.idk.setVisibility(4);
        this.idj.setVisibility(4);
    }

    private void X(x xVar) {
        long j;
        long j2;
        long j3;
        if (xVar.mLiveInfo == null || xVar.aFH == null) {
            j = 0;
            j2 = 0;
            j3 = 0;
        } else {
            long j4 = xVar.aFH.userId;
            long j5 = xVar.mLiveInfo.room_id;
            j = xVar.mLiveInfo.live_id;
            j2 = j5;
            j3 = j4;
        }
        long j6 = xVar.aGd != null ? xVar.aGd.userId : 0L;
        HashMap hashMap = new HashMap(2);
        hashMap.put("pk_anchor_id", ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)));
        this.aEU = com.baidu.live.utils.b.a(1, xVar.aGj.aEU, xVar.isHost, ExtraParamsManager.getEncryptionUserId(String.valueOf(j6)), ExtraParamsManager.getEncryptionUserId(String.valueOf(j3)), String.valueOf(j2), String.valueOf(j), hashMap);
    }

    private void coj() {
        if (this.aHg != null && !TextUtils.isEmpty(this.aHg.division) && this.aHg.aGZ > 0 && this.aHg.maxStar > 0) {
            int i = this.aHg.maxStar - this.aHg.aGZ;
            this.idi.startLoad(this.aHg.iconUrl, 10, false);
            cb(this.aHg.aGZ, i);
        }
    }

    private void cb(int i, int i2) {
        int i3;
        int i4;
        if (this.idj != null && this.idk != null) {
            this.idj.removeAllViews();
            this.idj.setVisibility(0);
            this.idk.setVisibility(4);
            if (i + i2 <= 4) {
                i4 = a.d.sdk_ds5;
                i3 = a.d.sdk_ds28;
            } else {
                i3 = a.d.sdk_ds22;
                i4 = a.d.sdk_ds3;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(this.mContext, i3), BdUtilHelper.getDimens(this.mContext, i3));
            layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, i4);
            layoutParams.gravity = 16;
            for (int i5 = 0; i5 < i; i5++) {
                this.idj.addView(getSolidStarView(), layoutParams);
            }
            for (int i6 = 0; i6 < i2; i6++) {
                this.idj.addView(getBlankStarView(), layoutParams);
            }
            this.idm.setText(this.erX);
            this.idA = BdUtilHelper.getTextWidth(this.idm.getPaint(), this.erX);
            ViewGroup.LayoutParams layoutParams2 = this.idm.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = this.idA;
                this.idm.setLayoutParams(layoutParams2);
            }
            this.idm.setTranslationX(0.0f);
            this.idj.setTranslationY(0.0f);
            this.idk.setTranslationY(0.0f);
            this.idj.setAlpha(1.0f);
            this.idj.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cok() {
        this.idB = true;
        coq();
        cor();
        cop();
        con();
        com();
        this.idz = new AnimatorSet();
        this.idz.play(this.idv).before(this.idw);
        this.idz.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.idz.removeAllListeners();
                c.this.idz.cancel();
                c.this.col();
            }
        });
        this.idz.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void col() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.idB && c.this.idy != null) {
                    c.this.idy.start();
                }
            }
        }, 300L);
    }

    private void com() {
        if (this.idu == null) {
            this.idu = cH(this.idj);
            this.idu.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.idj.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (c.this.idB) {
                        c.this.idB = false;
                        c.this.mHandler.postDelayed(c.this.idE, 9000L);
                    }
                }
            });
        }
    }

    private void con() {
        if (this.idk != null && this.idr == null) {
            this.idr = cG(this.idk);
            this.idr.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.idk.setVisibility(4);
                    c.this.idm.setTranslationX(0.0f);
                    c.this.coo();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coo() {
        if (this.idB && this.idu != null) {
            this.idu.start();
        }
    }

    private void cop() {
        if (this.idk != null) {
            this.idq = this.idk.getWidth();
            this.idy = ObjectAnimator.ofFloat(this.idm, "translationX", 0.0f, -(this.idA - this.idq));
            this.idy.setDuration(IMConnection.RETRY_DELAY_TIMES);
            this.idy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    c.this.cos();
                }
            });
        }
    }

    private void coq() {
        if (this.idv == null) {
            this.idv = cG(this.idj);
        }
    }

    private void cor() {
        if (this.idw == null) {
            this.idw = cH(this.idk);
            this.idw.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.c.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    c.this.idk.setVisibility(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cos() {
        if (this.idB) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.c.10
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.idB && c.this.idr != null) {
                        c.this.idr.start();
                    }
                }
            }, 7000L);
        }
    }

    private AnimatorSet cG(final View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds12));
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

    private AnimatorSet cH(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds12), 0.0f);
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
        imageView.setImageResource(a.e.ala_icon_five_pointed_star);
        return imageView;
    }

    private View getBlankStarView() {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setImageResource(a.e.ala_icon_blank_five_pointed_star);
        return imageView;
    }

    private void cancelAnimation() {
        if (this.idB) {
            this.idB = false;
            if (this.idr != null) {
                this.idr.cancel();
            }
            if (this.idu != null) {
                this.idu.cancel();
            }
            if (this.idv != null) {
                this.idv.cancel();
            }
            if (this.idw != null) {
                this.idw.cancel();
            }
            if (this.idy != null) {
                this.idy.cancel();
            }
            if (this.idz != null) {
                this.idz.cancel();
            }
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public void xk() {
        this.aHg = null;
        this.liveId = 0L;
        cancelAnimation();
    }

    public void onDestroy() {
        cancelAnimation();
    }
}
