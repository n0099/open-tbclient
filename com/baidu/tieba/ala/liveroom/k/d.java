package com.baidu.tieba.ala.liveroom.k;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes6.dex */
public class d extends Dialog implements View.OnClickListener {
    private HeadImageView Xy;
    private ImageView asj;
    private TextView ask;
    private TextView asl;
    private AnimatorSet asm;
    private View dNm;
    private a ehC;

    /* loaded from: classes6.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public d(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(a aVar) {
        this.ehC = aVar;
    }

    public void tD(String str) {
        aSx();
        this.Xy.startLoad(str, 25, false, false);
        tw();
        show();
    }

    public String aSv() {
        return this.ask.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dNm || view == this.asj) {
            dismiss();
        } else if (this.ehC != null) {
            if (view == this.ask) {
                this.ehC.onConfirm();
            } else if (view == this.asl) {
                this.ehC.onCancel();
            }
        }
    }

    private void init() {
        wC();
        initView();
        pv();
    }

    private void wC() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            aSw();
        }
    }

    public void aSw() {
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
                attributes.width = displayMetrics.heightPixels;
            } else {
                attributes.width = displayMetrics.widthPixels;
            }
        }
    }

    private void initView() {
        setContentView(a.h.ala_guide_follow_pop);
        this.dNm = findViewById(a.g.layout_root);
        this.Xy = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.Xy.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.Xy.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.Xy.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.Xy.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.Xy.setIsRound(true);
        this.Xy.setAutoChangeStyle(false);
        this.Xy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ask = (TextView) findViewById(a.g.tv_confirm);
        this.asl = (TextView) findViewById(a.g.tv_cancel);
        this.asj = (ImageView) findViewById(a.g.iv_close);
        this.dNm.setOnClickListener(this);
        this.ask.setOnClickListener(this);
        this.asl.setOnClickListener(this);
        this.asj.setOnClickListener(this);
    }

    private void pv() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.k.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.asm != null) {
                    d.this.asm.cancel();
                }
            }
        });
    }

    private void tw() {
        if (this.asm == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dNm, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dNm, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.asm = new AnimatorSet();
            this.asm.playTogether(ofFloat, ofFloat2);
            this.asm.setDuration(300L);
            this.asm.setInterpolator(new LinearInterpolator());
        }
        this.asm.start();
    }

    private void aSx() {
        if (this.Xy != null) {
            this.Xy.stopLoad();
        }
    }
}
