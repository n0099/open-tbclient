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
/* loaded from: classes10.dex */
public class a extends Dialog implements View.OnClickListener {
    private TextView aBG;
    private TextView bPw;
    private TextView bPx;
    private AnimatorSet bPz;
    private ImageView bbv;
    private View czi;
    private TbImageView gYu;
    private InterfaceC0635a gYv;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0635a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.i.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0635a interfaceC0635a) {
        this.gYv = interfaceC0635a;
    }

    public void Z(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gYu.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aBG.setText("已自动退团真的不再爱了吗？");
                this.bPw.setText("继续支持TA");
                this.bPx.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aBG.setText("再不努力就来不及啦！");
                this.bPw.setText("去提升");
                this.bPx.setText("衰减规则");
                break;
        }
        Ko();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.czi || view == this.bbv) {
            dismiss();
        } else if (this.gYv != null) {
            if (view == this.bPw) {
                this.gYv.onConfirm();
            } else if (view == this.bPx) {
                this.gYv.onCancel();
            }
        }
    }

    private void init() {
        FP();
        initView();
        Dn();
    }

    private void FP() {
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
        this.czi = findViewById(a.f.layout_root);
        this.bbv = (ImageView) findViewById(a.f.iv_close);
        this.gYu = (TbImageView) findViewById(a.f.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.f.tv_title);
        this.aBG = (TextView) findViewById(a.f.tv_content);
        this.bPx = (TextView) findViewById(a.f.tv_cancel);
        this.bPw = (TextView) findViewById(a.f.tv_confirm);
        this.gYu.setDefaultBgResource(a.c.sdk_transparent);
        this.gYu.setDefaultErrorResource(a.e.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds1), -56990);
        this.bPx.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds40));
        this.bPw.setBackgroundDrawable(gradientDrawable2);
        this.czi.setOnClickListener(this);
        this.bbv.setOnClickListener(this);
        this.bPw.setOnClickListener(this);
        this.bPx.setOnClickListener(this);
    }

    private void Dn() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.gYu != null) {
                    a.this.gYu.stopLoad();
                }
                if (a.this.bPz != null) {
                    a.this.bPz.cancel();
                }
            }
        });
    }

    private void Ko() {
        if (this.bPz == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.czi, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.czi, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bPz = new AnimatorSet();
            this.bPz.playTogether(ofFloat, ofFloat2);
            this.bPz.setDuration(300L);
            this.bPz.setInterpolator(new LinearInterpolator());
        }
        this.bPz.start();
    }
}
