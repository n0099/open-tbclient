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
import com.baidu.live.data.an;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.k;
/* loaded from: classes7.dex */
public class ChallengeJinzhuView extends FrameLayout {
    private final int fCl;
    private ImageView ghB;
    private final int gpE;
    public boolean guN;
    private HeadImageView gvt;
    private final int gwA;
    private final int gwB;
    private final int gwC;
    private View gwD;
    private ImageView gwE;
    private TextView gwF;
    private an gwG;
    private boolean gwH;
    private boolean gwI;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.gpE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gwA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gwB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fCl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gwC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gwH = false;
        this.guN = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gpE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gwA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gwB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fCl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gwC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gwH = false;
        this.guN = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gpE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gwA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gwB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fCl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gwC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gwH = false;
        this.guN = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.gwD = findViewById(a.g.ala_challenge_jinzhu_normal);
        this.gvt = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.gvt.setIsRound(true);
        this.gvt.setAutoChangeStyle(false);
        this.gvt.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.gvt.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.gvt.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gvt.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.gwE = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.gwF = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
        this.ghB = (ImageView) findViewById(a.g.ala_challenge_jinzhu_empty);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.guN = z;
    }

    public void a(boolean z, an anVar, String str) {
        if (anVar == null) {
            if (!this.gwI || this.gwH != z) {
                this.gwH = z;
                this.gwI = true;
                k.a(this.gvt, " ", false, false);
                this.gwD.setVisibility(4);
                this.ghB.setVisibility(0);
                this.ghB.setImageResource(z ? a.f.icon_challenge_jinzhu_anchor_empty : a.f.icon_challenge_jinzhu_rival_empty);
            }
        } else if (anVar.aIn != null) {
            boolean z2 = z && anVar.a(this.gwG);
            this.gwH = z2;
            if (!z2) {
                this.gwD.setVisibility(0);
                this.ghB.setVisibility(4);
                this.gwI = false;
                if (anVar.aIn != null) {
                    k.a(this.gvt, anVar.aIn.portrait, false, false);
                }
                this.gwG = anVar;
                this.gwH = z;
                Drawable background = this.gwE.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds28));
                if (anVar.CT()) {
                    this.gwF.setText("");
                    L(z, true);
                    this.gwE.setVisibility(0);
                    ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_jinzhu_mvp));
                } else {
                    this.gwF.setText("" + anVar.rank);
                    L(z, false);
                    if (anVar.isFirst()) {
                        this.gwE.setVisibility(0);
                        if (z) {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_jinzhu_anchor_primary));
                        } else {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_jinzhu_rival_primary));
                        }
                    } else {
                        this.gwE.setVisibility(8);
                    }
                }
                this.gwE.setBackgroundDrawable(background);
            }
        }
    }

    private void L(boolean z, boolean z2) {
        if (this.gwF != null) {
            ViewGroup.LayoutParams layoutParams = this.gwF.getLayoutParams();
            if (z2) {
                this.gwF.setBackgroundResource(a.f.icon_challenge_jinzhu_mvp);
                layoutParams.width = getResources().getDimensionPixelOffset(a.e.sdk_ds52);
            } else {
                Drawable background = this.gwF.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds10));
                if (z) {
                    ((GradientDrawable) background).setColor(getResources().getColor(a.d.ala_challenge_jinzhu_anchor_primary));
                } else {
                    ((GradientDrawable) background).setColor(getResources().getColor(a.d.ala_challenge_jinzhu_rival_primary));
                }
                this.gwF.setBackgroundDrawable(background);
                layoutParams.width = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            this.gwF.setLayoutParams(layoutParams);
        }
    }
}
