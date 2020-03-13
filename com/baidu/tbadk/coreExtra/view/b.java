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
    private ImageViewerBottomLayout dsm;
    private AbsFloorImageTextView dsn;
    private LinearLayout dso;
    private RelativeLayout dsp;
    private Context mContext;
    private int dsq = 0;
    private boolean dsr = true;
    private final ImageViewerBottomLayout.a dss = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            b.this.dsr = z;
            b.this.x(z, true);
        }
    };
    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.aMJ();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.aMJ();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.b(b.this);
            if (b.this.dsq >= 3) {
                b.this.dsq = 0;
                b.this.aMJ();
            }
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.aMJ();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.dsq;
        bVar.dsq = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.dso = new LinearLayout(context);
        this.dso.setOrientation(1);
        this.dso.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.dso, layoutParams);
        boolean aMH = aMH();
        go(aMH);
        gn(aMH);
        a(relativeLayout, aMH);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.dsp == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.aFD().getInt("anim_image_viewer_drag", 0) == 0) {
            this.dsp = new RelativeLayout(this.mContext);
            this.dsp.setOnClickListener(this.mOnClickListener);
            am.setBackgroundColor(this.dsp, R.color.black_alpha65);
            relativeLayout.addView(this.dsp, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.addAnimatorListener(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(R.raw.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.mContext) / 2, l.getEquipmentHeight(this.mContext) / 2);
            layoutParams.addRule(13);
            this.dsp.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.loop(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.playAnimation();
        }
    }

    private void gn(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.dsv);
        this.dsm = new ImageViewerBottomLayout(this.mContext, !z);
        this.dso.addView(this.dsm, layoutParams);
        this.dsm.setExpandButtonListener(this.dss);
    }

    private void go(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dsn = new FloorImageTextViewNew(this.mContext);
        this.dso.addView(this.dsn, layoutParams);
    }

    private boolean aMH() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).aMH();
    }

    public void x(boolean z, boolean z2) {
        if (this.dsn != null) {
            this.dsn.x(z, z2);
        }
        if (this.dsm != null) {
            this.dsm.gp(!z);
        }
    }

    public void setUserId(String str) {
        if (this.dsn != null) {
            this.dsn.setUserId(str);
        }
        if (this.dsm != null) {
            this.dsm.setUserId(str);
        }
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.dsm != null) {
            this.dsm.setIsBjhDynamic(z);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.dsn != null) {
            this.dsn.a(imageUrlData);
        }
        if (this.dsm != null) {
            this.dsm.b(imageUrlData);
        }
    }

    private boolean bd(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bd(this.dso);
    }

    public boolean aMI() {
        return this.dsr;
    }

    public void setVisibility(int i) {
        if (this.dso != null) {
            this.dso.clearAnimation();
            this.dso.setVisibility(i);
        }
    }

    public void aH(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.w(this.dso, i2);
        } else {
            com.baidu.tieba.v.a.v(this.dso, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMJ() {
        if (this.dsp != null) {
            this.dsp.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.aFD().putInt("anim_image_viewer_drag", 1);
    }
}
