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
    private ImageViewerBottomLayout cmQ;
    private AbsFloorImageTextView cmR;
    private LinearLayout cmS;
    private RelativeLayout cmT;
    private Context mContext;
    private int cmU = 0;
    private boolean cmV = true;
    private final ImageViewerBottomLayout.a cmW = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            b.this.cmV = z;
            b.this.q(z, true);
        }
    };
    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.aqm();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.aqm();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.b(b.this);
            if (b.this.cmU >= 3) {
                b.this.cmU = 0;
                b.this.aqm();
            }
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.aqm();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.cmU;
        bVar.cmU = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.cmS = new LinearLayout(context);
        this.cmS.setOrientation(1);
        this.cmS.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.cmS, layoutParams);
        boolean aqk = aqk();
        eS(aqk);
        eR(aqk);
        a(relativeLayout, aqk);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.cmT == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.ahO().getInt("anim_image_viewer_drag", 0) == 0) {
            this.cmT = new RelativeLayout(this.mContext);
            this.cmT.setOnClickListener(this.mOnClickListener);
            am.l(this.cmT, R.color.black_alpha65);
            relativeLayout.addView(this.cmT, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.a(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(R.raw.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.af(this.mContext) / 2, l.ah(this.mContext) / 2);
            layoutParams.addRule(13);
            this.cmT.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.y(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.br();
        }
    }

    private void eR(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.cmY);
        this.cmQ = new ImageViewerBottomLayout(this.mContext, !z);
        this.cmS.addView(this.cmQ, layoutParams);
        this.cmQ.setExpandButtonListener(this.cmW);
    }

    private void eS(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (z) {
            this.cmR = new FloorImageTextViewNew(this.mContext);
        } else {
            this.cmR = new FloorImageTextView(this.mContext);
        }
        this.cmS.addView(this.cmR, layoutParams);
    }

    private boolean aqk() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).aqk();
    }

    public void q(boolean z, boolean z2) {
        if (this.cmR != null) {
            this.cmR.q(z, z2);
        }
        if (this.cmQ != null) {
            this.cmQ.eT(!z);
        }
    }

    public void setUserId(String str) {
        if (this.cmR != null) {
            this.cmR.setUserId(str);
        }
        if (this.cmQ != null) {
            this.cmQ.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.cmR != null) {
            this.cmR.a(imageUrlData);
        }
        if (this.cmQ != null) {
            this.cmQ.b(imageUrlData);
        }
    }

    private boolean bc(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bc(this.cmS);
    }

    public boolean aql() {
        return this.cmV;
    }

    public void setVisibility(int i) {
        if (this.cmS != null) {
            this.cmS.clearAnimation();
            this.cmS.setVisibility(i);
        }
    }

    public void ai(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.t.a.J(this.cmS, i2);
        } else {
            com.baidu.tieba.t.a.I(this.cmS, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqm() {
        if (this.cmT != null) {
            this.cmT.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.ahO().putInt("anim_image_viewer_drag", 1);
    }
}
