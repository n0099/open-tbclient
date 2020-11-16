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
    private TextView aDw;
    private ImageView bJW;
    private TextView bJX;
    private TextView bJY;
    private AnimatorSet bJZ;
    private View csf;
    private TbImageView gIe;
    private InterfaceC0647a gIf;
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
        this.gIf = interfaceC0647a;
    }

    public void W(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gIe.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aDw.setText("已自动退团真的不再爱了吗？");
                this.bJX.setText("继续支持TA");
                this.bJY.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aDw.setText("再不努力就来不及啦！");
                this.bJX.setText("去提升");
                this.bJY.setText("衰减规则");
                break;
        }
        Mi();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.csf || view == this.bJW) {
            dismiss();
        } else if (this.gIf != null) {
            if (view == this.bJX) {
                this.gIf.onConfirm();
            } else if (view == this.bJY) {
                this.gIf.onCancel();
            }
        }
    }

    private void init() {
        Ov();
        initView();
        FS();
    }

    private void Ov() {
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
        this.csf = findViewById(a.f.layout_root);
        this.bJW = (ImageView) findViewById(a.f.iv_close);
        this.gIe = (TbImageView) findViewById(a.f.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.f.tv_title);
        this.aDw = (TextView) findViewById(a.f.tv_content);
        this.bJY = (TextView) findViewById(a.f.tv_cancel);
        this.bJX = (TextView) findViewById(a.f.tv_confirm);
        this.gIe.setDefaultBgResource(a.c.sdk_transparent);
        this.gIe.setDefaultErrorResource(a.e.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds1), -56990);
        this.bJY.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds40));
        this.bJX.setBackgroundDrawable(gradientDrawable2);
        this.csf.setOnClickListener(this);
        this.bJW.setOnClickListener(this);
        this.bJX.setOnClickListener(this);
        this.bJY.setOnClickListener(this);
    }

    private void FS() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.gIe != null) {
                    a.this.gIe.stopLoad();
                }
                if (a.this.bJZ != null) {
                    a.this.bJZ.cancel();
                }
            }
        });
    }

    private void Mi() {
        if (this.bJZ == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.csf, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.csf, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bJZ = new AnimatorSet();
            this.bJZ.playTogether(ofFloat, ofFloat2);
            this.bJZ.setDuration(300L);
            this.bJZ.setInterpolator(new LinearInterpolator());
        }
        this.bJZ.start();
    }
}
