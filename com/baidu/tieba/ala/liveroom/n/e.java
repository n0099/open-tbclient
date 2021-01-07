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
/* loaded from: classes11.dex */
public class e extends a {
    private HeadImageView aGr;
    private TextView aZY;
    private View cDU;
    private TextView hFc;

    public e(@NonNull Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void init() {
        super.init();
        Hi();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void initView() {
        setContentView(a.g.ala_hor_guide_follow_float);
        this.cDU = findViewById(a.f.layout_root);
        this.cDU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.dismiss();
            }
        });
        this.aZY = (TextView) findViewById(a.f.tv_guide_folllow_tip);
        this.hFc = (TextView) findViewById(a.f.ala_live_name);
        this.aGr = (HeadImageView) findViewById(a.f.iv_avatar);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.aGr.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def_hk);
            this.aGr.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.aGr.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            this.aGr.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        }
        this.aGr.setIsRound(true);
        this.aGr.setAutoChangeStyle(false);
        this.aGr.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds4));
        this.aGr.setBorderColor(872415231);
        this.aGr.setScaleType(ImageView.ScaleType.CENTER_CROP);
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
                if (e.this.hEL != null) {
                    e.this.hEL.onConfirm();
                }
            }
        });
        this.hEM = textView.getText().toString();
        ciT();
    }

    @Override // com.baidu.tieba.ala.liveroom.n.a
    public void ez(String str, String str2) {
        ciS();
        this.aGr.startLoad(str, 25, false, false);
        this.hFc.setText(str2);
        Oj();
        show();
    }

    private void ciT() {
        bj bjVar;
        if (com.baidu.live.af.a.SE().bwi != null && (bjVar = com.baidu.live.af.a.SE().bwi.aOM) != null && !TextUtils.isEmpty(bjVar.aRj)) {
            this.aZY.setText(bjVar.aRj);
        }
    }

    private void Hi() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.n.e.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                e.this.ciS();
            }
        });
    }

    private void Oj() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        this.cDU.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciS() {
        if (this.aGr != null) {
            this.aGr.stopLoad();
        }
    }
}
