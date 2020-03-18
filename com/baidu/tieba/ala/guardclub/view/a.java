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
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a extends Dialog implements View.OnClickListener {
    private ImageView aEV;
    private TextView aEW;
    private TextView aEX;
    private AnimatorSet aEY;
    private TextView aui;
    private View bao;
    private TbImageView eIl;
    private InterfaceC0437a eIm;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0437a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0437a interfaceC0437a) {
        this.eIm = interfaceC0437a;
    }

    public void ak(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eIl.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aui.setText("已自动退团真的不再爱了吗？");
                this.aEW.setText("继续支持TA");
                this.aEX.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aui.setText("再不努力就来不及啦！");
                this.aEW.setText("去提升");
                this.aEX.setText("衰减规则");
                break;
        }
        xL();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bao || view == this.aEV) {
            dismiss();
        } else if (this.eIm != null) {
            if (view == this.aEW) {
                this.eIm.onConfirm();
            } else if (view == this.aEX) {
                this.eIm.onCancel();
            }
        }
    }

    private void init() {
        initWindow();
        initView();
        sk();
    }

    private void initWindow() {
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
        this.bao = findViewById(a.g.layout_root);
        this.aEV = (ImageView) findViewById(a.g.iv_close);
        this.eIl = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.aui = (TextView) findViewById(a.g.tv_content);
        this.aEX = (TextView) findViewById(a.g.tv_cancel);
        this.aEW = (TextView) findViewById(a.g.tv_confirm);
        this.eIl.setDefaultBgResource(a.d.sdk_transparent);
        this.eIl.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.aEX.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.aEW.setBackgroundDrawable(gradientDrawable2);
        this.bao.setOnClickListener(this);
        this.aEV.setOnClickListener(this);
        this.aEW.setOnClickListener(this);
        this.aEX.setOnClickListener(this);
    }

    private void sk() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.eIl != null) {
                    a.this.eIl.stopLoad();
                }
                if (a.this.aEY != null) {
                    a.this.aEY.cancel();
                }
            }
        });
    }

    private void xL() {
        if (this.aEY == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bao, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bao, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.aEY = new AnimatorSet();
            this.aEY.playTogether(ofFloat, ofFloat2);
            this.aEY.setDuration(300L);
            this.aEY.setInterpolator(new LinearInterpolator());
        }
        this.aEY.start();
    }
}
