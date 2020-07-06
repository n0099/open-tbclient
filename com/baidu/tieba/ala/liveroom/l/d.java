package com.baidu.tieba.ala.liveroom.l;

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
/* loaded from: classes3.dex */
public class d extends Dialog implements View.OnClickListener {
    private HeadImageView aIh;
    private View bLk;
    private ImageView bnl;
    private TextView bnm;
    private TextView bnn;
    private a giP;

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
        this.giP = aVar;
    }

    public void show(String str) {
        bFs();
        this.aIh.startLoad(str, 25, false, false);
        show();
    }

    public String bFp() {
        return this.bnm.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bLk || view == this.bnl) {
            dismiss();
        } else if (this.giP != null) {
            if (view == this.bnm) {
                this.giP.onConfirm();
            } else if (view == this.bnn) {
                this.giP.onCancel();
            }
        }
    }

    private void init() {
        Fj();
        initView();
    }

    private void Fj() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            bFq();
        }
    }

    public void bFq() {
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
        this.bLk = findViewById(a.g.layout_root);
        this.aIh = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aIh.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.aIh.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aIh.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.aIh.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.aIh.setIsRound(true);
        this.aIh.setAutoChangeStyle(false);
        this.aIh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bnm = (TextView) findViewById(a.g.tv_confirm);
        this.bnn = (TextView) findViewById(a.g.tv_cancel);
        this.bnl = (ImageView) findViewById(a.g.iv_close);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s_shoubai);
        } else {
            colorStateList = getContext().getResources().getColorStateList(a.f.ala_live_custom_dialog_btn_text_color_s);
        }
        this.bnm.setTextColor(colorStateList);
        this.bLk.setOnClickListener(this);
        this.bnm.setOnClickListener(this);
        this.bnn.setOnClickListener(this);
        this.bnl.setOnClickListener(this);
    }

    private void bFs() {
        if (this.aIh != null) {
            this.aIh.stopLoad();
        }
    }
}
