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
/* loaded from: classes.dex */
public class a {
    private Context context;
    protected com.baidu.tbadk.widget.timepicker.a.c.a gbr;
    protected ViewGroup gcs;
    private ViewGroup gcu;
    private com.baidu.tbadk.widget.timepicker.a.d.c gcv;
    private boolean gcw;
    protected View gcy;
    private Animation inAnim;
    private boolean isShowing;
    private Dialog mDialog;
    private Animation outAnim;
    private ViewGroup rootView;
    protected int gcx = 80;
    private boolean gcz = true;
    private View.OnKeyListener gcA = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
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
        if (bLZ()) {
            this.gcu = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.gcu.setBackgroundColor(0);
            this.gcs = (ViewGroup) this.gcu.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.gcs.setLayoutParams(layoutParams);
            atC();
            this.gcu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.gbr.decorView == null) {
                this.gbr.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.rootView = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.gbr.decorView, false);
            this.rootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.gbr.backgroundId != -1) {
                this.rootView.setBackgroundColor(this.gbr.backgroundId);
            }
            this.gcs = (ViewGroup) this.rootView.findViewById(R.id.content_container);
            this.gcs.setLayoutParams(layoutParams);
        }
        lP(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void KN() {
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    public void show() {
        if (bLZ()) {
            SY();
        } else if (!isShowing()) {
            this.isShowing = true;
            cf(this.rootView);
            this.rootView.requestFocus();
        }
    }

    private void cf(View view) {
        this.gbr.decorView.addView(view);
        if (this.gcz) {
            this.gcs.startAnimation(this.inAnim);
        }
    }

    public boolean isShowing() {
        if (bLZ()) {
            return false;
        }
        return this.rootView.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (bLZ()) {
            If();
        } else if (!this.gcw) {
            if (this.gcz) {
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
                this.gcs.startAnimation(this.outAnim);
            } else {
                dismissImmediately();
            }
            this.gcw = true;
        }
    }

    public void dismissImmediately() {
        this.gbr.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.gbr.decorView.removeView(a.this.rootView);
                a.this.isShowing = false;
                a.this.gcw = false;
                if (a.this.gcv != null) {
                    a.this.gcv.aA(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.gcx, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.gcx, false));
    }

    public void lP(boolean z) {
        ViewGroup viewGroup;
        if (bLZ()) {
            viewGroup = this.gcu;
        } else {
            viewGroup = this.rootView;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.gcA);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a lQ(boolean z) {
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

    public void bLY() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.gbr.cancelable);
        }
    }

    public View findViewById(int i) {
        return this.gcs.findViewById(i);
    }

    public void atC() {
        if (this.gcu != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.gbr.cancelable);
            this.mDialog.setContentView(this.gcu);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.gcv != null) {
                        a.this.gcv.aA(a.this);
                    }
                }
            });
        }
    }

    private void SY() {
        if (this.mDialog != null) {
            this.mDialog.show();
        }
    }

    private void If() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean bLZ() {
        return false;
    }
}
