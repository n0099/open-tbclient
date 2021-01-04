package com.baidu.tieba.ala.liveroom.n;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes11.dex */
public class d extends Dialog implements View.OnClickListener {
    private HeadImageView aGr;
    private TextView bUi;
    private TextView bUj;
    private View cDU;
    private a hFb;

    /* loaded from: classes11.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public d(@NonNull Context context) {
        super(context, a.i.sdk_dialog_window);
        init();
    }

    public void a(a aVar) {
        this.hFb = aVar;
    }

    public void GB(String str) {
        ciR();
        this.aGr.startLoad(str, 25, false, false);
        show();
    }

    public String ciJ() {
        return this.bUi.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cDU) {
            dismiss();
        } else if (this.hFb != null) {
            if (view == this.bUi) {
                this.hFb.onConfirm();
            } else if (view == this.bUj) {
                this.hFb.onCancel();
            }
        }
    }

    private void init() {
        JK();
        initView();
    }

    private void JK() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            ciI();
        }
    }

    public void ciI() {
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
        this.cDU = findViewById(a.f.layout_root);
        this.aGr = (HeadImageView) findViewById(a.f.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aGr.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.aGr.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aGr.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.aGr.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.aGr.setIsRound(true);
        this.aGr.setAutoChangeStyle(false);
        this.aGr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aGr.setBorderWidth(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.aGr.setBorderColor(getContext().getResources().getColor(a.c.sdk_cp_cont_g));
        this.bUi = (TextView) findViewById(a.f.tv_confirm);
        this.bUj = (TextView) findViewById(a.f.tv_cancel);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.e.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.e.ala_live_custom_dialog_btn_text_color_s);
        }
        this.bUi.setTextColor(colorStateList);
        this.cDU.setOnClickListener(this);
        this.bUi.setOnClickListener(this);
        this.bUj.setOnClickListener(this);
    }

    private void ciR() {
        if (this.aGr != null) {
            this.aGr.stopLoad();
        }
    }
}
