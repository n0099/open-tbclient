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
    private TextView ask;
    private TextView asl;
    private AnimatorSet asm;
    private View dNm;
    private a dNn;

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
        this.dNn = aVar;
    }

    @Override // android.app.Dialog
    public void show() {
        tw();
        super.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dNm) {
            if (this.dNn != null) {
                this.dNn.onCancel();
            }
        } else if (this.dNn != null) {
            if (view == this.ask) {
                this.dNn.onConfirm();
            } else if (view == this.asl) {
                this.dNn.onCancel();
            }
        }
    }

    private void init() {
        wC();
        initView();
        pv();
    }

    private void wC() {
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
        this.dNm = findViewById(a.g.layout_root);
        this.ask = (TextView) findViewById(a.g.tv_confirm);
        this.asl = (TextView) findViewById(a.g.tv_cancel);
        this.dNm.setOnClickListener(this);
        this.ask.setOnClickListener(this);
        this.asl.setOnClickListener(this);
    }

    private void pv() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.k.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (k.this.asm != null) {
                    k.this.asm.cancel();
                }
            }
        });
    }

    private void tw() {
        if (this.asm == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dNm, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dNm, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.asm = new AnimatorSet();
            this.asm.playTogether(ofFloat, ofFloat2);
            this.asm.setDuration(300L);
            this.asm.setInterpolator(new LinearInterpolator());
        }
        this.asm.start();
    }
}
