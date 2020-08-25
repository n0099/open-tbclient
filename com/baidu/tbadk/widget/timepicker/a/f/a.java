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
    protected com.baidu.tbadk.widget.timepicker.a.c.a fhc;
    protected ViewGroup fig;
    private ViewGroup fih;
    private com.baidu.tbadk.widget.timepicker.a.d.c fii;
    private boolean fij;
    protected View fil;
    private Animation inAnim;
    private boolean isShowing;
    private Dialog mDialog;
    private Animation outAnim;
    private ViewGroup rootView;
    protected int fik = 80;
    private boolean fim = true;
    private View.OnKeyListener fin = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
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
        if (byC()) {
            this.fih = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.fih.setBackgroundColor(0);
            this.fig = (ViewGroup) this.fih.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.fig.setLayoutParams(layoutParams);
            ahV();
            this.fih.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.fhc.decorView == null) {
                this.fhc.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.rootView = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.fhc.decorView, false);
            this.rootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.fhc.backgroundId != -1) {
                this.rootView.setBackgroundColor(this.fhc.backgroundId);
            }
            this.fig = (ViewGroup) this.rootView.findViewById(R.id.content_container);
            this.fig.setLayoutParams(layoutParams);
        }
        kb(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void HE() {
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    public void show() {
        if (byC()) {
            Nv();
        } else if (!isShowing()) {
            this.isShowing = true;
            bz(this.rootView);
            this.rootView.requestFocus();
        }
    }

    private void bz(View view) {
        this.fhc.decorView.addView(view);
        if (this.fim) {
            this.fig.startAnimation(this.inAnim);
        }
    }

    public boolean isShowing() {
        if (byC()) {
            return false;
        }
        return this.rootView.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (byC()) {
            Fd();
        } else if (!this.fij) {
            if (this.fim) {
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
                this.fig.startAnimation(this.outAnim);
            } else {
                dismissImmediately();
            }
            this.fij = true;
        }
    }

    public void dismissImmediately() {
        this.fhc.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fhc.decorView.removeView(a.this.rootView);
                a.this.isShowing = false;
                a.this.fij = false;
                if (a.this.fii != null) {
                    a.this.fii.au(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.fik, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.fik, false));
    }

    public void kb(boolean z) {
        ViewGroup viewGroup;
        if (byC()) {
            viewGroup = this.fih;
        } else {
            viewGroup = this.rootView;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.fin);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a kc(boolean z) {
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

    public void byB() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.fhc.fhS);
        }
    }

    public View findViewById(int i) {
        return this.fig.findViewById(i);
    }

    public void ahV() {
        if (this.fih != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.fhc.fhS);
            this.mDialog.setContentView(this.fih);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.fii != null) {
                        a.this.fii.au(a.this);
                    }
                }
            });
        }
    }

    private void Nv() {
        if (this.mDialog != null) {
            this.mDialog.show();
        }
    }

    private void Fd() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean byC() {
        return false;
    }
}
