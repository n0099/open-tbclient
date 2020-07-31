package com.baidu.tieba.ala.liveroom.m;

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
    private HeadImageView avs;
    private View bLG;
    private ImageView bnG;
    private TextView bnH;
    private TextView bnI;
    private a gnN;

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
        this.gnN = aVar;
    }

    public void show(String str) {
        bIA();
        this.avs.startLoad(str, 25, false, false);
        show();
    }

    public String bIx() {
        return this.bnH.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bLG || view == this.bnG) {
            dismiss();
        } else if (this.gnN != null) {
            if (view == this.bnH) {
                this.gnN.onConfirm();
            } else if (view == this.bnI) {
                this.gnN.onCancel();
            }
        }
    }

    private void init() {
        GH();
        initView();
    }

    private void GH() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            bIy();
        }
    }

    public void bIy() {
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
        this.bLG = findViewById(a.g.layout_root);
        this.avs = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.avs.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.avs.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.avs.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.avs.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.avs.setIsRound(true);
        this.avs.setAutoChangeStyle(false);
        this.avs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bnH = (TextView) findViewById(a.g.tv_confirm);
        this.bnI = (TextView) findViewById(a.g.tv_cancel);
        this.bnG = (ImageView) findViewById(a.g.iv_close);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.bnH.setTextColor(colorStateList);
        this.bLG.setOnClickListener(this);
        this.bnH.setOnClickListener(this);
        this.bnI.setOnClickListener(this);
        this.bnG.setOnClickListener(this);
    }

    private void bIA() {
        if (this.avs != null) {
            this.avs.stopLoad();
        }
    }
}
