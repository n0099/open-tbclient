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
    private ViewGroup AE;
    private boolean abA;
    protected com.baidu.tbadk.widget.timepicker.a.c.a cXv;
    protected ViewGroup cYD;
    private ViewGroup cYE;
    private com.baidu.tbadk.widget.timepicker.a.d.c cYF;
    private boolean cYG;
    private Animation cYH;
    private Animation cYI;
    protected View cYK;
    private Context context;
    private Dialog mDialog;
    protected int cYJ = 80;
    private boolean cYL = true;
    private View.OnKeyListener cYM = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener cYN = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
        if (aAl()) {
            this.cYE = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.cYE.setBackgroundColor(0);
            this.cYD = (ViewGroup) this.cYE.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.cYD.setLayoutParams(layoutParams);
            FT();
            this.cYE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.cXv.decorView == null) {
                this.cXv.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.AE = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.cXv.decorView, false);
            this.AE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.cXv.backgroundId != -1) {
                this.AE.setBackgroundColor(this.cXv.backgroundId);
            }
            this.cYD = (ViewGroup) this.AE.findViewById(R.id.content_container);
            this.cYD.setLayoutParams(layoutParams);
        }
        fP(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rK() {
        this.cYI = aAh();
        this.cYH = aAi();
    }

    public void show() {
        if (aAl()) {
            showDialog();
        } else if (!isShowing()) {
            this.abA = true;
            bl(this.AE);
            this.AE.requestFocus();
        }
    }

    private void bl(View view) {
        this.cXv.decorView.addView(view);
        if (this.cYL) {
            this.cYD.startAnimation(this.cYI);
        }
    }

    public boolean isShowing() {
        if (aAl()) {
            return false;
        }
        return this.AE.getParent() != null || this.abA;
    }

    public void dismiss() {
        if (aAl()) {
            aAk();
        } else if (!this.cYG) {
            if (this.cYL) {
                this.cYH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.aAg();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.cYD.startAnimation(this.cYH);
            } else {
                aAg();
            }
            this.cYG = true;
        }
    }

    public void aAg() {
        this.cXv.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.cXv.decorView.removeView(a.this.AE);
                a.this.abA = false;
                a.this.cYG = false;
                if (a.this.cYF != null) {
                    a.this.cYF.ad(a.this);
                }
            }
        });
    }

    private Animation aAh() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.w(this.cYJ, true));
    }

    private Animation aAi() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.w(this.cYJ, false));
    }

    public void fP(boolean z) {
        ViewGroup viewGroup;
        if (aAl()) {
            viewGroup = this.cYE;
        } else {
            viewGroup = this.AE;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.cYM);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a fQ(boolean z) {
        if (this.AE != null) {
            View findViewById = this.AE.findViewById(R.id.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.cYN);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void aAj() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.cXv.cYp);
        }
    }

    public View findViewById(int i) {
        return this.cYD.findViewById(i);
    }

    public void FT() {
        if (this.cYE != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.cXv.cYp);
            this.mDialog.setContentView(this.cYE);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.cYF != null) {
                        a.this.cYF.ad(a.this);
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

    private void aAk() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean aAl() {
        return false;
    }
}
