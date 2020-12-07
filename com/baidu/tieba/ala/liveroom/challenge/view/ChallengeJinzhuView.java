package com.baidu.tieba.ala.liveroom.challenge.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ay;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.l;
/* loaded from: classes4.dex */
public class ChallengeJinzhuView extends FrameLayout {
    private ImageView gZx;
    private final int gpp;
    private final int hix;
    public boolean hnR;
    private HeadImageView hoe;
    private final int hpm;
    private final int hpn;
    private final int hpo;
    private View hpp;
    private ImageView hpq;
    private TextView hpr;
    private ay hps;
    private boolean hpt;
    private boolean hpu;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.hix = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hpm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hpn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gpp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hpo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hpt = false;
        this.hnR = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hix = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hpm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hpn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gpp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hpo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hpt = false;
        this.hnR = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hix = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hpm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hpn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gpp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hpo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hpt = false;
        this.hnR = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.hpp = findViewById(a.f.ala_challenge_jinzhu_normal);
        this.hoe = (HeadImageView) findViewById(a.f.ala_challenge_jinzhu_header);
        this.hoe.setIsRound(true);
        this.hoe.setAutoChangeStyle(false);
        this.hoe.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds2));
        this.hoe.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha20));
        this.hoe.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hoe.setDefaultResource(a.e.icon_challenge_default_avatar);
        this.hpq = (ImageView) findViewById(a.f.ala_challenge_jinzhu_headwear);
        this.hpr = (TextView) findViewById(a.f.ala_challenge_jinzhu_tv);
        this.gZx = (ImageView) findViewById(a.f.ala_challenge_jinzhu_empty);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hnR = z;
    }

    public void a(boolean z, ay ayVar, String str) {
        if (ayVar == null) {
            if (!this.hpu || this.hpt != z) {
                this.hpt = z;
                this.hpu = true;
                l.a(this.hoe, " ", false, false);
                this.hpp.setVisibility(4);
                this.gZx.setVisibility(0);
                this.gZx.setImageResource(z ? a.e.icon_challenge_jinzhu_anchor_empty : a.e.icon_challenge_jinzhu_rival_empty);
            }
        } else if (ayVar.aPJ != null) {
            this.hpt = z;
            if (!z || !ayVar.a(this.hps)) {
                this.hpp.setVisibility(0);
                this.gZx.setVisibility(4);
                this.hpu = false;
                if (ayVar.aPJ != null) {
                    l.a(this.hoe, ayVar.aPJ.portrait, false, false);
                }
                this.hps = ayVar;
                this.hpt = z;
                Drawable background = this.hpq.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds28));
                if (ayVar.FO()) {
                    this.hpr.setText("");
                    O(z, true);
                    this.hpq.setVisibility(0);
                    ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_mvp));
                } else {
                    this.hpr.setText("" + ayVar.rank);
                    O(z, false);
                    if (ayVar.isFirst()) {
                        this.hpq.setVisibility(0);
                        if (z) {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_anchor_primary));
                        } else {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_rival_primary));
                        }
                    } else {
                        this.hpq.setVisibility(8);
                    }
                }
                this.hpq.setBackgroundDrawable(background);
            }
        }
    }

    private void O(boolean z, boolean z2) {
        if (this.hpr != null) {
            ViewGroup.LayoutParams layoutParams = this.hpr.getLayoutParams();
            if (z2) {
                this.hpr.setBackgroundResource(a.e.icon_challenge_jinzhu_mvp);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds52);
            } else {
                Drawable background = this.hpr.getBackground();
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
                this.hpr.setBackgroundDrawable(background);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            this.hpr.setLayoutParams(layoutParams);
        }
    }
}
