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
import com.baidu.live.data.as;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.l;
/* loaded from: classes4.dex */
public class ChallengeJinzhuView extends FrameLayout {
    private final int fFx;
    private ImageView gkK;
    private final int gsS;
    private HeadImageView gyE;
    public boolean gyr;
    private final int gzM;
    private final int gzN;
    private final int gzO;
    private View gzP;
    private ImageView gzQ;
    private TextView gzR;
    private as gzS;
    private boolean gzT;
    private boolean gzU;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.gsS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gzM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gzN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fFx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gzO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gzT = false;
        this.gyr = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gsS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gzM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gzN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fFx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gzO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gzT = false;
        this.gyr = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gsS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gzM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gzN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fFx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gzO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gzT = false;
        this.gyr = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.gzP = findViewById(a.g.ala_challenge_jinzhu_normal);
        this.gyE = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.gyE.setIsRound(true);
        this.gyE.setAutoChangeStyle(false);
        this.gyE.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.gyE.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.gyE.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gyE.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.gzQ = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.gzR = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
        this.gkK = (ImageView) findViewById(a.g.ala_challenge_jinzhu_empty);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.gyr = z;
    }

    public void a(boolean z, as asVar, String str) {
        if (asVar == null) {
            if (!this.gzU || this.gzT != z) {
                this.gzT = z;
                this.gzU = true;
                l.a(this.gyE, " ", false, false);
                this.gzP.setVisibility(4);
                this.gkK.setVisibility(0);
                this.gkK.setImageResource(z ? a.f.icon_challenge_jinzhu_anchor_empty : a.f.icon_challenge_jinzhu_rival_empty);
            }
        } else if (asVar.aJI != null) {
            this.gzT = z;
            if (!z || !asVar.a(this.gzS)) {
                this.gzP.setVisibility(0);
                this.gkK.setVisibility(4);
                this.gzU = false;
                if (asVar.aJI != null) {
                    l.a(this.gyE, asVar.aJI.portrait, false, false);
                }
                this.gzS = asVar;
                this.gzT = z;
                Drawable background = this.gzQ.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds28));
                if (asVar.Dj()) {
                    this.gzR.setText("");
                    L(z, true);
                    this.gzQ.setVisibility(0);
                    ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_jinzhu_mvp));
                } else {
                    this.gzR.setText("" + asVar.rank);
                    L(z, false);
                    if (asVar.isFirst()) {
                        this.gzQ.setVisibility(0);
                        if (z) {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_jinzhu_anchor_primary));
                        } else {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_jinzhu_rival_primary));
                        }
                    } else {
                        this.gzQ.setVisibility(8);
                    }
                }
                this.gzQ.setBackgroundDrawable(background);
            }
        }
    }

    private void L(boolean z, boolean z2) {
        if (this.gzR != null) {
            ViewGroup.LayoutParams layoutParams = this.gzR.getLayoutParams();
            if (z2) {
                this.gzR.setBackgroundResource(a.f.icon_challenge_jinzhu_mvp);
                layoutParams.width = getResources().getDimensionPixelOffset(a.e.sdk_ds52);
            } else {
                Drawable background = this.gzR.getBackground();
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
                this.gzR.setBackgroundDrawable(background);
                layoutParams.width = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            this.gzR.setLayoutParams(layoutParams);
        }
    }
}
