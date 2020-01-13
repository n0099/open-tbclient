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
import com.baidu.live.data.aa;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.k;
/* loaded from: classes2.dex */
public class ChallengeJinzhuView extends FrameLayout {
    private static final int anm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
    private static final int ann = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
    private static final int eVj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
    private static final int eVk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
    private static final int eVl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
    private HeadImageView eVm;
    private ImageView eVn;
    private TextView eVo;
    private aa eVp;
    private boolean eVq;
    private boolean eVr;
    private FrameLayout.LayoutParams eVs;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.eVq = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eVq = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eVq = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.eVm = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.eVm.setIsRound(true);
        this.eVm.setAutoChangeStyle(false);
        this.eVm.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.eVm.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.eVm.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVm.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eVm.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.eVn = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.eVo = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
    }

    public void a(boolean z, aa aaVar, final String str) {
        if (aaVar == null) {
            if (!this.eVr || this.eVq != z) {
                B(true, false);
                this.eVq = z;
                this.eVr = true;
                k.a(this.eVm, HanziToPinyin.Token.SEPARATOR, false, false);
                this.eVo.setText(a.i.ala_challenge_jinzhu_def_tip);
                this.eVn.setVisibility(0);
                if (z) {
                    this.eVo.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    this.eVn.setImageResource(a.f.pic_live_pk_frameorange);
                } else {
                    this.eVo.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    this.eVn.setImageResource(a.f.pic_live_pk_framepurple);
                }
                this.eVo.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds16));
            }
        } else if (aaVar.ZC != null) {
            boolean z2 = z && aaVar.a(this.eVp);
            this.eVq = z2;
            if (!z2) {
                this.eVr = false;
                if (aaVar.ZC != null) {
                    k.a(this.eVm, aaVar.ZC.portrait, false, false);
                }
                this.eVp = aaVar;
                this.eVq = z;
                if (aaVar.pU()) {
                    B(false, true);
                    this.eVo.setText((CharSequence) null);
                    this.eVo.setBackgroundResource(a.f.icon_live_pkmvp);
                    this.eVn.setVisibility(0);
                    this.eVn.setImageResource(a.f.pic_live_pk_framemvp);
                } else {
                    B(false, false);
                    this.eVo.setText("" + aaVar.rank);
                    this.eVo.setTextSize(0, getContext().getResources().getDimensionPixelSize(a.e.sdk_ds18));
                    if (z) {
                        this.eVo.setBackgroundResource(a.f.ala_challenge_anchor_jinzhu_num_bg);
                    } else {
                        this.eVo.setBackgroundResource(a.f.ala_challenge_rival_jinzhu_num_bg);
                    }
                    if (aaVar.isFirst()) {
                        this.eVn.setVisibility(0);
                        if (z) {
                            this.eVn.setImageResource(a.f.pic_live_pk_frameorange);
                        } else {
                            this.eVn.setImageResource(a.f.pic_live_pk_framepurple);
                        }
                    } else {
                        this.eVn.setVisibility(8);
                    }
                }
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.ChallengeJinzhuView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!ChallengeJinzhuView.this.eVr && ChallengeJinzhuView.this.eVp != null && ChallengeJinzhuView.this.eVp.ZC != null) {
                            AlaLiveUserInfoData alaLiveUserInfoData = ChallengeJinzhuView.this.eVp.ZC;
                            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(ChallengeJinzhuView.this.getContext(), alaLiveUserInfoData.userId + "", alaLiveUserInfoData.userName, alaLiveUserInfoData.portrait, 0, 0, null, null, 0L, 0L, 0L, 0, null, str, false, null, null, alaLiveUserInfoData.userName, "");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        }
                    }
                });
            }
        }
    }

    private void B(boolean z, boolean z2) {
        if (z) {
            this.eVs = (FrameLayout.LayoutParams) this.eVo.getLayoutParams();
            this.eVs.width = -2;
            this.eVs.height = eVl;
            this.eVo.setLayoutParams(this.eVs);
            this.eVo.setPadding(anm, 0, anm, 0);
            return;
        }
        this.eVs = (FrameLayout.LayoutParams) this.eVo.getLayoutParams();
        this.eVs.width = z2 ? eVj : -2;
        this.eVs.height = eVk;
        this.eVo.setLayoutParams(this.eVs);
        if (z2) {
            this.eVo.setPadding(0, 0, 0, 0);
        } else {
            this.eVo.setPadding(ann, 0, ann, 0);
        }
    }
}
