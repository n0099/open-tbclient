package com.baidu.tieba.ala.liveroom.n;

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
import com.baidu.live.data.bj;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes10.dex */
public class e extends a {
    private HeadImageView aBE;
    private TextView aVl;
    private View czi;
    private TextView hAw;

    public e(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void init() {
        super.init();
        Dn();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void initView() {
        setContentView(a.g.ala_hor_guide_follow_float);
        this.czi = findViewById(a.f.layout_root);
        this.czi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
            }
        });
        this.aVl = (TextView) findViewById(a.f.tv_guide_folllow_tip);
        this.hAw = (TextView) findViewById(a.f.ala_live_name);
        this.aBE = (HeadImageView) findViewById(a.f.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aBE.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.aBE.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aBE.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.aBE.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.aBE.setIsRound(true);
        this.aBE.setAutoChangeStyle(false);
        this.aBE.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.aBE.setBorderColor(872415231);
        this.aBE.setScaleType(ImageView.ScaleType.CENTER_CROP);
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
                if (e.this.hAf != null) {
                    e.this.hAf.onConfirm();
                }
            }
        });
        this.hAg = textView.getText().toString();
        cfb();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void ey(String str, String str2) {
        cfa();
        this.aBE.startLoad(str, 25, false, false);
        this.hAw.setText(str2);
        Ko();
        show();
    }

    private void cfb() {
        bj bjVar;
        if (com.baidu.live.af.a.OJ().bru != null && (bjVar = com.baidu.live.af.a.OJ().bru.aJZ) != null && !TextUtils.isEmpty(bjVar.aMw)) {
            this.aVl.setText(bjVar.aMw);
        }
    }

    private void Dn() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.n.e.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                e.this.cfa();
            }
        });
    }

    private void Ko() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.czi.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfa() {
        if (this.aBE != null) {
            this.aBE.stopLoad();
        }
    }
}
