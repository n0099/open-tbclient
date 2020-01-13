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
/* loaded from: classes6.dex */
public class b {
    private ImageViewerBottomLayout dnP;
    private AbsFloorImageTextView dnQ;
    private LinearLayout dnR;
    private RelativeLayout dnS;
    private Context mContext;
    private int dnT = 0;
    private boolean dnU = true;
    private final ImageViewerBottomLayout.a dnV = new ImageViewerBottomLayout.a() { // from class: com.baidu.tbadk.coreExtra.view.b.1
        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            b.this.dnU = z;
            b.this.t(z, true);
        }
    };
    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.aKk();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.aKk();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.b(b.this);
            if (b.this.dnT >= 3) {
                b.this.dnT = 0;
                b.this.aKk();
            }
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.aKk();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.dnT;
        bVar.dnT = i + 1;
        return i;
    }

    public b(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        this.mContext = context;
        this.dnR = new LinearLayout(context);
        this.dnR.setOrientation(1);
        this.dnR.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.dnR, layoutParams);
        boolean aKi = aKi();
        gh(aKi);
        gg(aKi);
        a(relativeLayout, aKi);
    }

    private void a(RelativeLayout relativeLayout, boolean z) {
        if (this.dnS == null && relativeLayout != null && z && com.baidu.tbadk.core.sharedPref.b.aDr().getInt("anim_image_viewer_drag", 0) == 0) {
            this.dnS = new RelativeLayout(this.mContext);
            this.dnS.setOnClickListener(this.mOnClickListener);
            am.setBackgroundColor(this.dnS, R.color.black_alpha65);
            relativeLayout.addView(this.dnS, new RelativeLayout.LayoutParams(-1, -1));
            TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.mContext);
            tBLottieAnimationView.addAnimatorListener(this.mAnimatorListener);
            tBLottieAnimationView.setAnimation(R.raw.imageviewer_drag);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getEquipmentWidth(this.mContext) / 2, l.getEquipmentHeight(this.mContext) / 2);
            layoutParams.addRule(13);
            this.dnS.addView(tBLottieAnimationView, layoutParams);
            tBLottieAnimationView.loop(true);
            tBLottieAnimationView.setFrame(0);
            tBLottieAnimationView.playAnimation();
        }
    }

    private void gg(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.dnX);
        this.dnP = new ImageViewerBottomLayout(this.mContext, !z);
        this.dnR.addView(this.dnP, layoutParams);
        this.dnP.setExpandButtonListener(this.dnV);
    }

    private void gh(boolean z) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dnQ = new FloorImageTextViewNew(this.mContext);
        this.dnR.addView(this.dnQ, layoutParams);
    }

    private boolean aKi() {
        if (!(this.mContext instanceof a)) {
            return false;
        }
        return ((a) this.mContext).aKi();
    }

    public void t(boolean z, boolean z2) {
        if (this.dnQ != null) {
            this.dnQ.t(z, z2);
        }
        if (this.dnP != null) {
            this.dnP.gi(!z);
        }
    }

    public void setUserId(String str) {
        if (this.dnQ != null) {
            this.dnQ.setUserId(str);
        }
        if (this.dnP != null) {
            this.dnP.setUserId(str);
        }
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.dnP != null) {
            this.dnP.setIsBjhDynamic(z);
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        if (this.dnQ != null) {
            this.dnQ.a(imageUrlData);
        }
        if (this.dnP != null) {
            this.dnP.b(imageUrlData);
        }
    }

    private boolean bd(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public boolean isShown() {
        return bd(this.dnR);
    }

    public boolean aKj() {
        return this.dnU;
    }

    public void setVisibility(int i) {
        if (this.dnR != null) {
            this.dnR.clearAnimation();
            this.dnR.setVisibility(i);
        }
    }

    public void aH(int i, int i2) {
        if (i == 0) {
            com.baidu.tieba.u.a.w(this.dnR, i2);
        } else {
            com.baidu.tieba.u.a.v(this.dnR, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKk() {
        if (this.dnS != null) {
            this.dnS.setVisibility(8);
        }
        com.baidu.tbadk.core.sharedPref.b.aDr().putInt("anim_image_viewer_drag", 1);
    }
}
