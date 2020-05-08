package com.baidu.tbadk.coreExtra.view;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b {
    private ImageViewerBottomLayout dSA;
    private AbsFloorImageTextView dSB;
    private LinearLayout dSC;
    private RelativeLayout dSD;
    private Context mContext;
    private int dSE = 0;
    private boolean dSF = true;
    private final ImageViewerBottomLayout.a dSG = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            b.this.dSF = z;
            b.this.w(z, true);
        }
    };
    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.aVi();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.aVi();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.b(b.this);
            if (b.this.dSE >= 3) {
                b.this.dSE = 0;
                b.this.aVi();
            }
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.aVi();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.dSE;
        bVar.dSE = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.dSC = new LinearLayout(context);
        this.dSC.setOrientation(1);
        this.dSC.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.dSC, layoutParams);
        boolean aVg = aVg();
        hn(aVg);
        hm(aVg);
        a(relativeLayout, aVg);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.dSD == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.aNT().getInt("anim_image_viewer_drag", 0) == 0) {
            this.dSD = new RelativeLayout(this.mContext);
            this.dSD.setOnClickListener(this.mOnClickListener);
            am.setBackgroundColor(this.dSD, R.color.black_alpha65);
            relativeLayout.addView(this.dSD, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.addAnimatorListener(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(R.raw.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.mContext) / 2, l.getEquipmentHeight(this.mContext) / 2);
            layoutParams.addRule(13);
            this.dSD.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.loop(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.playAnimation();
        }
    }

    private void hm(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.dSI);
        this.dSA = new ImageViewerBottomLayout(this.mContext, !z);
        this.dSC.addView(this.dSA, layoutParams);
        this.dSA.setExpandButtonListener(this.dSG);
    }

    private void hn(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dSB = new FloorImageTextViewNew(this.mContext);
        this.dSC.addView(this.dSB, layoutParams);
    }

    private boolean aVg() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).aVg();
    }

    public void w(boolean z, boolean z2) {
        if (this.dSB != null) {
            this.dSB.w(z, z2);
        }
        if (this.dSA != null) {
            this.dSA.ho(!z);
        }
    }

    public void setUserId(String str) {
        if (this.dSB != null) {
            this.dSB.setUserId(str);
        }
        if (this.dSA != null) {
            this.dSA.setUserId(str);
        }
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.dSA != null) {
            this.dSA.setIsBjhDynamic(z);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.dSB != null) {
            this.dSB.a(imageUrlData);
        }
        if (this.dSA != null) {
            this.dSA.b(imageUrlData);
        }
    }

    private boolean be(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return be(this.dSC);
    }

    public boolean aVh() {
        return this.dSF;
    }

    public void setVisibility(int i) {
        if (this.dSC != null) {
            this.dSC.clearAnimation();
            this.dSC.setVisibility(i);
        }
    }

    public void aM(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.x(this.dSC, i2);
        } else {
            com.baidu.tieba.v.a.w(this.dSC, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVi() {
        if (this.dSD != null) {
            this.dSD.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.aNT().putInt("anim_image_viewer_drag", 1);
    }
}
