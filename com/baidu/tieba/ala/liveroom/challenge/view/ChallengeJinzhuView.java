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
    private final int fRG;
    private final int gHn;
    public boolean gMK;
    private HeadImageView gMX;
    private final int gOf;
    private final int gOg;
    private final int gOh;
    private View gOi;
    private ImageView gOj;
    private TextView gOk;
    private as gOl;
    private boolean gOm;
    private boolean gOn;
    private ImageView gzd;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.gHn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gOf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gOg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fRG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gOh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gOm = false;
        this.gMK = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gHn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gOf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gOg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fRG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gOh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gOm = false;
        this.gMK = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gHn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gOf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gOg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.fRG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gOh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.gOm = false;
        this.gMK = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.gOi = findViewById(a.g.ala_challenge_jinzhu_normal);
        this.gMX = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.gMX.setIsRound(true);
        this.gMX.setAutoChangeStyle(false);
        this.gMX.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.gMX.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.gMX.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gMX.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.gOj = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.gOk = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
        this.gzd = (ImageView) findViewById(a.g.ala_challenge_jinzhu_empty);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.gMK = z;
    }

    public void a(boolean z, as asVar, String str) {
        if (asVar == null) {
            if (!this.gOn || this.gOm != z) {
                this.gOm = z;
                this.gOn = true;
                l.a(this.gMX, " ", false, false);
                this.gOi.setVisibility(4);
                this.gzd.setVisibility(0);
                this.gzd.setImageResource(z ? a.f.icon_challenge_jinzhu_anchor_empty : a.f.icon_challenge_jinzhu_rival_empty);
            }
        } else if (asVar.aMN != null) {
            this.gOm = z;
            if (!z || !asVar.a(this.gOl)) {
                this.gOi.setVisibility(0);
                this.gzd.setVisibility(4);
                this.gOn = false;
                if (asVar.aMN != null) {
                    l.a(this.gMX, asVar.aMN.portrait, false, false);
                }
                this.gOl = asVar;
                this.gOm = z;
                Drawable background = this.gOj.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds28));
                if (asVar.Eg()) {
                    this.gOk.setText("");
                    L(z, true);
                    this.gOj.setVisibility(0);
                    ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_jinzhu_mvp));
                } else {
                    this.gOk.setText("" + asVar.rank);
                    L(z, false);
                    if (asVar.isFirst()) {
                        this.gOj.setVisibility(0);
                        if (z) {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_jinzhu_anchor_primary));
                        } else {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_jinzhu_rival_primary));
                        }
                    } else {
                        this.gOj.setVisibility(8);
                    }
                }
                this.gOj.setBackgroundDrawable(background);
            }
        }
    }

    private void L(boolean z, boolean z2) {
        if (this.gOk != null) {
            ViewGroup.LayoutParams layoutParams = this.gOk.getLayoutParams();
            if (z2) {
                this.gOk.setBackgroundResource(a.f.icon_challenge_jinzhu_mvp);
                layoutParams.width = getResources().getDimensionPixelOffset(a.e.sdk_ds52);
            } else {
                Drawable background = this.gOk.getBackground();
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
                this.gOk.setBackgroundDrawable(background);
                layoutParams.width = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            this.gOk.setLayoutParams(layoutParams);
        }
    }
}
