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
/* loaded from: classes4.dex */
public class d extends Dialog implements View.OnClickListener {
    private HeadImageView aGa;
    private TextView bPe;
    private TextView bPf;
    private View czb;
    private a htf;

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
        this.htf = aVar;
    }

    public void GD(String str) {
        cgd();
        this.aGa.startLoad(str, 25, false, false);
        show();
    }

    public String cfT() {
        return this.bPe.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.czb) {
            dismiss();
        } else if (this.htf != null) {
            if (view == this.bPe) {
                this.htf.onConfirm();
            } else if (view == this.bPf) {
                this.htf.onCancel();
            }
        }
    }

    private void init() {
        Ki();
        initView();
    }

    private void Ki() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            cfS();
        }
    }

    public void cfS() {
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
        this.czb = findViewById(a.f.layout_root);
        this.aGa = (HeadImageView) findViewById(a.f.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aGa.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.aGa.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aGa.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.aGa.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.aGa.setIsRound(true);
        this.aGa.setAutoChangeStyle(false);
        this.aGa.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aGa.setBorderWidth(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.aGa.setBorderColor(getContext().getResources().getColor(a.c.sdk_cp_cont_g));
        this.bPe = (TextView) findViewById(a.f.tv_confirm);
        this.bPf = (TextView) findViewById(a.f.tv_cancel);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.e.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.e.ala_live_custom_dialog_btn_text_color_s);
        }
        this.bPe.setTextColor(colorStateList);
        this.czb.setOnClickListener(this);
        this.bPe.setOnClickListener(this);
        this.bPf.setOnClickListener(this);
    }

    private void cgd() {
        if (this.aGa != null) {
            this.aGa.stopLoad();
        }
    }
}
