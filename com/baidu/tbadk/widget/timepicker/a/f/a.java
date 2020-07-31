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
/* loaded from: classes15.dex */
public class a {
    private Context context;
    protected com.baidu.tbadk.widget.timepicker.a.c.a eWu;
    private boolean eXA;
    protected View eXC;
    protected ViewGroup eXx;
    private ViewGroup eXy;
    private com.baidu.tbadk.widget.timepicker.a.d.c eXz;
    private Animation inAnim;
    private boolean isShowing;
    private Dialog mDialog;
    private Animation outAnim;
    private ViewGroup rootView;
    protected int eXB = 80;
    private boolean eXD = true;
    private View.OnKeyListener eXE = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
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
        if (bpO()) {
            this.eXy = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.eXy.setBackgroundColor(0);
            this.eXx = (ViewGroup) this.eXy.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.eXx.setLayoutParams(layoutParams);
            abJ();
            this.eXy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.eWu.decorView == null) {
                this.eWu.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.rootView = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.eWu.decorView, false);
            this.rootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.eWu.backgroundId != -1) {
                this.rootView.setBackgroundColor(this.eWu.backgroundId);
            }
            this.eXx = (ViewGroup) this.rootView.findViewById(R.id.content_container);
            this.eXx.setLayoutParams(layoutParams);
        }
        jD(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cb() {
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    public void show() {
        if (bpO()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            bx(this.rootView);
            this.rootView.requestFocus();
        }
    }

    private void bx(View view) {
        this.eWu.decorView.addView(view);
        if (this.eXD) {
            this.eXx.startAnimation(this.inAnim);
        }
    }

    public boolean isShowing() {
        if (bpO()) {
            return false;
        }
        return this.rootView.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (bpO()) {
            zA();
        } else if (!this.eXA) {
            if (this.eXD) {
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
                this.eXx.startAnimation(this.outAnim);
            } else {
                dismissImmediately();
            }
            this.eXA = true;
        }
    }

    public void dismissImmediately() {
        this.eWu.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.eWu.decorView.removeView(a.this.rootView);
                a.this.isShowing = false;
                a.this.eXA = false;
                if (a.this.eXz != null) {
                    a.this.eXz.as(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.eXB, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.eXB, false));
    }

    public void jD(boolean z) {
        ViewGroup viewGroup;
        if (bpO()) {
            viewGroup = this.eXy;
        } else {
            viewGroup = this.rootView;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.eXE);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a jE(boolean z) {
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

    public void bpN() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.eWu.eXk);
        }
    }

    public View findViewById(int i) {
        return this.eXx.findViewById(i);
    }

    public void abJ() {
        if (this.eXy != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.eWu.eXk);
            this.mDialog.setContentView(this.eXy);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.eXz != null) {
                        a.this.eXz.as(a.this);
                    }
                }
            });
        }
    }

    private void showDialog() {
        if (this.mDialog != null) {
            this.mDialog.show();
        }
    }

    private void zA() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean bpO() {
        return false;
    }
}
