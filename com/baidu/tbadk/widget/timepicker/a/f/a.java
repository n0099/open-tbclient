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
    protected com.baidu.tbadk.widget.timepicker.a.c.a fwo;
    protected ViewGroup fxr;
    private ViewGroup fxs;
    private com.baidu.tbadk.widget.timepicker.a.d.c fxt;
    private boolean fxu;
    protected View fxw;
    private Animation inAnim;
    private boolean isShowing;
    private Dialog mDialog;
    private Animation outAnim;
    private ViewGroup rootView;
    protected int fxv = 80;
    private boolean fxx = true;
    private View.OnKeyListener fxy = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
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
        if (bCw()) {
            this.fxs = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.fxs.setBackgroundColor(0);
            this.fxr = (ViewGroup) this.fxs.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.fxr.setLayoutParams(layoutParams);
            alq();
            this.fxs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.fwo.decorView == null) {
                this.fwo.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.rootView = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.fwo.decorView, false);
            this.rootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.fwo.backgroundId != -1) {
                this.rootView.setBackgroundColor(this.fwo.backgroundId);
            }
            this.fxr = (ViewGroup) this.rootView.findViewById(R.id.content_container);
            this.fxr.setLayoutParams(layoutParams);
        }
        kC(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Jd() {
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    public void show() {
        if (bCw()) {
            Pd();
        } else if (!isShowing()) {
            this.isShowing = true;
            bH(this.rootView);
            this.rootView.requestFocus();
        }
    }

    private void bH(View view) {
        this.fwo.decorView.addView(view);
        if (this.fxx) {
            this.fxr.startAnimation(this.inAnim);
        }
    }

    public boolean isShowing() {
        if (bCw()) {
            return false;
        }
        return this.rootView.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (bCw()) {
            Gz();
        } else if (!this.fxu) {
            if (this.fxx) {
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
                this.fxr.startAnimation(this.outAnim);
            } else {
                dismissImmediately();
            }
            this.fxu = true;
        }
    }

    public void dismissImmediately() {
        this.fwo.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fwo.decorView.removeView(a.this.rootView);
                a.this.isShowing = false;
                a.this.fxu = false;
                if (a.this.fxt != null) {
                    a.this.fxt.ay(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.fxv, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.fxv, false));
    }

    public void kC(boolean z) {
        ViewGroup viewGroup;
        if (bCw()) {
            viewGroup = this.fxs;
        } else {
            viewGroup = this.rootView;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.fxy);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a kD(boolean z) {
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

    public void bCv() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.fwo.fxe);
        }
    }

    public View findViewById(int i) {
        return this.fxr.findViewById(i);
    }

    public void alq() {
        if (this.fxs != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.fwo.fxe);
            this.mDialog.setContentView(this.fxs);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.fxt != null) {
                        a.this.fxt.ay(a.this);
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

    private void Gz() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean bCw() {
        return false;
    }
}
