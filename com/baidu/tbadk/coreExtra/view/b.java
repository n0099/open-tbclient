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
    private ImageViewerBottomLayout drZ;
    private AbsFloorImageTextView dsa;
    private LinearLayout dsb;
    private RelativeLayout dsc;
    private Context mContext;
    private int dsd = 0;
    private boolean dse = true;
    private final ImageViewerBottomLayout.a dsf = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            b.this.dse = z;
            b.this.w(z, true);
        }
    };
    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.aMI();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.aMI();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.b(b.this);
            if (b.this.dsd >= 3) {
                b.this.dsd = 0;
                b.this.aMI();
            }
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.aMI();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.dsd;
        bVar.dsd = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.dsb = new LinearLayout(context);
        this.dsb.setOrientation(1);
        this.dsb.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.dsb, layoutParams);
        boolean aMG = aMG();
        go(aMG);
        gn(aMG);
        a(relativeLayout, aMG);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.dsc == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.aFD().getInt("anim_image_viewer_drag", 0) == 0) {
            this.dsc = new RelativeLayout(this.mContext);
            this.dsc.setOnClickListener(this.mOnClickListener);
            am.setBackgroundColor(this.dsc, R.color.black_alpha65);
            relativeLayout.addView(this.dsc, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.addAnimatorListener(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(R.raw.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.mContext) / 2, l.getEquipmentHeight(this.mContext) / 2);
            layoutParams.addRule(13);
            this.dsc.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.loop(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.playAnimation();
        }
    }

    private void gn(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.dsh);
        this.drZ = new ImageViewerBottomLayout(this.mContext, !z);
        this.dsb.addView(this.drZ, layoutParams);
        this.drZ.setExpandButtonListener(this.dsf);
    }

    private void go(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dsa = new FloorImageTextViewNew(this.mContext);
        this.dsb.addView(this.dsa, layoutParams);
    }

    private boolean aMG() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).aMG();
    }

    public void w(boolean z, boolean z2) {
        if (this.dsa != null) {
            this.dsa.w(z, z2);
        }
        if (this.drZ != null) {
            this.drZ.gp(!z);
        }
    }

    public void setUserId(String str) {
        if (this.dsa != null) {
            this.dsa.setUserId(str);
        }
        if (this.drZ != null) {
            this.drZ.setUserId(str);
        }
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.drZ != null) {
            this.drZ.setIsBjhDynamic(z);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.dsa != null) {
            this.dsa.a(imageUrlData);
        }
        if (this.drZ != null) {
            this.drZ.b(imageUrlData);
        }
    }

    private boolean bd(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bd(this.dsb);
    }

    public boolean aMH() {
        return this.dse;
    }

    public void setVisibility(int i) {
        if (this.dsb != null) {
            this.dsb.clearAnimation();
            this.dsb.setVisibility(i);
        }
    }

    public void aH(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.v.a.w(this.dsb, i2);
        } else {
            com.baidu.tieba.v.a.v(this.dsb, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMI() {
        if (this.dsc != null) {
            this.dsc.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.aFD().putInt("anim_image_viewer_drag", 1);
    }
}
