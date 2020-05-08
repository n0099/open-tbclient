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
    private final int eNL;
    private final int fEe;
    private final int fEf;
    private final int fEg;
    private final int fEh;
    private HeadImageView fEi;
    private ImageView fEj;
    private TextView fEk;
    private ae fEl;
    private boolean fEm;
    private boolean fEn;
    private FrameLayout.LayoutParams fEo;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.fEe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fEf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.fEg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.eNL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.fEh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.fEm = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fEf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.fEg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.eNL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.fEh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.fEm = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fEf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.fEg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.eNL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.fEh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.fEm = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.fEi = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.fEi.setIsRound(true);
        this.fEi.setAutoChangeStyle(false);
        this.fEi.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.fEi.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.fEi.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fEi.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fEi.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.fEj = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.fEk = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
    }

    public void a(boolean z, ae aeVar, final String str) {
        if (aeVar == null) {
            if (!this.fEn || this.fEm != z) {
                D(true, false);
                this.fEm = z;
                this.fEn = true;
                k.a(this.fEi, " ", false, false);
                this.fEk.setText(a.i.ala_challenge_jinzhu_def_tip);
                this.fEj.setVisibility(0);
                if (z) {
                    this.fEk.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    this.fEj.setImageResource(a.f.pic_live_pk_frameorange);
                } else {
                    this.fEk.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    this.fEj.setImageResource(a.f.pic_live_pk_framepurple);
                }
                this.fEk.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds16));
            }
        } else if (aeVar.auk != null) {
            boolean z2 = z && aeVar.a(this.fEl);
            this.fEm = z2;
            if (!z2) {
                this.fEn = false;
                if (aeVar.auk != null) {
                    k.a(this.fEi, aeVar.auk.portrait, false, false);
                }
                this.fEl = aeVar;
                this.fEm = z;
                if (aeVar.va()) {
                    D(false, true);
                    this.fEk.setText((CharSequence) null);
                    this.fEk.setBackgroundResource(a.f.icon_live_pkmvp);
                    this.fEj.setVisibility(0);
                    this.fEj.setImageResource(a.f.pic_live_pk_framemvp);
                } else {
                    D(false, false);
                    this.fEk.setText("" + aeVar.rank);
                    this.fEk.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds18));
                    if (z) {
                        this.fEk.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    } else {
                        this.fEk.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    }
                    if (aeVar.isFirst()) {
                        this.fEj.setVisibility(0);
                        if (z) {
                            this.fEj.setImageResource(a.f.pic_live_pk_frameorange);
                        } else {
                            this.fEj.setImageResource(a.f.pic_live_pk_framepurple);
                        }
                    } else {
                        this.fEj.setVisibility(8);
                    }
                }
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ChallengeJinzhuView.this.fEn && ChallengeJinzhuView.this.fEl != null && ChallengeJinzhuView.this.fEl.auk != null) {
                            AlaLiveUserInfoData alaLiveUserInfoData = ChallengeJinzhuView.this.fEl.auk;
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
            this.fEo = (FrameLayout.LayoutParams) this.fEk.getLayoutParams();
            this.fEo.width = -2;
            this.fEo.height = this.fEh;
            this.fEk.setLayoutParams(this.fEo);
            this.fEk.setPadding(this.fEe, 0, this.fEe, 0);
            return;
        }
        this.fEo = (FrameLayout.LayoutParams) this.fEk.getLayoutParams();
        this.fEo.width = z2 ? this.fEg : -2;
        this.fEo.height = this.eNL;
        this.fEk.setLayoutParams(this.fEo);
        if (z2) {
            this.fEk.setPadding(0, 0, 0, 0);
        } else {
            this.fEk.setPadding(this.fEf, 0, this.fEf, 0);
        }
    }
}
