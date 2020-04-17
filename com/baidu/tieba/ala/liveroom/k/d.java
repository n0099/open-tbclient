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
    private HeadImageView aAm;
    private ImageView baC;
    private TextView baD;
    private TextView baE;
    private View byO;
    private a fHG;

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
        this.fHG = aVar;
    }

    public void show(String str) {
        bwl();
        this.aAm.startLoad(str, 25, false, false);
        show();
    }

    public String bwj() {
        return this.baD.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.byO || view == this.baC) {
            dismiss();
        } else if (this.fHG != null) {
            if (view == this.baD) {
                this.fHG.onConfirm();
            } else if (view == this.baE) {
                this.fHG.onCancel();
            }
        }
    }

    private void init() {
        Di();
        initView();
    }

    private void Di() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            bwk();
        }
    }

    public void bwk() {
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
        this.byO = findViewById(a.g.layout_root);
        this.aAm = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aAm.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.aAm.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aAm.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.aAm.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.aAm.setIsRound(true);
        this.aAm.setAutoChangeStyle(false);
        this.aAm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.baD = (TextView) findViewById(a.g.tv_confirm);
        this.baE = (TextView) findViewById(a.g.tv_cancel);
        this.baC = (ImageView) findViewById(a.g.iv_close);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.baD.setTextColor(colorStateList);
        this.byO.setOnClickListener(this);
        this.baD.setOnClickListener(this);
        this.baE.setOnClickListener(this);
        this.baC.setOnClickListener(this);
    }

    private void bwl() {
        if (this.aAm != null) {
            this.aAm.stopLoad();
        }
    }
}
