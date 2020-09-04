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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes7.dex */
public class a extends Dialog implements View.OnClickListener {
    private TextView aAy;
    private View bRg;
    private ImageView btm;
    private TextView bto;
    private TextView btp;
    private AnimatorSet btq;
    private TbImageView gde;
    private InterfaceC0606a gdf;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0606a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0606a interfaceC0606a) {
        this.gdf = interfaceC0606a;
    }

    public void aF(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gde.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aAy.setText("已自动退团真的不再爱了吗？");
                this.bto.setText("继续支持TA");
                this.btp.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aAy.setText("再不努力就来不及啦！");
                this.bto.setText("去提升");
                this.btp.setText("衰减规则");
                break;
        }
        Kl();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bRg || view == this.btm) {
            dismiss();
        } else if (this.gdf != null) {
            if (view == this.bto) {
                this.gdf.onConfirm();
            } else if (view == this.btp) {
                this.gdf.onCancel();
            }
        }
    }

    private void init() {
        Mt();
        initView();
        Ey();
    }

    private void Mt() {
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
        this.bRg = findViewById(a.g.layout_root);
        this.btm = (ImageView) findViewById(a.g.iv_close);
        this.gde = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.aAy = (TextView) findViewById(a.g.tv_content);
        this.btp = (TextView) findViewById(a.g.tv_cancel);
        this.bto = (TextView) findViewById(a.g.tv_confirm);
        this.gde.setDefaultBgResource(a.d.sdk_transparent);
        this.gde.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.btp.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.bto.setBackgroundDrawable(gradientDrawable2);
        this.bRg.setOnClickListener(this);
        this.btm.setOnClickListener(this);
        this.bto.setOnClickListener(this);
        this.btp.setOnClickListener(this);
    }

    private void Ey() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.gde != null) {
                    a.this.gde.stopLoad();
                }
                if (a.this.btq != null) {
                    a.this.btq.cancel();
                }
            }
        });
    }

    private void Kl() {
        if (this.btq == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bRg, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bRg, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.btq = new AnimatorSet();
            this.btq.playTogether(ofFloat, ofFloat2);
            this.btq.setDuration(300L);
            this.btq.setInterpolator(new LinearInterpolator());
        }
        this.btq.start();
    }
}
