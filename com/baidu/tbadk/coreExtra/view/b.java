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
    private ImageViewerBottomLayout dsA;
    private AbsFloorImageTextView dsB;
    private LinearLayout dsC;
    private RelativeLayout dsD;
    private Context mContext;
    private int dsE = 0;
    private boolean dsF = true;
    private final ImageViewerBottomLayout.a dsG = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            b.this.dsF = z;
            b.this.x(z, true);
        }
    };
    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.aMN();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.aMN();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.b(b.this);
            if (b.this.dsE >= 3) {
                b.this.dsE = 0;
                b.this.aMN();
            }
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.aMN();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.dsE;
        bVar.dsE = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.dsC = new LinearLayout(context);
        this.dsC.setOrientation(1);
        this.dsC.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.dsC, layoutParams);
        boolean aML = aML();
        gp(aML);
        go(aML);
        a(relativeLayout, aML);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.dsD == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.aFH().getInt("anim_image_viewer_drag", 0) == 0) {
            this.dsD = new RelativeLayout(this.mContext);
            this.dsD.setOnClickListener(this.mOnClickListener);
            am.setBackgroundColor(this.dsD, R.color.black_alpha65);
            relativeLayout.addView(this.dsD, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.addAnimatorListener(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(R.raw.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.mContext) / 2, l.getEquipmentHeight(this.mContext) / 2);
            layoutParams.addRule(13);
            this.dsD.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.loop(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.playAnimation();
        }
    }

    private void go(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.dsI);
        this.dsA = new ImageViewerBottomLayout(this.mContext, !z);
        this.dsC.addView(this.dsA, layoutParams);
        this.dsA.setExpandButtonListener(this.dsG);
    }

    private void gp(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dsB = new FloorImageTextViewNew(this.mContext);
        this.dsC.addView(this.dsB, layoutParams);
    }

    private boolean aML() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).aML();
    }

    public void x(boolean z, boolean z2) {
        if (this.dsB != null) {
            this.dsB.x(z, z2);
        }
        if (this.dsA != null) {
            this.dsA.gq(!z);
        }
    }

    public void setUserId(String str) {
        if (this.dsB != null) {
            this.dsB.setUserId(str);
        }
        if (this.dsA != null) {
            this.dsA.setUserId(str);
        }
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.dsA != null) {
            this.dsA.setIsBjhDynamic(z);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.dsB != null) {
            this.dsB.a(imageUrlData);
        }
        if (this.dsA != null) {
            this.dsA.b(imageUrlData);
        }
    }

    private boolean bd(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bd(this.dsC);
    }

    public boolean aMM() {
        return this.dsF;
    }

    public void setVisibility(int i) {
        if (this.dsC != null) {
            this.dsC.clearAnimation();
            this.dsC.setVisibility(i);
        }
    }

    public void aI(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.w(this.dsC, i2);
        } else {
            com.baidu.tieba.v.a.v(this.dsC, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMN() {
        if (this.dsD != null) {
            this.dsD.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.aFH().putInt("anim_image_viewer_drag", 1);
    }
}
