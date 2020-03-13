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
    private ImageView aEH;
    private TextView aEI;
    private TextView aEJ;
    private HeadImageView ahI;
    private View bab;
    private a fcY;

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
        this.fcY = aVar;
    }

    public void show(String str) {
        bmP();
        this.ahI.startLoad(str, 25, false, false);
        show();
    }

    public String bmN() {
        return this.aEI.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bab || view == this.aEH) {
            dismiss();
        } else if (this.fcY != null) {
            if (view == this.aEI) {
                this.fcY.onConfirm();
            } else if (view == this.aEJ) {
                this.fcY.onCancel();
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
            bmO();
        }
    }

    public void bmO() {
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
        this.bab = findViewById(a.g.layout_root);
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
        this.aEI = (TextView) findViewById(a.g.tv_confirm);
        this.aEJ = (TextView) findViewById(a.g.tv_cancel);
        this.aEH = (ImageView) findViewById(a.g.iv_close);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.aEI.setTextColor(colorStateList);
        this.bab.setOnClickListener(this);
        this.aEI.setOnClickListener(this);
        this.aEJ.setOnClickListener(this);
        this.aEH.setOnClickListener(this);
    }

    private void bmP() {
        if (this.ahI != null) {
            this.ahI.stopLoad();
        }
    }
}
