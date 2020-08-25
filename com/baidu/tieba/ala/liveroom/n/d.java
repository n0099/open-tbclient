package com.baidu.tieba.ala.liveroom.n;

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
/* loaded from: classes7.dex */
public class d extends Dialog implements View.OnClickListener {
    private HeadImageView aAu;
    private View bRc;
    private ImageView btj;
    private TextView btk;
    private TextView btl;
    private a gAD;

    /* loaded from: classes7.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public d(@NonNull Context context) {
        super(context, a.j.sdk_dialog_window);
        init();
    }

    public void a(a aVar) {
        this.gAD = aVar;
    }

    public void show(String str) {
        bSB();
        this.aAu.startLoad(str, 25, false, false);
        show();
    }

    public String bSy() {
        return this.btk.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bRc || view == this.btj) {
            dismiss();
        } else if (this.gAD != null) {
            if (view == this.btk) {
                this.gAD.onConfirm();
            } else if (view == this.btl) {
                this.gAD.onCancel();
            }
        }
    }

    private void init() {
        Mt();
        initView();
    }

    private void Mt() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            bSz();
        }
    }

    public void bSz() {
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
        this.bRc = findViewById(a.g.layout_root);
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
        this.aAu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.btk = (TextView) findViewById(a.g.tv_confirm);
        this.btl = (TextView) findViewById(a.g.tv_cancel);
        this.btj = (ImageView) findViewById(a.g.iv_close);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.btk.setTextColor(colorStateList);
        this.bRc.setOnClickListener(this);
        this.btk.setOnClickListener(this);
        this.btl.setOnClickListener(this);
        this.btj.setOnClickListener(this);
    }

    private void bSB() {
        if (this.aAu != null) {
            this.aAu.stopLoad();
        }
    }
}
