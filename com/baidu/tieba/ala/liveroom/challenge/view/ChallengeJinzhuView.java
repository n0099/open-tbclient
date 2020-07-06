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
import com.baidu.live.data.ak;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.k;
/* loaded from: classes3.dex */
public class ChallengeJinzhuView extends FrameLayout {
    private final int fYk;
    private final int flD;
    public boolean gdw;
    private HeadImageView ged;
    private final int gfi;
    private final int gfj;
    private final int gfk;
    private ImageView gfl;
    private TextView gfm;
    private ak gfn;
    private boolean gfo;
    private boolean gfp;
    private FrameLayout.LayoutParams gfq;
    private a gfr;

    /* loaded from: classes3.dex */
    public interface a {
        void bDE();
    }

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.fYk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gfi = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gfj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.flD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gfk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gfo = false;
        this.gdw = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fYk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gfi = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gfj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.flD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gfk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gfo = false;
        this.gdw = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fYk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gfi = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gfj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.flD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gfk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gfo = false;
        this.gdw = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.ged = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.ged.setIsRound(true);
        this.ged.setAutoChangeStyle(false);
        this.ged.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.ged.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.ged.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ged.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.ged.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.gfl = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.gfm = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.gdw = z;
    }

    public void setClickListener(a aVar) {
        this.gfr = aVar;
    }

    public void a(boolean z, ak akVar, final String str) {
        if (akVar == null) {
            if (!this.gfp || this.gfo != z) {
                H(true, false);
                this.gfo = z;
                this.gfp = true;
                k.a(this.ged, " ", false, false);
                this.gfm.setText(a.i.ala_challenge_jinzhu_def_tip);
                this.gfl.setVisibility(0);
                if (z) {
                    this.gfm.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    this.gfl.setImageResource(a.f.pic_live_pk_frameorange);
                } else {
                    this.gfm.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    this.gfl.setImageResource(a.f.pic_live_pk_framepurple);
                }
                this.gfm.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds16));
            }
        } else if (akVar.aBG != null) {
            boolean z2 = z && akVar.a(this.gfn);
            this.gfo = z2;
            if (!z2) {
                this.gfp = false;
                if (akVar.aBG != null) {
                    k.a(this.ged, akVar.aBG.portrait, false, false);
                }
                this.gfn = akVar;
                this.gfo = z;
                if (akVar.wN()) {
                    H(false, true);
                    this.gfm.setText((CharSequence) null);
                    this.gfm.setBackgroundResource(a.f.icon_live_pkmvp);
                    this.gfl.setVisibility(0);
                    this.gfl.setImageResource(a.f.pic_live_pk_framemvp);
                } else {
                    H(false, false);
                    this.gfm.setText("" + akVar.rank);
                    this.gfm.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds18));
                    if (z) {
                        this.gfm.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    } else {
                        this.gfm.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    }
                    if (akVar.isFirst()) {
                        this.gfl.setVisibility(0);
                        if (z) {
                            this.gfl.setImageResource(a.f.pic_live_pk_frameorange);
                        } else {
                            this.gfl.setImageResource(a.f.pic_live_pk_framepurple);
                        }
                    } else {
                        this.gfl.setVisibility(8);
                    }
                }
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ChallengeJinzhuView.this.gfp && ChallengeJinzhuView.this.gfn != null && ChallengeJinzhuView.this.gfn.aBG != null) {
                            if (!ChallengeJinzhuView.this.gdw || ChallengeJinzhuView.this.gfr == null) {
                                AlaLiveUserInfoData alaLiveUserInfoData = ChallengeJinzhuView.this.gfn.aBG;
                                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(ChallengeJinzhuView.this.getContext(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, str, false, null, null, alaLiveUserInfoData.userName, "");
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                                return;
                            }
                            ChallengeJinzhuView.this.gfr.bDE();
                        }
                    }
                });
            }
        }
    }

    private void H(boolean z, boolean z2) {
        if (z) {
            this.gfq = (FrameLayout.LayoutParams) this.gfm.getLayoutParams();
            this.gfq.width = -2;
            this.gfq.height = this.gfk;
            this.gfm.setLayoutParams(this.gfq);
            this.gfm.setPadding(this.fYk, 0, this.fYk, 0);
            return;
        }
        this.gfq = (FrameLayout.LayoutParams) this.gfm.getLayoutParams();
        this.gfq.width = z2 ? this.gfj : -2;
        this.gfq.height = this.flD;
        this.gfm.setLayoutParams(this.gfq);
        if (z2) {
            this.gfm.setPadding(0, 0, 0, 0);
        } else {
            this.gfm.setPadding(this.gfi, 0, this.gfi, 0);
        }
    }
}
