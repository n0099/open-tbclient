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
    protected com.baidu.tbadk.widget.timepicker.a.c.a gaA;
    protected ViewGroup gbB;
    private ViewGroup gbC;
    private com.baidu.tbadk.widget.timepicker.a.d.c gbD;
    private boolean gbE;
    protected View gbG;
    private Animation inAnim;
    private boolean isShowing;
    private Dialog mDialog;
    private Animation outAnim;
    private ViewGroup rootView;
    protected int gbF = 80;
    private boolean gbH = true;
    private View.OnKeyListener gbI = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
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
        if (bIF()) {
            this.gbC = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.gbC.setBackgroundColor(0);
            this.gbB = (ViewGroup) this.gbC.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.gbB.setLayoutParams(layoutParams);
            aqj();
            this.gbC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.gaA.decorView == null) {
                this.gaA.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.rootView = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.gaA.decorView, false);
            this.rootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.gaA.backgroundId != -1) {
                this.rootView.setBackgroundColor(this.gaA.backgroundId);
            }
            this.gbB = (ViewGroup) this.rootView.findViewById(R.id.content_container);
            this.gbB.setLayoutParams(layoutParams);
        }
        lP(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Il() {
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    public void show() {
        if (bIF()) {
            QH();
        } else if (!isShowing()) {
            this.isShowing = true;
            cb(this.rootView);
            this.rootView.requestFocus();
        }
    }

    private void cb(View view) {
        this.gaA.decorView.addView(view);
        if (this.gbH) {
            this.gbB.startAnimation(this.inAnim);
        }
    }

    public boolean isShowing() {
        if (bIF()) {
            return false;
        }
        return this.rootView.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (bIF()) {
            FD();
        } else if (!this.gbE) {
            if (this.gbH) {
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
                this.gbB.startAnimation(this.outAnim);
            } else {
                dismissImmediately();
            }
            this.gbE = true;
        }
    }

    public void dismissImmediately() {
        this.gaA.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.gaA.decorView.removeView(a.this.rootView);
                a.this.isShowing = false;
                a.this.gbE = false;
                if (a.this.gbD != null) {
                    a.this.gbD.aC(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.gbF, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.gbF, false));
    }

    public void lP(boolean z) {
        ViewGroup viewGroup;
        if (bIF()) {
            viewGroup = this.gbC;
        } else {
            viewGroup = this.rootView;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.gbI);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a lQ(boolean z) {
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

    public void bIE() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.gaA.cancelable);
        }
    }

    public View findViewById(int i) {
        return this.gbB.findViewById(i);
    }

    public void aqj() {
        if (this.gbC != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.gaA.cancelable);
            this.mDialog.setContentView(this.gbC);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.gbD != null) {
                        a.this.gbD.aC(a.this);
                    }
                }
            });
        }
    }

    private void QH() {
        if (this.mDialog != null) {
            this.mDialog.show();
        }
    }

    private void FD() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean bIF() {
        return false;
    }
}
