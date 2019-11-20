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
    private TextView ahx;
    private ImageView arR;
    private TextView arS;
    private TextView arT;
    private AnimatorSet arU;
    private View dMv;
    private TbImageView dOA;
    private InterfaceC0349a dOB;
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
        this.dOB = interfaceC0349a;
    }

    public void S(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dOA.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.ahx.setText("已自动退团真的不再爱了吗？");
                this.arS.setText("继续支持TA");
                this.arT.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.ahx.setText("再不努力就来不及啦！");
                this.arS.setText("去提升");
                this.arT.setText("衰减规则");
                break;
        }
        tx();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dMv || view == this.arR) {
            dismiss();
        } else if (this.dOB != null) {
            if (view == this.arS) {
                this.dOB.onConfirm();
            } else if (view == this.arT) {
                this.dOB.onCancel();
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
        this.dMv = findViewById(a.g.layout_root);
        this.arR = (ImageView) findViewById(a.g.iv_close);
        this.dOA = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.ahx = (TextView) findViewById(a.g.tv_content);
        this.arT = (TextView) findViewById(a.g.tv_cancel);
        this.arS = (TextView) findViewById(a.g.tv_confirm);
        this.dOA.setDefaultBgResource(a.d.sdk_transparent);
        this.dOA.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.arT.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.arS.setBackgroundDrawable(gradientDrawable2);
        this.dMv.setOnClickListener(this);
        this.arR.setOnClickListener(this);
        this.arS.setOnClickListener(this);
        this.arT.setOnClickListener(this);
    }

    private void pv() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.dOA != null) {
                    a.this.dOA.stopLoad();
                }
                if (a.this.arU != null) {
                    a.this.arU.cancel();
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
