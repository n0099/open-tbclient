package com.baidu.tieba.ala.liveroom.m;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class d extends Dialog implements View.OnClickListener {
    private ImageView aAp;
    private TextView aAq;
    private TextView aAr;
    private View aVN;
    private HeadImageView afA;
    private a eZx;

    /* loaded from: classes2.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public d(@NonNull Context context) {
        super(context, a.j.sdk_dialog_window);
        init();
    }

    public void a(a aVar) {
        this.eZx = aVar;
    }

    public void show(String str) {
        ble();
        this.afA.startLoad(str, 25, false, false);
        show();
    }

    public String blc() {
        return this.aAq.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aVN || view == this.aAp) {
            dismiss();
        } else if (this.eZx != null) {
            if (view == this.aAq) {
                this.eZx.onConfirm();
            } else if (view == this.aAr) {
                this.eZx.onCancel();
            }
        }
    }

    private void init() {
        initWindow();
        initView();
    }

    private void initWindow() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            bld();
        }
    }

    public void bld() {
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
            getWindow().setAttributes(attributes);
        }
    }

    private void initView() {
        ColorStateList colorStateList;
        setContentView(a.h.ala_guide_follow_pop);
        this.aVN = findViewById(a.g.layout_root);
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
        this.afA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aAq = (TextView) findViewById(a.g.tv_confirm);
        this.aAr = (TextView) findViewById(a.g.tv_cancel);
        this.aAp = (ImageView) findViewById(a.g.iv_close);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.aAq.setTextColor(colorStateList);
        this.aVN.setOnClickListener(this);
        this.aAq.setOnClickListener(this);
        this.aAr.setOnClickListener(this);
        this.aAp.setOnClickListener(this);
    }

    private void ble() {
        if (this.afA != null) {
            this.afA.stopLoad();
        }
    }
}
