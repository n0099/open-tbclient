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
import com.baidu.live.data.av;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.l;
/* loaded from: classes4.dex */
public class ChallengeJinzhuView extends FrameLayout {
    private ImageView gKR;
    private final int gTc;
    private HeadImageView gYL;
    public boolean gYy;
    private final int gZT;
    private final int gZU;
    private final int gZV;
    private View gZW;
    private ImageView gZX;
    private TextView gZY;
    private av gZZ;
    private final int gbJ;
    private boolean haa;
    private boolean hab;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.gTc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gZT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gZU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.gbJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gZV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.haa = false;
        this.gYy = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gTc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gZT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gZU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.gbJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gZV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.haa = false;
        this.gYy = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gTc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gZT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
        this.gZU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds52);
        this.gbJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.gZV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        this.haa = false;
        this.gYy = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.gZW = findViewById(a.g.ala_challenge_jinzhu_normal);
        this.gYL = (HeadImageView) findViewById(a.g.ala_challenge_jinzhu_header);
        this.gYL.setIsRound(true);
        this.gYL.setAutoChangeStyle(false);
        this.gYL.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.e.sdk_ds2));
        this.gYL.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha20));
        this.gYL.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gYL.setDefaultResource(a.f.icon_challenge_default_avatar);
        this.gZX = (ImageView) findViewById(a.g.ala_challenge_jinzhu_headwear);
        this.gZY = (TextView) findViewById(a.g.ala_challenge_jinzhu_tv);
        this.gKR = (ImageView) findViewById(a.g.ala_challenge_jinzhu_empty);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.gYy = z;
    }

    public void a(boolean z, av avVar, String str) {
        if (avVar == null) {
            if (!this.hab || this.haa != z) {
                this.haa = z;
                this.hab = true;
                l.a(this.gYL, " ", false, false);
                this.gZW.setVisibility(4);
                this.gKR.setVisibility(0);
                this.gKR.setImageResource(z ? a.f.icon_challenge_jinzhu_anchor_empty : a.f.icon_challenge_jinzhu_rival_empty);
            }
        } else if (avVar.aNs != null) {
            this.haa = z;
            if (!z || !avVar.a(this.gZZ)) {
                this.gZW.setVisibility(0);
                this.gKR.setVisibility(4);
                this.hab = false;
                if (avVar.aNs != null) {
                    l.a(this.gYL, avVar.aNs.portrait, false, false);
                }
                this.gZZ = avVar;
                this.haa = z;
                Drawable background = this.gZX.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds28));
                if (avVar.Ep()) {
                    this.gZY.setText("");
                    O(z, true);
                    this.gZX.setVisibility(0);
                    ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_jinzhu_mvp));
                } else {
                    this.gZY.setText("" + avVar.rank);
                    O(z, false);
                    if (avVar.isFirst()) {
                        this.gZX.setVisibility(0);
                        if (z) {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_jinzhu_anchor_primary));
                        } else {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.d.ala_challenge_jinzhu_rival_primary));
                        }
                    } else {
                        this.gZX.setVisibility(8);
                    }
                }
                this.gZX.setBackgroundDrawable(background);
            }
        }
    }

    private void O(boolean z, boolean z2) {
        if (this.gZY != null) {
            ViewGroup.LayoutParams layoutParams = this.gZY.getLayoutParams();
            if (z2) {
                this.gZY.setBackgroundResource(a.f.icon_challenge_jinzhu_mvp);
                layoutParams.width = getResources().getDimensionPixelOffset(a.e.sdk_ds52);
            } else {
                Drawable background = this.gZY.getBackground();
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
                this.gZY.setBackgroundDrawable(background);
                layoutParams.width = getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            this.gZY.setLayoutParams(layoutParams);
        }
    }
}
