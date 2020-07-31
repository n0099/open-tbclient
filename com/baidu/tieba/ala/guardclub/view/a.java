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
    private TextView avu;
    private View bLG;
    private ImageView bnG;
    private TextView bnH;
    private TextView bnI;
    private AnimatorSet bnJ;
    private TbImageView fRc;
    private InterfaceC0559a fRd;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0559a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0559a interfaceC0559a) {
        this.fRd = interfaceC0559a;
    }

    public void aI(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fRc.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.avu.setText("已自动退团真的不再爱了吗？");
                this.bnH.setText("继续支持TA");
                this.bnI.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.avu.setText("再不努力就来不及啦！");
                this.bnH.setText("去提升");
                this.bnI.setText("衰减规则");
                break;
        }
        EG();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bLG || view == this.bnG) {
            dismiss();
        } else if (this.fRd != null) {
            if (view == this.bnH) {
                this.fRd.onConfirm();
            } else if (view == this.bnI) {
                this.fRd.onCancel();
            }
        }
    }

    private void init() {
        GH();
        initView();
        yV();
    }

    private void GH() {
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
        this.bLG = findViewById(a.g.layout_root);
        this.bnG = (ImageView) findViewById(a.g.iv_close);
        this.fRc = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.avu = (TextView) findViewById(a.g.tv_content);
        this.bnI = (TextView) findViewById(a.g.tv_cancel);
        this.bnH = (TextView) findViewById(a.g.tv_confirm);
        this.fRc.setDefaultBgResource(a.d.sdk_transparent);
        this.fRc.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.bnI.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.bnH.setBackgroundDrawable(gradientDrawable2);
        this.bLG.setOnClickListener(this);
        this.bnG.setOnClickListener(this);
        this.bnH.setOnClickListener(this);
        this.bnI.setOnClickListener(this);
    }

    private void yV() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.fRc != null) {
                    a.this.fRc.stopLoad();
                }
                if (a.this.bnJ != null) {
                    a.this.bnJ.cancel();
                }
            }
        });
    }

    private void EG() {
        if (this.bnJ == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bLG, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bLG, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bnJ = new AnimatorSet();
            this.bnJ.playTogether(ofFloat, ofFloat2);
            this.bnJ.setDuration(300L);
            this.bnJ.setInterpolator(new LinearInterpolator());
        }
        this.bnJ.start();
    }
}
