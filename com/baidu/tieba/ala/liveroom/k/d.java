package com.baidu.tieba.ala.liveroom.k;

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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class d extends Dialog implements View.OnClickListener {
    private ImageView aEG;
    private TextView aEH;
    private TextView aEI;
    private HeadImageView ahI;
    private View baa;
    private a fcL;

    /* loaded from: classes3.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public d(@NonNull Context context) {
        super(context, a.j.sdk_dialog_window);
        init();
    }

    public void a(a aVar) {
        this.fcL = aVar;
    }

    public void show(String str) {
        bmO();
        this.ahI.startLoad(str, 25, false, false);
        show();
    }

    public String bmM() {
        return this.aEH.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.baa || view == this.aEG) {
            dismiss();
        } else if (this.fcL != null) {
            if (view == this.aEH) {
                this.fcL.onConfirm();
            } else if (view == this.aEI) {
                this.fcL.onCancel();
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
            bmN();
        }
    }

    public void bmN() {
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
        this.baa = findViewById(a.g.layout_root);
        this.ahI = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ahI.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.ahI.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.ahI.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.ahI.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.ahI.setIsRound(true);
        this.ahI.setAutoChangeStyle(false);
        this.ahI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aEH = (TextView) findViewById(a.g.tv_confirm);
        this.aEI = (TextView) findViewById(a.g.tv_cancel);
        this.aEG = (ImageView) findViewById(a.g.iv_close);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.aEH.setTextColor(colorStateList);
        this.baa.setOnClickListener(this);
        this.aEH.setOnClickListener(this);
        this.aEI.setOnClickListener(this);
        this.aEG.setOnClickListener(this);
    }

    private void bmO() {
        if (this.ahI != null) {
            this.ahI.stopLoad();
        }
    }
}
