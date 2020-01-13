package com.baidu.tieba.ala.liveroom.m;

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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class c extends Dialog {
    private View aVN;
    private HeadImageView afA;
    private View bHD;
    private a eZv;
    private String mConfirmText;

    /* loaded from: classes2.dex */
    public interface a {
        void onConfirm();
    }

    public c(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(a aVar) {
        this.eZv = aVar;
    }

    public void show(String str) {
        ble();
        this.afA.startLoad(str, 25, false, false);
        vI();
        show();
    }

    public String blc() {
        return this.mConfirmText;
    }

    private void init() {
        initView();
        initWindow();
        re();
    }

    private void initWindow() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        bld();
    }

    public void bld() {
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
                    this.bHD.setBackgroundResource(a.f.sdk_black_radius20_alpha70);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(13);
                    layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds80);
                    this.bHD.setLayoutParams(layoutParams);
                } else {
                    attributes.width = displayMetrics.widthPixels;
                    window.setGravity(80);
                    this.bHD.setBackgroundResource(a.f.ala_bg_guide_follow_float);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams2.addRule(12);
                    this.bHD.setLayoutParams(layoutParams2);
                }
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        setContentView(a.h.ala_guide_follow_float);
        this.aVN = findViewById(a.g.layout_root);
        this.aVN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
        this.bHD = findViewById(a.g.layout_container);
        this.afA = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.afA.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.afA.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.afA.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.afA.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.afA.setIsRound(true);
        this.afA.setAutoChangeStyle(false);
        this.afA.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.afA.setBorderColor(872415231);
        this.afA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) findViewById(a.g.tv_confirm);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eZv != null) {
                    c.this.eZv.onConfirm();
                }
            }
        });
        this.mConfirmText = textView.getText().toString();
    }

    private void re() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                c.this.ble();
            }
        });
    }

    private void vI() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.aVN.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ble() {
        if (this.afA != null) {
            this.afA.stopLoad();
        }
    }
}
