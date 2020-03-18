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
    private ImageView aEV;
    private TextView aEW;
    private TextView aEX;
    private HeadImageView ahS;
    private View bao;
    private a fdw;

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
        this.fdw = aVar;
    }

    public void show(String str) {
        bmU();
        this.ahS.startLoad(str, 25, false, false);
        show();
    }

    public String bmS() {
        return this.aEW.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bao || view == this.aEV) {
            dismiss();
        } else if (this.fdw != null) {
            if (view == this.aEW) {
                this.fdw.onConfirm();
            } else if (view == this.aEX) {
                this.fdw.onCancel();
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
            bmT();
        }
    }

    public void bmT() {
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
        this.bao = findViewById(a.g.layout_root);
        this.ahS = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ahS.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.ahS.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.ahS.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.ahS.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.ahS.setIsRound(true);
        this.ahS.setAutoChangeStyle(false);
        this.ahS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aEW = (TextView) findViewById(a.g.tv_confirm);
        this.aEX = (TextView) findViewById(a.g.tv_cancel);
        this.aEV = (ImageView) findViewById(a.g.iv_close);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.aEW.setTextColor(colorStateList);
        this.bao.setOnClickListener(this);
        this.aEW.setOnClickListener(this);
        this.aEX.setOnClickListener(this);
        this.aEV.setOnClickListener(this);
    }

    private void bmU() {
        if (this.ahS != null) {
            this.ahS.stopLoad();
        }
    }
}
