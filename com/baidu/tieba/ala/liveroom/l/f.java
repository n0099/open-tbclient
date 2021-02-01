package com.baidu.tieba.ala.liveroom.l;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes11.dex */
public class f extends a {
    private HeadImageView aDr;
    private TextView aYt;
    private View cBE;
    private TextView hEG;

    public f(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.liveroom.l.a
    public void init() {
        super.init();
        ED();
    }

    @Override // com.baidu.tieba.ala.liveroom.l.a
    public void initView() {
        setContentView(a.g.ala_ver_guide_follow_float);
        this.cBE = findViewById(a.f.layout_root);
        this.cBE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
        this.aYt = (TextView) findViewById(a.f.tv_guide_folllow_tip);
        this.aDr = (HeadImageView) findViewById(a.f.iv_avatar);
        this.hEG = (TextView) findViewById(a.f.ala_live_name);
        this.aDr.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.aDr.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.aDr.setIsRound(true);
        this.aDr.setAutoChangeStyle(false);
        this.aDr.setDrawBorder(false);
        this.aDr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) findViewById(a.f.tv_confirm);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hEp != null) {
                    f.this.hEp.onConfirm();
                }
            }
        });
        this.hEq = textView.getText().toString();
        cfU();
    }

    @Override // com.baidu.tieba.ala.liveroom.l.a
    public void ex(String str, String str2) {
        cfT();
        this.aDr.startLoad(str, 25, false, false);
        this.hEG.setText(str2);
        LN();
        show();
    }

    private void cfU() {
        if (com.baidu.live.ae.a.Qj().buX != null && com.baidu.live.ae.a.Qj().buX.aMM == null) {
        }
    }

    private void ED() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.l.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.cfT();
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
    public void cfT() {
        if (this.aDr != null) {
            this.aDr.stopLoad();
        }
    }
}
