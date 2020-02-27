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
    private static final int aqE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
    private static final int aqF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
    private static final int eZa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
    private static final int eZb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
    private static final int eZc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
    private HeadImageView eZd;
    private ImageView eZe;
    private TextView eZf;
    private ab eZg;
    private boolean eZh;
    private boolean eZi;
    private FrameLayout.LayoutParams eZj;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.eZh = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eZh = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eZh = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.eZd = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.eZd.setIsRound(true);
        this.eZd.setAutoChangeStyle(false);
        this.eZd.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.eZd.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.eZd.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eZd.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eZd.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.eZe = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.eZf = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
    }

    public void a(boolean z, ab abVar, final String str) {
        if (abVar == null) {
            if (!this.eZi || this.eZh != z) {
                D(true, false);
                this.eZh = z;
                this.eZi = true;
                k.a(this.eZd, HanziToPinyin.Token.SEPARATOR, false, false);
                this.eZf.setText(a.i.ala_challenge_jinzhu_def_tip);
                this.eZe.setVisibility(0);
                if (z) {
                    this.eZf.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    this.eZe.setImageResource(a.f.pic_live_pk_frameorange);
                } else {
                    this.eZf.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    this.eZe.setImageResource(a.f.pic_live_pk_framepurple);
                }
                this.eZf.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds16));
            }
        } else if (abVar.abx != null) {
            boolean z2 = z && abVar.a(this.eZg);
            this.eZh = z2;
            if (!z2) {
                this.eZi = false;
                if (abVar.abx != null) {
                    k.a(this.eZd, abVar.abx.portrait, false, false);
                }
                this.eZg = abVar;
                this.eZh = z;
                if (abVar.qF()) {
                    D(false, true);
                    this.eZf.setText((CharSequence) null);
                    this.eZf.setBackgroundResource(a.f.icon_live_pkmvp);
                    this.eZe.setVisibility(0);
                    this.eZe.setImageResource(a.f.pic_live_pk_framemvp);
                } else {
                    D(false, false);
                    this.eZf.setText("" + abVar.rank);
                    this.eZf.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds18));
                    if (z) {
                        this.eZf.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    } else {
                        this.eZf.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    }
                    if (abVar.isFirst()) {
                        this.eZe.setVisibility(0);
                        if (z) {
                            this.eZe.setImageResource(a.f.pic_live_pk_frameorange);
                        } else {
                            this.eZe.setImageResource(a.f.pic_live_pk_framepurple);
                        }
                    } else {
                        this.eZe.setVisibility(8);
                    }
                }
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ChallengeJinzhuView.this.eZi && ChallengeJinzhuView.this.eZg != null && ChallengeJinzhuView.this.eZg.abx != null) {
                            AlaLiveUserInfoData alaLiveUserInfoData = ChallengeJinzhuView.this.eZg.abx;
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
            this.eZj = (FrameLayout.LayoutParams) this.eZf.getLayoutParams();
            this.eZj.width = -2;
            this.eZj.height = eZc;
            this.eZf.setLayoutParams(this.eZj);
            this.eZf.setPadding(aqE, 0, aqE, 0);
            return;
        }
        this.eZj = (FrameLayout.LayoutParams) this.eZf.getLayoutParams();
        this.eZj.width = z2 ? eZa : -2;
        this.eZj.height = eZb;
        this.eZf.setLayoutParams(this.eZj);
        if (z2) {
            this.eZf.setPadding(0, 0, 0, 0);
        } else {
            this.eZf.setPadding(aqF, 0, aqF, 0);
        }
    }
}
