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
    private ImageView aEF;
    private TextView aEG;
    private TextView aEH;
    private View aZZ;
    private HeadImageView ahI;
    private a fcK;

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
        this.fcK = aVar;
    }

    public void show(String str) {
        bmM();
        this.ahI.startLoad(str, 25, false, false);
        show();
    }

    public String bmK() {
        return this.aEG.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aZZ || view == this.aEF) {
            dismiss();
        } else if (this.fcK != null) {
            if (view == this.aEG) {
                this.fcK.onConfirm();
            } else if (view == this.aEH) {
                this.fcK.onCancel();
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
            bmL();
        }
    }

    public void bmL() {
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
        this.aZZ = findViewById(a.g.layout_root);
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
        this.aEG = (TextView) findViewById(a.g.tv_confirm);
        this.aEH = (TextView) findViewById(a.g.tv_cancel);
        this.aEF = (ImageView) findViewById(a.g.iv_close);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.aEG.setTextColor(colorStateList);
        this.aZZ.setOnClickListener(this);
        this.aEG.setOnClickListener(this);
        this.aEH.setOnClickListener(this);
        this.aEF.setOnClickListener(this);
    }

    private void bmM() {
        if (this.ahI != null) {
            this.ahI.stopLoad();
        }
    }
}
