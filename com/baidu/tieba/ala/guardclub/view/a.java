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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes2.dex */
public class a extends Dialog implements View.OnClickListener {
    private ImageView aAp;
    private TextView aAq;
    private TextView aAr;
    private AnimatorSet aAs;
    private View aVN;
    private TextView aqn;
    private TbImageView eDR;
    private InterfaceC0426a eDS;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0426a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0426a interfaceC0426a) {
        this.eDS = interfaceC0426a;
    }

    public void aj(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eDR.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aqn.setText("已自动退团真的不再爱了吗？");
                this.aAq.setText("继续支持TA");
                this.aAr.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aqn.setText("再不努力就来不及啦！");
                this.aAq.setText("去提升");
                this.aAr.setText("衰减规则");
                break;
        }
        vI();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aVN || view == this.aAp) {
            dismiss();
        } else if (this.eDS != null) {
            if (view == this.aAq) {
                this.eDS.onConfirm();
            } else if (view == this.aAr) {
                this.eDS.onCancel();
            }
        }
    }

    private void init() {
        initWindow();
        initView();
        re();
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
        this.aVN = findViewById(a.g.layout_root);
        this.aAp = (ImageView) findViewById(a.g.iv_close);
        this.eDR = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.aqn = (TextView) findViewById(a.g.tv_content);
        this.aAr = (TextView) findViewById(a.g.tv_cancel);
        this.aAq = (TextView) findViewById(a.g.tv_confirm);
        this.eDR.setDefaultBgResource(a.d.sdk_transparent);
        this.eDR.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.aAr.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.aAq.setBackgroundDrawable(gradientDrawable2);
        this.aVN.setOnClickListener(this);
        this.aAp.setOnClickListener(this);
        this.aAq.setOnClickListener(this);
        this.aAr.setOnClickListener(this);
    }

    private void re() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.eDR != null) {
                    a.this.eDR.stopLoad();
                }
                if (a.this.aAs != null) {
                    a.this.aAs.cancel();
                }
            }
        });
    }

    private void vI() {
        if (this.aAs == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aVN, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aVN, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.aAs = new AnimatorSet();
            this.aAs.playTogether(ofFloat, ofFloat2);
            this.aAs.setDuration(300L);
            this.aAs.setInterpolator(new LinearInterpolator());
        }
        this.aAs.start();
    }
}
