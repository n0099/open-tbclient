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
    private ImageViewerBottomLayout clC;
    private AbsFloorImageTextView clD;
    private LinearLayout clE;
    private RelativeLayout clF;
    private Context mContext;
    private int clG = 0;
    private boolean clH = true;
    private final ImageViewerBottomLayout.a clI = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            b.this.clH = z;
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
            if (b.this.clG >= 3) {
                b.this.clG = 0;
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
        int i = bVar.clG;
        bVar.clG = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.clE = new LinearLayout(context);
        this.clE.setOrientation(1);
        this.clE.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.clE, layoutParams);
        boolean ape = ape();
        eO(ape);
        eN(ape);
        a(relativeLayout, ape);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.clF == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.agM().getInt("anim_image_viewer_drag", 0) == 0) {
            this.clF = new RelativeLayout(this.mContext);
            this.clF.setOnClickListener(this.mOnClickListener);
            al.l(this.clF, R.color.black_alpha65);
            relativeLayout.addView(this.clF, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.a(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(R.raw.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.af(this.mContext) / 2, l.ah(this.mContext) / 2);
            layoutParams.addRule(13);
            this.clF.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.y(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.bo();
        }
    }

    private void eN(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.clK);
        this.clC = new ImageViewerBottomLayout(this.mContext, !z);
        this.clE.addView(this.clC, layoutParams);
        this.clC.setExpandButtonListener(this.clI);
    }

    private void eO(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (z) {
            this.clD = new FloorImageTextViewNew(this.mContext);
        } else {
            this.clD = new FloorImageTextView(this.mContext);
        }
        this.clE.addView(this.clD, layoutParams);
    }

    private boolean ape() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).ape();
    }

    public void o(boolean z, boolean z2) {
        if (this.clD != null) {
            this.clD.o(z, z2);
        }
        if (this.clC != null) {
            this.clC.eP(!z);
        }
    }

    public void setUserId(String str) {
        if (this.clD != null) {
            this.clD.setUserId(str);
        }
        if (this.clC != null) {
            this.clC.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.clD != null) {
            this.clD.a(imageUrlData);
        }
        if (this.clC != null) {
            this.clC.b(imageUrlData);
        }
    }

    private boolean ba(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return ba(this.clE);
    }

    public boolean apf() {
        return this.clH;
    }

    public void setVisibility(int i) {
        if (this.clE != null) {
            this.clE.clearAnimation();
            this.clE.setVisibility(i);
        }
    }

    public void af(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.t.a.J(this.clE, i2);
        } else {
            com.baidu.tieba.t.a.I(this.clE, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apg() {
        if (this.clF != null) {
            this.clF.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("anim_image_viewer_drag", 1);
    }
}
