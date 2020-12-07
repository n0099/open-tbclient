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
    protected com.baidu.tbadk.widget.timepicker.a.c.a fRN;
    protected ViewGroup fSQ;
    private ViewGroup fSR;
    private com.baidu.tbadk.widget.timepicker.a.d.c fSS;
    private boolean fST;
    protected View fSV;
    private Animation inAnim;
    private boolean isShowing;
    private Dialog mDialog;
    private Animation outAnim;
    private ViewGroup rootView;
    protected int fSU = 80;
    private boolean fSW = true;
    private View.OnKeyListener fSX = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
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
        if (bJH()) {
            this.fSR = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.fSR.setBackgroundColor(0);
            this.fSQ = (ViewGroup) this.fSR.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.fSQ.setLayoutParams(layoutParams);
            ask();
            this.fSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.fRN.decorView == null) {
                this.fRN.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.rootView = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.fRN.decorView, false);
            this.rootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.fRN.backgroundId != -1) {
                this.rootView.setBackgroundColor(this.fRN.backgroundId);
            }
            this.fSQ = (ViewGroup) this.rootView.findViewById(R.id.content_container);
            this.fSQ.setLayoutParams(layoutParams);
        }
        lt(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Lo() {
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    public void show() {
        if (bJH()) {
            RU();
        } else if (!isShowing()) {
            this.isShowing = true;
            bW(this.rootView);
            this.rootView.requestFocus();
        }
    }

    private void bW(View view) {
        this.fRN.decorView.addView(view);
        if (this.fSW) {
            this.fSQ.startAnimation(this.inAnim);
        }
    }

    public boolean isShowing() {
        if (bJH()) {
            return false;
        }
        return this.rootView.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (bJH()) {
            ID();
        } else if (!this.fST) {
            if (this.fSW) {
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
                this.fSQ.startAnimation(this.outAnim);
            } else {
                dismissImmediately();
            }
            this.fST = true;
        }
    }

    public void dismissImmediately() {
        this.fRN.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fRN.decorView.removeView(a.this.rootView);
                a.this.isShowing = false;
                a.this.fST = false;
                if (a.this.fSS != null) {
                    a.this.fSS.ay(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.fSU, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.fSU, false));
    }

    public void lt(boolean z) {
        ViewGroup viewGroup;
        if (bJH()) {
            viewGroup = this.fSR;
        } else {
            viewGroup = this.rootView;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.fSX);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a lu(boolean z) {
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

    public void bJG() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.fRN.fSD);
        }
    }

    public View findViewById(int i) {
        return this.fSQ.findViewById(i);
    }

    public void ask() {
        if (this.fSR != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.fRN.fSD);
            this.mDialog.setContentView(this.fSR);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.fSS != null) {
                        a.this.fSS.ay(a.this);
                    }
                }
            });
        }
    }

    private void RU() {
        if (this.mDialog != null) {
            this.mDialog.show();
        }
    }

    private void ID() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean bJH() {
        return false;
    }
}
