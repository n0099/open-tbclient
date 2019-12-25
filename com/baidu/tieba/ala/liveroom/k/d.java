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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class d extends Dialog implements View.OnClickListener {
    private View aUV;
    private HeadImageView aeR;
    private ImageView azF;
    private TextView azG;
    private TextView azH;
    private a eWY;

    /* loaded from: classes2.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public d(@NonNull Context context) {
        super(context, a.j.sdk_dialog_window);
        init();
    }

    public void a(a aVar) {
        this.eWY = aVar;
    }

    public void show(String str) {
        bki();
        this.aeR.startLoad(str, 25, false, false);
        show();
    }

    public String bkg() {
        return this.azG.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aUV || view == this.azF) {
            dismiss();
        } else if (this.eWY != null) {
            if (view == this.azG) {
                this.eWY.onConfirm();
            } else if (view == this.azH) {
                this.eWY.onCancel();
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
            bkh();
        }
    }

    public void bkh() {
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
        this.aUV = findViewById(a.g.layout_root);
        this.aeR = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aeR.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.aeR.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aeR.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.aeR.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.aeR.setIsRound(true);
        this.aeR.setAutoChangeStyle(false);
        this.aeR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.azG = (TextView) findViewById(a.g.tv_confirm);
        this.azH = (TextView) findViewById(a.g.tv_cancel);
        this.azF = (ImageView) findViewById(a.g.iv_close);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.azG.setTextColor(colorStateList);
        this.aUV.setOnClickListener(this);
        this.azG.setOnClickListener(this);
        this.azH.setOnClickListener(this);
        this.azF.setOnClickListener(this);
    }

    private void bki() {
        if (this.aeR != null) {
            this.aeR.stopLoad();
        }
    }
}
