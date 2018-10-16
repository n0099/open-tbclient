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
    private ViewGroup acx;
    protected com.baidu.tbadk.widget.timepicker.a.c.a bog;
    protected ViewGroup bpm;
    private ViewGroup bpn;
    private com.baidu.tbadk.widget.timepicker.a.d.c bpo;
    private boolean bpp;
    private Animation bpq;
    private Animation bpr;
    protected View bpt;
    private Context context;
    private boolean isShowing;
    private Dialog mDialog;
    protected int bps = 80;
    private boolean bpu = true;
    private View.OnKeyListener bpv = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener bpw = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
        if (RN()) {
            this.bpn = (ViewGroup) from.inflate(e.h.layout_basepickerview, (ViewGroup) null, false);
            this.bpn.setBackgroundColor(0);
            this.bpm = (ViewGroup) this.bpn.findViewById(e.g.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.bpm.setLayoutParams(layoutParams);
            createDialog();
            this.bpn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.bog.decorView == null) {
                this.bog.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.acx = (ViewGroup) from.inflate(e.h.layout_basepickerview, this.bog.decorView, false);
            this.acx.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.bog.aZA != -1) {
                this.acx.setBackgroundColor(this.bog.aZA);
            }
            this.bpm = (ViewGroup) this.acx.findViewById(e.g.content_container);
            this.bpm.setLayoutParams(layoutParams);
        }
        cL(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAnim() {
        this.bpr = getInAnimation();
        this.bpq = getOutAnimation();
    }

    public void show() {
        if (RN()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            ai(this.acx);
            this.acx.requestFocus();
        }
    }

    private void ai(View view) {
        this.bog.decorView.addView(view);
        if (this.bpu) {
            this.bpm.startAnimation(this.bpr);
        }
    }

    public boolean isShowing() {
        if (RN()) {
            return false;
        }
        return this.acx.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (RN()) {
            RM();
        } else if (!this.bpp) {
            if (this.bpu) {
                this.bpq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.RK();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.bpm.startAnimation(this.bpq);
            } else {
                RK();
            }
            this.bpp = true;
        }
    }

    public void RK() {
        this.bog.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.bog.decorView.removeView(a.this.acx);
                a.this.isShowing = false;
                a.this.bpp = false;
                if (a.this.bpo != null) {
                    a.this.bpo.N(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.i(this.bps, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.i(this.bps, false));
    }

    public void cL(boolean z) {
        ViewGroup viewGroup;
        if (RN()) {
            viewGroup = this.bpn;
        } else {
            viewGroup = this.acx;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.bpv);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a cM(boolean z) {
        if (this.acx != null) {
            View findViewById = this.acx.findViewById(e.g.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.bpw);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void RL() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.bog.boY);
        }
    }

    public View findViewById(int i) {
        return this.bpm.findViewById(i);
    }

    public void createDialog() {
        if (this.bpn != null) {
            this.mDialog = new Dialog(this.context, e.k.custom_dialog2);
            this.mDialog.setCancelable(this.bog.boY);
            this.mDialog.setContentView(this.bpn);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(e.k.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.bpo != null) {
                        a.this.bpo.N(a.this);
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

    private void RM() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean RN() {
        return false;
    }
}
