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
/* loaded from: classes3.dex */
public class a {
    private ViewGroup RH;
    protected com.baidu.tbadk.widget.timepicker.a.c.a cOU;
    protected ViewGroup cQc;
    private ViewGroup cQd;
    private com.baidu.tbadk.widget.timepicker.a.d.c cQe;
    private boolean cQf;
    private Animation cQg;
    private Animation cQh;
    protected View cQj;
    private Context context;
    private boolean isShowing;
    private Dialog mDialog;
    protected int cQi = 80;
    private boolean cQk = true;
    private View.OnKeyListener cQl = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener cQm = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
        if (aAe()) {
            this.cQd = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.cQd.setBackgroundColor(0);
            this.cQc = (ViewGroup) this.cQd.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.cQc.setLayoutParams(layoutParams);
            AX();
            this.cQd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.cOU.decorView == null) {
                this.cOU.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.RH = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.cOU.decorView, false);
            this.RH.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.cOU.cyH != -1) {
                this.RH.setBackgroundColor(this.cOU.cyH);
            }
            this.cQc = (ViewGroup) this.RH.findViewById(R.id.content_container);
            this.cQc.setLayoutParams(layoutParams);
        }
        ga(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAnim() {
        this.cQh = aAa();
        this.cQg = aAb();
    }

    public void show() {
        if (aAe()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            bl(this.RH);
            this.RH.requestFocus();
        }
    }

    private void bl(View view) {
        this.cOU.decorView.addView(view);
        if (this.cQk) {
            this.cQc.startAnimation(this.cQh);
        }
    }

    public boolean isShowing() {
        if (aAe()) {
            return false;
        }
        return this.RH.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (aAe()) {
            aAd();
        } else if (!this.cQf) {
            if (this.cQk) {
                this.cQg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.azZ();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.cQc.startAnimation(this.cQg);
            } else {
                azZ();
            }
            this.cQf = true;
        }
    }

    public void azZ() {
        this.cOU.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.cOU.decorView.removeView(a.this.RH);
                a.this.isShowing = false;
                a.this.cQf = false;
                if (a.this.cQe != null) {
                    a.this.cQe.ah(a.this);
                }
            }
        });
    }

    private Animation aAa() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.u(this.cQi, true));
    }

    private Animation aAb() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.u(this.cQi, false));
    }

    public void ga(boolean z) {
        ViewGroup viewGroup;
        if (aAe()) {
            viewGroup = this.cQd;
        } else {
            viewGroup = this.RH;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.cQl);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a gb(boolean z) {
        if (this.RH != null) {
            View findViewById = this.RH.findViewById(R.id.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.cQm);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void aAc() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.cOU.cPO);
        }
    }

    public View findViewById(int i) {
        return this.cQc.findViewById(i);
    }

    public void AX() {
        if (this.cQd != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.cOU.cPO);
            this.mDialog.setContentView(this.cQd);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.cQe != null) {
                        a.this.cQe.ah(a.this);
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

    private void aAd() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean aAe() {
        return false;
    }
}
