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
    private HeadImageView aAw;
    private View bRg;
    private ImageView btm;
    private TextView bto;
    private TextView btp;
    private a gAH;

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
        this.gAH = aVar;
    }

    public void show(String str) {
        bSC();
        this.aAw.startLoad(str, 25, false, false);
        show();
    }

    public String bSz() {
        return this.bto.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bRg || view == this.btm) {
            dismiss();
        } else if (this.gAH != null) {
            if (view == this.bto) {
                this.gAH.onConfirm();
            } else if (view == this.btp) {
                this.gAH.onCancel();
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
            bSA();
        }
    }

    public void bSA() {
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
        this.bRg = findViewById(a.g.layout_root);
        this.aAw = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aAw.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.aAw.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aAw.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.aAw.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.aAw.setIsRound(true);
        this.aAw.setAutoChangeStyle(false);
        this.aAw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bto = (TextView) findViewById(a.g.tv_confirm);
        this.btp = (TextView) findViewById(a.g.tv_cancel);
        this.btm = (ImageView) findViewById(a.g.iv_close);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.bto.setTextColor(colorStateList);
        this.bRg.setOnClickListener(this);
        this.bto.setOnClickListener(this);
        this.btp.setOnClickListener(this);
        this.btm.setOnClickListener(this);
    }

    private void bSC() {
        if (this.aAw != null) {
            this.aAw.stopLoad();
        }
    }
}
