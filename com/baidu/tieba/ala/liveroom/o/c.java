package com.baidu.tieba.ala.liveroom.o;

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
import com.baidu.live.data.bb;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class c extends Dialog {
    private HeadImageView aBc;
    private TextView aQU;
    private View bTg;
    private View cOO;
    private a gDT;
    private String gDU;

    /* loaded from: classes4.dex */
    public interface a {
        void onConfirm();
    }

    public c(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(a aVar) {
        this.gDT = aVar;
    }

    public void EO(String str) {
        bTZ();
        this.aBc.startLoad(str, 25, false, false);
        KS();
        show();
    }

    public String bTW() {
        return this.gDU;
    }

    private void init() {
        initView();
        Nb();
        EP();
    }

    private void Nb() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        bTX();
    }

    public void bTX() {
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
                    this.cOO.setBackgroundResource(a.f.sdk_black_radius20_alpha70);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(13);
                    layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds80);
                    this.cOO.setLayoutParams(layoutParams);
                } else {
                    attributes.width = displayMetrics.widthPixels;
                    window.setGravity(80);
                    this.cOO.setBackgroundResource(a.f.ala_bg_guide_follow_float);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams2.addRule(12);
                    this.cOO.setLayoutParams(layoutParams2);
                }
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        setContentView(a.h.ala_guide_follow_float);
        this.bTg = findViewById(a.g.layout_root);
        this.bTg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
        this.cOO = findViewById(a.g.layout_container);
        this.aQU = (TextView) findViewById(a.g.tv_guide_folllow_tip);
        this.aBc = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aBc.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.aBc.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aBc.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.aBc.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.aBc.setIsRound(true);
        this.aBc.setAutoChangeStyle(false);
        this.aBc.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.aBc.setBorderColor(872415231);
        this.aBc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) findViewById(a.g.tv_confirm);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.gDT != null) {
                    c.this.gDT.onConfirm();
                }
            }
        });
        this.gDU = textView.getText().toString();
        bTY();
    }

    private void bTY() {
        bb bbVar;
        if (com.baidu.live.x.a.NN().bhy != null && (bbVar = com.baidu.live.x.a.NN().bhy.aIn) != null && !TextUtils.isEmpty(bbVar.aKt)) {
            this.aQU.setText(bbVar.aKt);
        }
    }

    private void EP() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                c.this.bTZ();
            }
        });
    }

    private void KS() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.bTg.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTZ() {
        if (this.aBc != null) {
            this.aBc.stopLoad();
        }
    }
}
