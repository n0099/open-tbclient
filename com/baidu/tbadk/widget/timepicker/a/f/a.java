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
    private ViewGroup Bg;
    private boolean abS;
    protected com.baidu.tbadk.widget.timepicker.a.c.a cYm;
    protected View cZB;
    protected ViewGroup cZu;
    private ViewGroup cZv;
    private com.baidu.tbadk.widget.timepicker.a.d.c cZw;
    private boolean cZx;
    private Animation cZy;
    private Animation cZz;
    private Context context;
    private Dialog mDialog;
    protected int cZA = 80;
    private boolean cZC = true;
    private View.OnKeyListener cZD = new View.OnKeyListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.4
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && a.this.isShowing()) {
                a.this.dismiss();
                return true;
            }
            return false;
        }
    };
    private final View.OnTouchListener cZE = new View.OnTouchListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.5
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
        if (aAn()) {
            this.cZv = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.cZv.setBackgroundColor(0);
            this.cZu = (ViewGroup) this.cZv.findViewById(R.id.content_container);
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            this.cZu.setLayoutParams(layoutParams);
            FS();
            this.cZv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dismiss();
                }
            });
        } else {
            if (this.cYm.decorView == null) {
                this.cYm.decorView = (ViewGroup) ((Activity) this.context).getWindow().getDecorView();
            }
            this.Bg = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.cYm.decorView, false);
            this.Bg.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            if (this.cYm.backgroundId != -1) {
                this.Bg.setBackgroundColor(this.cYm.backgroundId);
            }
            this.cZu = (ViewGroup) this.Bg.findViewById(R.id.content_container);
            this.cZu.setLayoutParams(layoutParams);
        }
        fP(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rJ() {
        this.cZz = aAj();
        this.cZy = aAk();
    }

    public void show() {
        if (aAn()) {
            showDialog();
        } else if (!isShowing()) {
            this.abS = true;
            bl(this.Bg);
            this.Bg.requestFocus();
        }
    }

    private void bl(View view) {
        this.cYm.decorView.addView(view);
        if (this.cZC) {
            this.cZu.startAnimation(this.cZz);
        }
    }

    public boolean isShowing() {
        if (aAn()) {
            return false;
        }
        return this.Bg.getParent() != null || this.abS;
    }

    public void dismiss() {
        if (aAn()) {
            aAm();
        } else if (!this.cZx) {
            if (this.cZC) {
                this.cZy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.aAi();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                this.cZu.startAnimation(this.cZy);
            } else {
                aAi();
            }
            this.cZx = true;
        }
    }

    public void aAi() {
        this.cYm.decorView.post(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.cYm.decorView.removeView(a.this.Bg);
                a.this.abS = false;
                a.this.cZx = false;
                if (a.this.cZw != null) {
                    a.this.cZw.ad(a.this);
                }
            }
        });
    }

    private Animation aAj() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.w(this.cZA, true));
    }

    private Animation aAk() {
        return AnimationUtils.loadAnimation(this.context, com.baidu.tbadk.widget.timepicker.a.e.c.w(this.cZA, false));
    }

    public void fP(boolean z) {
        ViewGroup viewGroup;
        if (aAn()) {
            viewGroup = this.cZv;
        } else {
            viewGroup = this.Bg;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.cZD);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a fQ(boolean z) {
        if (this.Bg != null) {
            View findViewById = this.Bg.findViewById(R.id.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.cZE);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void aAl() {
        if (this.mDialog != null) {
            this.mDialog.setCancelable(this.cYm.cZg);
        }
    }

    public View findViewById(int i) {
        return this.cZu.findViewById(i);
    }

    public void FS() {
        if (this.cZv != null) {
            this.mDialog = new Dialog(this.context, R.style.custom_dialog2);
            this.mDialog.setCancelable(this.cYm.cZg);
            this.mDialog.setContentView(this.cZv);
            Window window = this.mDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tbadk.widget.timepicker.a.f.a.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.cZw != null) {
                        a.this.cZw.ad(a.this);
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

    private void aAm() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean aAn() {
        return false;
    }
}
