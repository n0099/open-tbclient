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
import com.baidu.live.data.ax;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.l;
/* loaded from: classes4.dex */
public class ChallengeJinzhuView extends FrameLayout {
    private ImageView gQD;
    private final int gZh;
    private final int ghy;
    public boolean heC;
    private HeadImageView heP;
    private final int hfX;
    private final int hfY;
    private final int hfZ;
    private View hga;
    private ImageView hgb;
    private TextView hgc;
    private ax hgd;
    private boolean hge;
    private boolean hgf;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.gZh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hfX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hfY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.ghy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hfZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hge = false;
        this.heC = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gZh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hfX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hfY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.ghy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hfZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hge = false;
        this.heC = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gZh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hfX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hfY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.ghy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hfZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hge = false;
        this.heC = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.hga = findViewById(a.f.ala_challenge_jinzhu_normal);
        this.heP = (HeadImageView) findViewById(a.f.ala_challenge_jinzhu_header);
        this.heP.setIsRound(true);
        this.heP.setAutoChangeStyle(false);
        this.heP.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds2));
        this.heP.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha20));
        this.heP.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.heP.setDefaultResource(a.e.icon_challenge_default_avatar);
        this.hgb = (ImageView) findViewById(a.f.ala_challenge_jinzhu_headwear);
        this.hgc = (TextView) findViewById(a.f.ala_challenge_jinzhu_tv);
        this.gQD = (ImageView) findViewById(a.f.ala_challenge_jinzhu_empty);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.heC = z;
    }

    public void a(boolean z, ax axVar, String str) {
        if (axVar == null) {
            if (!this.hgf || this.hge != z) {
                this.hge = z;
                this.hgf = true;
                l.a(this.heP, " ", false, false);
                this.hga.setVisibility(4);
                this.gQD.setVisibility(0);
                this.gQD.setImageResource(z ? a.e.icon_challenge_jinzhu_anchor_empty : a.e.icon_challenge_jinzhu_rival_empty);
            }
        } else if (axVar.aOv != null) {
            this.hge = z;
            if (!z || !axVar.a(this.hgd)) {
                this.hga.setVisibility(0);
                this.gQD.setVisibility(4);
                this.hgf = false;
                if (axVar.aOv != null) {
                    l.a(this.heP, axVar.aOv.portrait, false, false);
                }
                this.hgd = axVar;
                this.hge = z;
                Drawable background = this.hgb.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds28));
                if (axVar.EM()) {
                    this.hgc.setText("");
                    O(z, true);
                    this.hgb.setVisibility(0);
                    ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_mvp));
                } else {
                    this.hgc.setText("" + axVar.rank);
                    O(z, false);
                    if (axVar.isFirst()) {
                        this.hgb.setVisibility(0);
                        if (z) {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_anchor_primary));
                        } else {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_rival_primary));
                        }
                    } else {
                        this.hgb.setVisibility(8);
                    }
                }
                this.hgb.setBackgroundDrawable(background);
            }
        }
    }

    private void O(boolean z, boolean z2) {
        if (this.hgc != null) {
            ViewGroup.LayoutParams layoutParams = this.hgc.getLayoutParams();
            if (z2) {
                this.hgc.setBackgroundResource(a.e.icon_challenge_jinzhu_mvp);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds52);
            } else {
                Drawable background = this.hgc.getBackground();
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
                this.hgc.setBackgroundDrawable(background);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            this.hgc.setLayoutParams(layoutParams);
        }
    }
}
