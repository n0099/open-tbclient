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
    private TextView aAw;
    private View bRc;
    private ImageView btj;
    private TextView btk;
    private TextView btl;
    private AnimatorSet btm;
    private TbImageView gda;
    private InterfaceC0606a gdb;
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
        this.gdb = interfaceC0606a;
    }

    public void aG(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gda.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aAw.setText("已自动退团真的不再爱了吗？");
                this.btk.setText("继续支持TA");
                this.btl.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aAw.setText("再不努力就来不及啦！");
                this.btk.setText("去提升");
                this.btl.setText("衰减规则");
                break;
        }
        Kl();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bRc || view == this.btj) {
            dismiss();
        } else if (this.gdb != null) {
            if (view == this.btk) {
                this.gdb.onConfirm();
            } else if (view == this.btl) {
                this.gdb.onCancel();
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
        this.bRc = findViewById(a.g.layout_root);
        this.btj = (ImageView) findViewById(a.g.iv_close);
        this.gda = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.aAw = (TextView) findViewById(a.g.tv_content);
        this.btl = (TextView) findViewById(a.g.tv_cancel);
        this.btk = (TextView) findViewById(a.g.tv_confirm);
        this.gda.setDefaultBgResource(a.d.sdk_transparent);
        this.gda.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.btl.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.btk.setBackgroundDrawable(gradientDrawable2);
        this.bRc.setOnClickListener(this);
        this.btj.setOnClickListener(this);
        this.btk.setOnClickListener(this);
        this.btl.setOnClickListener(this);
    }

    private void Ey() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.gda != null) {
                    a.this.gda.stopLoad();
                }
                if (a.this.btm != null) {
                    a.this.btm.cancel();
                }
            }
        });
    }

    private void Kl() {
        if (this.btm == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bRc, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bRc, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.btm = new AnimatorSet();
            this.btm.playTogether(ofFloat, ofFloat2);
            this.btm.setDuration(300L);
            this.btm.setInterpolator(new LinearInterpolator());
        }
        this.btm.start();
    }
}
