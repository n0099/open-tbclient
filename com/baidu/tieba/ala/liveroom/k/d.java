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
    private HeadImageView aAs;
    private ImageView baH;
    private TextView baI;
    private TextView baJ;
    private View byT;
    private a fHL;

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
        this.fHL = aVar;
    }

    public void show(String str) {
        bwj();
        this.aAs.startLoad(str, 25, false, false);
        show();
    }

    public String bwh() {
        return this.baI.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.byT || view == this.baH) {
            dismiss();
        } else if (this.fHL != null) {
            if (view == this.baI) {
                this.fHL.onConfirm();
            } else if (view == this.baJ) {
                this.fHL.onCancel();
            }
        }
    }

    private void init() {
        Dh();
        initView();
    }

    private void Dh() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            bwi();
        }
    }

    public void bwi() {
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
        this.byT = findViewById(a.g.layout_root);
        this.aAs = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aAs.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.aAs.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aAs.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.aAs.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.aAs.setIsRound(true);
        this.aAs.setAutoChangeStyle(false);
        this.aAs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.baI = (TextView) findViewById(a.g.tv_confirm);
        this.baJ = (TextView) findViewById(a.g.tv_cancel);
        this.baH = (ImageView) findViewById(a.g.iv_close);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.baI.setTextColor(colorStateList);
        this.byT.setOnClickListener(this);
        this.baI.setOnClickListener(this);
        this.baJ.setOnClickListener(this);
        this.baH.setOnClickListener(this);
    }

    private void bwj() {
        if (this.aAs != null) {
            this.aAs.stopLoad();
        }
    }
}
