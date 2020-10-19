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
/* loaded from: classes4.dex */
public class a extends Dialog implements View.OnClickListener {
    private TextView aEj;
    private ImageView bDg;
    private TextView bDh;
    private TextView bDi;
    private AnimatorSet bDj;
    private View cfu;
    private TbImageView gsF;
    private InterfaceC0619a gsG;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0619a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0619a interfaceC0619a) {
        this.gsG = interfaceC0619a;
    }

    public void Q(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gsF.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aEj.setText("已自动退团真的不再爱了吗？");
                this.bDh.setText("继续支持TA");
                this.bDi.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aEj.setText("再不努力就来不及啦！");
                this.bDh.setText("去提升");
                this.bDi.setText("衰减规则");
                break;
        }
        LX();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cfu || view == this.bDg) {
            dismiss();
        } else if (this.gsG != null) {
            if (view == this.bDh) {
                this.gsG.onConfirm();
            } else if (view == this.bDi) {
                this.gsG.onCancel();
            }
        }
    }

    private void init() {
        Og();
        initView();
        FL();
    }

    private void Og() {
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
        this.cfu = findViewById(a.g.layout_root);
        this.bDg = (ImageView) findViewById(a.g.iv_close);
        this.gsF = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.aEj = (TextView) findViewById(a.g.tv_content);
        this.bDi = (TextView) findViewById(a.g.tv_cancel);
        this.bDh = (TextView) findViewById(a.g.tv_confirm);
        this.gsF.setDefaultBgResource(a.d.sdk_transparent);
        this.gsF.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.bDi.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.bDh.setBackgroundDrawable(gradientDrawable2);
        this.cfu.setOnClickListener(this);
        this.bDg.setOnClickListener(this);
        this.bDh.setOnClickListener(this);
        this.bDi.setOnClickListener(this);
    }

    private void FL() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.gsF != null) {
                    a.this.gsF.stopLoad();
                }
                if (a.this.bDj != null) {
                    a.this.bDj.cancel();
                }
            }
        });
    }

    private void LX() {
        if (this.bDj == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cfu, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cfu, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bDj = new AnimatorSet();
            this.bDj.playTogether(ofFloat, ofFloat2);
            this.bDj.setDuration(300L);
            this.bDj.setInterpolator(new LinearInterpolator());
        }
        this.bDj.start();
    }
}
