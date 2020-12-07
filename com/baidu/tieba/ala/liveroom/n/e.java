package com.baidu.tieba.ala.liveroom.n;

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
import com.baidu.live.data.bh;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class e extends a {
    private HeadImageView aGa;
    private TextView aYs;
    private View czb;
    private TextView hte;

    public e(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void init() {
        super.init();
        HH();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void initView() {
        setContentView(a.g.ala_hor_guide_follow_float);
        this.czb = findViewById(a.f.layout_root);
        this.czb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
            }
        });
        this.aYs = (TextView) findViewById(a.f.tv_guide_folllow_tip);
        this.hte = (TextView) findViewById(a.f.ala_live_name);
        this.aGa = (HeadImageView) findViewById(a.f.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aGa.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.aGa.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aGa.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.aGa.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.aGa.setIsRound(true);
        this.aGa.setAutoChangeStyle(false);
        this.aGa.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.aGa.setBorderColor(872415231);
        this.aGa.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TextView textView = (TextView) findViewById(a.f.tv_confirm);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            textView.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector_hk);
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            textView.setBackgroundResource(a.e.ala_live_room_follow_btn_radius_16_selector_bd);
        } else {
            textView.setBackgroundResource(a.e.ala_live_follow_btn_radius_16_selector);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.hsO != null) {
                    e.this.hsO.onConfirm();
                }
            }
        });
        this.hsP = textView.getText().toString();
        cgd();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void eA(String str, String str2) {
        cgc();
        this.aGa.startLoad(str, 25, false, false);
        this.hte.setText(str2);
        OD();
        show();
    }

    private void cgd() {
        bh bhVar;
        if (com.baidu.live.ae.a.RB().brA != null && (bhVar = com.baidu.live.ae.a.RB().brA.aOf) != null && !TextUtils.isEmpty(bhVar.aQu)) {
            this.aYs.setText(bhVar.aQu);
        }
    }

    private void HH() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.n.e.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                e.this.cgc();
            }
        });
    }

    private void OD() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.czb.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgc() {
        if (this.aGa != null) {
            this.aGa.stopLoad();
        }
    }
}
