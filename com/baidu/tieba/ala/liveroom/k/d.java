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
    private HeadImageView aFL;
    private View bGw;
    private ImageView bif;
    private TextView bih;
    private TextView bii;
    private a fVH;

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
        this.fVH = aVar;
    }

    public void show(String str) {
        bCj();
        this.aFL.startLoad(str, 25, false, false);
        show();
    }

    public String bCg() {
        return this.bih.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bGw || view == this.bif) {
            dismiss();
        } else if (this.fVH != null) {
            if (view == this.bih) {
                this.fVH.onConfirm();
            } else if (view == this.bii) {
                this.fVH.onCancel();
            }
        }
    }

    private void init() {
        EF();
        initView();
    }

    private void EF() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            bCh();
        }
    }

    public void bCh() {
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
        this.bGw = findViewById(a.g.layout_root);
        this.aFL = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aFL.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.aFL.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aFL.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.aFL.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.aFL.setIsRound(true);
        this.aFL.setAutoChangeStyle(false);
        this.aFL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bih = (TextView) findViewById(a.g.tv_confirm);
        this.bii = (TextView) findViewById(a.g.tv_cancel);
        this.bif = (ImageView) findViewById(a.g.iv_close);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.bih.setTextColor(colorStateList);
        this.bGw.setOnClickListener(this);
        this.bih.setOnClickListener(this);
        this.bii.setOnClickListener(this);
        this.bif.setOnClickListener(this);
    }

    private void bCj() {
        if (this.aFL != null) {
            this.aFL.stopLoad();
        }
    }
}
