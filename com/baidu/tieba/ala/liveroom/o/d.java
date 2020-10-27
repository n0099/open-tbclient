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
    private HeadImageView aEp;
    private TextView bGd;
    private TextView bGe;
    private View cnT;
    private a hec;

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
        this.hec = aVar;
    }

    public void FZ(String str) {
        caq();
        this.aEp.startLoad(str, 25, false, false);
        show();
    }

    public String caf() {
        return this.bGd.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cnT) {
            dismiss();
        } else if (this.hec != null) {
            if (view == this.bGd) {
                this.hec.onConfirm();
            } else if (view == this.bGe) {
                this.hec.onCancel();
            }
        }
    }

    private void init() {
        OE();
        initView();
    }

    private void OE() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            cae();
        }
    }

    public void cae() {
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
        this.cnT = findViewById(a.g.layout_root);
        this.aEp = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aEp.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.aEp.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aEp.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.aEp.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.aEp.setIsRound(true);
        this.aEp.setAutoChangeStyle(false);
        this.aEp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aEp.setBorderWidth(getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds4));
        this.aEp.setBorderColor(getContext().getResources().getColor(a.d.sdk_cp_cont_g));
        this.bGd = (TextView) findViewById(a.g.tv_confirm);
        this.bGe = (TextView) findViewById(a.g.tv_cancel);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.bGd.setTextColor(colorStateList);
        this.cnT.setOnClickListener(this);
        this.bGd.setOnClickListener(this);
        this.bGe.setOnClickListener(this);
    }

    private void caq() {
        if (this.aEp != null) {
            this.aEp.stopLoad();
        }
    }
}
