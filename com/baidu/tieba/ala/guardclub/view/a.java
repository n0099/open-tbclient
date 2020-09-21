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
    private TextView aBe;
    private View bTg;
    private ImageView bwD;
    private TextView bwE;
    private TextView bwF;
    private AnimatorSet bwG;
    private TbImageView ggq;
    private InterfaceC0602a ggr;
    private TextView mTitleTextView;

    /* renamed from: com.baidu.tieba.ala.guardclub.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0602a {
        void onCancel();

        void onConfirm();
    }

    public a(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(InterfaceC0602a interfaceC0602a) {
        this.ggr = interfaceC0602a;
    }

    public void aG(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ggq.startLoad(str, 10, false);
        }
        switch (i) {
            case 0:
                this.mTitleTextView.setText("您已超过30天未活跃");
                this.aBe.setText("已自动退团真的不再爱了吗？");
                this.bwE.setText("继续支持TA");
                this.bwF.setText("我不爱了");
                break;
            case 1:
                this.mTitleTextView.setText("您已进入真爱值衰减期");
                this.aBe.setText("再不努力就来不及啦！");
                this.bwE.setText("去提升");
                this.bwF.setText("衰减规则");
                break;
        }
        KS();
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bTg || view == this.bwD) {
            dismiss();
        } else if (this.ggr != null) {
            if (view == this.bwE) {
                this.ggr.onConfirm();
            } else if (view == this.bwF) {
                this.ggr.onCancel();
            }
        }
    }

    private void init() {
        Nb();
        initView();
        EP();
    }

    private void Nb() {
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
        this.bTg = findViewById(a.g.layout_root);
        this.bwD = (ImageView) findViewById(a.g.iv_close);
        this.ggq = (TbImageView) findViewById(a.g.iv_flag);
        this.mTitleTextView = (TextView) findViewById(a.g.tv_title);
        this.aBe = (TextView) findViewById(a.g.tv_content);
        this.bwF = (TextView) findViewById(a.g.tv_cancel);
        this.bwE = (TextView) findViewById(a.g.tv_confirm);
        this.ggq.setDefaultBgResource(a.d.sdk_transparent);
        this.ggq.setDefaultErrorResource(a.f.sdk_shape_transparent);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        gradientDrawable.setStroke(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds1), -56990);
        this.bwF.setBackgroundDrawable(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable2.setColors(new int[]{-57754, -39399});
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        gradientDrawable2.setCornerRadius(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds40));
        this.bwE.setBackgroundDrawable(gradientDrawable2);
        this.bTg.setOnClickListener(this);
        this.bwD.setOnClickListener(this);
        this.bwE.setOnClickListener(this);
        this.bwF.setOnClickListener(this);
    }

    private void EP() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.guardclub.view.a.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.ggq != null) {
                    a.this.ggq.stopLoad();
                }
                if (a.this.bwG != null) {
                    a.this.bwG.cancel();
                }
            }
        });
    }

    private void KS() {
        if (this.bwG == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.bTg, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.bTg, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.bwG = new AnimatorSet();
            this.bwG.playTogether(ofFloat, ofFloat2);
            this.bwG.setDuration(300L);
            this.bwG.setInterpolator(new LinearInterpolator());
        }
        this.bwG.start();
    }
}
