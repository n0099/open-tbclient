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
    private HeadImageView Xg;
    private ImageView arR;
    private TextView arS;
    private TextView arT;
    private AnimatorSet arU;
    private View dMv;
    private a egL;

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
        this.egL = aVar;
    }

    public void tD(String str) {
        aSv();
        this.Xg.startLoad(str, 25, false, false);
        tx();
        show();
    }

    public String aSt() {
        return this.arS.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dMv || view == this.arR) {
            dismiss();
        } else if (this.egL != null) {
            if (view == this.arS) {
                this.egL.onConfirm();
            } else if (view == this.arT) {
                this.egL.onCancel();
            }
        }
    }

    private void init() {
        wD();
        initView();
        pv();
    }

    private void wD() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            aSu();
        }
    }

    public void aSu() {
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
        this.dMv = findViewById(a.g.layout_root);
        this.Xg = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.Xg.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.Xg.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.Xg.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.Xg.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.Xg.setIsRound(true);
        this.Xg.setAutoChangeStyle(false);
        this.Xg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.arS = (TextView) findViewById(a.g.tv_confirm);
        this.arT = (TextView) findViewById(a.g.tv_cancel);
        this.arR = (ImageView) findViewById(a.g.iv_close);
        this.dMv.setOnClickListener(this);
        this.arS.setOnClickListener(this);
        this.arT.setOnClickListener(this);
        this.arR.setOnClickListener(this);
    }

    private void pv() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.k.d.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.arU != null) {
                    d.this.arU.cancel();
                }
            }
        });
    }

    private void tx() {
        if (this.arU == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dMv, "ScaleX", 0.5f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.dMv, "ScaleY", 0.5f, 1.2f, 1.0f);
            this.arU = new AnimatorSet();
            this.arU.playTogether(ofFloat, ofFloat2);
            this.arU.setDuration(300L);
            this.arU.setInterpolator(new LinearInterpolator());
        }
        this.arU.start();
    }

    private void aSv() {
        if (this.Xg != null) {
            this.Xg.stopLoad();
        }
    }
}
