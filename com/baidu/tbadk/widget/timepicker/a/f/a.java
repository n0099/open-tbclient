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
    protected com.baidu.tbadk.widget.timepicker.a.c.a boS;
    protected ViewGroup bpY;
    private ViewGroup bpZ;
    private com.baidu.tbadk.widget.timepicker.a.d.c bqa;
    private boolean bqb;
    private Animation bqc;
    private Animation bqd;
    protected View bqf;
    private Context context;
    private boolean isShowing;
    private Dialog mDialog;
    protected int bqe = 80;
    private boolean bqg = true;
    private View.OnKeyListener bqh = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener bqi = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
        if (RW()) {
            this.bpZ = (ViewGroup) from.inflate(e.h.layout_basepickerview, (ViewGroup) null, false);
            this.bpZ.setBackgroundColor(0);
            this.bpY = (ViewGroup) this.bpZ.findViewById(e.g.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.bpY.setLayoutParams(layoutParams);
            createDialog();
            this.bpZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.boS.decorView == null) {
                this.boS.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.acu = (ViewGroup) from.inflate(e.h.layout_basepickerview, this.boS.decorView, false);
            this.acu.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.boS.ban != -1) {
                this.acu.setBackgroundColor(this.boS.ban);
            }
            this.bpY = (ViewGroup) this.acu.findViewById(e.g.content_container);
            this.bpY.setLayoutParams(layoutParams);
        }
        dc(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAnim() {
        this.bqd = getInAnimation();
        this.bqc = getOutAnimation();
    }

    public void show() {
        if (RW()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            ah(this.acu);
            this.acu.requestFocus();
        }
    }

    private void ah(View view) {
        this.boS.decorView.addView(view);
        if (this.bqg) {
            this.bpY.startAnimation(this.bqd);
        }
    }

    public boolean isShowing() {
        if (RW()) {
            return false;
        }
        return this.acu.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (RW()) {
            RV();
        } else if (!this.bqb) {
            if (this.bqg) {
                this.bqc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.RT();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.bpY.startAnimation(this.bqc);
            } else {
                RT();
            }
            this.bqb = true;
        }
    }

    public void RT() {
        this.boS.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.boS.decorView.removeView(a.this.acu);
                a.this.isShowing = false;
                a.this.bqb = false;
                if (a.this.bqa != null) {
                    a.this.bqa.N(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.i(this.bqe, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.i(this.bqe, false));
    }

    public void dc(boolean z) {
        ViewGroup viewGroup;
        if (RW()) {
            viewGroup = this.bpZ;
        } else {
            viewGroup = this.acu;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.bqh);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a dd(boolean z) {
        if (this.acu != null) {
            View findViewById = this.acu.findViewById(e.g.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.bqi);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void RU() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.boS.bpK);
        }
    }

    public View findViewById(int i) {
        return this.bpY.findViewById(i);
    }

    public void createDialog() {
        if (this.bpZ != null) {
            this.mDialog = new Dialog(this.context, e.k.custom_dialog2);
            this.mDialog.setCancelable(this.boS.bpK);
            this.mDialog.setContentView(this.bpZ);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(e.k.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.bqa != null) {
                        a.this.bqa.N(a.this);
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

    private void RV() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean RW() {
        return false;
    }
}
