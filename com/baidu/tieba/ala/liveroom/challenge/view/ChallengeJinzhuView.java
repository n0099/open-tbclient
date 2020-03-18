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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
/* loaded from: classes3.dex */
public class ChallengeJinzhuView extends FrameLayout {
    private static final int aqP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
    private static final int aqQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
    private static final int eZM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
    private static final int eZN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
    private static final int eZO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
    private HeadImageView eZP;
    private ImageView eZQ;
    private TextView eZR;
    private ab eZS;
    private boolean eZT;
    private boolean eZU;
    private FrameLayout.LayoutParams eZV;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.eZT = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eZT = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eZT = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.eZP = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.eZP.setIsRound(true);
        this.eZP.setAutoChangeStyle(false);
        this.eZP.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.eZP.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.eZP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eZP.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eZP.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.eZQ = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.eZR = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
    }

    public void a(boolean z, ab abVar, final String str) {
        if (abVar == null) {
            if (!this.eZU || this.eZT != z) {
                E(true, false);
                this.eZT = z;
                this.eZU = true;
                k.a(this.eZP, HanziToPinyin.Token.SEPARATOR, false, false);
                this.eZR.setText(a.i.ala_challenge_jinzhu_def_tip);
                this.eZQ.setVisibility(0);
                if (z) {
                    this.eZR.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    this.eZQ.setImageResource(a.f.pic_live_pk_frameorange);
                } else {
                    this.eZR.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    this.eZQ.setImageResource(a.f.pic_live_pk_framepurple);
                }
                this.eZR.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds16));
            }
        } else if (abVar.abH != null) {
            boolean z2 = z && abVar.a(this.eZS);
            this.eZT = z2;
            if (!z2) {
                this.eZU = false;
                if (abVar.abH != null) {
                    k.a(this.eZP, abVar.abH.portrait, false, false);
                }
                this.eZS = abVar;
                this.eZT = z;
                if (abVar.qK()) {
                    E(false, true);
                    this.eZR.setText((CharSequence) null);
                    this.eZR.setBackgroundResource(a.f.icon_live_pkmvp);
                    this.eZQ.setVisibility(0);
                    this.eZQ.setImageResource(a.f.pic_live_pk_framemvp);
                } else {
                    E(false, false);
                    this.eZR.setText("" + abVar.rank);
                    this.eZR.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds18));
                    if (z) {
                        this.eZR.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    } else {
                        this.eZR.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    }
                    if (abVar.isFirst()) {
                        this.eZQ.setVisibility(0);
                        if (z) {
                            this.eZQ.setImageResource(a.f.pic_live_pk_frameorange);
                        } else {
                            this.eZQ.setImageResource(a.f.pic_live_pk_framepurple);
                        }
                    } else {
                        this.eZQ.setVisibility(8);
                    }
                }
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ChallengeJinzhuView.this.eZU && ChallengeJinzhuView.this.eZS != null && ChallengeJinzhuView.this.eZS.abH != null) {
                            AlaLiveUserInfoData alaLiveUserInfoData = ChallengeJinzhuView.this.eZS.abH;
                            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(ChallengeJinzhuView.this.getContext(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, str, false, null, null, alaLiveUserInfoData.userName, "");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        }
                    }
                });
            }
        }
    }

    private void E(boolean z, boolean z2) {
        if (z) {
            this.eZV = (FrameLayout.LayoutParams) this.eZR.getLayoutParams();
            this.eZV.width = -2;
            this.eZV.height = eZO;
            this.eZR.setLayoutParams(this.eZV);
            this.eZR.setPadding(aqP, 0, aqP, 0);
            return;
        }
        this.eZV = (FrameLayout.LayoutParams) this.eZR.getLayoutParams();
        this.eZV.width = z2 ? eZM : -2;
        this.eZV.height = eZN;
        this.eZR.setLayoutParams(this.eZV);
        if (z2) {
            this.eZR.setPadding(0, 0, 0, 0);
        } else {
            this.eZR.setPadding(aqQ, 0, aqQ, 0);
        }
    }
}
