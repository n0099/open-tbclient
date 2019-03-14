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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private ViewGroup TG;
    protected com.baidu.tbadk.widget.timepicker.a.c.a cEq;
    private Animation cFA;
    private Animation cFB;
    protected View cFD;
    protected ViewGroup cFw;
    private ViewGroup cFx;
    private com.baidu.tbadk.widget.timepicker.a.d.c cFy;
    private boolean cFz;
    private Context context;
    private boolean isShowing;
    private Dialog mDialog;
    protected int cFC = 80;
    private boolean cFE = true;
    private View.OnKeyListener cFF = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener cFG = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
        if (atz()) {
            this.cFx = (ViewGroup) from.inflate(d.h.layout_basepickerview, (ViewGroup) null, false);
            this.cFx.setBackgroundColor(0);
            this.cFw = (ViewGroup) this.cFx.findViewById(d.g.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.cFw.setLayoutParams(layoutParams);
            zn();
            this.cFx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.cEq.decorView == null) {
                this.cEq.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.TG = (ViewGroup) from.inflate(d.h.layout_basepickerview, this.cEq.decorView, false);
            this.TG.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.cEq.coe != -1) {
                this.TG.setBackgroundColor(this.cEq.coe);
            }
            this.cFw = (ViewGroup) this.TG.findViewById(d.g.content_container);
            this.cFw.setLayoutParams(layoutParams);
        }
        fw(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAnim() {
        this.cFB = getInAnimation();
        this.cFA = getOutAnimation();
    }

    public void show() {
        if (atz()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            bd(this.TG);
            this.TG.requestFocus();
        }
    }

    private void bd(View view) {
        this.cEq.decorView.addView(view);
        if (this.cFE) {
            this.cFw.startAnimation(this.cFB);
        }
    }

    public boolean isShowing() {
        if (atz()) {
            return false;
        }
        return this.TG.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (atz()) {
            aty();
        } else if (!this.cFz) {
            if (this.cFE) {
                this.cFA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.atw();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.cFw.startAnimation(this.cFA);
            } else {
                atw();
            }
            this.cFz = true;
        }
    }

    public void atw() {
        this.cEq.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.cEq.decorView.removeView(a.this.TG);
                a.this.isShowing = false;
                a.this.cFz = false;
                if (a.this.cFy != null) {
                    a.this.cFy.ah(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.o(this.cFC, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.o(this.cFC, false));
    }

    public void fw(boolean z) {
        ViewGroup viewGroup;
        if (atz()) {
            viewGroup = this.cFx;
        } else {
            viewGroup = this.TG;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.cFF);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a fx(boolean z) {
        if (this.TG != null) {
            View findViewById = this.TG.findViewById(d.g.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.cFG);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void atx() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.cEq.cFi);
        }
    }

    public View findViewById(int i) {
        return this.cFw.findViewById(i);
    }

    public void zn() {
        if (this.cFx != null) {
            this.mDialog = new Dialog(this.context, d.k.custom_dialog2);
            this.mDialog.setCancelable(this.cEq.cFi);
            this.mDialog.setContentView(this.cFx);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(d.k.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.cFy != null) {
                        a.this.cFy.ah(a.this);
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

    private void aty() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean atz() {
        return false;
    }
}
