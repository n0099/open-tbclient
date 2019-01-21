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
    private ViewGroup acE;
    protected com.baidu.tbadk.widget.timepicker.a.c.a bth;
    protected ViewGroup bup;
    private ViewGroup buq;
    private com.baidu.tbadk.widget.timepicker.a.d.c bur;
    private boolean bus;
    private Animation but;
    private Animation buu;
    protected View buw;
    private Context context;
    private boolean isShowing;
    private Dialog mDialog;
    protected int buv = 80;
    private boolean bux = true;
    private View.OnKeyListener buy = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener buz = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
        if (TA()) {
            this.buq = (ViewGroup) from.inflate(e.h.layout_basepickerview, (ViewGroup) null, false);
            this.buq.setBackgroundColor(0);
            this.bup = (ViewGroup) this.buq.findViewById(e.g.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.bup.setLayoutParams(layoutParams);
            createDialog();
            this.buq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.bth.decorView == null) {
                this.bth.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.acE = (ViewGroup) from.inflate(e.h.layout_basepickerview, this.bth.decorView, false);
            this.acE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.bth.beB != -1) {
                this.acE.setBackgroundColor(this.bth.beB);
            }
            this.bup = (ViewGroup) this.acE.findViewById(e.g.content_container);
            this.bup.setLayoutParams(layoutParams);
        }
        dg(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAnim() {
        this.buu = getInAnimation();
        this.but = getOutAnimation();
    }

    public void show() {
        if (TA()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            ah(this.acE);
            this.acE.requestFocus();
        }
    }

    private void ah(View view) {
        this.bth.decorView.addView(view);
        if (this.bux) {
            this.bup.startAnimation(this.buu);
        }
    }

    public boolean isShowing() {
        if (TA()) {
            return false;
        }
        return this.acE.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (TA()) {
            Tz();
        } else if (!this.bus) {
            if (this.bux) {
                this.but.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.Tx();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.bup.startAnimation(this.but);
            } else {
                Tx();
            }
            this.bus = true;
        }
    }

    public void Tx() {
        this.bth.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.bth.decorView.removeView(a.this.acE);
                a.this.isShowing = false;
                a.this.bus = false;
                if (a.this.bur != null) {
                    a.this.bur.N(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.i(this.buv, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.i(this.buv, false));
    }

    public void dg(boolean z) {
        ViewGroup viewGroup;
        if (TA()) {
            viewGroup = this.buq;
        } else {
            viewGroup = this.acE;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.buy);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a dh(boolean z) {
        if (this.acE != null) {
            View findViewById = this.acE.findViewById(e.g.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.buz);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void Ty() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.bth.bua);
        }
    }

    public View findViewById(int i) {
        return this.bup.findViewById(i);
    }

    public void createDialog() {
        if (this.buq != null) {
            this.mDialog = new Dialog(this.context, e.k.custom_dialog2);
            this.mDialog.setCancelable(this.bth.bua);
            this.mDialog.setContentView(this.buq);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(e.k.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.bur != null) {
                        a.this.bur.N(a.this);
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

    private void Tz() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean TA() {
        return false;
    }
}
