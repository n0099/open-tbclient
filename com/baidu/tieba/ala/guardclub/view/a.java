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
    private TextView aEr;
    private ImageView bGc;
    private TextView bGd;
    private TextView bGe;
    private AnimatorSet bGf;
    private View cnT;
    private TbImageView gCJ;
    private InterfaceC0635a gCK;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0635a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0635a interfaceC0635a) {
        this.gCK = interfaceC0635a;
    }

    public void S(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gCJ.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aEr.setText("已自动退团真的不再爱了吗？");
                this.bGd.setText("继续支持TA");
                this.bGe.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aEr.setText("再不努力就来不及啦！");
                this.bGd.setText("去提升");
                this.bGe.setText("衰减规则");
                break;
        }
        Mr();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cnT || view == this.bGc) {
            dismiss();
        } else if (this.gCK != null) {
            if (view == this.bGd) {
                this.gCK.onConfirm();
            } else if (view == this.bGe) {
                this.gCK.onCancel();
            }
        }
    }

    private void init() {
        OE();
        initView();
        Ga();
    }

    private void OE() {
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
        this.cnT = findViewById(a.g.layout_root);
        this.bGc = (ImageView) findViewById(a.g.iv_close);
        this.gCJ = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.aEr = (TextView) findViewById(a.g.tv_content);
        this.bGe = (TextView) findViewById(a.g.tv_cancel);
        this.bGd = (TextView) findViewById(a.g.tv_confirm);
        this.gCJ.setDefaultBgResource(a.d.sdk_transparent);
        this.gCJ.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.bGe.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.bGd.setBackgroundDrawable(gradientDrawable2);
        this.cnT.setOnClickListener(this);
        this.bGc.setOnClickListener(this);
        this.bGd.setOnClickListener(this);
        this.bGe.setOnClickListener(this);
    }

    private void Ga() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.gCJ != null) {
                    a.this.gCJ.stopLoad();
                }
                if (a.this.bGf != null) {
                    a.this.bGf.cancel();
                }
            }
        });
    }

    private void Mr() {
        if (this.bGf == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cnT, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cnT, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bGf = new AnimatorSet();
            this.bGf.playTogether(ofFloat, ofFloat2);
            this.bGf.setDuration(300L);
            this.bGf.setInterpolator(new LinearInterpolator());
        }
        this.bGf.start();
    }
}
