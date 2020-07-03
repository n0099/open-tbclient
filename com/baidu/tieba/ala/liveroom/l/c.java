package com.baidu.tieba.ala.liveroom.l;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.at;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes3.dex */
public class c extends Dialog {
    private HeadImageView aIh;
    private TextView aIj;
    private View bLk;
    private View cAZ;
    private a giM;
    private String giN;

    /* loaded from: classes3.dex */
    public interface a {
        void onConfirm();
    }

    public c(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
        init();
    }

    public void a(a aVar) {
        this.giM = aVar;
    }

    public void show(String str) {
        bFr();
        this.aIh.startLoad(str, 25, false, false);
        Ez();
        show();
    }

    public String bFo() {
        return this.giN;
    }

    private void init() {
        initView();
        Fj();
        yt();
    }

    private void Fj() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        bFp();
    }

    public void bFp() {
        show();
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            if (windowManager != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
                    attributes.width = displayMetrics.heightPixels;
                    window.setGravity(17);
                    this.cAZ.setBackgroundResource(a.f.sdk_black_radius20_alpha70);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(13);
                    layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(a.e.sdk_ds80);
                    this.cAZ.setLayoutParams(layoutParams);
                } else {
                    attributes.width = displayMetrics.widthPixels;
                    window.setGravity(80);
                    this.cAZ.setBackgroundResource(a.f.ala_bg_guide_follow_float);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams2.addRule(12);
                    this.cAZ.setLayoutParams(layoutParams2);
                }
                window.setAttributes(attributes);
            }
        }
    }

    private void initView() {
        setContentView(a.h.ala_guide_follow_float);
        this.bLk = findViewById(a.g.layout_root);
        this.bLk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
        this.cAZ = findViewById(a.g.layout_container);
        this.aIj = (TextView) findViewById(a.g.tv_guide_folllow_tip);
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
        this.aIh.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.aIh.setBorderColor(872415231);
        this.aIh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) findViewById(a.g.tv_confirm);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_20_selector_bd);
        } else {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.giM != null) {
                    c.this.giM.onConfirm();
                }
            }
        });
        this.giN = textView.getText().toString();
        bFq();
    }

    private void bFq() {
        at atVar;
        if (com.baidu.live.v.a.Hm().aZp != null && (atVar = com.baidu.live.v.a.Hm().aZp.aAy) != null && !TextUtils.isEmpty(atVar.aCw)) {
            this.aIj.setText(atVar.aCw);
        }
    }

    private void yt() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.l.c.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                c.this.bFr();
            }
        });
    }

    private void Ez() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.bLk.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFr() {
        if (this.aIh != null) {
            this.aIh.stopLoad();
        }
    }
}
