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
    protected com.baidu.tbadk.widget.timepicker.a.c.a cOe;
    protected ViewGroup cPm;
    private ViewGroup cPn;
    private com.baidu.tbadk.widget.timepicker.a.d.c cPo;
    private boolean cPp;
    private Animation cPq;
    private Animation cPr;
    protected View cPt;
    private Context context;
    private boolean isShowing;
    private Dialog mDialog;
    protected int cPs = 80;
    private boolean cPu = true;
    private View.OnKeyListener cPv = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener cPw = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
        if (azS()) {
            this.cPn = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.cPn.setBackgroundColor(0);
            this.cPm = (ViewGroup) this.cPn.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.cPm.setLayoutParams(layoutParams);
            AT();
            this.cPn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.cOe.decorView == null) {
                this.cOe.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.RI = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.cOe.decorView, false);
            this.RI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.cOe.cxL != -1) {
                this.RI.setBackgroundColor(this.cOe.cxL);
            }
            this.cPm = (ViewGroup) this.RI.findViewById(R.id.content_container);
            this.cPm.setLayoutParams(layoutParams);
        }
        fX(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAnim() {
        this.cPr = azO();
        this.cPq = azP();
    }

    public void show() {
        if (azS()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            bl(this.RI);
            this.RI.requestFocus();
        }
    }

    private void bl(View view) {
        this.cOe.decorView.addView(view);
        if (this.cPu) {
            this.cPm.startAnimation(this.cPr);
        }
    }

    public boolean isShowing() {
        if (azS()) {
            return false;
        }
        return this.RI.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (azS()) {
            azR();
        } else if (!this.cPp) {
            if (this.cPu) {
                this.cPq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.azN();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.cPm.startAnimation(this.cPq);
            } else {
                azN();
            }
            this.cPp = true;
        }
    }

    public void azN() {
        this.cOe.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.cOe.decorView.removeView(a.this.RI);
                a.this.isShowing = false;
                a.this.cPp = false;
                if (a.this.cPo != null) {
                    a.this.cPo.ah(a.this);
                }
            }
        });
    }

    private Animation azO() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.t(this.cPs, true));
    }

    private Animation azP() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.t(this.cPs, false));
    }

    public void fX(boolean z) {
        ViewGroup viewGroup;
        if (azS()) {
            viewGroup = this.cPn;
        } else {
            viewGroup = this.RI;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.cPv);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a fY(boolean z) {
        if (this.RI != null) {
            View findViewById = this.RI.findViewById(R.id.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.cPw);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void azQ() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.cOe.cOY);
        }
    }

    public View findViewById(int i) {
        return this.cPm.findViewById(i);
    }

    public void AT() {
        if (this.cPn != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.cOe.cOY);
            this.mDialog.setContentView(this.cPn);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.cPo != null) {
                        a.this.cPo.ah(a.this);
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

    private void azR() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean azS() {
        return false;
    }
}
