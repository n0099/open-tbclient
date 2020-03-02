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
    private ImageView aEG;
    private TextView aEH;
    private TextView aEI;
    private AnimatorSet aEJ;
    private TextView atX;
    private View baa;
    private TbImageView eHC;
    private InterfaceC0437a eHD;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0437a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0437a interfaceC0437a) {
        this.eHD = interfaceC0437a;
    }

    public void ak(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eHC.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.atX.setText("已自动退团真的不再爱了吗？");
                this.aEH.setText("继续支持TA");
                this.aEI.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.atX.setText("再不努力就来不及啦！");
                this.aEH.setText("去提升");
                this.aEI.setText("衰减规则");
                break;
        }
        xG();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.baa || view == this.aEG) {
            dismiss();
        } else if (this.eHD != null) {
            if (view == this.aEH) {
                this.eHD.onConfirm();
            } else if (view == this.aEI) {
                this.eHD.onCancel();
            }
        }
    }

    private void init() {
        initWindow();
        initView();
        sf();
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
        this.baa = findViewById(a.g.layout_root);
        this.aEG = (ImageView) findViewById(a.g.iv_close);
        this.eHC = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.atX = (TextView) findViewById(a.g.tv_content);
        this.aEI = (TextView) findViewById(a.g.tv_cancel);
        this.aEH = (TextView) findViewById(a.g.tv_confirm);
        this.eHC.setDefaultBgResource(a.d.sdk_transparent);
        this.eHC.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.aEI.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.aEH.setBackgroundDrawable(gradientDrawable2);
        this.baa.setOnClickListener(this);
        this.aEG.setOnClickListener(this);
        this.aEH.setOnClickListener(this);
        this.aEI.setOnClickListener(this);
    }

    private void sf() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.eHC != null) {
                    a.this.eHC.stopLoad();
                }
                if (a.this.aEJ != null) {
                    a.this.aEJ.cancel();
                }
            }
        });
    }

    private void xG() {
        if (this.aEJ == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.baa, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.baa, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.aEJ = new AnimatorSet();
            this.aEJ.playTogether(ofFloat, ofFloat2);
            this.aEJ.setDuration(300L);
            this.aEJ.setInterpolator(new LinearInterpolator());
        }
        this.aEJ.start();
    }
}
