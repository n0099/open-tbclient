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
    private TextView aFh;
    private ImageView bLH;
    private TextView bLI;
    private TextView bLJ;
    private AnimatorSet bLK;
    private View ctR;
    private TbImageView gIx;
    private InterfaceC0647a gIy;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0647a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.i.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0647a interfaceC0647a) {
        this.gIy = interfaceC0647a;
    }

    public void W(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gIx.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aFh.setText("已自动退团真的不再爱了吗？");
                this.bLI.setText("继续支持TA");
                this.bLJ.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aFh.setText("再不努力就来不及啦！");
                this.bLI.setText("去提升");
                this.bLJ.setText("衰减规则");
                break;
        }
        MR();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ctR || view == this.bLH) {
            dismiss();
        } else if (this.gIy != null) {
            if (view == this.bLI) {
                this.gIy.onConfirm();
            } else if (view == this.bLJ) {
                this.gIy.onCancel();
            }
        }
    }

    private void init() {
        Pe();
        initView();
        GB();
    }

    private void Pe() {
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
        this.ctR = findViewById(a.f.layout_root);
        this.bLH = (ImageView) findViewById(a.f.iv_close);
        this.gIx = (TbImageView) findViewById(a.f.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.f.tv_title);
        this.aFh = (TextView) findViewById(a.f.tv_content);
        this.bLJ = (TextView) findViewById(a.f.tv_cancel);
        this.bLI = (TextView) findViewById(a.f.tv_confirm);
        this.gIx.setDefaultBgResource(a.c.sdk_transparent);
        this.gIx.setDefaultErrorResource(a.e.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds1), -56990);
        this.bLJ.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds40));
        this.bLI.setBackgroundDrawable(gradientDrawable2);
        this.ctR.setOnClickListener(this);
        this.bLH.setOnClickListener(this);
        this.bLI.setOnClickListener(this);
        this.bLJ.setOnClickListener(this);
    }

    private void GB() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.gIx != null) {
                    a.this.gIx.stopLoad();
                }
                if (a.this.bLK != null) {
                    a.this.bLK.cancel();
                }
            }
        });
    }

    private void MR() {
        if (this.bLK == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ctR, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ctR, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bLK = new AnimatorSet();
            this.bLK.playTogether(ofFloat, ofFloat2);
            this.bLK.setDuration(300L);
            this.bLK.setInterpolator(new LinearInterpolator());
        }
        this.bLK.start();
    }
}
