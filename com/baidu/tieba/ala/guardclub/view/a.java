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
    private ImageView aEH;
    private TextView aEI;
    private TextView aEJ;
    private AnimatorSet aEK;
    private TextView atY;
    private View bab;
    private TbImageView eHP;
    private InterfaceC0437a eHQ;
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
        this.eHQ = interfaceC0437a;
    }

    public void ak(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eHP.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.atY.setText("已自动退团真的不再爱了吗？");
                this.aEI.setText("继续支持TA");
                this.aEJ.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.atY.setText("再不努力就来不及啦！");
                this.aEI.setText("去提升");
                this.aEJ.setText("衰减规则");
                break;
        }
        xG();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bab || view == this.aEH) {
            dismiss();
        } else if (this.eHQ != null) {
            if (view == this.aEI) {
                this.eHQ.onConfirm();
            } else if (view == this.aEJ) {
                this.eHQ.onCancel();
            }
        }
    }

    private void init() {
        initWindow();
        initView();
        sf();
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
        this.bab = findViewById(a.g.layout_root);
        this.aEH = (ImageView) findViewById(a.g.iv_close);
        this.eHP = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.atY = (TextView) findViewById(a.g.tv_content);
        this.aEJ = (TextView) findViewById(a.g.tv_cancel);
        this.aEI = (TextView) findViewById(a.g.tv_confirm);
        this.eHP.setDefaultBgResource(a.d.sdk_transparent);
        this.eHP.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.aEJ.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.aEI.setBackgroundDrawable(gradientDrawable2);
        this.bab.setOnClickListener(this);
        this.aEH.setOnClickListener(this);
        this.aEI.setOnClickListener(this);
        this.aEJ.setOnClickListener(this);
    }

    private void sf() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.eHP != null) {
                    a.this.eHP.stopLoad();
                }
                if (a.this.aEK != null) {
                    a.this.aEK.cancel();
                }
            }
        });
    }

    private void xG() {
        if (this.aEK == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bab, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bab, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.aEK = new AnimatorSet();
            this.aEK.playTogether(ofFloat, ofFloat2);
            this.aEK.setDuration(300L);
            this.aEK.setInterpolator(new LinearInterpolator());
        }
        this.aEK.start();
    }
}
