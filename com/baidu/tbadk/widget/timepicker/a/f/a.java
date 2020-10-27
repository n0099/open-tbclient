package com.baidu.tbadk.widget.timepicker.a.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class a {
    private Context context;
    protected com.baidu.tbadk.widget.timepicker.a.c.a fEJ;
    protected ViewGroup fFM;
    private ViewGroup fFN;
    private com.baidu.tbadk.widget.timepicker.a.d.c fFO;
    private boolean fFP;
    protected View fFR;
    private Animation inAnim;
    private boolean isShowing;
    private Dialog mDialog;
    private Animation outAnim;
    private ViewGroup rootView;
    protected int fFQ = 80;
    private boolean fFS = true;
    private View.OnKeyListener fFT = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener onCancelableTouchListener = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.dismiss();
                return false;
            }
            return false;
        }
    };

    public a(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initViews() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater from = LayoutInflater.from(this.context);
        if (bEp()) {
            this.fFN = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.fFN.setBackgroundColor(0);
            this.fFM = (ViewGroup) this.fFN.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.fFM.setLayoutParams(layoutParams);
            ank();
            this.fFN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.fEJ.decorView == null) {
                this.fEJ.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.rootView = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.fEJ.decorView, false);
            this.rootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.fEJ.backgroundId != -1) {
                this.rootView.setBackgroundColor(this.fEJ.backgroundId);
            }
            this.fFM = (ViewGroup) this.rootView.findViewById(R.id.content_container);
            this.fFM.setLayoutParams(layoutParams);
        }
        kP(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Jw() {
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    public void show() {
        if (bEp()) {
            PJ();
        } else if (!isShowing()) {
            this.isShowing = true;
            bI(this.rootView);
            this.rootView.requestFocus();
        }
    }

    private void bI(View view) {
        this.fEJ.decorView.addView(view);
        if (this.fFS) {
            this.fFM.startAnimation(this.inAnim);
        }
    }

    public boolean isShowing() {
        if (bEp()) {
            return false;
        }
        return this.rootView.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (bEp()) {
            GU();
        } else if (!this.fFP) {
            if (this.fFS) {
                this.outAnim.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dismissImmediately();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.fFM.startAnimation(this.outAnim);
            } else {
                dismissImmediately();
            }
            this.fFP = true;
        }
    }

    public void dismissImmediately() {
        this.fEJ.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fEJ.decorView.removeView(a.this.rootView);
                a.this.isShowing = false;
                a.this.fFP = false;
                if (a.this.fFO != null) {
                    a.this.fFO.ay(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.fFQ, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.fFQ, false));
    }

    public void kP(boolean z) {
        ViewGroup viewGroup;
        if (bEp()) {
            viewGroup = this.fFN;
        } else {
            viewGroup = this.rootView;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.fFT);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a kQ(boolean z) {
        if (this.rootView != null) {
            View findViewById = this.rootView.findViewById(R.id.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.onCancelableTouchListener);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void bEo() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.fEJ.fFz);
        }
    }

    public View findViewById(int i) {
        return this.fFM.findViewById(i);
    }

    public void ank() {
        if (this.fFN != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.fEJ.fFz);
            this.mDialog.setContentView(this.fFN);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.fFO != null) {
                        a.this.fFO.ay(a.this);
                    }
                }
            });
        }
    }

    private void PJ() {
        if (this.mDialog != null) {
            this.mDialog.show();
        }
    }

    private void GU() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean bEp() {
        return false;
    }
}
