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
    private ImageViewerBottomLayout drY;
    private AbsFloorImageTextView drZ;
    private LinearLayout dsa;
    private RelativeLayout dsb;
    private Context mContext;
    private int dsc = 0;
    private boolean dsd = true;
    private final ImageViewerBottomLayout.a dse = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            b.this.dsd = z;
            b.this.w(z, true);
        }
    };
    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.aMG();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.aMG();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.b(b.this);
            if (b.this.dsc >= 3) {
                b.this.dsc = 0;
                b.this.aMG();
            }
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.aMG();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.dsc;
        bVar.dsc = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.dsa = new LinearLayout(context);
        this.dsa.setOrientation(1);
        this.dsa.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.dsa, layoutParams);
        boolean aME = aME();
        go(aME);
        gn(aME);
        a(relativeLayout, aME);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.dsb == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.aFB().getInt("anim_image_viewer_drag", 0) == 0) {
            this.dsb = new RelativeLayout(this.mContext);
            this.dsb.setOnClickListener(this.mOnClickListener);
            am.setBackgroundColor(this.dsb, R.color.black_alpha65);
            relativeLayout.addView(this.dsb, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.addAnimatorListener(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(R.raw.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.mContext) / 2, l.getEquipmentHeight(this.mContext) / 2);
            layoutParams.addRule(13);
            this.dsb.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.loop(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.playAnimation();
        }
    }

    private void gn(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.dsg);
        this.drY = new ImageViewerBottomLayout(this.mContext, !z);
        this.dsa.addView(this.drY, layoutParams);
        this.drY.setExpandButtonListener(this.dse);
    }

    private void go(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.drZ = new FloorImageTextViewNew(this.mContext);
        this.dsa.addView(this.drZ, layoutParams);
    }

    private boolean aME() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).aME();
    }

    public void w(boolean z, boolean z2) {
        if (this.drZ != null) {
            this.drZ.w(z, z2);
        }
        if (this.drY != null) {
            this.drY.gp(!z);
        }
    }

    public void setUserId(String str) {
        if (this.drZ != null) {
            this.drZ.setUserId(str);
        }
        if (this.drY != null) {
            this.drY.setUserId(str);
        }
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.drY != null) {
            this.drY.setIsBjhDynamic(z);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.drZ != null) {
            this.drZ.a(imageUrlData);
        }
        if (this.drY != null) {
            this.drY.b(imageUrlData);
        }
    }

    private boolean bd(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bd(this.dsa);
    }

    public boolean aMF() {
        return this.dsd;
    }

    public void setVisibility(int i) {
        if (this.dsa != null) {
            this.dsa.clearAnimation();
            this.dsa.setVisibility(i);
        }
    }

    public void aH(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.w(this.dsa, i2);
        } else {
            com.baidu.tieba.v.a.v(this.dsa, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMG() {
        if (this.dsb != null) {
            this.dsb.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.aFB().putInt("anim_image_viewer_drag", 1);
    }
}
