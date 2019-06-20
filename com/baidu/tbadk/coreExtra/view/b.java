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
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private ImageViewerBottomLayout clD;
    private AbsFloorImageTextView clE;
    private LinearLayout clF;
    private RelativeLayout clG;
    private Context mContext;
    private int clH = 0;
    private boolean clI = true;
    private final ImageViewerBottomLayout.a clJ = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            b.this.clI = z;
            b.this.o(z, true);
        }
    };
    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.apg();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.apg();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.b(b.this);
            if (b.this.clH >= 3) {
                b.this.clH = 0;
                b.this.apg();
            }
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.apg();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.clH;
        bVar.clH = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.clF = new LinearLayout(context);
        this.clF.setOrientation(1);
        this.clF.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.clF, layoutParams);
        boolean ape = ape();
        eO(ape);
        eN(ape);
        a(relativeLayout, ape);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.clG == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.agM().getInt("anim_image_viewer_drag", 0) == 0) {
            this.clG = new RelativeLayout(this.mContext);
            this.clG.setOnClickListener(this.mOnClickListener);
            al.l(this.clG, R.color.black_alpha65);
            relativeLayout.addView(this.clG, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.a(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(R.raw.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.af(this.mContext) / 2, l.ah(this.mContext) / 2);
            layoutParams.addRule(13);
            this.clG.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.y(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.bo();
        }
    }

    private void eN(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.clL);
        this.clD = new ImageViewerBottomLayout(this.mContext, !z);
        this.clF.addView(this.clD, layoutParams);
        this.clD.setExpandButtonListener(this.clJ);
    }

    private void eO(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (z) {
            this.clE = new FloorImageTextViewNew(this.mContext);
        } else {
            this.clE = new FloorImageTextView(this.mContext);
        }
        this.clF.addView(this.clE, layoutParams);
    }

    private boolean ape() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).ape();
    }

    public void o(boolean z, boolean z2) {
        if (this.clE != null) {
            this.clE.o(z, z2);
        }
        if (this.clD != null) {
            this.clD.eP(!z);
        }
    }

    public void setUserId(String str) {
        if (this.clE != null) {
            this.clE.setUserId(str);
        }
        if (this.clD != null) {
            this.clD.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.clE != null) {
            this.clE.a(imageUrlData);
        }
        if (this.clD != null) {
            this.clD.b(imageUrlData);
        }
    }

    private boolean ba(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return ba(this.clF);
    }

    public boolean apf() {
        return this.clI;
    }

    public void setVisibility(int i) {
        if (this.clF != null) {
            this.clF.clearAnimation();
            this.clF.setVisibility(i);
        }
    }

    public void af(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.t.a.J(this.clF, i2);
        } else {
            com.baidu.tieba.t.a.I(this.clF, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apg() {
        if (this.clG != null) {
            this.clG.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("anim_image_viewer_drag", 1);
    }
}
