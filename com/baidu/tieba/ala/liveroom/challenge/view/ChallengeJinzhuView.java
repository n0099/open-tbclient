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
    public boolean fRg;
    private final int fSi;
    private final int fSj;
    private final int fSk;
    private final int fSl;
    private HeadImageView fSm;
    private ImageView fSn;
    private TextView fSo;
    private ai fSp;
    private boolean fSq;
    private boolean fSr;
    private FrameLayout.LayoutParams fSs;
    private a fSt;
    private final int fai;

    /* loaded from: classes3.dex */
    public interface a {
        void bAC();
    }

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.fSi = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fSj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.fSk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fai = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.fSl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.fSq = false;
        this.fRg = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fSi = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fSj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.fSk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fai = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.fSl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.fSq = false;
        this.fRg = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fSi = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.fSj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.fSk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fai = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.fSl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.fSq = false;
        this.fRg = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.fSm = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.fSm.setIsRound(true);
        this.fSm.setAutoChangeStyle(false);
        this.fSm.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.fSm.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.fSm.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fSm.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fSm.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.fSn = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.fSo = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.fRg = z;
    }

    public void setClickListener(a aVar) {
        this.fSt = aVar;
    }

    public void a(boolean z, ai aiVar, final String str) {
        if (aiVar == null) {
            if (!this.fSr || this.fSq != z) {
                G(true, false);
                this.fSq = z;
                this.fSr = true;
                k.a(this.fSm, " ", false, false);
                this.fSo.setText(a.i.ala_challenge_jinzhu_def_tip);
                this.fSn.setVisibility(0);
                if (z) {
                    this.fSo.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    this.fSn.setImageResource(a.f.pic_live_pk_frameorange);
                } else {
                    this.fSo.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    this.fSn.setImageResource(a.f.pic_live_pk_framepurple);
                }
                this.fSo.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds16));
            }
        } else if (aiVar.azo != null) {
            boolean z2 = z && aiVar.a(this.fSp);
            this.fSq = z2;
            if (!z2) {
                this.fSr = false;
                if (aiVar.azo != null) {
                    k.a(this.fSm, aiVar.azo.portrait, false, false);
                }
                this.fSp = aiVar;
                this.fSq = z;
                if (aiVar.wp()) {
                    G(false, true);
                    this.fSo.setText((CharSequence) null);
                    this.fSo.setBackgroundResource(a.f.icon_live_pkmvp);
                    this.fSn.setVisibility(0);
                    this.fSn.setImageResource(a.f.pic_live_pk_framemvp);
                } else {
                    G(false, false);
                    this.fSo.setText("" + aiVar.rank);
                    this.fSo.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds18));
                    if (z) {
                        this.fSo.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    } else {
                        this.fSo.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    }
                    if (aiVar.isFirst()) {
                        this.fSn.setVisibility(0);
                        if (z) {
                            this.fSn.setImageResource(a.f.pic_live_pk_frameorange);
                        } else {
                            this.fSn.setImageResource(a.f.pic_live_pk_framepurple);
                        }
                    } else {
                        this.fSn.setVisibility(8);
                    }
                }
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ChallengeJinzhuView.this.fSr && ChallengeJinzhuView.this.fSp != null && ChallengeJinzhuView.this.fSp.azo != null) {
                            if (!ChallengeJinzhuView.this.fRg || ChallengeJinzhuView.this.fSt == null) {
                                AlaLiveUserInfoData alaLiveUserInfoData = ChallengeJinzhuView.this.fSp.azo;
                                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(ChallengeJinzhuView.this.getContext(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, str, false, null, null, alaLiveUserInfoData.userName, "");
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                                return;
                            }
                            ChallengeJinzhuView.this.fSt.bAC();
                        }
                    }
                });
            }
        }
    }

    private void G(boolean z, boolean z2) {
        if (z) {
            this.fSs = (FrameLayout.LayoutParams) this.fSo.getLayoutParams();
            this.fSs.width = -2;
            this.fSs.height = this.fSl;
            this.fSo.setLayoutParams(this.fSs);
            this.fSo.setPadding(this.fSi, 0, this.fSi, 0);
            return;
        }
        this.fSs = (FrameLayout.LayoutParams) this.fSo.getLayoutParams();
        this.fSs.width = z2 ? this.fSk : -2;
        this.fSs.height = this.fai;
        this.fSo.setLayoutParams(this.fSs);
        if (z2) {
            this.fSo.setPadding(0, 0, 0, 0);
        } else {
            this.fSo.setPadding(this.fSj, 0, this.fSj, 0);
        }
    }
}
