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
/* loaded from: classes21.dex */
public class a {
    private Context context;
    protected com.baidu.tbadk.widget.timepicker.a.c.a fKz;
    protected ViewGroup fLC;
    private ViewGroup fLD;
    private com.baidu.tbadk.widget.timepicker.a.d.c fLE;
    private boolean fLF;
    protected View fLH;
    private Animation inAnim;
    private boolean isShowing;
    private Dialog mDialog;
    private Animation outAnim;
    private ViewGroup rootView;
    protected int fLG = 80;
    private boolean fLI = true;
    private View.OnKeyListener fLJ = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener onCancelableTouchListener = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
        if (bGO()) {
            this.fLD = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.fLD.setBackgroundColor(0);
            this.fLC = (ViewGroup) this.fLD.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.fLC.setLayoutParams(layoutParams);
            apL();
            this.fLD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.fKz.decorView == null) {
                this.fKz.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.rootView = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.fKz.decorView, false);
            this.rootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.fKz.backgroundId != -1) {
                this.rootView.setBackgroundColor(this.fKz.backgroundId);
            }
            this.fLC = (ViewGroup) this.rootView.findViewById(R.id.content_container);
            this.fLC.setLayoutParams(layoutParams);
        }
        kY(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void JW() {
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    public void show() {
        if (bGO()) {
            Qj();
        } else if (!isShowing()) {
            this.isShowing = true;
            bM(this.rootView);
            this.rootView.requestFocus();
        }
    }

    private void bM(View view) {
        this.fKz.decorView.addView(view);
        if (this.fLI) {
            this.fLC.startAnimation(this.inAnim);
        }
    }

    public boolean isShowing() {
        if (bGO()) {
            return false;
        }
        return this.rootView.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (bGO()) {
            Hv();
        } else if (!this.fLF) {
            if (this.fLI) {
                this.outAnim.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dismissImmediately();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.fLC.startAnimation(this.outAnim);
            } else {
                dismissImmediately();
            }
            this.fLF = true;
        }
    }

    public void dismissImmediately() {
        this.fKz.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fKz.decorView.removeView(a.this.rootView);
                a.this.isShowing = false;
                a.this.fLF = false;
                if (a.this.fLE != null) {
                    a.this.fLE.ay(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.fLG, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.fLG, false));
    }

    public void kY(boolean z) {
        ViewGroup viewGroup;
        if (bGO()) {
            viewGroup = this.fLD;
        } else {
            viewGroup = this.rootView;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.fLJ);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a kZ(boolean z) {
        if (this.rootView != null) {
            View findViewById = this.rootView.findViewById(R.id.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.onCancelableTouchListener);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void bGN() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.fKz.fLp);
        }
    }

    public View findViewById(int i) {
        return this.fLC.findViewById(i);
    }

    public void apL() {
        if (this.fLD != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.fKz.fLp);
            this.mDialog.setContentView(this.fLD);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.fLE != null) {
                        a.this.fLE.ay(a.this);
                    }
                }
            });
        }
    }

    private void Qj() {
        if (this.mDialog != null) {
            this.mDialog.show();
        }
    }

    private void Hv() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean bGO() {
        return false;
    }
}
