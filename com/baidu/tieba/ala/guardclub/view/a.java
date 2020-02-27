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
    private ImageView aEF;
    private TextView aEG;
    private TextView aEH;
    private AnimatorSet aEI;
    private View aZZ;
    private TextView atX;
    private TbImageView eHB;
    private InterfaceC0437a eHC;
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
        this.eHC = interfaceC0437a;
    }

    public void ak(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.eHB.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.atX.setText("已自动退团真的不再爱了吗？");
                this.aEG.setText("继续支持TA");
                this.aEH.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.atX.setText("再不努力就来不及啦！");
                this.aEG.setText("去提升");
                this.aEH.setText("衰减规则");
                break;
        }
        xG();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aZZ || view == this.aEF) {
            dismiss();
        } else if (this.eHC != null) {
            if (view == this.aEG) {
                this.eHC.onConfirm();
            } else if (view == this.aEH) {
                this.eHC.onCancel();
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
        this.aZZ = findViewById(a.g.layout_root);
        this.aEF = (ImageView) findViewById(a.g.iv_close);
        this.eHB = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.atX = (TextView) findViewById(a.g.tv_content);
        this.aEH = (TextView) findViewById(a.g.tv_cancel);
        this.aEG = (TextView) findViewById(a.g.tv_confirm);
        this.eHB.setDefaultBgResource(a.d.sdk_transparent);
        this.eHB.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.aEH.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.aEG.setBackgroundDrawable(gradientDrawable2);
        this.aZZ.setOnClickListener(this);
        this.aEF.setOnClickListener(this);
        this.aEG.setOnClickListener(this);
        this.aEH.setOnClickListener(this);
    }

    private void sf() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.eHB != null) {
                    a.this.eHB.stopLoad();
                }
                if (a.this.aEI != null) {
                    a.this.aEI.cancel();
                }
            }
        });
    }

    private void xG() {
        if (this.aEI == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aZZ, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aZZ, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.aEI = new AnimatorSet();
            this.aEI.playTogether(ofFloat, ofFloat2);
            this.aEI.setDuration(300L);
            this.aEI.setInterpolator(new LinearInterpolator());
        }
        this.aEI.start();
    }
}
