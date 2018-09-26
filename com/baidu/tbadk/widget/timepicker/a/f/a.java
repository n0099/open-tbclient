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
    private ViewGroup XR;
    protected com.baidu.tbadk.widget.timepicker.a.c.a bke;
    protected ViewGroup blk;
    private ViewGroup bll;
    private com.baidu.tbadk.widget.timepicker.a.d.c blm;
    private boolean bln;
    private Animation blo;
    private Animation blp;
    protected View blr;
    private Context context;
    private boolean isShowing;
    private Dialog mDialog;
    protected int blq = 80;
    private boolean bls = true;
    private View.OnKeyListener blt = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener blu = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
        if (PT()) {
            this.bll = (ViewGroup) from.inflate(e.h.layout_basepickerview, (ViewGroup) null, false);
            this.bll.setBackgroundColor(0);
            this.blk = (ViewGroup) this.bll.findViewById(e.g.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.blk.setLayoutParams(layoutParams);
            PR();
            this.bll.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.bke.decorView == null) {
                this.bke.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.XR = (ViewGroup) from.inflate(e.h.layout_basepickerview, this.bke.decorView, false);
            this.XR.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.bke.aVb != -1) {
                this.XR.setBackgroundColor(this.bke.aVb);
            }
            this.blk = (ViewGroup) this.XR.findViewById(e.g.content_container);
            this.blk.setLayoutParams(layoutParams);
        }
        cC(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAnim() {
        this.blp = getInAnimation();
        this.blo = getOutAnimation();
    }

    public void show() {
        if (PT()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            ai(this.XR);
            this.XR.requestFocus();
        }
    }

    private void ai(View view) {
        this.bke.decorView.addView(view);
        if (this.bls) {
            this.blk.startAnimation(this.blp);
        }
    }

    public boolean isShowing() {
        if (PT()) {
            return false;
        }
        return this.XR.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (PT()) {
            PS();
        } else if (!this.bln) {
            if (this.bls) {
                this.blo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.PP();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.blk.startAnimation(this.blo);
            } else {
                PP();
            }
            this.bln = true;
        }
    }

    public void PP() {
        this.bke.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.bke.decorView.removeView(a.this.XR);
                a.this.isShowing = false;
                a.this.bln = false;
                if (a.this.blm != null) {
                    a.this.blm.J(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.i(this.blq, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.i(this.blq, false));
    }

    public void cC(boolean z) {
        ViewGroup viewGroup;
        if (PT()) {
            viewGroup = this.bll;
        } else {
            viewGroup = this.XR;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.blt);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a cD(boolean z) {
        if (this.XR != null) {
            View findViewById = this.XR.findViewById(e.g.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.blu);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void PQ() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.bke.bkW);
        }
    }

    public View findViewById(int i) {
        return this.blk.findViewById(i);
    }

    public void PR() {
        if (this.bll != null) {
            this.mDialog = new Dialog(this.context, e.k.custom_dialog2);
            this.mDialog.setCancelable(this.bke.bkW);
            this.mDialog.setContentView(this.bll);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(e.k.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.blm != null) {
                        a.this.blm.J(a.this);
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

    private void PS() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean PT() {
        return false;
    }
}
