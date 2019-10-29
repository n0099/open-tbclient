package com.baidu.tieba.ala.guardclub.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes6.dex */
public class a extends Dialog implements View.OnClickListener {
    private TextView ahP;
    private ImageView asj;
    private TextView ask;
    private TextView asl;
    private AnimatorSet asm;
    private View dNm;
    private TbImageView dPr;
    private InterfaceC0349a dPs;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0349a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0349a interfaceC0349a) {
        this.dPs = interfaceC0349a;
    }

    public void T(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dPr.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.ahP.setText("已自动退团真的不再爱了吗？");
                this.ask.setText("继续支持TA");
                this.asl.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.ahP.setText("再不努力就来不及啦！");
                this.ask.setText("去提升");
                this.asl.setText("衰减规则");
                break;
        }
        tw();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dNm || view == this.asj) {
            dismiss();
        } else if (this.dPs != null) {
            if (view == this.ask) {
                this.dPs.onConfirm();
            } else if (view == this.asl) {
                this.dPs.onCancel();
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
            window.setGravity(17);
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
        setContentView(a.h.live_guard_club_attenuat);
        this.dNm = findViewById(a.g.layout_root);
        this.asj = (ImageView) findViewById(a.g.iv_close);
        this.dPr = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.ahP = (TextView) findViewById(a.g.tv_content);
        this.asl = (TextView) findViewById(a.g.tv_cancel);
        this.ask = (TextView) findViewById(a.g.tv_confirm);
        this.dPr.setDefaultBgResource(a.d.sdk_transparent);
        this.dPr.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.asl.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.ask.setBackgroundDrawable(gradientDrawable2);
        this.dNm.setOnClickListener(this);
        this.asj.setOnClickListener(this);
        this.ask.setOnClickListener(this);
        this.asl.setOnClickListener(this);
    }

    private void pv() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.dPr != null) {
                    a.this.dPr.stopLoad();
                }
                if (a.this.asm != null) {
                    a.this.asm.cancel();
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
