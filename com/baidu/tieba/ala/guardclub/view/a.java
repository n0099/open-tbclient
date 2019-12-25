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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes2.dex */
public class a extends Dialog implements View.OnClickListener {
    private View aUV;
    private TextView apB;
    private ImageView azF;
    private TextView azG;
    private TextView azH;
    private AnimatorSet azI;
    private TbImageView eCG;
    private InterfaceC0423a eCH;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0423a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0423a interfaceC0423a) {
        this.eCH = interfaceC0423a;
    }

    public void ah(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eCG.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.apB.setText("已自动退团真的不再爱了吗？");
                this.azG.setText("继续支持TA");
                this.azH.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.apB.setText("再不努力就来不及啦！");
                this.azG.setText("去提升");
                this.azH.setText("衰减规则");
                break;
        }
        vr();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aUV || view == this.azF) {
            dismiss();
        } else if (this.eCH != null) {
            if (view == this.azG) {
                this.eCH.onConfirm();
            } else if (view == this.azH) {
                this.eCH.onCancel();
            }
        }
    }

    private void init() {
        initWindow();
        initView();
        qS();
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
        this.aUV = findViewById(a.g.layout_root);
        this.azF = (ImageView) findViewById(a.g.iv_close);
        this.eCG = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.apB = (TextView) findViewById(a.g.tv_content);
        this.azH = (TextView) findViewById(a.g.tv_cancel);
        this.azG = (TextView) findViewById(a.g.tv_confirm);
        this.eCG.setDefaultBgResource(a.d.sdk_transparent);
        this.eCG.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.azH.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.azG.setBackgroundDrawable(gradientDrawable2);
        this.aUV.setOnClickListener(this);
        this.azF.setOnClickListener(this);
        this.azG.setOnClickListener(this);
        this.azH.setOnClickListener(this);
    }

    private void qS() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.eCG != null) {
                    a.this.eCG.stopLoad();
                }
                if (a.this.azI != null) {
                    a.this.azI.cancel();
                }
            }
        });
    }

    private void vr() {
        if (this.azI == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aUV, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aUV, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.azI = new AnimatorSet();
            this.azI.playTogether(ofFloat, ofFloat2);
            this.azI.setDuration(300L);
            this.azI.setInterpolator(new LinearInterpolator());
        }
        this.azI.start();
    }
}
