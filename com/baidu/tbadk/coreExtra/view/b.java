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
/* loaded from: classes3.dex */
public class b {
    private ImageViewerBottomLayout cnT;
    private AbsFloorImageTextView cnU;
    private LinearLayout cnV;
    private RelativeLayout cnW;
    private Context mContext;
    private int cnX = 0;
    private boolean cnY = true;
    private final ImageViewerBottomLayout.a cnZ = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            b.this.cnY = z;
            b.this.q(z, true);
        }
    };
    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.aqA();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.aqA();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.b(b.this);
            if (b.this.cnX >= 3) {
                b.this.cnX = 0;
                b.this.aqA();
            }
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.aqA();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.cnX;
        bVar.cnX = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.cnV = new LinearLayout(context);
        this.cnV.setOrientation(1);
        this.cnV.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.cnV, layoutParams);
        boolean aqy = aqy();
        eV(aqy);
        eU(aqy);
        a(relativeLayout, aqy);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.cnW == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.ahU().getInt("anim_image_viewer_drag", 0) == 0) {
            this.cnW = new RelativeLayout(this.mContext);
            this.cnW.setOnClickListener(this.mOnClickListener);
            am.l(this.cnW, R.color.black_alpha65);
            relativeLayout.addView(this.cnW, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.a(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(R.raw.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.af(this.mContext) / 2, l.ah(this.mContext) / 2);
            layoutParams.addRule(13);
            this.cnW.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.y(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.br();
        }
    }

    private void eU(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.cob);
        this.cnT = new ImageViewerBottomLayout(this.mContext, !z);
        this.cnV.addView(this.cnT, layoutParams);
        this.cnT.setExpandButtonListener(this.cnZ);
    }

    private void eV(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (z) {
            this.cnU = new FloorImageTextViewNew(this.mContext);
        } else {
            this.cnU = new FloorImageTextView(this.mContext);
        }
        this.cnV.addView(this.cnU, layoutParams);
    }

    private boolean aqy() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).aqy();
    }

    public void q(boolean z, boolean z2) {
        if (this.cnU != null) {
            this.cnU.q(z, z2);
        }
        if (this.cnT != null) {
            this.cnT.eW(!z);
        }
    }

    public void setUserId(String str) {
        if (this.cnU != null) {
            this.cnU.setUserId(str);
        }
        if (this.cnT != null) {
            this.cnT.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.cnU != null) {
            this.cnU.a(imageUrlData);
        }
        if (this.cnT != null) {
            this.cnT.b(imageUrlData);
        }
    }

    private boolean bc(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bc(this.cnV);
    }

    public boolean aqz() {
        return this.cnY;
    }

    public void setVisibility(int i) {
        if (this.cnV != null) {
            this.cnV.clearAnimation();
            this.cnV.setVisibility(i);
        }
    }

    public void ai(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.t.a.J(this.cnV, i2);
        } else {
            com.baidu.tieba.t.a.I(this.cnV, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqA() {
        if (this.cnW != null) {
            this.cnW.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.ahU().putInt("anim_image_viewer_drag", 1);
    }
}
