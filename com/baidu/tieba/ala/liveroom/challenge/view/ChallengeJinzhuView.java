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
    private static final int eZb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
    private static final int eZc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
    private static final int eZd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
    private HeadImageView eZe;
    private ImageView eZf;
    private TextView eZg;
    private ab eZh;
    private boolean eZi;
    private boolean eZj;
    private FrameLayout.LayoutParams eZk;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.eZi = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eZi = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eZi = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.eZe = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.eZe.setIsRound(true);
        this.eZe.setAutoChangeStyle(false);
        this.eZe.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.eZe.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.eZe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eZe.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eZe.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.eZf = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.eZg = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
    }

    public void a(boolean z, ab abVar, final String str) {
        if (abVar == null) {
            if (!this.eZj || this.eZi != z) {
                D(true, false);
                this.eZi = z;
                this.eZj = true;
                k.a(this.eZe, HanziToPinyin.Token.SEPARATOR, false, false);
                this.eZg.setText(a.i.ala_challenge_jinzhu_def_tip);
                this.eZf.setVisibility(0);
                if (z) {
                    this.eZg.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    this.eZf.setImageResource(a.f.pic_live_pk_frameorange);
                } else {
                    this.eZg.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    this.eZf.setImageResource(a.f.pic_live_pk_framepurple);
                }
                this.eZg.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds16));
            }
        } else if (abVar.abx != null) {
            boolean z2 = z && abVar.a(this.eZh);
            this.eZi = z2;
            if (!z2) {
                this.eZj = false;
                if (abVar.abx != null) {
                    k.a(this.eZe, abVar.abx.portrait, false, false);
                }
                this.eZh = abVar;
                this.eZi = z;
                if (abVar.qF()) {
                    D(false, true);
                    this.eZg.setText((CharSequence) null);
                    this.eZg.setBackgroundResource(a.f.icon_live_pkmvp);
                    this.eZf.setVisibility(0);
                    this.eZf.setImageResource(a.f.pic_live_pk_framemvp);
                } else {
                    D(false, false);
                    this.eZg.setText("" + abVar.rank);
                    this.eZg.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds18));
                    if (z) {
                        this.eZg.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    } else {
                        this.eZg.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    }
                    if (abVar.isFirst()) {
                        this.eZf.setVisibility(0);
                        if (z) {
                            this.eZf.setImageResource(a.f.pic_live_pk_frameorange);
                        } else {
                            this.eZf.setImageResource(a.f.pic_live_pk_framepurple);
                        }
                    } else {
                        this.eZf.setVisibility(8);
                    }
                }
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ChallengeJinzhuView.this.eZj && ChallengeJinzhuView.this.eZh != null && ChallengeJinzhuView.this.eZh.abx != null) {
                            AlaLiveUserInfoData alaLiveUserInfoData = ChallengeJinzhuView.this.eZh.abx;
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
            this.eZk = (FrameLayout.LayoutParams) this.eZg.getLayoutParams();
            this.eZk.width = -2;
            this.eZk.height = eZd;
            this.eZg.setLayoutParams(this.eZk);
            this.eZg.setPadding(aqE, 0, aqE, 0);
            return;
        }
        this.eZk = (FrameLayout.LayoutParams) this.eZg.getLayoutParams();
        this.eZk.width = z2 ? eZb : -2;
        this.eZk.height = eZc;
        this.eZg.setLayoutParams(this.eZk);
        if (z2) {
            this.eZg.setPadding(0, 0, 0, 0);
        } else {
            this.eZg.setPadding(aqF, 0, aqF, 0);
        }
    }
}
