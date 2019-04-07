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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private ViewGroup TG;
    protected com.baidu.tbadk.widget.timepicker.a.c.a cEs;
    private com.baidu.tbadk.widget.timepicker.a.d.c cFA;
    private boolean cFB;
    private Animation cFC;
    private Animation cFD;
    protected View cFF;
    protected ViewGroup cFy;
    private ViewGroup cFz;
    private Context context;
    private boolean isShowing;
    private Dialog mDialog;
    protected int cFE = 80;
    private boolean cFG = true;
    private View.OnKeyListener cFH = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener cFI = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
        if (atw()) {
            this.cFz = (ViewGroup) from.inflate(d.h.layout_basepickerview, (ViewGroup) null, false);
            this.cFz.setBackgroundColor(0);
            this.cFy = (ViewGroup) this.cFz.findViewById(d.g.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.cFy.setLayoutParams(layoutParams);
            zm();
            this.cFz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.cEs.decorView == null) {
                this.cEs.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.TG = (ViewGroup) from.inflate(d.h.layout_basepickerview, this.cEs.decorView, false);
            this.TG.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.cEs.cog != -1) {
                this.TG.setBackgroundColor(this.cEs.cog);
            }
            this.cFy = (ViewGroup) this.TG.findViewById(d.g.content_container);
            this.cFy.setLayoutParams(layoutParams);
        }
        fw(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAnim() {
        this.cFD = getInAnimation();
        this.cFC = getOutAnimation();
    }

    public void show() {
        if (atw()) {
            showDialog();
        } else if (!isShowing()) {
            this.isShowing = true;
            bd(this.TG);
            this.TG.requestFocus();
        }
    }

    private void bd(View view) {
        this.cEs.decorView.addView(view);
        if (this.cFG) {
            this.cFy.startAnimation(this.cFD);
        }
    }

    public boolean isShowing() {
        if (atw()) {
            return false;
        }
        return this.TG.getParent() != null || this.isShowing;
    }

    public void dismiss() {
        if (atw()) {
            atv();
        } else if (!this.cFB) {
            if (this.cFG) {
                this.cFC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.att();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.cFy.startAnimation(this.cFC);
            } else {
                att();
            }
            this.cFB = true;
        }
    }

    public void att() {
        this.cEs.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.cEs.decorView.removeView(a.this.TG);
                a.this.isShowing = false;
                a.this.cFB = false;
                if (a.this.cFA != null) {
                    a.this.cFA.af(a.this);
                }
            }
        });
    }

    private Animation getInAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.o(this.cFE, true));
    }

    private Animation getOutAnimation() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.o(this.cFE, false));
    }

    public void fw(boolean z) {
        ViewGroup viewGroup;
        if (atw()) {
            viewGroup = this.cFz;
        } else {
            viewGroup = this.TG;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.cFH);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a fx(boolean z) {
        if (this.TG != null) {
            View findViewById = this.TG.findViewById(d.g.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.cFI);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void atu() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.cEs.cFk);
        }
    }

    public View findViewById(int i) {
        return this.cFy.findViewById(i);
    }

    public void zm() {
        if (this.cFz != null) {
            this.mDialog = new Dialog(this.context, d.k.custom_dialog2);
            this.mDialog.setCancelable(this.cEs.cFk);
            this.mDialog.setContentView(this.cFz);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(d.k.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.cFA != null) {
                        a.this.cFA.af(a.this);
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

    private void atv() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean atw() {
        return false;
    }
}
