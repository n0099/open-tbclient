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
    private TextView aET;
    private TextView bUM;
    private TextView bUN;
    private AnimatorSet bUP;
    private ImageView bge;
    private View cDe;
    private TbImageView hdb;
    private InterfaceC0642a hdc;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0642a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.i.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0642a interfaceC0642a) {
        this.hdc = interfaceC0642a;
    }

    public void ad(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hdb.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aET.setText("已自动退团真的不再爱了吗？");
                this.bUM.setText("继续支持TA");
                this.bUN.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aET.setText("再不努力就来不及啦！");
                this.bUM.setText("去提升");
                this.bUN.setText("衰减规则");
                break;
        }
        LQ();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cDe || view == this.bge) {
            dismiss();
        } else if (this.hdc != null) {
            if (view == this.bUM) {
                this.hdc.onConfirm();
            } else if (view == this.bUN) {
                this.hdc.onCancel();
            }
        }
    }

    private void init() {
        Hi();
        initView();
        EG();
    }

    private void Hi() {
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
        this.cDe = findViewById(a.f.layout_root);
        this.bge = (ImageView) findViewById(a.f.iv_close);
        this.hdb = (TbImageView) findViewById(a.f.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.f.tv_title);
        this.aET = (TextView) findViewById(a.f.tv_content);
        this.bUN = (TextView) findViewById(a.f.tv_cancel);
        this.bUM = (TextView) findViewById(a.f.tv_confirm);
        this.hdb.setDefaultBgResource(a.c.sdk_transparent);
        this.hdb.setDefaultErrorResource(a.e.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds1), -56990);
        this.bUN.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds40));
        this.bUM.setBackgroundDrawable(gradientDrawable2);
        this.cDe.setOnClickListener(this);
        this.bge.setOnClickListener(this);
        this.bUM.setOnClickListener(this);
        this.bUN.setOnClickListener(this);
    }

    private void EG() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.hdb != null) {
                    a.this.hdb.stopLoad();
                }
                if (a.this.bUP != null) {
                    a.this.bUP.cancel();
                }
            }
        });
    }

    private void LQ() {
        if (this.bUP == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cDe, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cDe, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bUP = new AnimatorSet();
            this.bUP.playTogether(ofFloat, ofFloat2);
            this.bUP.setDuration(300L);
            this.bUP.setInterpolator(new LinearInterpolator());
        }
        this.bUP.start();
    }
}
