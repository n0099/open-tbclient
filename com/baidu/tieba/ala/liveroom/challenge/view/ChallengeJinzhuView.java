package com.baidu.tieba.ala.liveroom.challenge.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.be;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.m;
/* loaded from: classes11.dex */
public class ChallengeJinzhuView extends FrameLayout {
    private final int gxR;
    private final int hAO;
    private final int hAP;
    private final int hAQ;
    private View hAR;
    private ImageView hAS;
    private TextView hAT;
    private be hAU;
    private boolean hAV;
    private boolean hAW;
    private ImageView hkX;
    private final int htY;
    private HeadImageView hzF;
    public boolean hzs;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.htY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hAO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hAP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gxR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hAQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hAV = false;
        this.hzs = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.htY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hAO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hAP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gxR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hAQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hAV = false;
        this.hzs = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.htY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hAO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hAP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gxR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hAQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hAV = false;
        this.hzs = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.hAR = findViewById(a.f.ala_challenge_jinzhu_normal);
        this.hzF = (HeadImageView) findViewById(a.f.ala_challenge_jinzhu_header);
        this.hzF.setIsRound(true);
        this.hzF.setAutoChangeStyle(false);
        this.hzF.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds2));
        this.hzF.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha20));
        this.hzF.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hzF.setDefaultResource(a.e.icon_challenge_default_avatar);
        this.hAS = (ImageView) findViewById(a.f.ala_challenge_jinzhu_headwear);
        this.hAT = (TextView) findViewById(a.f.ala_challenge_jinzhu_tv);
        this.hkX = (ImageView) findViewById(a.f.ala_challenge_jinzhu_empty);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hzs = z;
    }

    public void a(boolean z, be beVar, String str) {
        if (beVar == null) {
            if (!this.hAW || this.hAV != z) {
                this.hAV = z;
                this.hAW = true;
                m.a(this.hzF, " ", false, false);
                this.hAR.setVisibility(4);
                this.hkX.setVisibility(0);
                this.hkX.setImageResource(z ? a.e.icon_challenge_jinzhu_anchor_empty : a.e.icon_challenge_jinzhu_rival_empty);
            }
        } else if (beVar.aOI != null) {
            this.hAV = z;
            if (!z || !beVar.a(this.hAU)) {
                this.hAR.setVisibility(0);
                this.hkX.setVisibility(4);
                this.hAW = false;
                if (beVar.aOI != null) {
                    m.a(this.hzF, beVar.aOI.portrait, false, false);
                }
                this.hAU = beVar;
                this.hAV = z;
                Drawable background = this.hAS.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds28));
                if (beVar.Cw()) {
                    this.hAT.setText("");
                    Q(z, true);
                    this.hAS.setVisibility(0);
                    ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_mvp));
                } else {
                    this.hAT.setText("" + beVar.rank);
                    Q(z, false);
                    if (beVar.isFirst()) {
                        this.hAS.setVisibility(0);
                        if (z) {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_anchor_primary));
                        } else {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_rival_primary));
                        }
                    } else {
                        this.hAS.setVisibility(8);
                    }
                }
                this.hAS.setBackgroundDrawable(background);
            }
        }
    }

    private void Q(boolean z, boolean z2) {
        if (this.hAT != null) {
            ViewGroup.LayoutParams layoutParams = this.hAT.getLayoutParams();
            if (z2) {
                this.hAT.setBackgroundResource(a.e.icon_challenge_jinzhu_mvp);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds52);
            } else {
                Drawable background = this.hAT.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds10));
                if (z) {
                    ((GradientDrawable) background).setColor(getResources().getColor(a.c.ala_challenge_jinzhu_anchor_primary));
                } else {
                    ((GradientDrawable) background).setColor(getResources().getColor(a.c.ala_challenge_jinzhu_rival_primary));
                }
                this.hAT.setBackgroundDrawable(background);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            this.hAT.setLayoutParams(layoutParams);
        }
    }
}
