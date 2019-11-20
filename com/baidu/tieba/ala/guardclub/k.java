package com.baidu.tieba.ala.guardclub;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class k extends Dialog implements View.OnClickListener {
    private TextView arS;
    private TextView arT;
    private AnimatorSet arU;
    private View dMv;
    private a dMw;

    /* loaded from: classes6.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public k(@NonNull Context context) {
        super(context);
        init();
    }

    public void a(a aVar) {
        this.dMw = aVar;
    }

    @Override // android.app.Dialog
    public void show() {
        tx();
        super.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dMv) {
            if (this.dMw != null) {
                this.dMw.onCancel();
            }
        } else if (this.dMw != null) {
            if (view == this.arS) {
                this.dMw.onConfirm();
            } else if (view == this.arT) {
                this.dMw.onCancel();
            }
        }
    }

    private void init() {
        wD();
        initView();
        pv();
    }

    private void wD() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            if (windowManager != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = displayMetrics.widthPixels;
                attributes.height = displayMetrics.heightPixels;
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        setContentView(a.h.guard_club_exit_pop);
        this.dMv = findViewById(a.g.layout_root);
        this.arS = (TextView) findViewById(a.g.tv_confirm);
        this.arT = (TextView) findViewById(a.g.tv_cancel);
        this.dMv.setOnClickListener(this);
        this.arS.setOnClickListener(this);
        this.arT.setOnClickListener(this);
    }

    private void pv() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.k.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (k.this.arU != null) {
                    k.this.arU.cancel();
                }
            }
        });
    }

    private void tx() {
        if (this.arU == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dMv, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dMv, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.arU = new AnimatorSet();
            this.arU.playTogether(ofFloat, ofFloat2);
            this.arU.setDuration(300L);
            this.arU.setInterpolator(new LinearInterpolator());
        }
        this.arU.start();
    }
}
