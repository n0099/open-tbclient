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
    private ViewGroup Rr;
    protected com.baidu.tbadk.widget.timepicker.a.c.a cMC;
    protected ViewGroup cNI;
    private ViewGroup cNJ;
    private com.baidu.tbadk.widget.timepicker.a.d.c cNK;
    private boolean cNL;
    private Animation cNM;
    private Animation cNN;
    protected View cNP;
    private Context context;
    private boolean isShowing;
    private Dialog mDialog;
    protected int cNO = 80;
    private boolean cNQ = true;
    private View.OnKeyListener cNR = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener cNS = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
        if (ayC()) {
            this.cNJ = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.cNJ.setBackgroundColor(0);
            this.cNI = (ViewGroup) this.cNJ.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.cNI.setLayoutParams(layoutParams);
            Am();
            this.cNJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.cMC.decorView == null) {
                this.cMC.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.Rr = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.cMC.decorView, false);
            this.Rr.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.cMC.cwo != -1) {
                this.Rr.setBackgroundColor(this.cMC.cwo);
            }
            this.cNI = (ViewGroup) this.Rr.findViewById(R.id.content_container);
            this.cNI.setLayoutParams(layoutParams);
        }
        fT(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAnim() {
        this.cNN = getInAnimation();
        this.cNM = getOutAnimation();
    }

    public void show() {
        if (ayC()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            bj(this.Rr);
            this.Rr.requestFocus();
        }
    }

    private void bj(View view) {
        this.cMC.decorView.addView(view);
        if (this.cNQ) {
            this.cNI.startAnimation(this.cNN);
        }
    }

    public boolean isShowing() {
        if (ayC()) {
            return false;
        }
        return this.Rr.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (ayC()) {
            ayB();
        } else if (!this.cNL) {
            if (this.cNQ) {
                this.cNM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.ayz();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.cNI.startAnimation(this.cNM);
            } else {
                ayz();
            }
            this.cNL = true;
        }
    }

    public void ayz() {
        this.cMC.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.cMC.decorView.removeView(a.this.Rr);
                a.this.isShowing = false;
                a.this.cNL = false;
                if (a.this.cNK != null) {
                    a.this.cNK.ah(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.t(this.cNO, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.t(this.cNO, false));
    }

    public void fT(boolean z) {
        ViewGroup viewGroup;
        if (ayC()) {
            viewGroup = this.cNJ;
        } else {
            viewGroup = this.Rr;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.cNR);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a fU(boolean z) {
        if (this.Rr != null) {
            View findViewById = this.Rr.findViewById(R.id.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.cNS);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void ayA() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.cMC.cNu);
        }
    }

    public View findViewById(int i) {
        return this.cNI.findViewById(i);
    }

    public void Am() {
        if (this.cNJ != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.cMC.cNu);
            this.mDialog.setContentView(this.cNJ);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.cNK != null) {
                        a.this.cNK.ah(a.this);
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

    private void ayB() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean ayC() {
        return false;
    }
}
