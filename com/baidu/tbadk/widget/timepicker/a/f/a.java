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
    protected com.baidu.tbadk.widget.timepicker.a.c.a btg;
    protected ViewGroup buo;
    private ViewGroup bup;
    private com.baidu.tbadk.widget.timepicker.a.d.c buq;
    private boolean bur;
    private Animation bus;
    private Animation but;
    protected View buv;
    private Context context;
    private boolean isShowing;
    private Dialog mDialog;
    protected int buu = 80;
    private boolean buw = true;
    private View.OnKeyListener bux = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener buy = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
            this.bup = (ViewGroup) from.inflate(e.h.layout_basepickerview, (ViewGroup) null, false);
            this.bup.setBackgroundColor(0);
            this.buo = (ViewGroup) this.bup.findViewById(e.g.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.buo.setLayoutParams(layoutParams);
            createDialog();
            this.bup.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.btg.decorView == null) {
                this.btg.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.acE = (ViewGroup) from.inflate(e.h.layout_basepickerview, this.btg.decorView, false);
            this.acE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.btg.beA != -1) {
                this.acE.setBackgroundColor(this.btg.beA);
            }
            this.buo = (ViewGroup) this.acE.findViewById(e.g.content_container);
            this.buo.setLayoutParams(layoutParams);
        }
        dg(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAnim() {
        this.but = getInAnimation();
        this.bus = getOutAnimation();
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
        this.btg.decorView.addView(view);
        if (this.buw) {
            this.buo.startAnimation(this.but);
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
        } else if (!this.bur) {
            if (this.buw) {
                this.bus.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
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
                this.buo.startAnimation(this.bus);
            } else {
                Tx();
            }
            this.bur = true;
        }
    }

    public void Tx() {
        this.btg.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.btg.decorView.removeView(a.this.acE);
                a.this.isShowing = false;
                a.this.bur = false;
                if (a.this.buq != null) {
                    a.this.buq.N(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.i(this.buu, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.i(this.buu, false));
    }

    public void dg(boolean z) {
        ViewGroup viewGroup;
        if (TA()) {
            viewGroup = this.bup;
        } else {
            viewGroup = this.acE;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.bux);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a dh(boolean z) {
        if (this.acE != null) {
            View findViewById = this.acE.findViewById(e.g.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.buy);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void Ty() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.btg.btZ);
        }
    }

    public View findViewById(int i) {
        return this.buo.findViewById(i);
    }

    public void createDialog() {
        if (this.bup != null) {
            this.mDialog = new Dialog(this.context, e.k.custom_dialog2);
            this.mDialog.setCancelable(this.btg.btZ);
            this.mDialog.setContentView(this.bup);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(e.k.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.buq != null) {
                        a.this.buq.N(a.this);
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
