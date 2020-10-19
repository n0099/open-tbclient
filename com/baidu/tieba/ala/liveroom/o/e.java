package com.baidu.tieba.ala.liveroom.o;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bb;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class e extends a {
    private HeadImageView aEh;
    private TextView aUf;
    private View cfu;
    private TextView gSq;

    public e(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void init() {
        super.init();
        FL();
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void initView() {
        setContentView(a.h.ala_hor_guide_follow_float);
        this.cfu = findViewById(a.g.layout_root);
        this.cfu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
            }
        });
        this.aUf = (TextView) findViewById(a.g.tv_guide_folllow_tip);
        this.gSq = (TextView) findViewById(a.g.ala_live_name);
        this.aEh = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aEh.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.aEh.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aEh.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.aEh.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.aEh.setIsRound(true);
        this.aEh.setAutoChangeStyle(false);
        this.aEh.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.aEh.setBorderColor(872415231);
        this.aEh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) findViewById(a.g.tv_confirm);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_16_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.f.ala_live_room_follow_btn_radius_16_selector_bd);
        } else {
            textView.setBackgroundResource(a.f.ala_live_follow_btn_radius_16_selector);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.gSb != null) {
                    e.this.gSb.onConfirm();
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
        bb bbVar;
        if (com.baidu.live.x.a.OS().blo != null && (bbVar = com.baidu.live.x.a.OS().blo.aLr) != null && !TextUtils.isEmpty(bbVar.aNy)) {
            this.aUf.setText(bbVar.aNy);
        }
    }

    private void FL() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.o.e.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                e.this.bXr();
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
