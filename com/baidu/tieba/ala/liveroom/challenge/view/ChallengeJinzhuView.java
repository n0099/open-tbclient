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
import com.baidu.live.data.ai;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
/* loaded from: classes3.dex */
public class ChallengeJinzhuView extends FrameLayout {
    public boolean fRr;
    private ai fSA;
    private boolean fSB;
    private boolean fSC;
    private FrameLayout.LayoutParams fSD;
    private a fSE;
    private final int fSt;
    private final int fSu;
    private final int fSv;
    private final int fSw;
    private HeadImageView fSx;
    private ImageView fSy;
    private TextView fSz;
    private final int fat;

    /* loaded from: classes3.dex */
    public interface a {
        void bAE();
    }

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.fSt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fSu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.fSv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fat = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.fSw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.fSB = false;
        this.fRr = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fSt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fSu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.fSv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fat = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.fSw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.fSB = false;
        this.fRr = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fSt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fSu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.fSv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fat = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.fSw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.fSB = false;
        this.fRr = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.fSx = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.fSx.setIsRound(true);
        this.fSx.setAutoChangeStyle(false);
        this.fSx.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.fSx.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.fSx.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fSx.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fSx.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.fSy = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.fSz = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.fRr = z;
    }

    public void setClickListener(a aVar) {
        this.fSE = aVar;
    }

    public void a(boolean z, ai aiVar, final String str) {
        if (aiVar == null) {
            if (!this.fSC || this.fSB != z) {
                G(true, false);
                this.fSB = z;
                this.fSC = true;
                k.a(this.fSx, " ", false, false);
                this.fSz.setText(a.i.ala_challenge_jinzhu_def_tip);
                this.fSy.setVisibility(0);
                if (z) {
                    this.fSz.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    this.fSy.setImageResource(a.f.pic_live_pk_frameorange);
                } else {
                    this.fSz.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    this.fSy.setImageResource(a.f.pic_live_pk_framepurple);
                }
                this.fSz.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds16));
            }
        } else if (aiVar.azo != null) {
            boolean z2 = z && aiVar.a(this.fSA);
            this.fSB = z2;
            if (!z2) {
                this.fSC = false;
                if (aiVar.azo != null) {
                    k.a(this.fSx, aiVar.azo.portrait, false, false);
                }
                this.fSA = aiVar;
                this.fSB = z;
                if (aiVar.wp()) {
                    G(false, true);
                    this.fSz.setText((CharSequence) null);
                    this.fSz.setBackgroundResource(a.f.icon_live_pkmvp);
                    this.fSy.setVisibility(0);
                    this.fSy.setImageResource(a.f.pic_live_pk_framemvp);
                } else {
                    G(false, false);
                    this.fSz.setText("" + aiVar.rank);
                    this.fSz.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds18));
                    if (z) {
                        this.fSz.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    } else {
                        this.fSz.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    }
                    if (aiVar.isFirst()) {
                        this.fSy.setVisibility(0);
                        if (z) {
                            this.fSy.setImageResource(a.f.pic_live_pk_frameorange);
                        } else {
                            this.fSy.setImageResource(a.f.pic_live_pk_framepurple);
                        }
                    } else {
                        this.fSy.setVisibility(8);
                    }
                }
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ChallengeJinzhuView.this.fSC && ChallengeJinzhuView.this.fSA != null && ChallengeJinzhuView.this.fSA.azo != null) {
                            if (!ChallengeJinzhuView.this.fRr || ChallengeJinzhuView.this.fSE == null) {
                                AlaLiveUserInfoData alaLiveUserInfoData = ChallengeJinzhuView.this.fSA.azo;
                                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(ChallengeJinzhuView.this.getContext(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, str, false, null, null, alaLiveUserInfoData.userName, "");
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                                return;
                            }
                            ChallengeJinzhuView.this.fSE.bAE();
                        }
                    }
                });
            }
        }
    }

    private void G(boolean z, boolean z2) {
        if (z) {
            this.fSD = (FrameLayout.LayoutParams) this.fSz.getLayoutParams();
            this.fSD.width = -2;
            this.fSD.height = this.fSw;
            this.fSz.setLayoutParams(this.fSD);
            this.fSz.setPadding(this.fSt, 0, this.fSt, 0);
            return;
        }
        this.fSD = (FrameLayout.LayoutParams) this.fSz.getLayoutParams();
        this.fSD.width = z2 ? this.fSv : -2;
        this.fSD.height = this.fat;
        this.fSz.setLayoutParams(this.fSD);
        if (z2) {
            this.fSz.setPadding(0, 0, 0, 0);
        } else {
            this.fSz.setPadding(this.fSu, 0, this.fSu, 0);
        }
    }
}
