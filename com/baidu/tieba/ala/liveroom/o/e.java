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
import com.baidu.live.data.bg;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class e extends a {
    private HeadImageView aFf;
    private TextView aWS;
    private View ctR;
    private TextView hjZ;

    public e(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void init() {
        super.init();
        GB();
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void initView() {
        setContentView(a.g.ala_hor_guide_follow_float);
        this.ctR = findViewById(a.f.layout_root);
        this.ctR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
            }
        });
        this.aWS = (TextView) findViewById(a.f.tv_guide_folllow_tip);
        this.hjZ = (TextView) findViewById(a.f.ala_live_name);
        this.aFf = (HeadImageView) findViewById(a.f.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aFf.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.aFf.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aFf.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.aFf.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.aFf.setIsRound(true);
        this.aFf.setAutoChangeStyle(false);
        this.aFf.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.aFf.setBorderColor(872415231);
        this.aFf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) findViewById(a.f.tv_confirm);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            textView.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_16_selector_bd);
        } else {
            textView.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.hjK != null) {
                    e.this.hjK.onConfirm();
                }
            }
        });
        this.hjL = textView.getText().toString();
        ccS();
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void eu(String str, String str2) {
        ccR();
        this.aFf.startLoad(str, 25, false, false);
        this.hjZ.setText(str2);
        MR();
        show();
    }

    private void ccS() {
        bg bgVar;
        if (com.baidu.live.aa.a.PQ().bod != null && (bgVar = com.baidu.live.aa.a.PQ().bod.aMV) != null && !TextUtils.isEmpty(bgVar.aPg)) {
            this.aWS.setText(bgVar.aPg);
        }
    }

    private void GB() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.o.e.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                e.this.ccR();
            }
        });
    }

    private void MR() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.ctR.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccR() {
        if (this.aFf != null) {
            this.aFf.stopLoad();
        }
    }
}
