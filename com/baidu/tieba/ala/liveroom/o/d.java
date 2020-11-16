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
    private HeadImageView aDu;
    private TextView bJX;
    private TextView bJY;
    private View csf;
    private a hjF;

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
        this.hjF = aVar;
    }

    public void FO(String str) {
        cck();
        this.aDu.startLoad(str, 25, false, false);
        show();
    }

    public String cca() {
        return this.bJX.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.csf) {
            dismiss();
        } else if (this.hjF != null) {
            if (view == this.bJX) {
                this.hjF.onConfirm();
            } else if (view == this.bJY) {
                this.hjF.onCancel();
            }
        }
    }

    private void init() {
        Ov();
        initView();
    }

    private void Ov() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            cbZ();
        }
    }

    public void cbZ() {
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
        this.csf = findViewById(a.f.layout_root);
        this.aDu = (HeadImageView) findViewById(a.f.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aDu.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.aDu.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aDu.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.aDu.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.aDu.setIsRound(true);
        this.aDu.setAutoChangeStyle(false);
        this.aDu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aDu.setBorderWidth(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.aDu.setBorderColor(getContext().getResources().getColor(a.c.sdk_cp_cont_g));
        this.bJX = (TextView) findViewById(a.f.tv_confirm);
        this.bJY = (TextView) findViewById(a.f.tv_cancel);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.e.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.e.ala_live_custom_dialog_btn_text_color_s);
        }
        this.bJX.setTextColor(colorStateList);
        this.csf.setOnClickListener(this);
        this.bJX.setOnClickListener(this);
        this.bJY.setOnClickListener(this);
    }

    private void cck() {
        if (this.aDu != null) {
            this.aDu.stopLoad();
        }
    }
}
