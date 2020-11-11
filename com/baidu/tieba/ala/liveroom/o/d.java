package com.baidu.tieba.ala.liveroom.o;

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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class d extends Dialog implements View.OnClickListener {
    private HeadImageView aFf;
    private TextView bLI;
    private TextView bLJ;
    private View ctR;
    private a hjY;

    /* loaded from: classes4.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public d(@NonNull Context context) {
        super(context, a.i.sdk_dialog_window);
        init();
    }

    public void a(a aVar) {
        this.hjY = aVar;
    }

    public void Gn(String str) {
        ccR();
        this.aFf.startLoad(str, 25, false, false);
        show();
    }

    public String ccH() {
        return this.bLI.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ctR) {
            dismiss();
        } else if (this.hjY != null) {
            if (view == this.bLI) {
                this.hjY.onConfirm();
            } else if (view == this.bLJ) {
                this.hjY.onCancel();
            }
        }
    }

    private void init() {
        Pe();
        initView();
    }

    private void Pe() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            ccG();
        }
    }

    public void ccG() {
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
        setContentView(a.g.ala_guide_follow_pop);
        this.ctR = findViewById(a.f.layout_root);
        this.aFf = (HeadImageView) findViewById(a.f.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aFf.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.aFf.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aFf.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.aFf.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.aFf.setIsRound(true);
        this.aFf.setAutoChangeStyle(false);
        this.aFf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aFf.setBorderWidth(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.aFf.setBorderColor(getContext().getResources().getColor(a.c.sdk_cp_cont_g));
        this.bLI = (TextView) findViewById(a.f.tv_confirm);
        this.bLJ = (TextView) findViewById(a.f.tv_cancel);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.e.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.e.ala_live_custom_dialog_btn_text_color_s);
        }
        this.bLI.setTextColor(colorStateList);
        this.ctR.setOnClickListener(this);
        this.bLI.setOnClickListener(this);
        this.bLJ.setOnClickListener(this);
    }

    private void ccR() {
        if (this.aFf != null) {
            this.aFf.stopLoad();
        }
    }
}
