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
    private ImageViewerBottomLayout cmX;
    private AbsFloorImageTextView cmY;
    private LinearLayout cmZ;
    private RelativeLayout cna;
    private Context mContext;
    private int cnb = 0;
    private boolean cnc = true;
    private final ImageViewerBottomLayout.a cnd = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            b.this.cnc = z;
            b.this.q(z, true);
        }
    };
    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.aqo();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.aqo();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.b(b.this);
            if (b.this.cnb >= 3) {
                b.this.cnb = 0;
                b.this.aqo();
            }
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.aqo();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.cnb;
        bVar.cnb = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.cmZ = new LinearLayout(context);
        this.cmZ.setOrientation(1);
        this.cmZ.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.cmZ, layoutParams);
        boolean aqm = aqm();
        eS(aqm);
        eR(aqm);
        a(relativeLayout, aqm);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.cna == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("anim_image_viewer_drag", 0) == 0) {
            this.cna = new RelativeLayout(this.mContext);
            this.cna.setOnClickListener(this.mOnClickListener);
            am.l(this.cna, R.color.black_alpha65);
            relativeLayout.addView(this.cna, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.a(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(R.raw.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.af(this.mContext) / 2, l.ah(this.mContext) / 2);
            layoutParams.addRule(13);
            this.cna.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.y(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.br();
        }
    }

    private void eR(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.cnf);
        this.cmX = new ImageViewerBottomLayout(this.mContext, !z);
        this.cmZ.addView(this.cmX, layoutParams);
        this.cmX.setExpandButtonListener(this.cnd);
    }

    private void eS(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (z) {
            this.cmY = new FloorImageTextViewNew(this.mContext);
        } else {
            this.cmY = new FloorImageTextView(this.mContext);
        }
        this.cmZ.addView(this.cmY, layoutParams);
    }

    private boolean aqm() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).aqm();
    }

    public void q(boolean z, boolean z2) {
        if (this.cmY != null) {
            this.cmY.q(z, z2);
        }
        if (this.cmX != null) {
            this.cmX.eT(!z);
        }
    }

    public void setUserId(String str) {
        if (this.cmY != null) {
            this.cmY.setUserId(str);
        }
        if (this.cmX != null) {
            this.cmX.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.cmY != null) {
            this.cmY.a(imageUrlData);
        }
        if (this.cmX != null) {
            this.cmX.b(imageUrlData);
        }
    }

    private boolean bc(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bc(this.cmZ);
    }

    public boolean aqn() {
        return this.cnc;
    }

    public void setVisibility(int i) {
        if (this.cmZ != null) {
            this.cmZ.clearAnimation();
            this.cmZ.setVisibility(i);
        }
    }

    public void ai(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.t.a.J(this.cmZ, i2);
        } else {
            com.baidu.tieba.t.a.I(this.cmZ, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqo() {
        if (this.cna != null) {
            this.cna.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("anim_image_viewer_drag", 1);
    }
}
