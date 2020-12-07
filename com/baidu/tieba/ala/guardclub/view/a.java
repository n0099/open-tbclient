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
    private TextView aGc;
    private TextView bPe;
    private TextView bPf;
    private AnimatorSet bPg;
    private ImageView beA;
    private View czb;
    private TbImageView gRl;
    private InterfaceC0660a gRm;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0660a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.i.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0660a interfaceC0660a) {
        this.gRm = interfaceC0660a;
    }

    public void W(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gRl.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aGc.setText("已自动退团真的不再爱了吗？");
                this.bPe.setText("继续支持TA");
                this.bPf.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aGc.setText("再不努力就来不及啦！");
                this.bPe.setText("去提升");
                this.bPf.setText("衰减规则");
                break;
        }
        OD();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.czb || view == this.beA) {
            dismiss();
        } else if (this.gRm != null) {
            if (view == this.bPe) {
                this.gRm.onConfirm();
            } else if (view == this.bPf) {
                this.gRm.onCancel();
            }
        }
    }

    private void init() {
        Ki();
        initView();
        HH();
    }

    private void Ki() {
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
        this.czb = findViewById(a.f.layout_root);
        this.beA = (ImageView) findViewById(a.f.iv_close);
        this.gRl = (TbImageView) findViewById(a.f.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.f.tv_title);
        this.aGc = (TextView) findViewById(a.f.tv_content);
        this.bPf = (TextView) findViewById(a.f.tv_cancel);
        this.bPe = (TextView) findViewById(a.f.tv_confirm);
        this.gRl.setDefaultBgResource(a.c.sdk_transparent);
        this.gRl.setDefaultErrorResource(a.e.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds1), -56990);
        this.bPf.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds40));
        this.bPe.setBackgroundDrawable(gradientDrawable2);
        this.czb.setOnClickListener(this);
        this.beA.setOnClickListener(this);
        this.bPe.setOnClickListener(this);
        this.bPf.setOnClickListener(this);
    }

    private void HH() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.gRl != null) {
                    a.this.gRl.stopLoad();
                }
                if (a.this.bPg != null) {
                    a.this.bPg.cancel();
                }
            }
        });
    }

    private void OD() {
        if (this.bPg == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.czb, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.czb, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bPg = new AnimatorSet();
            this.bPg.playTogether(ofFloat, ofFloat2);
            this.bPg.setDuration(300L);
            this.bPg.setInterpolator(new LinearInterpolator());
        }
        this.bPg.start();
    }
}
