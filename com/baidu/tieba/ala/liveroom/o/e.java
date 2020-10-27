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
import com.baidu.live.data.be;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class e extends a {
    private HeadImageView aEp;
    private TextView aVA;
    private View cnT;
    private TextView hed;

    public e(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void init() {
        super.init();
        Ga();
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void initView() {
        setContentView(a.h.ala_hor_guide_follow_float);
        this.cnT = findViewById(a.g.layout_root);
        this.cnT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
            }
        });
        this.aVA = (TextView) findViewById(a.g.tv_guide_folllow_tip);
        this.hed = (TextView) findViewById(a.g.ala_live_name);
        this.aEp = (HeadImageView) findViewById(a.g.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aEp.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.aEp.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aEp.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.aEp.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.aEp.setIsRound(true);
        this.aEp.setAutoChangeStyle(false);
        this.aEp.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds4));
        this.aEp.setBorderColor(872415231);
        this.aEp.setScaleType(ImageView.ScaleType.CENTER_CROP);
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
                if (e.this.hdO != null) {
                    e.this.hdO.onConfirm();
                }
            }
        });
        this.hdP = textView.getText().toString();
        car();
    }

    @Override // com.baidu.tieba.ala.liveroom.o.a
    public void eu(String str, String str2) {
        caq();
        this.aEp.startLoad(str, 25, false, false);
        this.hed.setText(str2);
        Mr();
        show();
    }

    private void car() {
        be beVar;
        if (com.baidu.live.z.a.Pq().bmJ != null && (beVar = com.baidu.live.z.a.Pq().bmJ.aLV) != null && !TextUtils.isEmpty(beVar.aOd)) {
            this.aVA.setText(beVar.aOd);
        }
    }

    private void Ga() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.o.e.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                e.this.caq();
            }
        });
    }

    private void Mr() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.cnT.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caq() {
        if (this.aEp != null) {
            this.aEp.stopLoad();
        }
    }
}
