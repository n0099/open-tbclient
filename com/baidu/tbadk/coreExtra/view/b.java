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
    private ImageViewerBottomLayout cAO;
    private AbsFloorImageTextView cAP;
    private LinearLayout cAQ;
    private RelativeLayout cAR;
    private Context mContext;
    private int cAS = 0;
    private boolean cAT = true;
    private final ImageViewerBottomLayout.a cAU = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            b.this.cAT = z;
            b.this.t(z, true);
        }
    };
    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.asu();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.asu();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.b(b.this);
            if (b.this.cAS >= 3) {
                b.this.cAS = 0;
                b.this.asu();
            }
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.asu();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.cAS;
        bVar.cAS = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.cAQ = new LinearLayout(context);
        this.cAQ.setOrientation(1);
        this.cAQ.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.cAQ, layoutParams);
        boolean ass = ass();
        eQ(ass);
        eP(ass);
        a(relativeLayout, ass);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.cAR == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.alR().getInt("anim_image_viewer_drag", 0) == 0) {
            this.cAR = new RelativeLayout(this.mContext);
            this.cAR.setOnClickListener(this.mOnClickListener);
            am.setBackgroundColor(this.cAR, R.color.black_alpha65);
            relativeLayout.addView(this.cAR, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.addAnimatorListener(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(R.raw.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.mContext) / 2, l.getEquipmentHeight(this.mContext) / 2);
            layoutParams.addRule(13);
            this.cAR.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.loop(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.playAnimation();
        }
    }

    private void eP(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.cAW);
        this.cAO = new ImageViewerBottomLayout(this.mContext, !z);
        this.cAQ.addView(this.cAO, layoutParams);
        this.cAO.setExpandButtonListener(this.cAU);
    }

    private void eQ(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (z) {
            this.cAP = new FloorImageTextViewNew(this.mContext);
        } else {
            this.cAP = new FloorImageTextView(this.mContext);
        }
        this.cAQ.addView(this.cAP, layoutParams);
    }

    private boolean ass() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).ass();
    }

    public void t(boolean z, boolean z2) {
        if (this.cAP != null) {
            this.cAP.t(z, z2);
        }
        if (this.cAO != null) {
            this.cAO.eR(!z);
        }
    }

    public void setUserId(String str) {
        if (this.cAP != null) {
            this.cAP.setUserId(str);
        }
        if (this.cAO != null) {
            this.cAO.setUserId(str);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.cAP != null) {
            this.cAP.a(imageUrlData);
        }
        if (this.cAO != null) {
            this.cAO.b(imageUrlData);
        }
    }

    private boolean bc(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bc(this.cAQ);
    }

    public boolean ast() {
        return this.cAT;
    }

    public void setVisibility(int i) {
        if (this.cAQ != null) {
            this.cAQ.clearAnimation();
            this.cAQ.setVisibility(i);
        }
    }

    public void am(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.t.a.y(this.cAQ, i2);
        } else {
            com.baidu.tieba.t.a.x(this.cAQ, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asu() {
        if (this.cAR != null) {
            this.cAR.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.alR().putInt("anim_image_viewer_drag", 1);
    }
}
