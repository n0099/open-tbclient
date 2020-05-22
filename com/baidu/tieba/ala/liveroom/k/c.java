package com.baidu.tieba.ala.liveroom.k;

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
import com.baidu.live.data.ap;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class c extends Dialog {
    private HeadImageView aFL;
    private TextView aFN;
    private View bGw;
    private View cwp;
    private a fVE;
    private String fVF;

    /* loaded from: classes3.dex */
    public interface a {
        void onConfirm();
    }

    public c(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(a aVar) {
        this.fVE = aVar;
    }

    public void show(String str) {
        bCj();
        this.aFL.startLoad(str, 25, false, false);
        DX();
        show();
    }

    public String bCg() {
        return this.fVF;
    }

    private void init() {
        initView();
        EF();
        xT();
    }

    private void EF() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        bCh();
    }

    public void bCh() {
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
                    this.cwp.setBackgroundResource(a.f.sdk_black_radius20_alpha70);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(13);
                    layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds80);
                    this.cwp.setLayoutParams(layoutParams);
                } else {
                    attributes.width = displayMetrics.widthPixels;
                    window.setGravity(80);
                    this.cwp.setBackgroundResource(a.f.ala_bg_guide_follow_float);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams2.addRule(12);
                    this.cwp.setLayoutParams(layoutParams2);
                }
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        setContentView(a.h.ala_guide_follow_float);
        this.bGw = findViewById(a.g.layout_root);
        this.bGw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.k.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
        this.cwp = findViewById(a.g.layout_container);
        this.aFN = (TextView) findViewById(a.g.tv_guide_folllow_tip);
        this.aFL = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aFL.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.aFL.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aFL.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.aFL.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.aFL.setIsRound(true);
        this.aFL.setAutoChangeStyle(false);
        this.aFL.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.aFL.setBorderColor(872415231);
        this.aFL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) findViewById(a.g.tv_confirm);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.k.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fVE != null) {
                    c.this.fVE.onConfirm();
                }
            }
        });
        this.fVF = textView.getText().toString();
        bCi();
    }

    private void bCi() {
        ap apVar;
        if (com.baidu.live.v.a.Ge().aWF != null && (apVar = com.baidu.live.v.a.Ge().aWF.ayj) != null && !TextUtils.isEmpty(apVar.aAl)) {
            this.aFN.setText(apVar.aAl);
        }
    }

    private void xT() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.k.c.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                c.this.bCj();
            }
        });
    }

    private void DX() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.bGw.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCj() {
        if (this.aFL != null) {
            this.aFL.stopLoad();
        }
    }
}
