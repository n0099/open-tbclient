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
    private TextView aNH;
    private ImageView baC;
    private TextView baD;
    private TextView baE;
    private AnimatorSet baF;
    private View byO;
    private TbImageView fmC;
    private InterfaceC0472a fmD;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0472a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0472a interfaceC0472a) {
        this.fmD = interfaceC0472a;
    }

    public void az(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fmC.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aNH.setText("已自动退团真的不再爱了吗？");
                this.baD.setText("继续支持TA");
                this.baE.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aNH.setText("再不努力就来不及啦！");
                this.baD.setText("去提升");
                this.baE.setText("衰减规则");
                break;
        }
        CB();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.byO || view == this.baC) {
            dismiss();
        } else if (this.fmD != null) {
            if (view == this.baD) {
                this.fmD.onConfirm();
            } else if (view == this.baE) {
                this.fmD.onCancel();
            }
        }
    }

    private void init() {
        Di();
        initView();
        wD();
    }

    private void Di() {
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
        this.byO = findViewById(a.g.layout_root);
        this.baC = (ImageView) findViewById(a.g.iv_close);
        this.fmC = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.aNH = (TextView) findViewById(a.g.tv_content);
        this.baE = (TextView) findViewById(a.g.tv_cancel);
        this.baD = (TextView) findViewById(a.g.tv_confirm);
        this.fmC.setDefaultBgResource(a.d.sdk_transparent);
        this.fmC.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.baE.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.baD.setBackgroundDrawable(gradientDrawable2);
        this.byO.setOnClickListener(this);
        this.baC.setOnClickListener(this);
        this.baD.setOnClickListener(this);
        this.baE.setOnClickListener(this);
    }

    private void wD() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.fmC != null) {
                    a.this.fmC.stopLoad();
                }
                if (a.this.baF != null) {
                    a.this.baF.cancel();
                }
            }
        });
    }

    private void CB() {
        if (this.baF == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.byO, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.byO, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.baF = new AnimatorSet();
            this.baF.playTogether(ofFloat, ofFloat2);
            this.baF.setDuration(300L);
            this.baF.setInterpolator(new LinearInterpolator());
        }
        this.baF.start();
    }
}
