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
/* loaded from: classes5.dex */
public class b {
    private ImageViewerBottomLayout dnE;
    private AbsFloorImageTextView dnF;
    private LinearLayout dnG;
    private RelativeLayout dnH;
    private Context mContext;
    private int dnI = 0;
    private boolean dnJ = true;
    private final ImageViewerBottomLayout.a dnK = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            b.this.dnJ = z;
            b.this.u(z, true);
        }
    };
    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.aJR();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.aJR();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.b(b.this);
            if (b.this.dnI >= 3) {
                b.this.dnI = 0;
                b.this.aJR();
            }
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.aJR();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.dnI;
        bVar.dnI = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.dnG = new LinearLayout(context);
        this.dnG.setOrientation(1);
        this.dnG.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.dnG, layoutParams);
        boolean aJP = aJP();
        gc(aJP);
        gb(aJP);
        a(relativeLayout, aJP);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.dnH == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.aCY().getInt("anim_image_viewer_drag", 0) == 0) {
            this.dnH = new RelativeLayout(this.mContext);
            this.dnH.setOnClickListener(this.mOnClickListener);
            am.setBackgroundColor(this.dnH, R.color.black_alpha65);
            relativeLayout.addView(this.dnH, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.addAnimatorListener(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(R.raw.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.mContext) / 2, l.getEquipmentHeight(this.mContext) / 2);
            layoutParams.addRule(13);
            this.dnH.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.loop(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.playAnimation();
        }
    }

    private void gb(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.dnM);
        this.dnE = new ImageViewerBottomLayout(this.mContext, !z);
        this.dnG.addView(this.dnE, layoutParams);
        this.dnE.setExpandButtonListener(this.dnK);
    }

    private void gc(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dnF = new FloorImageTextViewNew(this.mContext);
        this.dnG.addView(this.dnF, layoutParams);
    }

    private boolean aJP() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).aJP();
    }

    public void u(boolean z, boolean z2) {
        if (this.dnF != null) {
            this.dnF.u(z, z2);
        }
        if (this.dnE != null) {
            this.dnE.gd(!z);
        }
    }

    public void setUserId(String str) {
        if (this.dnF != null) {
            this.dnF.setUserId(str);
        }
        if (this.dnE != null) {
            this.dnE.setUserId(str);
        }
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.dnE != null) {
            this.dnE.setIsBjhDynamic(z);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.dnF != null) {
            this.dnF.a(imageUrlData);
        }
        if (this.dnE != null) {
            this.dnE.b(imageUrlData);
        }
    }

    private boolean aZ(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return aZ(this.dnG);
    }

    public boolean aJQ() {
        return this.dnJ;
    }

    public void setVisibility(int i) {
        if (this.dnG != null) {
            this.dnG.clearAnimation();
            this.dnG.setVisibility(i);
        }
    }

    public void aD(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.u.a.w(this.dnG, i2);
        } else {
            com.baidu.tieba.u.a.v(this.dnG, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJR() {
        if (this.dnH != null) {
            this.dnH.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.aCY().putInt("anim_image_viewer_drag", 1);
    }
}
