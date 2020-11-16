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
    private ImageView gQk;
    private final int gYO;
    private final int ghf;
    public boolean hej;
    private HeadImageView hew;
    private final int hfE;
    private final int hfF;
    private final int hfG;
    private View hfH;
    private ImageView hfI;
    private TextView hfJ;
    private ax hfK;
    private boolean hfL;
    private boolean hfM;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.gYO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hfE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hfF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.ghf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hfG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hfL = false;
        this.hej = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gYO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hfE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hfF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.ghf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hfG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hfL = false;
        this.hej = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gYO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hfE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hfF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.ghf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hfG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hfL = false;
        this.hej = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.hfH = findViewById(a.f.ala_challenge_jinzhu_normal);
        this.hew = (HeadImageView) findViewById(a.f.ala_challenge_jinzhu_header);
        this.hew.setIsRound(true);
        this.hew.setAutoChangeStyle(false);
        this.hew.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds2));
        this.hew.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha20));
        this.hew.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hew.setDefaultResource(a.e.icon_challenge_default_avatar);
        this.hfI = (ImageView) findViewById(a.f.ala_challenge_jinzhu_headwear);
        this.hfJ = (TextView) findViewById(a.f.ala_challenge_jinzhu_tv);
        this.gQk = (ImageView) findViewById(a.f.ala_challenge_jinzhu_empty);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hej = z;
    }

    public void a(boolean z, ax axVar, String str) {
        if (axVar == null) {
            if (!this.hfM || this.hfL != z) {
                this.hfL = z;
                this.hfM = true;
                l.a(this.hew, " ", false, false);
                this.hfH.setVisibility(4);
                this.gQk.setVisibility(0);
                this.gQk.setImageResource(z ? a.e.icon_challenge_jinzhu_anchor_empty : a.e.icon_challenge_jinzhu_rival_empty);
            }
        } else if (axVar.aMK != null) {
            this.hfL = z;
            if (!z || !axVar.a(this.hfK)) {
                this.hfH.setVisibility(0);
                this.gQk.setVisibility(4);
                this.hfM = false;
                if (axVar.aMK != null) {
                    l.a(this.hew, axVar.aMK.portrait, false, false);
                }
                this.hfK = axVar;
                this.hfL = z;
                Drawable background = this.hfI.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds28));
                if (axVar.Ed()) {
                    this.hfJ.setText("");
                    O(z, true);
                    this.hfI.setVisibility(0);
                    ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_mvp));
                } else {
                    this.hfJ.setText("" + axVar.rank);
                    O(z, false);
                    if (axVar.isFirst()) {
                        this.hfI.setVisibility(0);
                        if (z) {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_anchor_primary));
                        } else {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_rival_primary));
                        }
                    } else {
                        this.hfI.setVisibility(8);
                    }
                }
                this.hfI.setBackgroundDrawable(background);
            }
        }
    }

    private void O(boolean z, boolean z2) {
        if (this.hfJ != null) {
            ViewGroup.LayoutParams layoutParams = this.hfJ.getLayoutParams();
            if (z2) {
                this.hfJ.setBackgroundResource(a.e.icon_challenge_jinzhu_mvp);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds52);
            } else {
                Drawable background = this.hfJ.getBackground();
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
                this.hfJ.setBackgroundDrawable(background);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            this.hfJ.setLayoutParams(layoutParams);
        }
    }
}
