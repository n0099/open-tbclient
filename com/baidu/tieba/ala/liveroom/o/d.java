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
    private HeadImageView aEh;
    private TextView bDh;
    private TextView bDi;
    private View cfu;
    private a gSp;

    /* loaded from: classes4.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public d(@NonNull Context context) {
        super(context, a.j.sdk_dialog_window);
        init();
    }

    public void a(a aVar) {
        this.gSp = aVar;
    }

    public void Fz(String str) {
        bXr();
        this.aEh.startLoad(str, 25, false, false);
        show();
    }

    public String bXg() {
        return this.bDh.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cfu) {
            dismiss();
        } else if (this.gSp != null) {
            if (view == this.bDh) {
                this.gSp.onConfirm();
            } else if (view == this.bDi) {
                this.gSp.onCancel();
            }
        }
    }

    private void init() {
        Og();
        initView();
    }

    private void Og() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            bXf();
        }
    }

    public void bXf() {
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
        this.cfu = findViewById(a.g.layout_root);
        this.aEh = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aEh.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.aEh.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aEh.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.aEh.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.aEh.setIsRound(true);
        this.aEh.setAutoChangeStyle(false);
        this.aEh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aEh.setBorderWidth(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds4));
        this.aEh.setBorderColor(getContext().getResources().getColor(a.d.sdk_cp_cont_g));
        this.bDh = (TextView) findViewById(a.g.tv_confirm);
        this.bDi = (TextView) findViewById(a.g.tv_cancel);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.bDh.setTextColor(colorStateList);
        this.cfu.setOnClickListener(this);
        this.bDh.setOnClickListener(this);
        this.bDi.setOnClickListener(this);
    }

    private void bXr() {
        if (this.aEh != null) {
            this.aEh.stopLoad();
        }
    }
}
