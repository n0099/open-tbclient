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
    private HeadImageView aEh;
    private TextView aUf;
    private View cfu;
    private TextView gSq;

    public f(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void init() {
        super.init();
        FL();
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void initView() {
        setContentView(a.h.ala_ver_guide_follow_float);
        this.cfu = findViewById(a.g.layout_root);
        this.cfu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
        this.aUf = (TextView) findViewById(a.g.tv_guide_folllow_tip);
        this.aEh = (HeadImageView) findViewById(a.g.iv_avatar);
        this.gSq = (TextView) findViewById(a.g.ala_live_name);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aEh.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.aEh.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aEh.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.aEh.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.aEh.setIsRound(true);
        this.aEh.setAutoChangeStyle(false);
        this.aEh.setDrawBorder(false);
        this.aEh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) findViewById(a.g.tv_confirm);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_16_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_16_selector_bd);
        } else {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_16_selector);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gSb != null) {
                    f.this.gSb.onConfirm();
                }
            }
        });
        this.gSc = textView.getText().toString();
        bXs();
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void en(String str, String str2) {
        bXr();
        this.aEh.startLoad(str, 25, false, false);
        this.gSq.setText(str2);
        LX();
        show();
    }

    private void bXs() {
        if (com.baidu.live.x.a.OS().blo != null && com.baidu.live.x.a.OS().blo.aLr == null) {
        }
    }

    private void FL() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.o.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.bXr();
            }
        });
    }

    private void LX() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.cfu.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXr() {
        if (this.aEh != null) {
            this.aEh.stopLoad();
        }
    }
}
