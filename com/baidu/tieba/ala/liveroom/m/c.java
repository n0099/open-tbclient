package com.baidu.tieba.ala.liveroom.m;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
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
import com.baidu.live.data.au;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class c extends Dialog {
    private TextView aJF;
    private HeadImageView avs;
    private View bLG;
    private View cDM;
    private a gnK;
    private String gnL;

    /* loaded from: classes4.dex */
    public interface a {
        void onConfirm();
    }

    public c(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(a aVar) {
        this.gnK = aVar;
    }

    public void show(String str) {
        bIA();
        this.avs.startLoad(str, 25, false, false);
        EG();
        show();
    }

    public String bIx() {
        return this.gnL;
    }

    private void init() {
        initView();
        GH();
        yV();
    }

    private void GH() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        bIy();
    }

    public void bIy() {
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
                    this.cDM.setBackgroundResource(a.f.sdk_black_radius20_alpha70);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(13);
                    layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds80);
                    this.cDM.setLayoutParams(layoutParams);
                } else {
                    attributes.width = displayMetrics.widthPixels;
                    window.setGravity(80);
                    this.cDM.setBackgroundResource(a.f.ala_bg_guide_follow_float);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams2.addRule(12);
                    this.cDM.setLayoutParams(layoutParams2);
                }
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        setContentView(a.h.ala_guide_follow_float);
        this.bLG = findViewById(a.g.layout_root);
        this.bLG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
        this.cDM = findViewById(a.g.layout_container);
        this.aJF = (TextView) findViewById(a.g.tv_guide_folllow_tip);
        this.avs = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.avs.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.avs.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.avs.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.avs.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.avs.setIsRound(true);
        this.avs.setAutoChangeStyle(false);
        this.avs.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.avs.setBorderColor(872415231);
        this.avs.setScaleType(ImageView.ScaleType.CENTER_CROP);
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
                if (c.this.gnK != null) {
                    c.this.gnK.onConfirm();
                }
            }
        });
        this.gnL = textView.getText().toString();
        bIz();
    }

    private void bIz() {
        au auVar;
        if (com.baidu.live.v.a.Hs().aZn != null && (auVar = com.baidu.live.v.a.Hs().aZn.aBL) != null && !TextUtils.isEmpty(auVar.aDR)) {
            this.aJF.setText(auVar.aDR);
        }
    }

    private void yV() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                c.this.bIA();
            }
        });
    }

    private void EG() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.bLG.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIA() {
        if (this.avs != null) {
            this.avs.stopLoad();
        }
    }
}
