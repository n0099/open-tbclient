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
    private ImageViewerBottomLayout cdv;
    private AbsFloorImageTextView cdw;
    private LinearLayout cdx;
    private RelativeLayout cdy;
    private Context mContext;
    private int cdz = 0;
    private final ImageViewerBottomLayout.a cdA = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
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
            b.this.akh();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.akh();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.b(b.this);
            if (b.this.cdz >= 3) {
                b.this.cdz = 0;
                b.this.akh();
            }
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.akh();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.cdz;
        bVar.cdz = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.cdx = new LinearLayout(context);
        this.cdx.setOrientation(1);
        this.cdx.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.cdx, layoutParams);
        boolean akg = akg();
        es(akg);
        er(akg);
        a(relativeLayout, akg);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.cdy == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("anim_image_viewer_drag", 0) == 0) {
            this.cdy = new RelativeLayout(this.mContext);
            this.cdy.setOnClickListener(this.mOnClickListener);
            al.l(this.cdy, d.C0277d.black_alpha65);
            relativeLayout.addView(this.cdy, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.a(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(d.i.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.aO(this.mContext) / 2, l.aQ(this.mContext) / 2);
            layoutParams.addRule(13);
            this.cdy.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.G(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.cu();
        }
    }

    private void er(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.cdC);
        this.cdv = new ImageViewerBottomLayout(this.mContext, !z);
        this.cdx.addView(this.cdv, layoutParams);
        this.cdv.setExpandButtonListener(this.cdA);
    }

    private void es(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (z) {
            this.cdw = new FloorImageTextViewNew(this.mContext);
        } else {
            this.cdw = new FloorImageTextView(this.mContext);
        }
        this.cdx.addView(this.cdw, layoutParams);
    }

    private boolean akg() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).akg();
    }

    public void ep(boolean z) {
        if (this.cdw != null) {
            this.cdw.ep(z);
        }
        if (this.cdv != null) {
            this.cdv.et(!z);
        }
    }

    public void setUserId(String str) {
        if (this.cdw != null) {
            this.cdw.setUserId(str);
        }
        if (this.cdv != null) {
            this.cdv.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.cdw != null) {
            this.cdw.a(imageUrlData);
        }
        if (this.cdv != null) {
            this.cdv.b(imageUrlData);
        }
    }

    private boolean aU(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return aU(this.cdx);
    }

    public void setVisibility(int i) {
        if (this.cdx != null) {
            this.cdx.clearAnimation();
            this.cdx.setVisibility(i);
        }
    }

    public void af(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.t.a.H(this.cdx, i2);
        } else {
            com.baidu.tieba.t.a.G(this.cdx, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akh() {
        if (this.cdy != null) {
            this.cdy.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("anim_image_viewer_drag", 1);
    }
}
