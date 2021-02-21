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
    private final int gyf;
    private final int hBc;
    private final int hBd;
    private final int hBe;
    private View hBf;
    private ImageView hBg;
    private TextView hBh;
    private be hBi;
    private boolean hBj;
    private boolean hBk;
    private ImageView hll;
    private final int hum;
    public boolean hzG;
    private HeadImageView hzT;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.hum = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hBc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hBd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gyf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hBe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hBj = false;
        this.hzG = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hum = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hBc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hBd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gyf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hBe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hBj = false;
        this.hzG = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hum = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hBc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hBd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gyf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hBe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hBj = false;
        this.hzG = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.hBf = findViewById(a.f.ala_challenge_jinzhu_normal);
        this.hzT = (HeadImageView) findViewById(a.f.ala_challenge_jinzhu_header);
        this.hzT.setIsRound(true);
        this.hzT.setAutoChangeStyle(false);
        this.hzT.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds2));
        this.hzT.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha20));
        this.hzT.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hzT.setDefaultResource(a.e.icon_challenge_default_avatar);
        this.hBg = (ImageView) findViewById(a.f.ala_challenge_jinzhu_headwear);
        this.hBh = (TextView) findViewById(a.f.ala_challenge_jinzhu_tv);
        this.hll = (ImageView) findViewById(a.f.ala_challenge_jinzhu_empty);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hzG = z;
    }

    public void a(boolean z, be beVar, String str) {
        if (beVar == null) {
            if (!this.hBk || this.hBj != z) {
                this.hBj = z;
                this.hBk = true;
                m.a(this.hzT, " ", false, false);
                this.hBf.setVisibility(4);
                this.hll.setVisibility(0);
                this.hll.setImageResource(z ? a.e.icon_challenge_jinzhu_anchor_empty : a.e.icon_challenge_jinzhu_rival_empty);
            }
        } else if (beVar.aOI != null) {
            this.hBj = z;
            if (!z || !beVar.a(this.hBi)) {
                this.hBf.setVisibility(0);
                this.hll.setVisibility(4);
                this.hBk = false;
                if (beVar.aOI != null) {
                    m.a(this.hzT, beVar.aOI.portrait, false, false);
                }
                this.hBi = beVar;
                this.hBj = z;
                Drawable background = this.hBg.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds28));
                if (beVar.Cw()) {
                    this.hBh.setText("");
                    Q(z, true);
                    this.hBg.setVisibility(0);
                    ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_mvp));
                } else {
                    this.hBh.setText("" + beVar.rank);
                    Q(z, false);
                    if (beVar.isFirst()) {
                        this.hBg.setVisibility(0);
                        if (z) {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_anchor_primary));
                        } else {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_rival_primary));
                        }
                    } else {
                        this.hBg.setVisibility(8);
                    }
                }
                this.hBg.setBackgroundDrawable(background);
            }
        }
    }

    private void Q(boolean z, boolean z2) {
        if (this.hBh != null) {
            ViewGroup.LayoutParams layoutParams = this.hBh.getLayoutParams();
            if (z2) {
                this.hBh.setBackgroundResource(a.e.icon_challenge_jinzhu_mvp);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds52);
            } else {
                Drawable background = this.hBh.getBackground();
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
                this.hBh.setBackgroundDrawable(background);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            this.hBh.setLayoutParams(layoutParams);
        }
    }
}
