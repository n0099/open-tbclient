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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a {
    private ViewGroup acu;
    protected com.baidu.tbadk.widget.timepicker.a.c.a bsp;
    private Animation btA;
    private Animation btB;
    protected View btD;
    protected ViewGroup btw;
    private ViewGroup btx;
    private com.baidu.tbadk.widget.timepicker.a.d.c bty;
    private boolean btz;
    private Context context;
    private boolean isShowing;
    private Dialog mDialog;
    protected int btC = 80;
    private boolean btE = true;
    private View.OnKeyListener btF = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener btG = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
        if (Tc()) {
            this.btx = (ViewGroup) from.inflate(e.h.layout_basepickerview, (ViewGroup) null, false);
            this.btx.setBackgroundColor(0);
            this.btw = (ViewGroup) this.btx.findViewById(e.g.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.btw.setLayoutParams(layoutParams);
            createDialog();
            this.btx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.bsp.decorView == null) {
                this.bsp.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.acu = (ViewGroup) from.inflate(e.h.layout_basepickerview, this.bsp.decorView, false);
            this.acu.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.bsp.bdL != -1) {
                this.acu.setBackgroundColor(this.bsp.bdL);
            }
            this.btw = (ViewGroup) this.acu.findViewById(e.g.content_container);
            this.btw.setLayoutParams(layoutParams);
        }
        dd(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAnim() {
        this.btB = getInAnimation();
        this.btA = getOutAnimation();
    }

    public void show() {
        if (Tc()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            ah(this.acu);
            this.acu.requestFocus();
        }
    }

    private void ah(View view) {
        this.bsp.decorView.addView(view);
        if (this.btE) {
            this.btw.startAnimation(this.btB);
        }
    }

    public boolean isShowing() {
        if (Tc()) {
            return false;
        }
        return this.acu.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (Tc()) {
            Tb();
        } else if (!this.btz) {
            if (this.btE) {
                this.btA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.SZ();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.btw.startAnimation(this.btA);
            } else {
                SZ();
            }
            this.btz = true;
        }
    }

    public void SZ() {
        this.bsp.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.bsp.decorView.removeView(a.this.acu);
                a.this.isShowing = false;
                a.this.btz = false;
                if (a.this.bty != null) {
                    a.this.bty.N(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.i(this.btC, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.i(this.btC, false));
    }

    public void dd(boolean z) {
        ViewGroup viewGroup;
        if (Tc()) {
            viewGroup = this.btx;
        } else {
            viewGroup = this.acu;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.btF);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a de(boolean z) {
        if (this.acu != null) {
            View findViewById = this.acu.findViewById(e.g.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.btG);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void Ta() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.bsp.bth);
        }
    }

    public View findViewById(int i) {
        return this.btw.findViewById(i);
    }

    public void createDialog() {
        if (this.btx != null) {
            this.mDialog = new Dialog(this.context, e.k.custom_dialog2);
            this.mDialog.setCancelable(this.bsp.bth);
            this.mDialog.setContentView(this.btx);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(e.k.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.bty != null) {
                        a.this.bty.N(a.this);
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

    private void Tb() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean Tc() {
        return false;
    }
}
