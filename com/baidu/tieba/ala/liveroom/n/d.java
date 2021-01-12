package com.baidu.tieba.ala.liveroom.n;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes10.dex */
public class d extends Dialog implements View.OnClickListener {
    private HeadImageView aBE;
    private TextView bPw;
    private TextView bPx;
    private View czi;
    private a hAv;

    /* loaded from: classes10.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public d(@NonNull Context context) {
        super(context, a.i.sdk_dialog_window);
        init();
    }

    public void a(a aVar) {
        this.hAv = aVar;
    }

    public void Fp(String str) {
        cfa();
        this.aBE.startLoad(str, 25, false, false);
        show();
    }

    public String ceS() {
        return this.bPw.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.czi) {
            dismiss();
        } else if (this.hAv != null) {
            if (view == this.bPw) {
                this.hAv.onConfirm();
            } else if (view == this.bPx) {
                this.hAv.onCancel();
            }
        }
    }

    private void init() {
        FP();
        initView();
    }

    private void FP() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            ceR();
        }
    }

    public void ceR() {
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
        this.czi = findViewById(a.f.layout_root);
        this.aBE = (HeadImageView) findViewById(a.f.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aBE.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.aBE.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aBE.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.aBE.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.aBE.setIsRound(true);
        this.aBE.setAutoChangeStyle(false);
        this.aBE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aBE.setBorderWidth(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.aBE.setBorderColor(getContext().getResources().getColor(a.c.sdk_cp_cont_g));
        this.bPw = (TextView) findViewById(a.f.tv_confirm);
        this.bPx = (TextView) findViewById(a.f.tv_cancel);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.e.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.e.ala_live_custom_dialog_btn_text_color_s);
        }
        this.bPw.setTextColor(colorStateList);
        this.czi.setOnClickListener(this);
        this.bPw.setOnClickListener(this);
        this.bPx.setOnClickListener(this);
    }

    private void cfa() {
        if (this.aBE != null) {
            this.aBE.stopLoad();
        }
    }
}
