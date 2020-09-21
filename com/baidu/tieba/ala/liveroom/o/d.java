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
    private HeadImageView aBc;
    private View bTg;
    private ImageView bwD;
    private TextView bwE;
    private TextView bwF;
    private a gDW;

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
        this.gDW = aVar;
    }

    public void EO(String str) {
        bTZ();
        this.aBc.startLoad(str, 25, false, false);
        show();
    }

    public String bTW() {
        return this.bwE.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bTg || view == this.bwD) {
            dismiss();
        } else if (this.gDW != null) {
            if (view == this.bwE) {
                this.gDW.onConfirm();
            } else if (view == this.bwF) {
                this.gDW.onCancel();
            }
        }
    }

    private void init() {
        Nb();
        initView();
    }

    private void Nb() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            bTX();
        }
    }

    public void bTX() {
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
        this.bTg = findViewById(a.g.layout_root);
        this.aBc = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aBc.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.aBc.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aBc.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.aBc.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.aBc.setIsRound(true);
        this.aBc.setAutoChangeStyle(false);
        this.aBc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bwE = (TextView) findViewById(a.g.tv_confirm);
        this.bwF = (TextView) findViewById(a.g.tv_cancel);
        this.bwD = (ImageView) findViewById(a.g.iv_close);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.bwE.setTextColor(colorStateList);
        this.bTg.setOnClickListener(this);
        this.bwE.setOnClickListener(this);
        this.bwF.setOnClickListener(this);
        this.bwD.setOnClickListener(this);
    }

    private void bTZ() {
        if (this.aBc != null) {
            this.aBc.stopLoad();
        }
    }
}
