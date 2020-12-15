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
    private ImageView gZz;
    private final int gpr;
    private final int hiz;
    public boolean hnT;
    private HeadImageView hog;
    private final int hpo;
    private final int hpp;
    private final int hpq;
    private View hpr;
    private ImageView hps;
    private TextView hpt;
    private ay hpu;
    private boolean hpv;
    private boolean hpw;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.hiz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hpo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hpp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gpr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hpq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hpv = false;
        this.hnT = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hiz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hpo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hpp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gpr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hpq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hpv = false;
        this.hnT = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hiz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hpo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hpp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gpr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hpq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hpv = false;
        this.hnT = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.hpr = findViewById(a.f.ala_challenge_jinzhu_normal);
        this.hog = (HeadImageView) findViewById(a.f.ala_challenge_jinzhu_header);
        this.hog.setIsRound(true);
        this.hog.setAutoChangeStyle(false);
        this.hog.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds2));
        this.hog.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha20));
        this.hog.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hog.setDefaultResource(a.e.icon_challenge_default_avatar);
        this.hps = (ImageView) findViewById(a.f.ala_challenge_jinzhu_headwear);
        this.hpt = (TextView) findViewById(a.f.ala_challenge_jinzhu_tv);
        this.gZz = (ImageView) findViewById(a.f.ala_challenge_jinzhu_empty);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hnT = z;
    }

    public void a(boolean z, ay ayVar, String str) {
        if (ayVar == null) {
            if (!this.hpw || this.hpv != z) {
                this.hpv = z;
                this.hpw = true;
                l.a(this.hog, " ", false, false);
                this.hpr.setVisibility(4);
                this.gZz.setVisibility(0);
                this.gZz.setImageResource(z ? a.e.icon_challenge_jinzhu_anchor_empty : a.e.icon_challenge_jinzhu_rival_empty);
            }
        } else if (ayVar.aPJ != null) {
            this.hpv = z;
            if (!z || !ayVar.a(this.hpu)) {
                this.hpr.setVisibility(0);
                this.gZz.setVisibility(4);
                this.hpw = false;
                if (ayVar.aPJ != null) {
                    l.a(this.hog, ayVar.aPJ.portrait, false, false);
                }
                this.hpu = ayVar;
                this.hpv = z;
                Drawable background = this.hps.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds28));
                if (ayVar.FO()) {
                    this.hpt.setText("");
                    O(z, true);
                    this.hps.setVisibility(0);
                    ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_mvp));
                } else {
                    this.hpt.setText("" + ayVar.rank);
                    O(z, false);
                    if (ayVar.isFirst()) {
                        this.hps.setVisibility(0);
                        if (z) {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_anchor_primary));
                        } else {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_rival_primary));
                        }
                    } else {
                        this.hps.setVisibility(8);
                    }
                }
                this.hps.setBackgroundDrawable(background);
            }
        }
    }

    private void O(boolean z, boolean z2) {
        if (this.hpt != null) {
            ViewGroup.LayoutParams layoutParams = this.hpt.getLayoutParams();
            if (z2) {
                this.hpt.setBackgroundResource(a.e.icon_challenge_jinzhu_mvp);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds52);
            } else {
                Drawable background = this.hpt.getBackground();
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
                this.hpt.setBackgroundDrawable(background);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            this.hpt.setLayoutParams(layoutParams);
        }
    }
}
