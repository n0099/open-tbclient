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
    private static final int aqF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
    private static final int aqG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
    private static final int eZo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
    private static final int eZp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
    private static final int eZq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
    private HeadImageView eZr;
    private ImageView eZs;
    private TextView eZt;
    private ab eZu;
    private boolean eZv;
    private boolean eZw;
    private FrameLayout.LayoutParams eZx;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.eZv = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eZv = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eZv = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.eZr = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.eZr.setIsRound(true);
        this.eZr.setAutoChangeStyle(false);
        this.eZr.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.eZr.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.eZr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eZr.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eZr.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.eZs = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.eZt = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
    }

    public void a(boolean z, ab abVar, final String str) {
        if (abVar == null) {
            if (!this.eZw || this.eZv != z) {
                E(true, false);
                this.eZv = z;
                this.eZw = true;
                k.a(this.eZr, HanziToPinyin.Token.SEPARATOR, false, false);
                this.eZt.setText(a.i.ala_challenge_jinzhu_def_tip);
                this.eZs.setVisibility(0);
                if (z) {
                    this.eZt.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    this.eZs.setImageResource(a.f.pic_live_pk_frameorange);
                } else {
                    this.eZt.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    this.eZs.setImageResource(a.f.pic_live_pk_framepurple);
                }
                this.eZt.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds16));
            }
        } else if (abVar.abx != null) {
            boolean z2 = z && abVar.a(this.eZu);
            this.eZv = z2;
            if (!z2) {
                this.eZw = false;
                if (abVar.abx != null) {
                    k.a(this.eZr, abVar.abx.portrait, false, false);
                }
                this.eZu = abVar;
                this.eZv = z;
                if (abVar.qF()) {
                    E(false, true);
                    this.eZt.setText((CharSequence) null);
                    this.eZt.setBackgroundResource(a.f.icon_live_pkmvp);
                    this.eZs.setVisibility(0);
                    this.eZs.setImageResource(a.f.pic_live_pk_framemvp);
                } else {
                    E(false, false);
                    this.eZt.setText("" + abVar.rank);
                    this.eZt.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds18));
                    if (z) {
                        this.eZt.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    } else {
                        this.eZt.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    }
                    if (abVar.isFirst()) {
                        this.eZs.setVisibility(0);
                        if (z) {
                            this.eZs.setImageResource(a.f.pic_live_pk_frameorange);
                        } else {
                            this.eZs.setImageResource(a.f.pic_live_pk_framepurple);
                        }
                    } else {
                        this.eZs.setVisibility(8);
                    }
                }
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ChallengeJinzhuView.this.eZw && ChallengeJinzhuView.this.eZu != null && ChallengeJinzhuView.this.eZu.abx != null) {
                            AlaLiveUserInfoData alaLiveUserInfoData = ChallengeJinzhuView.this.eZu.abx;
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
            this.eZx = (FrameLayout.LayoutParams) this.eZt.getLayoutParams();
            this.eZx.width = -2;
            this.eZx.height = eZq;
            this.eZt.setLayoutParams(this.eZx);
            this.eZt.setPadding(aqF, 0, aqF, 0);
            return;
        }
        this.eZx = (FrameLayout.LayoutParams) this.eZt.getLayoutParams();
        this.eZx.width = z2 ? eZo : -2;
        this.eZx.height = eZp;
        this.eZt.setLayoutParams(this.eZx);
        if (z2) {
            this.eZt.setPadding(0, 0, 0, 0);
        } else {
            this.eZt.setPadding(aqG, 0, aqG, 0);
        }
    }
}
