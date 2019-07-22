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
    private ViewGroup RI;
    protected com.baidu.tbadk.widget.timepicker.a.c.a cNX;
    protected ViewGroup cPf;
    private ViewGroup cPg;
    private com.baidu.tbadk.widget.timepicker.a.d.c cPh;
    private boolean cPi;
    private Animation cPj;
    private Animation cPk;
    protected View cPm;
    private Context context;
    private boolean isShowing;
    private Dialog mDialog;
    protected int cPl = 80;
    private boolean cPn = true;
    private View.OnKeyListener cPo = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener cPp = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
        if (azQ()) {
            this.cPg = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.cPg.setBackgroundColor(0);
            this.cPf = (ViewGroup) this.cPg.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.cPf.setLayoutParams(layoutParams);
            AT();
            this.cPg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.cNX.decorView == null) {
                this.cNX.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.RI = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.cNX.decorView, false);
            this.RI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.cNX.cxE != -1) {
                this.RI.setBackgroundColor(this.cNX.cxE);
            }
            this.cPf = (ViewGroup) this.RI.findViewById(R.id.content_container);
            this.cPf.setLayoutParams(layoutParams);
        }
        fX(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAnim() {
        this.cPk = azM();
        this.cPj = azN();
    }

    public void show() {
        if (azQ()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            bl(this.RI);
            this.RI.requestFocus();
        }
    }

    private void bl(View view) {
        this.cNX.decorView.addView(view);
        if (this.cPn) {
            this.cPf.startAnimation(this.cPk);
        }
    }

    public boolean isShowing() {
        if (azQ()) {
            return false;
        }
        return this.RI.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (azQ()) {
            azP();
        } else if (!this.cPi) {
            if (this.cPn) {
                this.cPj.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.azL();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.cPf.startAnimation(this.cPj);
            } else {
                azL();
            }
            this.cPi = true;
        }
    }

    public void azL() {
        this.cNX.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.cNX.decorView.removeView(a.this.RI);
                a.this.isShowing = false;
                a.this.cPi = false;
                if (a.this.cPh != null) {
                    a.this.cPh.ah(a.this);
                }
            }
        });
    }

    private Animation azM() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.t(this.cPl, true));
    }

    private Animation azN() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.t(this.cPl, false));
    }

    public void fX(boolean z) {
        ViewGroup viewGroup;
        if (azQ()) {
            viewGroup = this.cPg;
        } else {
            viewGroup = this.RI;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.cPo);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a fY(boolean z) {
        if (this.RI != null) {
            View findViewById = this.RI.findViewById(R.id.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.cPp);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void azO() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.cNX.cOR);
        }
    }

    public View findViewById(int i) {
        return this.cPf.findViewById(i);
    }

    public void AT() {
        if (this.cPg != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.cNX.cOR);
            this.mDialog.setContentView(this.cPg);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.cPh != null) {
                        a.this.cPh.ah(a.this);
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

    private void azP() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean azQ() {
        return false;
    }
}
