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
/* loaded from: classes8.dex */
public class a {
    private Context context;
    protected com.baidu.tbadk.widget.timepicker.a.c.a dQZ;
    protected ViewGroup dSc;
    private ViewGroup dSd;
    private com.baidu.tbadk.widget.timepicker.a.d.c dSe;
    private boolean dSf;
    protected View dSh;
    private Animation inAnim;
    private boolean isShowing;
    private Dialog mDialog;
    private Animation outAnim;
    private ViewGroup rootView;
    protected int dSg = 80;
    private boolean dSi = true;
    private View.OnKeyListener dSj = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
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
        if (aUZ()) {
            this.dSd = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.dSd.setBackgroundColor(0);
            this.dSc = (ViewGroup) this.dSd.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.dSc.setLayoutParams(layoutParams);
            Pb();
            this.dSd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.dQZ.decorView == null) {
                this.dQZ.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.rootView = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.dQZ.decorView, false);
            this.rootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.dQZ.backgroundId != -1) {
                this.rootView.setBackgroundColor(this.dQZ.backgroundId);
            }
            this.dSc = (ViewGroup) this.rootView.findViewById(R.id.content_container);
            this.dSc.setLayoutParams(layoutParams);
        }
        hr(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vm() {
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    public void show() {
        if (aUZ()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            bm(this.rootView);
            this.rootView.requestFocus();
        }
    }

    private void bm(View view) {
        this.dQZ.decorView.addView(view);
        if (this.dSi) {
            this.dSc.startAnimation(this.inAnim);
        }
    }

    public boolean isShowing() {
        if (aUZ()) {
            return false;
        }
        return this.rootView.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (aUZ()) {
            sS();
        } else if (!this.dSf) {
            if (this.dSi) {
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
                this.dSc.startAnimation(this.outAnim);
            } else {
                dismissImmediately();
            }
            this.dSf = true;
        }
    }

    public void dismissImmediately() {
        this.dQZ.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.dQZ.decorView.removeView(a.this.rootView);
                a.this.isShowing = false;
                a.this.dSf = false;
                if (a.this.dSe != null) {
                    a.this.dSe.am(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.dSg, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.getAnimationResource(this.dSg, false));
    }

    public void hr(boolean z) {
        ViewGroup viewGroup;
        if (aUZ()) {
            viewGroup = this.dSd;
        } else {
            viewGroup = this.rootView;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.dSj);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a hs(boolean z) {
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

    public void aUY() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.dQZ.dRP);
        }
    }

    public View findViewById(int i) {
        return this.dSc.findViewById(i);
    }

    public void Pb() {
        if (this.dSd != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.dQZ.dRP);
            this.mDialog.setContentView(this.dSd);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.dSe != null) {
                        a.this.dSe.am(a.this);
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

    private void sS() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean aUZ() {
        return false;
    }
}
