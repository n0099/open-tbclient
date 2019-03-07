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
    private ViewGroup TF;
    protected com.baidu.tbadk.widget.timepicker.a.c.a cEt;
    private ViewGroup cFA;
    private com.baidu.tbadk.widget.timepicker.a.d.c cFB;
    private boolean cFC;
    private Animation cFD;
    private Animation cFE;
    protected View cFG;
    protected ViewGroup cFz;
    private Context context;
    private boolean isShowing;
    private Dialog mDialog;
    protected int cFF = 80;
    private boolean cFH = true;
    private View.OnKeyListener cFI = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener cFJ = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
            this.cFA = (ViewGroup) from.inflate(d.h.layout_basepickerview, (ViewGroup) null, false);
            this.cFA.setBackgroundColor(0);
            this.cFz = (ViewGroup) this.cFA.findViewById(d.g.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.cFz.setLayoutParams(layoutParams);
            zn();
            this.cFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.cEt.decorView == null) {
                this.cEt.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.TF = (ViewGroup) from.inflate(d.h.layout_basepickerview, this.cEt.decorView, false);
            this.TF.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.cEt.coe != -1) {
                this.TF.setBackgroundColor(this.cEt.coe);
            }
            this.cFz = (ViewGroup) this.TF.findViewById(d.g.content_container);
            this.cFz.setLayoutParams(layoutParams);
        }
        fw(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAnim() {
        this.cFE = getInAnimation();
        this.cFD = getOutAnimation();
    }

    public void show() {
        if (atz()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            bd(this.TF);
            this.TF.requestFocus();
        }
    }

    private void bd(View view) {
        this.cEt.decorView.addView(view);
        if (this.cFH) {
            this.cFz.startAnimation(this.cFE);
        }
    }

    public boolean isShowing() {
        if (atz()) {
            return false;
        }
        return this.TF.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (atz()) {
            aty();
        } else if (!this.cFC) {
            if (this.cFH) {
                this.cFD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
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
                this.cFz.startAnimation(this.cFD);
            } else {
                atw();
            }
            this.cFC = true;
        }
    }

    public void atw() {
        this.cEt.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.cEt.decorView.removeView(a.this.TF);
                a.this.isShowing = false;
                a.this.cFC = false;
                if (a.this.cFB != null) {
                    a.this.cFB.ah(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.o(this.cFF, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.o(this.cFF, false));
    }

    public void fw(boolean z) {
        ViewGroup viewGroup;
        if (atz()) {
            viewGroup = this.cFA;
        } else {
            viewGroup = this.TF;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.cFI);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a fx(boolean z) {
        if (this.TF != null) {
            View findViewById = this.TF.findViewById(d.g.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.cFJ);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void atx() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.cEt.cFl);
        }
    }

    public View findViewById(int i) {
        return this.cFz.findViewById(i);
    }

    public void zn() {
        if (this.cFA != null) {
            this.mDialog = new Dialog(this.context, d.k.custom_dialog2);
            this.mDialog.setCancelable(this.cEt.cFl);
            this.mDialog.setContentView(this.cFA);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(d.k.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.cFB != null) {
                        a.this.cFB.ah(a.this);
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
