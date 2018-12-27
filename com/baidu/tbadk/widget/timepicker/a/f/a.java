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
    protected com.baidu.tbadk.widget.timepicker.a.c.a bss;
    private ViewGroup btA;
    private com.baidu.tbadk.widget.timepicker.a.d.c btB;
    private boolean btC;
    private Animation btD;
    private Animation btE;
    protected View btG;
    protected ViewGroup btz;
    private Context context;
    private boolean isShowing;
    private Dialog mDialog;
    protected int btF = 80;
    private boolean btH = true;
    private View.OnKeyListener btI = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener btJ = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
        if (Te()) {
            this.btA = (ViewGroup) from.inflate(e.h.layout_basepickerview, (ViewGroup) null, false);
            this.btA.setBackgroundColor(0);
            this.btz = (ViewGroup) this.btA.findViewById(e.g.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.btz.setLayoutParams(layoutParams);
            createDialog();
            this.btA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.bss.decorView == null) {
                this.bss.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.acu = (ViewGroup) from.inflate(e.h.layout_basepickerview, this.bss.decorView, false);
            this.acu.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.bss.bdO != -1) {
                this.acu.setBackgroundColor(this.bss.bdO);
            }
            this.btz = (ViewGroup) this.acu.findViewById(e.g.content_container);
            this.btz.setLayoutParams(layoutParams);
        }
        dd(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAnim() {
        this.btE = getInAnimation();
        this.btD = getOutAnimation();
    }

    public void show() {
        if (Te()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            ah(this.acu);
            this.acu.requestFocus();
        }
    }

    private void ah(View view) {
        this.bss.decorView.addView(view);
        if (this.btH) {
            this.btz.startAnimation(this.btE);
        }
    }

    public boolean isShowing() {
        if (Te()) {
            return false;
        }
        return this.acu.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (Te()) {
            Td();
        } else if (!this.btC) {
            if (this.btH) {
                this.btD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.Tb();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.btz.startAnimation(this.btD);
            } else {
                Tb();
            }
            this.btC = true;
        }
    }

    public void Tb() {
        this.bss.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.bss.decorView.removeView(a.this.acu);
                a.this.isShowing = false;
                a.this.btC = false;
                if (a.this.btB != null) {
                    a.this.btB.N(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.i(this.btF, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.i(this.btF, false));
    }

    public void dd(boolean z) {
        ViewGroup viewGroup;
        if (Te()) {
            viewGroup = this.btA;
        } else {
            viewGroup = this.acu;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.btI);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a de(boolean z) {
        if (this.acu != null) {
            View findViewById = this.acu.findViewById(e.g.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.btJ);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void Tc() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.bss.btk);
        }
    }

    public View findViewById(int i) {
        return this.btz.findViewById(i);
    }

    public void createDialog() {
        if (this.btA != null) {
            this.mDialog = new Dialog(this.context, e.k.custom_dialog2);
            this.mDialog.setCancelable(this.bss.btk);
            this.mDialog.setContentView(this.btA);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(e.k.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.btB != null) {
                        a.this.btB.N(a.this);
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

    private void Td() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean Te() {
        return false;
    }
}
