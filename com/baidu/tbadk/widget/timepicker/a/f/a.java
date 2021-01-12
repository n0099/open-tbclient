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
/* loaded from: classes.dex */
public class a {
    private Context context;
    protected com.baidu.tbadk.widget.timepicker.a.c.a fWJ;
    protected ViewGroup fXK;
    private ViewGroup fXL;
    private com.baidu.tbadk.widget.timepicker.a.d.c fXM;
    private boolean fXN;
    protected View fXP;
    private Animation inAnim;
    private boolean isShowing;
    private Dialog mDialog;
    private Animation outAnim;
    private ViewGroup rootView;
    protected int fXO = 80;
    private boolean fXQ = true;
    private View.OnKeyListener fXR = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
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
        if (bIi()) {
            this.fXL = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.fXL.setBackgroundColor(0);
            this.fXK = (ViewGroup) this.fXL.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.fXK.setLayoutParams(layoutParams);
            apI();
            this.fXL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.fWJ.decorView == null) {
                this.fWJ.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.rootView = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.fWJ.decorView, false);
            this.rootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.fWJ.backgroundId != -1) {
                this.rootView.setBackgroundColor(this.fWJ.backgroundId);
            }
            this.fXK = (ViewGroup) this.rootView.findViewById(R.id.content_container);
            this.fXK.setLayoutParams(layoutParams);
        }
        lL(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void GS() {
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    public void show() {
        if (bIi()) {
            Pd();
        } else if (!isShowing()) {
            this.isShowing = true;
            cf(this.rootView);
            this.rootView.requestFocus();
        }
    }

    private void cf(View view) {
        this.fWJ.decorView.addView(view);
        if (this.fXQ) {
            this.fXK.startAnimation(this.inAnim);
        }
    }

    public boolean isShowing() {
        if (bIi()) {
            return false;
        }
        return this.rootView.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (bIi()) {
            Ek();
        } else if (!this.fXN) {
            if (this.fXQ) {
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
                this.fXK.startAnimation(this.outAnim);
            } else {
                dismissImmediately();
            }
            this.fXN = true;
        }
    }

    public void dismissImmediately() {
        this.fWJ.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fWJ.decorView.removeView(a.this.rootView);
                a.this.isShowing = false;
                a.this.fXN = false;
                if (a.this.fXM != null) {
                    a.this.fXM.aA(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.fXO, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.fXO, false));
    }

    public void lL(boolean z) {
        ViewGroup viewGroup;
        if (bIi()) {
            viewGroup = this.fXL;
        } else {
            viewGroup = this.rootView;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.fXR);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a lM(boolean z) {
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

    public void bIh() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.fWJ.cancelable);
        }
    }

    public View findViewById(int i) {
        return this.fXK.findViewById(i);
    }

    public void apI() {
        if (this.fXL != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.fWJ.cancelable);
            this.mDialog.setContentView(this.fXL);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.fXM != null) {
                        a.this.fXM.aA(a.this);
                    }
                }
            });
        }
    }

    private void Pd() {
        if (this.mDialog != null) {
            this.mDialog.show();
        }
    }

    private void Ek() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean bIi() {
        return false;
    }
}
