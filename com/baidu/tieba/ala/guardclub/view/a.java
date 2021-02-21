package com.baidu.tieba.ala.guardclub.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes11.dex */
public class a extends Dialog implements View.OnClickListener {
    private TextView aDt;
    private TextView bTm;
    private TextView bTn;
    private AnimatorSet bTp;
    private ImageView beC;
    private View cBE;
    private TbImageView hbs;
    private InterfaceC0636a hbt;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0636a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.i.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0636a interfaceC0636a) {
        this.hbt = interfaceC0636a;
    }

    public void ad(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hbs.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aDt.setText("已自动退团真的不再爱了吗？");
                this.bTm.setText("继续支持TA");
                this.bTn.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aDt.setText("再不努力就来不及啦！");
                this.bTm.setText("去提升");
                this.bTn.setText("衰减规则");
                break;
        }
        LN();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cBE || view == this.beC) {
            dismiss();
        } else if (this.hbt != null) {
            if (view == this.bTm) {
                this.hbt.onConfirm();
            } else if (view == this.bTn) {
                this.hbt.onCancel();
            }
        }
    }

    private void init() {
        Hf();
        initView();
        ED();
    }

    private void Hf() {
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
        setContentView(a.g.live_guard_club_attenuat);
        this.cBE = findViewById(a.f.layout_root);
        this.beC = (ImageView) findViewById(a.f.iv_close);
        this.hbs = (TbImageView) findViewById(a.f.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.f.tv_title);
        this.aDt = (TextView) findViewById(a.f.tv_content);
        this.bTn = (TextView) findViewById(a.f.tv_cancel);
        this.bTm = (TextView) findViewById(a.f.tv_confirm);
        this.hbs.setDefaultBgResource(a.c.sdk_transparent);
        this.hbs.setDefaultErrorResource(a.e.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds1), -56990);
        this.bTn.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds40));
        this.bTm.setBackgroundDrawable(gradientDrawable2);
        this.cBE.setOnClickListener(this);
        this.beC.setOnClickListener(this);
        this.bTm.setOnClickListener(this);
        this.bTn.setOnClickListener(this);
    }

    private void ED() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.hbs != null) {
                    a.this.hbs.stopLoad();
                }
                if (a.this.bTp != null) {
                    a.this.bTp.cancel();
                }
            }
        });
    }

    private void LN() {
        if (this.bTp == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cBE, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cBE, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bTp = new AnimatorSet();
            this.bTp.playTogether(ofFloat, ofFloat2);
            this.bTp.setDuration(300L);
            this.bTp.setInterpolator(new LinearInterpolator());
        }
        this.bTp.start();
    }
}
