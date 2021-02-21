package com.baidu.tieba.ala.liveroom.l;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes11.dex */
public class d extends Dialog implements View.OnClickListener {
    private HeadImageView aDr;
    private TextView bTm;
    private TextView bTn;
    private View cBE;
    private a hET;

    /* loaded from: classes11.dex */
    public interface a {
        void onCancel();

        void onConfirm();
    }

    public d(@NonNull Context context) {
        super(context, a.i.sdk_dialog_window);
        init();
    }

    public void a(a aVar) {
        this.hET = aVar;
    }

    public void FO(String str) {
        cga();
        this.aDr.startLoad(str, 25, false, false);
        show();
    }

    public String cfS() {
        return this.bTm.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cBE) {
            dismiss();
        } else if (this.hET != null) {
            if (view == this.bTm) {
                this.hET.onConfirm();
            } else if (view == this.bTn) {
                this.hET.onCancel();
            }
        }
    }

    public final void init() {
        Hf();
        initView();
    }

    private void Hf() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            cfR();
        }
    }

    public void cfR() {
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
        setContentView(a.g.ala_guide_follow_pop);
        this.cBE = findViewById(a.f.layout_root);
        this.aDr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aDr.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.aDr.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.aDr.setIsRound(true);
        this.aDr.setAutoChangeStyle(false);
        this.aDr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aDr.setBorderWidth(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.aDr.setBorderColor(getContext().getResources().getColor(a.c.sdk_cp_cont_g));
        this.bTm = (TextView) findViewById(a.f.tv_confirm);
        this.bTn = (TextView) findViewById(a.f.tv_cancel);
        this.cBE.setOnClickListener(this);
        this.bTm.setOnClickListener(this);
        this.bTn.setOnClickListener(this);
    }

    private void cga() {
        if (this.aDr != null) {
            this.aDr.stopLoad();
        }
    }
}
