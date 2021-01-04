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
import com.baidu.live.data.ba;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.m;
/* loaded from: classes11.dex */
public class ChallengeJinzhuView extends FrameLayout {
    private final int gzO;
    private HeadImageView hAb;
    private final int hBk;
    private final int hBl;
    private final int hBm;
    private View hBn;
    private ImageView hBo;
    private TextView hBp;
    private ba hBq;
    private boolean hBr;
    private boolean hBs;
    private ImageView hlo;
    private final int huu;
    public boolean hzO;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.huu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hBk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hBl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gzO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hBm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hBr = false;
        this.hzO = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.huu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hBk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hBl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gzO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hBm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hBr = false;
        this.hzO = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.huu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hBk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hBl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gzO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hBm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hBr = false;
        this.hzO = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.hBn = findViewById(a.f.ala_challenge_jinzhu_normal);
        this.hAb = (HeadImageView) findViewById(a.f.ala_challenge_jinzhu_header);
        this.hAb.setIsRound(true);
        this.hAb.setAutoChangeStyle(false);
        this.hAb.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds2));
        this.hAb.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha20));
        this.hAb.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hAb.setDefaultResource(a.e.icon_challenge_default_avatar);
        this.hBo = (ImageView) findViewById(a.f.ala_challenge_jinzhu_headwear);
        this.hBp = (TextView) findViewById(a.f.ala_challenge_jinzhu_tv);
        this.hlo = (ImageView) findViewById(a.f.ala_challenge_jinzhu_empty);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hzO = z;
    }

    public void a(boolean z, ba baVar, String str) {
        if (baVar == null) {
            if (!this.hBs || this.hBr != z) {
                this.hBr = z;
                this.hBs = true;
                m.a(this.hAb, " ", false, false);
                this.hBn.setVisibility(4);
                this.hlo.setVisibility(0);
                this.hlo.setImageResource(z ? a.e.icon_challenge_jinzhu_anchor_empty : a.e.icon_challenge_jinzhu_rival_empty);
            }
        } else if (baVar.aQy != null) {
            this.hBr = z;
            if (!z || !baVar.a(this.hBq)) {
                this.hBn.setVisibility(0);
                this.hlo.setVisibility(4);
                this.hBs = false;
                if (baVar.aQy != null) {
                    m.a(this.hAb, baVar.aQy.portrait, false, false);
                }
                this.hBq = baVar;
                this.hBr = z;
                Drawable background = this.hBo.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds28));
                if (baVar.Fe()) {
                    this.hBp.setText("");
                    Q(z, true);
                    this.hBo.setVisibility(0);
                    ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_mvp));
                } else {
                    this.hBp.setText("" + baVar.rank);
                    Q(z, false);
                    if (baVar.isFirst()) {
                        this.hBo.setVisibility(0);
                        if (z) {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_anchor_primary));
                        } else {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_rival_primary));
                        }
                    } else {
                        this.hBo.setVisibility(8);
                    }
                }
                this.hBo.setBackgroundDrawable(background);
            }
        }
    }

    private void Q(boolean z, boolean z2) {
        if (this.hBp != null) {
            ViewGroup.LayoutParams layoutParams = this.hBp.getLayoutParams();
            if (z2) {
                this.hBp.setBackgroundResource(a.e.icon_challenge_jinzhu_mvp);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds52);
            } else {
                Drawable background = this.hBp.getBackground();
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
                this.hBp.setBackgroundDrawable(background);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            this.hBp.setLayoutParams(layoutParams);
        }
    }
}
