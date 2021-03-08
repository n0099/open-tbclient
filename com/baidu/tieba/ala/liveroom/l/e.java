package com.baidu.tieba.ala.liveroom.l;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bo;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes10.dex */
public class e extends a {
    private HeadImageView aER;
    private TextView aZT;
    private View cDe;
    private TextView hGD;

    public e(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.liveroom.l.a
    public void init() {
        super.init();
        EG();
    }

    @Override // com.baidu.tieba.ala.liveroom.l.a
    public void initView() {
        setContentView(a.g.ala_hor_guide_follow_float);
        this.cDe = findViewById(a.f.layout_root);
        this.cDe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
            }
        });
        this.aZT = (TextView) findViewById(a.f.tv_guide_folllow_tip);
        this.hGD = (TextView) findViewById(a.f.ala_live_name);
        this.aER = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aER.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.aER.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.aER.setIsRound(true);
        this.aER.setAutoChangeStyle(false);
        this.aER.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.aER.setBorderColor(872415231);
        this.aER.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) findViewById(a.f.tv_confirm);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.hGm != null) {
                    e.this.hGm.onConfirm();
                }
            }
        });
        this.hGn = textView.getText().toString();
        cgh();
    }

    @Override // com.baidu.tieba.ala.liveroom.l.a
    public void ex(String str, String str2) {
        cgg();
        this.aER.startLoad(str, 25, false, false);
        this.hGD.setText(str2);
        LQ();
        show();
    }

    private void cgh() {
        bo boVar;
        if (com.baidu.live.ae.a.Qm().bwx != null && (boVar = com.baidu.live.ae.a.Qm().bwx.aOm) != null && !TextUtils.isEmpty(boVar.aQU)) {
            this.aZT.setText(boVar.aQU);
        }
    }

    private void EG() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.l.e.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                e.this.cgg();
            }
        });
    }

    private void LQ() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.cDe.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgg() {
        if (this.aER != null) {
            this.aER.stopLoad();
        }
    }
}
