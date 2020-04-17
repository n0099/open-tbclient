package com.baidu.tieba.ala.liveroom.challenge.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ae;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
/* loaded from: classes3.dex */
public class ChallengeJinzhuView extends FrameLayout {
    private final int eNG;
    private final int fDZ;
    private final int fEa;
    private final int fEb;
    private final int fEc;
    private HeadImageView fEd;
    private ImageView fEe;
    private TextView fEf;
    private ae fEg;
    private boolean fEh;
    private boolean fEi;
    private FrameLayout.LayoutParams fEj;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.fDZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fEa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.fEb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.eNG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.fEc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.fEh = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fDZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fEa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.fEb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.eNG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.fEc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.fEh = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fDZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fEa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.fEb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.eNG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.fEc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.fEh = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.fEd = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.fEd.setIsRound(true);
        this.fEd.setAutoChangeStyle(false);
        this.fEd.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.fEd.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.fEd.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fEd.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fEd.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.fEe = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.fEf = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
    }

    public void a(boolean z, ae aeVar, final String str) {
        if (aeVar == null) {
            if (!this.fEi || this.fEh != z) {
                D(true, false);
                this.fEh = z;
                this.fEi = true;
                k.a(this.fEd, " ", false, false);
                this.fEf.setText(a.i.ala_challenge_jinzhu_def_tip);
                this.fEe.setVisibility(0);
                if (z) {
                    this.fEf.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    this.fEe.setImageResource(a.f.pic_live_pk_frameorange);
                } else {
                    this.fEf.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    this.fEe.setImageResource(a.f.pic_live_pk_framepurple);
                }
                this.fEf.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds16));
            }
        } else if (aeVar.aue != null) {
            boolean z2 = z && aeVar.a(this.fEg);
            this.fEh = z2;
            if (!z2) {
                this.fEi = false;
                if (aeVar.aue != null) {
                    k.a(this.fEd, aeVar.aue.portrait, false, false);
                }
                this.fEg = aeVar;
                this.fEh = z;
                if (aeVar.vb()) {
                    D(false, true);
                    this.fEf.setText((CharSequence) null);
                    this.fEf.setBackgroundResource(a.f.icon_live_pkmvp);
                    this.fEe.setVisibility(0);
                    this.fEe.setImageResource(a.f.pic_live_pk_framemvp);
                } else {
                    D(false, false);
                    this.fEf.setText("" + aeVar.rank);
                    this.fEf.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds18));
                    if (z) {
                        this.fEf.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    } else {
                        this.fEf.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    }
                    if (aeVar.isFirst()) {
                        this.fEe.setVisibility(0);
                        if (z) {
                            this.fEe.setImageResource(a.f.pic_live_pk_frameorange);
                        } else {
                            this.fEe.setImageResource(a.f.pic_live_pk_framepurple);
                        }
                    } else {
                        this.fEe.setVisibility(8);
                    }
                }
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ChallengeJinzhuView.this.fEi && ChallengeJinzhuView.this.fEg != null && ChallengeJinzhuView.this.fEg.aue != null) {
                            AlaLiveUserInfoData alaLiveUserInfoData = ChallengeJinzhuView.this.fEg.aue;
                            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(ChallengeJinzhuView.this.getContext(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, str, false, null, null, alaLiveUserInfoData.userName, "");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        }
                    }
                });
            }
        }
    }

    private void D(boolean z, boolean z2) {
        if (z) {
            this.fEj = (FrameLayout.LayoutParams) this.fEf.getLayoutParams();
            this.fEj.width = -2;
            this.fEj.height = this.fEc;
            this.fEf.setLayoutParams(this.fEj);
            this.fEf.setPadding(this.fDZ, 0, this.fDZ, 0);
            return;
        }
        this.fEj = (FrameLayout.LayoutParams) this.fEf.getLayoutParams();
        this.fEj.width = z2 ? this.fEb : -2;
        this.fEj.height = this.eNG;
        this.fEf.setLayoutParams(this.fEj);
        if (z2) {
            this.fEf.setPadding(0, 0, 0, 0);
        } else {
            this.fEf.setPadding(this.fEa, 0, this.fEa, 0);
        }
    }
}
