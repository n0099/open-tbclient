package com.baidu.tbadk.coreExtra.view;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    private LinearLayout cdA;
    private RelativeLayout cdB;
    private ImageViewerBottomLayout cdy;
    private AbsFloorImageTextView cdz;
    private Context mContext;
    private int cdC = 0;
    private final ImageViewerBottomLayout.a cdD = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            b.this.ep(z);
        }
    };
    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.ake();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.ake();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.b(b.this);
            if (b.this.cdC >= 3) {
                b.this.cdC = 0;
                b.this.ake();
            }
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.ake();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.cdC;
        bVar.cdC = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.cdA = new LinearLayout(context);
        this.cdA.setOrientation(1);
        this.cdA.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.cdA, layoutParams);
        boolean akd = akd();
        es(akd);
        er(akd);
        a(relativeLayout, akd);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.cdB == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("anim_image_viewer_drag", 0) == 0) {
            this.cdB = new RelativeLayout(this.mContext);
            this.cdB.setOnClickListener(this.mOnClickListener);
            al.l(this.cdB, d.C0277d.black_alpha65);
            relativeLayout.addView(this.cdB, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.a(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(d.i.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.aO(this.mContext) / 2, l.aQ(this.mContext) / 2);
            layoutParams.addRule(13);
            this.cdB.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.G(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.cu();
        }
    }

    private void er(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.cdF);
        this.cdy = new ImageViewerBottomLayout(this.mContext, !z);
        this.cdA.addView(this.cdy, layoutParams);
        this.cdy.setExpandButtonListener(this.cdD);
    }

    private void es(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (z) {
            this.cdz = new FloorImageTextViewNew(this.mContext);
        } else {
            this.cdz = new FloorImageTextView(this.mContext);
        }
        this.cdA.addView(this.cdz, layoutParams);
    }

    private boolean akd() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).akd();
    }

    public void ep(boolean z) {
        if (this.cdz != null) {
            this.cdz.ep(z);
        }
        if (this.cdy != null) {
            this.cdy.et(!z);
        }
    }

    public void setUserId(String str) {
        if (this.cdz != null) {
            this.cdz.setUserId(str);
        }
        if (this.cdy != null) {
            this.cdy.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.cdz != null) {
            this.cdz.a(imageUrlData);
        }
        if (this.cdy != null) {
            this.cdy.b(imageUrlData);
        }
    }

    private boolean aU(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return aU(this.cdA);
    }

    public void setVisibility(int i) {
        if (this.cdA != null) {
            this.cdA.clearAnimation();
            this.cdA.setVisibility(i);
        }
    }

    public void af(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.t.a.H(this.cdA, i2);
        } else {
            com.baidu.tieba.t.a.G(this.cdA, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ake() {
        if (this.cdB != null) {
            this.cdB.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("anim_image_viewer_drag", 1);
    }
}
