package com.baidu.tieba.ala.liveroom.n;

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
import com.baidu.live.data.aw;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes7.dex */
public class c extends Dialog {
    private HeadImageView aAu;
    private TextView aOQ;
    private View bRc;
    private View cMK;
    private a gAA;
    private String gAB;

    /* loaded from: classes7.dex */
    public interface a {
        void onConfirm();
    }

    public c(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(a aVar) {
        this.gAA = aVar;
    }

    public void show(String str) {
        bSB();
        this.aAu.startLoad(str, 25, false, false);
        Kl();
        show();
    }

    public String bSy() {
        return this.gAB;
    }

    private void init() {
        initView();
        Mt();
        Ey();
    }

    private void Mt() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        bSz();
    }

    public void bSz() {
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
                    this.cMK.setBackgroundResource(a.f.sdk_black_radius20_alpha70);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(13);
                    layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds80);
                    this.cMK.setLayoutParams(layoutParams);
                } else {
                    attributes.width = displayMetrics.widthPixels;
                    window.setGravity(80);
                    this.cMK.setBackgroundResource(a.f.ala_bg_guide_follow_float);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams2.addRule(12);
                    this.cMK.setLayoutParams(layoutParams2);
                }
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        setContentView(a.h.ala_guide_follow_float);
        this.bRc = findViewById(a.g.layout_root);
        this.bRc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
        this.cMK = findViewById(a.g.layout_container);
        this.aOQ = (TextView) findViewById(a.g.tv_guide_folllow_tip);
        this.aAu = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aAu.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.aAu.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aAu.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.aAu.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.aAu.setIsRound(true);
        this.aAu.setAutoChangeStyle(false);
        this.aAu.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.aAu.setBorderColor(872415231);
        this.aAu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) findViewById(a.g.tv_confirm);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gAA != null) {
                    c.this.gAA.onConfirm();
                }
            }
        });
        this.gAB = textView.getText().toString();
        bSA();
    }

    private void bSA() {
        aw awVar;
        if (com.baidu.live.w.a.Nk().beH != null && (awVar = com.baidu.live.w.a.Nk().beH.aGV) != null && !TextUtils.isEmpty(awVar.aJb)) {
            this.aOQ.setText(awVar.aJb);
        }
    }

    private void Ey() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.n.c.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                c.this.bSB();
            }
        });
    }

    private void Kl() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.bRc.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSB() {
        if (this.aAu != null) {
            this.aAu.stopLoad();
        }
    }
}
