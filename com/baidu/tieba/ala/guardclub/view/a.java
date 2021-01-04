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
    private TextView aGt;
    private TextView bUi;
    private TextView bUj;
    private AnimatorSet bUl;
    private ImageView bgl;
    private View cDU;
    private TbImageView hda;
    private InterfaceC0652a hdb;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0652a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.i.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0652a interfaceC0652a) {
        this.hdb = interfaceC0652a;
    }

    public void Y(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hda.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aGt.setText("已自动退团真的不再爱了吗？");
                this.bUi.setText("继续支持TA");
                this.bUj.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aGt.setText("再不努力就来不及啦！");
                this.bUi.setText("去提升");
                this.bUj.setText("衰减规则");
                break;
        }
        Oj();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cDU || view == this.bgl) {
            dismiss();
        } else if (this.hdb != null) {
            if (view == this.bUi) {
                this.hdb.onConfirm();
            } else if (view == this.bUj) {
                this.hdb.onCancel();
            }
        }
    }

    private void init() {
        JK();
        initView();
        Hi();
    }

    private void JK() {
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
        this.cDU = findViewById(a.f.layout_root);
        this.bgl = (ImageView) findViewById(a.f.iv_close);
        this.hda = (TbImageView) findViewById(a.f.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.f.tv_title);
        this.aGt = (TextView) findViewById(a.f.tv_content);
        this.bUj = (TextView) findViewById(a.f.tv_cancel);
        this.bUi = (TextView) findViewById(a.f.tv_confirm);
        this.hda.setDefaultBgResource(a.c.sdk_transparent);
        this.hda.setDefaultErrorResource(a.e.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds1), -56990);
        this.bUj.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds40));
        this.bUi.setBackgroundDrawable(gradientDrawable2);
        this.cDU.setOnClickListener(this);
        this.bgl.setOnClickListener(this);
        this.bUi.setOnClickListener(this);
        this.bUj.setOnClickListener(this);
    }

    private void Hi() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.hda != null) {
                    a.this.hda.stopLoad();
                }
                if (a.this.bUl != null) {
                    a.this.bUl.cancel();
                }
            }
        });
    }

    private void Oj() {
        if (this.bUl == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cDU, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cDU, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bUl = new AnimatorSet();
            this.bUl.playTogether(ofFloat, ofFloat2);
            this.bUl.setDuration(300L);
            this.bUl.setInterpolator(new LinearInterpolator());
        }
        this.bUl.start();
    }
}
