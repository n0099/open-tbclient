package com.baidu.tieba.ala.liveroom.o;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class f extends a {
    private HeadImageView aDu;
    private TextView aVh;
    private View csf;
    private TextView hjG;

    public f(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void init() {
        super.init();
        FS();
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void initView() {
        setContentView(a.g.ala_ver_guide_follow_float);
        this.csf = findViewById(a.f.layout_root);
        this.csf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
        this.aVh = (TextView) findViewById(a.f.tv_guide_folllow_tip);
        this.aDu = (HeadImageView) findViewById(a.f.iv_avatar);
        this.hjG = (TextView) findViewById(a.f.ala_live_name);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aDu.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.aDu.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aDu.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.aDu.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.aDu.setIsRound(true);
        this.aDu.setAutoChangeStyle(false);
        this.aDu.setDrawBorder(false);
        this.aDu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) findViewById(a.f.tv_confirm);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            textView.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_16_selector_bd);
        } else {
            textView.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hjr != null) {
                    f.this.hjr.onConfirm();
                }
            }
        });
        this.hjs = textView.getText().toString();
        ccl();
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void eu(String str, String str2) {
        cck();
        this.aDu.startLoad(str, 25, false, false);
        this.hjG.setText(str2);
        Mi();
        show();
    }

    private void ccl() {
        if (com.baidu.live.aa.a.Ph().bms != null && com.baidu.live.aa.a.Ph().bms.aLk == null) {
        }
    }

    private void FS() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.o.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.cck();
            }
        });
    }

    private void Mi() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.csf.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cck() {
        if (this.aDu != null) {
            this.aDu.stopLoad();
        }
    }
}
