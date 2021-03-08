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
/* loaded from: classes10.dex */
public class ChallengeJinzhuView extends FrameLayout {
    private final int gzO;
    private HeadImageView hBC;
    public boolean hBp;
    private final int hCL;
    private final int hCM;
    private final int hCN;
    private View hCO;
    private ImageView hCP;
    private TextView hCQ;
    private be hCR;
    private boolean hCS;
    private boolean hCT;
    private ImageView hmU;
    private final int hvV;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.hvV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hCL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hCM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gzO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hCN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hCS = false;
        this.hBp = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hvV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hCL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hCM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gzO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hCN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hCS = false;
        this.hBp = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hvV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hCL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hCM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gzO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hCN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hCS = false;
        this.hBp = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.hCO = findViewById(a.f.ala_challenge_jinzhu_normal);
        this.hBC = (HeadImageView) findViewById(a.f.ala_challenge_jinzhu_header);
        this.hBC.setIsRound(true);
        this.hBC.setAutoChangeStyle(false);
        this.hBC.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds2));
        this.hBC.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha20));
        this.hBC.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hBC.setDefaultResource(a.e.icon_challenge_default_avatar);
        this.hCP = (ImageView) findViewById(a.f.ala_challenge_jinzhu_headwear);
        this.hCQ = (TextView) findViewById(a.f.ala_challenge_jinzhu_tv);
        this.hmU = (ImageView) findViewById(a.f.ala_challenge_jinzhu_empty);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hBp = z;
    }

    public void a(boolean z, be beVar, String str) {
        if (beVar == null) {
            if (!this.hCT || this.hCS != z) {
                this.hCS = z;
                this.hCT = true;
                m.a(this.hBC, " ", false, false);
                this.hCO.setVisibility(4);
                this.hmU.setVisibility(0);
                this.hmU.setImageResource(z ? a.e.icon_challenge_jinzhu_anchor_empty : a.e.icon_challenge_jinzhu_rival_empty);
            }
        } else if (beVar.aQi != null) {
            this.hCS = z;
            if (!z || !beVar.a(this.hCR)) {
                this.hCO.setVisibility(0);
                this.hmU.setVisibility(4);
                this.hCT = false;
                if (beVar.aQi != null) {
                    m.a(this.hBC, beVar.aQi.portrait, false, false);
                }
                this.hCR = beVar;
                this.hCS = z;
                Drawable background = this.hCP.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds28));
                if (beVar.Cz()) {
                    this.hCQ.setText("");
                    Q(z, true);
                    this.hCP.setVisibility(0);
                    ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_mvp));
                } else {
                    this.hCQ.setText("" + beVar.rank);
                    Q(z, false);
                    if (beVar.isFirst()) {
                        this.hCP.setVisibility(0);
                        if (z) {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_anchor_primary));
                        } else {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_rival_primary));
                        }
                    } else {
                        this.hCP.setVisibility(8);
                    }
                }
                this.hCP.setBackgroundDrawable(background);
            }
        }
    }

    private void Q(boolean z, boolean z2) {
        if (this.hCQ != null) {
            ViewGroup.LayoutParams layoutParams = this.hCQ.getLayoutParams();
            if (z2) {
                this.hCQ.setBackgroundResource(a.e.icon_challenge_jinzhu_mvp);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds52);
            } else {
                Drawable background = this.hCQ.getBackground();
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
                this.hCQ.setBackgroundDrawable(background);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            this.hCQ.setLayoutParams(layoutParams);
        }
    }
}
