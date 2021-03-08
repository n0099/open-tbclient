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
/* loaded from: classes10.dex */
public class d extends Dialog implements View.OnClickListener {
    private HeadImageView aER;
    private TextView bUM;
    private TextView bUN;
    private View cDe;
    private a hGC;

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
        this.hGC = aVar;
    }

    public void FX(String str) {
        cgg();
        this.aER.startLoad(str, 25, false, false);
        show();
    }

    public String cfY() {
        return this.bUM.getText().toString();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cDe) {
            dismiss();
        } else if (this.hGC != null) {
            if (view == this.bUM) {
                this.hGC.onConfirm();
            } else if (view == this.bUN) {
                this.hGC.onCancel();
            }
        }
    }

    public final void init() {
        Hi();
        initView();
    }

    private void Hi() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            cfX();
        }
    }

    public void cfX() {
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
        this.cDe = findViewById(a.f.layout_root);
        this.aER = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aER.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.aER.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.aER.setIsRound(true);
        this.aER.setAutoChangeStyle(false);
        this.aER.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aER.setBorderWidth(getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds4));
        this.aER.setBorderColor(getContext().getResources().getColor(a.c.sdk_cp_cont_g));
        this.bUM = (TextView) findViewById(a.f.tv_confirm);
        this.bUN = (TextView) findViewById(a.f.tv_cancel);
        this.cDe.setOnClickListener(this);
        this.bUM.setOnClickListener(this);
        this.bUN.setOnClickListener(this);
    }

    private void cgg() {
        if (this.aER != null) {
            this.aER.stopLoad();
        }
    }
}
