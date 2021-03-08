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
/* loaded from: classes10.dex */
public class f extends a {
    private HeadImageView aER;
    private TextView aZT;
    private View cDe;
    private TextView hGD;

    public f(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.liveroom.l.a
    public void init() {
        super.init();
        EG();
    }

    @Override // com.baidu.tieba.ala.liveroom.l.a
    public void initView() {
        setContentView(a.g.ala_ver_guide_follow_float);
        this.cDe = findViewById(a.f.layout_root);
        this.cDe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
        this.aZT = (TextView) findViewById(a.f.tv_guide_folllow_tip);
        this.aER = (HeadImageView) findViewById(a.f.iv_avatar);
        this.hGD = (TextView) findViewById(a.f.ala_live_name);
        this.aER.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.aER.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.aER.setIsRound(true);
        this.aER.setAutoChangeStyle(false);
        this.aER.setDrawBorder(false);
        this.aER.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) findViewById(a.f.tv_confirm);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hGm != null) {
                    f.this.hGm.onConfirm();
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
        if (com.baidu.live.ae.a.Qm().bwx != null && com.baidu.live.ae.a.Qm().bwx.aOm == null) {
        }
    }

    private void EG() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.l.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.cgg();
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
