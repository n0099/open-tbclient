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
import com.baidu.live.data.al;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.k;
/* loaded from: classes4.dex */
public class ChallengeJinzhuView extends FrameLayout {
    private final int fqL;
    private final int gdr;
    public boolean giF;
    private HeadImageView gjm;
    private final int gkq;
    private final int gkr;
    private final int gks;
    private ImageView gkt;
    private TextView gku;
    private al gkv;
    private boolean gkw;
    private boolean gkx;
    private FrameLayout.LayoutParams gky;
    private a gkz;

    /* loaded from: classes4.dex */
    public interface a {
        void bGP();
    }

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.gdr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gkq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gkr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fqL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gks = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gkw = false;
        this.giF = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gdr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gkq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gkr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fqL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gks = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gkw = false;
        this.giF = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gdr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gkq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gkr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fqL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gks = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gkw = false;
        this.giF = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.gjm = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.gjm.setIsRound(true);
        this.gjm.setAutoChangeStyle(false);
        this.gjm.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.gjm.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.gjm.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gjm.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gjm.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.gkt = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.gku = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.giF = z;
    }

    public void setClickListener(a aVar) {
        this.gkz = aVar;
    }

    public void a(boolean z, al alVar, final String str) {
        if (alVar == null) {
            if (!this.gkx || this.gkw != z) {
                I(true, false);
                this.gkw = z;
                this.gkx = true;
                k.a(this.gjm, " ", false, false);
                this.gku.setText(a.i.ala_challenge_jinzhu_def_tip);
                this.gkt.setVisibility(0);
                if (z) {
                    this.gku.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    this.gkt.setImageResource(a.f.pic_live_pk_frameorange);
                } else {
                    this.gku.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    this.gkt.setImageResource(a.f.pic_live_pk_framepurple);
                }
                this.gku.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds16));
            }
        } else if (alVar.aDb != null) {
            boolean z2 = z && alVar.a(this.gkv);
            this.gkw = z2;
            if (!z2) {
                this.gkx = false;
                if (alVar.aDb != null) {
                    k.a(this.gjm, alVar.aDb.portrait, false, false);
                }
                this.gkv = alVar;
                this.gkw = z;
                if (alVar.xq()) {
                    I(false, true);
                    this.gku.setText((CharSequence) null);
                    this.gku.setBackgroundResource(a.f.icon_live_pkmvp);
                    this.gkt.setVisibility(0);
                    this.gkt.setImageResource(a.f.pic_live_pk_framemvp);
                } else {
                    I(false, false);
                    this.gku.setText("" + alVar.rank);
                    this.gku.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds18));
                    if (z) {
                        this.gku.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    } else {
                        this.gku.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    }
                    if (alVar.isFirst()) {
                        this.gkt.setVisibility(0);
                        if (z) {
                            this.gkt.setImageResource(a.f.pic_live_pk_frameorange);
                        } else {
                            this.gkt.setImageResource(a.f.pic_live_pk_framepurple);
                        }
                    } else {
                        this.gkt.setVisibility(8);
                    }
                }
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ChallengeJinzhuView.this.gkx && ChallengeJinzhuView.this.gkv != null && ChallengeJinzhuView.this.gkv.aDb != null) {
                            if (!ChallengeJinzhuView.this.giF || ChallengeJinzhuView.this.gkz == null) {
                                AlaLiveUserInfoData alaLiveUserInfoData = ChallengeJinzhuView.this.gkv.aDb;
                                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(ChallengeJinzhuView.this.getContext(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, str, false, null, null, alaLiveUserInfoData.userName, "");
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                                return;
                            }
                            ChallengeJinzhuView.this.gkz.bGP();
                        }
                    }
                });
            }
        }
    }

    private void I(boolean z, boolean z2) {
        if (z) {
            this.gky = (FrameLayout.LayoutParams) this.gku.getLayoutParams();
            this.gky.width = -2;
            this.gky.height = this.gks;
            this.gku.setLayoutParams(this.gky);
            this.gku.setPadding(this.gdr, 0, this.gdr, 0);
            return;
        }
        this.gky = (FrameLayout.LayoutParams) this.gku.getLayoutParams();
        this.gky.width = z2 ? this.gkr : -2;
        this.gky.height = this.fqL;
        this.gku.setLayoutParams(this.gky);
        if (z2) {
            this.gku.setPadding(0, 0, 0, 0);
        } else {
            this.gku.setPadding(this.gkq, 0, this.gkq, 0);
        }
    }
}
