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
    protected com.baidu.tbadk.widget.timepicker.a.c.a fKc;
    protected ViewGroup fLf;
    private ViewGroup fLg;
    private com.baidu.tbadk.widget.timepicker.a.d.c fLh;
    private boolean fLi;
    protected View fLk;
    private Animation inAnim;
    private boolean isShowing;
    private Dialog mDialog;
    private Animation outAnim;
    private ViewGroup rootView;
    protected int fLj = 80;
    private boolean fLl = true;
    private View.OnKeyListener fLm = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
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
        if (bGh()) {
            this.fLg = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.fLg.setBackgroundColor(0);
            this.fLf = (ViewGroup) this.fLg.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.fLf.setLayoutParams(layoutParams);
            apc();
            this.fLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.fKc.decorView == null) {
                this.fKc.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.rootView = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.fKc.decorView, false);
            this.rootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.fKc.backgroundId != -1) {
                this.rootView.setBackgroundColor(this.fKc.backgroundId);
            }
            this.fLf = (ViewGroup) this.rootView.findViewById(R.id.content_container);
            this.fLf.setLayoutParams(layoutParams);
        }
        kZ(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Jn() {
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    public void show() {
        if (bGh()) {
            PA();
        } else if (!isShowing()) {
            this.isShowing = true;
            bP(this.rootView);
            this.rootView.requestFocus();
        }
    }

    private void bP(View view) {
        this.fKc.decorView.addView(view);
        if (this.fLl) {
            this.fLf.startAnimation(this.inAnim);
        }
    }

    public boolean isShowing() {
        if (bGh()) {
            return false;
        }
        return this.rootView.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (bGh()) {
            GM();
        } else if (!this.fLi) {
            if (this.fLl) {
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
                this.fLf.startAnimation(this.outAnim);
            } else {
                dismissImmediately();
            }
            this.fLi = true;
        }
    }

    public void dismissImmediately() {
        this.fKc.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fKc.decorView.removeView(a.this.rootView);
                a.this.isShowing = false;
                a.this.fLi = false;
                if (a.this.fLh != null) {
                    a.this.fLh.ay(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.fLj, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.fLj, false));
    }

    public void kZ(boolean z) {
        ViewGroup viewGroup;
        if (bGh()) {
            viewGroup = this.fLg;
        } else {
            viewGroup = this.rootView;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.fLm);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a la(boolean z) {
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

    public void bGg() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.fKc.fKS);
        }
    }

    public View findViewById(int i) {
        return this.fLf.findViewById(i);
    }

    public void apc() {
        if (this.fLg != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.fKc.fKS);
            this.mDialog.setContentView(this.fLg);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.fLh != null) {
                        a.this.fLh.ay(a.this);
                    }
                }
            });
        }
    }

    private void PA() {
        if (this.mDialog != null) {
            this.mDialog.show();
        }
    }

    private void GM() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean bGh() {
        return false;
    }
}
