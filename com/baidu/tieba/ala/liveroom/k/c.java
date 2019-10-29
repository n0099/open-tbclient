package com.baidu.tieba.ala.liveroom.k;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes6.dex */
public class c extends Dialog {
    private HeadImageView Xy;
    private View bez;
    private View dNm;
    private a ehA;
    private String mConfirmText;

    /* loaded from: classes6.dex */
    public interface a {
        void onConfirm();
    }

    public c(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(a aVar) {
        this.ehA = aVar;
    }

    public void tD(String str) {
        aSx();
        this.Xy.startLoad(str, 25, false, false);
        tw();
        show();
    }

    public String aSv() {
        return this.mConfirmText;
    }

    private void init() {
        initView();
        wC();
        pv();
    }

    private void wC() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        aSw();
    }

    public void aSw() {
        show();
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            if (windowManager != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
                    attributes.width = displayMetrics.heightPixels;
                    window.setGravity(17);
                    this.bez.setBackgroundResource(a.f.sdk_black_radius20_alpha70);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(13);
                    layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds80);
                    this.bez.setLayoutParams(layoutParams);
                } else {
                    attributes.width = displayMetrics.widthPixels;
                    window.setGravity(80);
                    this.bez.setBackgroundResource(a.f.ala_bg_guide_follow_float);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams2.addRule(12);
                    this.bez.setLayoutParams(layoutParams2);
                }
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        setContentView(a.h.ala_guide_follow_float);
        this.dNm = findViewById(a.g.layout_root);
        this.dNm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.k.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
        this.bez = findViewById(a.g.layout_container);
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
        this.Xy.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.Xy.setBorderColor(872415231);
        this.Xy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) findViewById(a.g.tv_confirm);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.k.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ehA != null) {
                    c.this.ehA.onConfirm();
                }
            }
        });
        this.mConfirmText = textView.getText().toString();
    }

    private void pv() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.k.c.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                c.this.aSx();
            }
        });
    }

    private void tw() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.dNm.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSx() {
        if (this.Xy != null) {
            this.Xy.stopLoad();
        }
    }
}
