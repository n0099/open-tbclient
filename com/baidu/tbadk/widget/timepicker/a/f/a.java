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
    private ViewGroup Rq;
    protected com.baidu.tbadk.widget.timepicker.a.c.a cMD;
    protected ViewGroup cNJ;
    private ViewGroup cNK;
    private com.baidu.tbadk.widget.timepicker.a.d.c cNL;
    private boolean cNM;
    private Animation cNN;
    private Animation cNO;
    protected View cNQ;
    private Context context;
    private boolean isShowing;
    private Dialog mDialog;
    protected int cNP = 80;
    private boolean cNR = true;
    private View.OnKeyListener cNS = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener cNT = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
            this.cNK = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.cNK.setBackgroundColor(0);
            this.cNJ = (ViewGroup) this.cNK.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.cNJ.setLayoutParams(layoutParams);
            Am();
            this.cNK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.cMD.decorView == null) {
                this.cMD.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.Rq = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.cMD.decorView, false);
            this.Rq.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.cMD.cwp != -1) {
                this.Rq.setBackgroundColor(this.cMD.cwp);
            }
            this.cNJ = (ViewGroup) this.Rq.findViewById(R.id.content_container);
            this.cNJ.setLayoutParams(layoutParams);
        }
        fT(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAnim() {
        this.cNO = getInAnimation();
        this.cNN = getOutAnimation();
    }

    public void show() {
        if (ayC()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            bj(this.Rq);
            this.Rq.requestFocus();
        }
    }

    private void bj(View view) {
        this.cMD.decorView.addView(view);
        if (this.cNR) {
            this.cNJ.startAnimation(this.cNO);
        }
    }

    public boolean isShowing() {
        if (ayC()) {
            return false;
        }
        return this.Rq.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (ayC()) {
            ayB();
        } else if (!this.cNM) {
            if (this.cNR) {
                this.cNN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
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
                this.cNJ.startAnimation(this.cNN);
            } else {
                ayz();
            }
            this.cNM = true;
        }
    }

    public void ayz() {
        this.cMD.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.cMD.decorView.removeView(a.this.Rq);
                a.this.isShowing = false;
                a.this.cNM = false;
                if (a.this.cNL != null) {
                    a.this.cNL.ah(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.t(this.cNP, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.t(this.cNP, false));
    }

    public void fT(boolean z) {
        ViewGroup viewGroup;
        if (ayC()) {
            viewGroup = this.cNK;
        } else {
            viewGroup = this.Rq;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.cNS);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a fU(boolean z) {
        if (this.Rq != null) {
            View findViewById = this.Rq.findViewById(R.id.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.cNT);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void ayA() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.cMD.cNv);
        }
    }

    public View findViewById(int i) {
        return this.cNJ.findViewById(i);
    }

    public void Am() {
        if (this.cNK != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.cMD.cNv);
            this.mDialog.setContentView(this.cNK);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.cNL != null) {
                        a.this.cNL.ah(a.this);
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
