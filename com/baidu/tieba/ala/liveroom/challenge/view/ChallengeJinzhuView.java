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
    private final int fCh;
    private ImageView ghx;
    private final int gpA;
    public boolean guJ;
    private HeadImageView gvp;
    private ImageView gwA;
    private TextView gwB;
    private an gwC;
    private boolean gwD;
    private boolean gwE;
    private final int gww;
    private final int gwx;
    private final int gwy;
    private View gwz;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.gpA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gww = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gwx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fCh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gwy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gwD = false;
        this.guJ = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gpA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gww = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gwx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fCh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gwy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gwD = false;
        this.guJ = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gpA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gww = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gwx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fCh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gwy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gwD = false;
        this.guJ = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.gwz = findViewById(a.g.ala_challenge_jinzhu_normal);
        this.gvp = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.gvp.setIsRound(true);
        this.gvp.setAutoChangeStyle(false);
        this.gvp.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.gvp.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.gvp.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gvp.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.gwA = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.gwB = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
        this.ghx = (ImageView) findViewById(a.g.ala_challenge_jinzhu_empty);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.guJ = z;
    }

    public void a(boolean z, an anVar, String str) {
        if (anVar == null) {
            if (!this.gwE || this.gwD != z) {
                this.gwD = z;
                this.gwE = true;
                k.a(this.gvp, " ", false, false);
                this.gwz.setVisibility(4);
                this.ghx.setVisibility(0);
                this.ghx.setImageResource(z ? a.f.icon_challenge_jinzhu_anchor_empty : a.f.icon_challenge_jinzhu_rival_empty);
            }
        } else if (anVar.aIl != null) {
            boolean z2 = z && anVar.a(this.gwC);
            this.gwD = z2;
            if (!z2) {
                this.gwz.setVisibility(0);
                this.ghx.setVisibility(4);
                this.gwE = false;
                if (anVar.aIl != null) {
                    k.a(this.gvp, anVar.aIl.portrait, false, false);
                }
                this.gwC = anVar;
                this.gwD = z;
                Drawable background = this.gwA.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds28));
                if (anVar.CT()) {
                    this.gwB.setText("");
                    L(z, true);
                    this.gwA.setVisibility(0);
                    ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_jinzhu_mvp));
                } else {
                    this.gwB.setText("" + anVar.rank);
                    L(z, false);
                    if (anVar.isFirst()) {
                        this.gwA.setVisibility(0);
                        if (z) {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_jinzhu_anchor_primary));
                        } else {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_jinzhu_rival_primary));
                        }
                    } else {
                        this.gwA.setVisibility(8);
                    }
                }
                this.gwA.setBackgroundDrawable(background);
            }
        }
    }

    private void L(boolean z, boolean z2) {
        if (this.gwB != null) {
            ViewGroup.LayoutParams layoutParams = this.gwB.getLayoutParams();
            if (z2) {
                this.gwB.setBackgroundResource(a.f.icon_challenge_jinzhu_mvp);
                layoutParams.width = getResources().getDimensionPixelOffset(a.e.sdk_ds52);
            } else {
                Drawable background = this.gwB.getBackground();
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
                this.gwB.setBackgroundDrawable(background);
                layoutParams.width = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            this.gwB.setLayoutParams(layoutParams);
        }
    }
}
