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
/* loaded from: classes3.dex */
public class a extends Dialog implements View.OnClickListener {
    private TextView aWB;
    private View bLk;
    private ImageView bnl;
    private TextView bnm;
    private TextView bnn;
    private AnimatorSet bno;
    private TbImageView fLI;
    private InterfaceC0548a fLJ;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0548a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0548a interfaceC0548a) {
        this.fLJ = interfaceC0548a;
    }

    public void aG(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fLI.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aWB.setText("已自动退团真的不再爱了吗？");
                this.bnm.setText("继续支持TA");
                this.bnn.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aWB.setText("再不努力就来不及啦！");
                this.bnm.setText("去提升");
                this.bnn.setText("衰减规则");
                break;
        }
        Ez();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bLk || view == this.bnl) {
            dismiss();
        } else if (this.fLJ != null) {
            if (view == this.bnm) {
                this.fLJ.onConfirm();
            } else if (view == this.bnn) {
                this.fLJ.onCancel();
            }
        }
    }

    private void init() {
        Fj();
        initView();
        yt();
    }

    private void Fj() {
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
        this.bLk = findViewById(a.g.layout_root);
        this.bnl = (ImageView) findViewById(a.g.iv_close);
        this.fLI = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.aWB = (TextView) findViewById(a.g.tv_content);
        this.bnn = (TextView) findViewById(a.g.tv_cancel);
        this.bnm = (TextView) findViewById(a.g.tv_confirm);
        this.fLI.setDefaultBgResource(a.d.sdk_transparent);
        this.fLI.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.bnn.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.bnm.setBackgroundDrawable(gradientDrawable2);
        this.bLk.setOnClickListener(this);
        this.bnl.setOnClickListener(this);
        this.bnm.setOnClickListener(this);
        this.bnn.setOnClickListener(this);
    }

    private void yt() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.fLI != null) {
                    a.this.fLI.stopLoad();
                }
                if (a.this.bno != null) {
                    a.this.bno.cancel();
                }
            }
        });
    }

    private void Ez() {
        if (this.bno == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bLk, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bLk, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bno = new AnimatorSet();
            this.bno.playTogether(ofFloat, ofFloat2);
            this.bno.setDuration(300L);
            this.bno.setInterpolator(new LinearInterpolator());
        }
        this.bno.start();
    }
}
