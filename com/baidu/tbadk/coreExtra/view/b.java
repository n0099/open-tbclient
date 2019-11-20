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
    private RelativeLayout cAa;
    private ImageViewerBottomLayout czX;
    private AbsFloorImageTextView czY;
    private LinearLayout czZ;
    private Context mContext;
    private int cAb = 0;
    private boolean cAc = true;
    private final ImageViewerBottomLayout.a cAd = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            b.this.cAc = z;
            b.this.t(z, true);
        }
    };
    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.ass();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.ass();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.b(b.this);
            if (b.this.cAb >= 3) {
                b.this.cAb = 0;
                b.this.ass();
            }
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.ass();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.cAb;
        bVar.cAb = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.czZ = new LinearLayout(context);
        this.czZ.setOrientation(1);
        this.czZ.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.czZ, layoutParams);
        boolean asq = asq();
        eQ(asq);
        eP(asq);
        a(relativeLayout, asq);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.cAa == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.alP().getInt("anim_image_viewer_drag", 0) == 0) {
            this.cAa = new RelativeLayout(this.mContext);
            this.cAa.setOnClickListener(this.mOnClickListener);
            am.setBackgroundColor(this.cAa, R.color.black_alpha65);
            relativeLayout.addView(this.cAa, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.addAnimatorListener(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(R.raw.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.mContext) / 2, l.getEquipmentHeight(this.mContext) / 2);
            layoutParams.addRule(13);
            this.cAa.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.loop(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.playAnimation();
        }
    }

    private void eP(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.cAf);
        this.czX = new ImageViewerBottomLayout(this.mContext, !z);
        this.czZ.addView(this.czX, layoutParams);
        this.czX.setExpandButtonListener(this.cAd);
    }

    private void eQ(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (z) {
            this.czY = new FloorImageTextViewNew(this.mContext);
        } else {
            this.czY = new FloorImageTextView(this.mContext);
        }
        this.czZ.addView(this.czY, layoutParams);
    }

    private boolean asq() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).asq();
    }

    public void t(boolean z, boolean z2) {
        if (this.czY != null) {
            this.czY.t(z, z2);
        }
        if (this.czX != null) {
            this.czX.eR(!z);
        }
    }

    public void setUserId(String str) {
        if (this.czY != null) {
            this.czY.setUserId(str);
        }
        if (this.czX != null) {
            this.czX.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.czY != null) {
            this.czY.a(imageUrlData);
        }
        if (this.czX != null) {
            this.czX.b(imageUrlData);
        }
    }

    private boolean bc(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bc(this.czZ);
    }

    public boolean asr() {
        return this.cAc;
    }

    public void setVisibility(int i) {
        if (this.czZ != null) {
            this.czZ.clearAnimation();
            this.czZ.setVisibility(i);
        }
    }

    public void ak(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.t.a.y(this.czZ, i2);
        } else {
            com.baidu.tieba.t.a.x(this.czZ, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ass() {
        if (this.cAa != null) {
            this.cAa.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.alP().putInt("anim_image_viewer_drag", 1);
    }
}
