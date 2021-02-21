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
/* loaded from: classes11.dex */
public class e extends a {
    private HeadImageView aDr;
    private TextView aYt;
    private View cBE;
    private TextView hEU;

    public e(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.liveroom.l.a
    public void init() {
        super.init();
        ED();
    }

    @Override // com.baidu.tieba.ala.liveroom.l.a
    public void initView() {
        setContentView(a.g.ala_hor_guide_follow_float);
        this.cBE = findViewById(a.f.layout_root);
        this.cBE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
            }
        });
        this.aYt = (TextView) findViewById(a.f.tv_guide_folllow_tip);
        this.hEU = (TextView) findViewById(a.f.ala_live_name);
        this.aDr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.aDr.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.aDr.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.aDr.setIsRound(true);
        this.aDr.setAutoChangeStyle(false);
        this.aDr.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.aDr.setBorderColor(872415231);
        this.aDr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) findViewById(a.f.tv_confirm);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.hED != null) {
                    e.this.hED.onConfirm();
                }
            }
        });
        this.hEE = textView.getText().toString();
        cgb();
    }

    @Override // com.baidu.tieba.ala.liveroom.l.a
    public void ex(String str, String str2) {
        cga();
        this.aDr.startLoad(str, 25, false, false);
        this.hEU.setText(str2);
        LN();
        show();
    }

    private void cgb() {
        bo boVar;
        if (com.baidu.live.ae.a.Qj().buX != null && (boVar = com.baidu.live.ae.a.Qj().buX.aMM) != null && !TextUtils.isEmpty(boVar.aPu)) {
            this.aYt.setText(boVar.aPu);
        }
    }

    private void ED() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.l.e.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                e.this.cga();
            }
        });
    }

    private void LN() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.cBE.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cga() {
        if (this.aDr != null) {
            this.aDr.stopLoad();
        }
    }
}
