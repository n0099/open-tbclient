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
    private TextView aTU;
    private View bGw;
    private ImageView bif;
    private TextView bih;
    private TextView bii;
    private AnimatorSet bij;
    private InterfaceC0540a fAA;
    private TbImageView fAz;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0540a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0540a interfaceC0540a) {
        this.fAA = interfaceC0540a;
    }

    public void aE(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fAz.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aTU.setText("已自动退团真的不再爱了吗？");
                this.bih.setText("继续支持TA");
                this.bii.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aTU.setText("再不努力就来不及啦！");
                this.bih.setText("去提升");
                this.bii.setText("衰减规则");
                break;
        }
        DX();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bGw || view == this.bif) {
            dismiss();
        } else if (this.fAA != null) {
            if (view == this.bih) {
                this.fAA.onConfirm();
            } else if (view == this.bii) {
                this.fAA.onCancel();
            }
        }
    }

    private void init() {
        EF();
        initView();
        xT();
    }

    private void EF() {
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
        this.bGw = findViewById(a.g.layout_root);
        this.bif = (ImageView) findViewById(a.g.iv_close);
        this.fAz = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.aTU = (TextView) findViewById(a.g.tv_content);
        this.bii = (TextView) findViewById(a.g.tv_cancel);
        this.bih = (TextView) findViewById(a.g.tv_confirm);
        this.fAz.setDefaultBgResource(a.d.sdk_transparent);
        this.fAz.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.bii.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.bih.setBackgroundDrawable(gradientDrawable2);
        this.bGw.setOnClickListener(this);
        this.bif.setOnClickListener(this);
        this.bih.setOnClickListener(this);
        this.bii.setOnClickListener(this);
    }

    private void xT() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.fAz != null) {
                    a.this.fAz.stopLoad();
                }
                if (a.this.bij != null) {
                    a.this.bij.cancel();
                }
            }
        });
    }

    private void DX() {
        if (this.bij == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bGw, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bGw, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bij = new AnimatorSet();
            this.bij.playTogether(ofFloat, ofFloat2);
            this.bij.setDuration(300L);
            this.bij.setInterpolator(new LinearInterpolator());
        }
        this.bij.start();
    }
}
