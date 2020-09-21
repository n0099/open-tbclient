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
/* loaded from: classes20.dex */
public class a {
    private Context context;
    protected com.baidu.tbadk.widget.timepicker.a.c.a fka;
    protected ViewGroup fld;
    private ViewGroup fle;
    private com.baidu.tbadk.widget.timepicker.a.d.c flf;
    private boolean flg;
    protected View fli;
    private Animation inAnim;
    private boolean isShowing;
    private Dialog mDialog;
    private Animation outAnim;
    private ViewGroup rootView;
    protected int flh = 80;
    private boolean flj = true;
    private View.OnKeyListener flk = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
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
        if (bzM()) {
            this.fle = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.fle.setBackgroundColor(0);
            this.fld = (ViewGroup) this.fle.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.fld.setLayoutParams(layoutParams);
            aiF();
            this.fle.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.fka.decorView == null) {
                this.fka.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.rootView = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.fka.decorView, false);
            this.rootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.fka.backgroundId != -1) {
                this.rootView.setBackgroundColor(this.fka.backgroundId);
            }
            this.fld = (ViewGroup) this.rootView.findViewById(R.id.content_container);
            this.fld.setLayoutParams(layoutParams);
        }
        ke(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ig() {
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    public void show() {
        if (bzM()) {
            NY();
        } else if (!isShowing()) {
            this.isShowing = true;
            bD(this.rootView);
            this.rootView.requestFocus();
        }
    }

    private void bD(View view) {
        this.fka.decorView.addView(view);
        if (this.flj) {
            this.fld.startAnimation(this.inAnim);
        }
    }

    public boolean isShowing() {
        if (bzM()) {
            return false;
        }
        return this.rootView.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (bzM()) {
            FD();
        } else if (!this.flg) {
            if (this.flj) {
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
                this.fld.startAnimation(this.outAnim);
            } else {
                dismissImmediately();
            }
            this.flg = true;
        }
    }

    public void dismissImmediately() {
        this.fka.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fka.decorView.removeView(a.this.rootView);
                a.this.isShowing = false;
                a.this.flg = false;
                if (a.this.flf != null) {
                    a.this.flf.av(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.flh, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.flh, false));
    }

    public void ke(boolean z) {
        ViewGroup viewGroup;
        if (bzM()) {
            viewGroup = this.fle;
        } else {
            viewGroup = this.rootView;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.flk);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a kf(boolean z) {
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

    public void bzL() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.fka.fkQ);
        }
    }

    public View findViewById(int i) {
        return this.fld.findViewById(i);
    }

    public void aiF() {
        if (this.fle != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.fka.fkQ);
            this.mDialog.setContentView(this.fle);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.flf != null) {
                        a.this.flf.av(a.this);
                    }
                }
            });
        }
    }

    private void NY() {
        if (this.mDialog != null) {
            this.mDialog.show();
        }
    }

    private void FD() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean bzM() {
        return false;
    }
}
