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
    private TextView aNN;
    private ImageView baH;
    private TextView baI;
    private TextView baJ;
    private AnimatorSet baK;
    private View byT;
    private TbImageView fmH;
    private InterfaceC0493a fmI;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0493a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0493a interfaceC0493a) {
        this.fmI = interfaceC0493a;
    }

    public void az(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fmH.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aNN.setText("已自动退团真的不再爱了吗？");
                this.baI.setText("继续支持TA");
                this.baJ.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aNN.setText("再不努力就来不及啦！");
                this.baI.setText("去提升");
                this.baJ.setText("衰减规则");
                break;
        }
        CA();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.byT || view == this.baH) {
            dismiss();
        } else if (this.fmI != null) {
            if (view == this.baI) {
                this.fmI.onConfirm();
            } else if (view == this.baJ) {
                this.fmI.onCancel();
            }
        }
    }

    private void init() {
        Dh();
        initView();
        wC();
    }

    private void Dh() {
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
        this.byT = findViewById(a.g.layout_root);
        this.baH = (ImageView) findViewById(a.g.iv_close);
        this.fmH = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.aNN = (TextView) findViewById(a.g.tv_content);
        this.baJ = (TextView) findViewById(a.g.tv_cancel);
        this.baI = (TextView) findViewById(a.g.tv_confirm);
        this.fmH.setDefaultBgResource(a.d.sdk_transparent);
        this.fmH.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.baJ.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.baI.setBackgroundDrawable(gradientDrawable2);
        this.byT.setOnClickListener(this);
        this.baH.setOnClickListener(this);
        this.baI.setOnClickListener(this);
        this.baJ.setOnClickListener(this);
    }

    private void wC() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.fmH != null) {
                    a.this.fmH.stopLoad();
                }
                if (a.this.baK != null) {
                    a.this.baK.cancel();
                }
            }
        });
    }

    private void CA() {
        if (this.baK == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.byT, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.byT, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.baK = new AnimatorSet();
            this.baK.playTogether(ofFloat, ofFloat2);
            this.baK.setDuration(300L);
            this.baK.setInterpolator(new LinearInterpolator());
        }
        this.baK.start();
    }
}
