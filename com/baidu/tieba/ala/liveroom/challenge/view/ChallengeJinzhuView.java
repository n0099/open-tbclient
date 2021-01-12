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
/* loaded from: classes10.dex */
public class ChallengeJinzhuView extends FrameLayout {
    private final int gvh;
    private ImageView hgH;
    private final int hpO;
    public boolean hvi;
    private HeadImageView hvv;
    private final int hwE;
    private final int hwF;
    private final int hwG;
    private View hwH;
    private ImageView hwI;
    private TextView hwJ;
    private ba hwK;
    private boolean hwL;
    private boolean hwM;

    public ChallengeJinzhuView(@NonNull Context context) {
        super(context);
        this.hpO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hwE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hwF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gvh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hwG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hwL = false;
        this.hvi = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hpO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hwE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hwF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gvh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hwG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hwL = false;
        this.hvi = false;
        initView();
    }

    public ChallengeJinzhuView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hpO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds8);
        this.hwE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds10);
        this.hwF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds52);
        this.gvh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        this.hwG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds24);
        this.hwL = false;
        this.hvi = false;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_jinzhu_item, (ViewGroup) this, true);
        this.hwH = findViewById(a.f.ala_challenge_jinzhu_normal);
        this.hvv = (HeadImageView) findViewById(a.f.ala_challenge_jinzhu_header);
        this.hvv.setIsRound(true);
        this.hvv.setAutoChangeStyle(false);
        this.hvv.setBorderWidth(BdUtilHelper.getDimens(getContext(), a.d.sdk_ds2));
        this.hvv.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha20));
        this.hvv.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hvv.setDefaultResource(a.e.icon_challenge_default_avatar);
        this.hwI = (ImageView) findViewById(a.f.ala_challenge_jinzhu_headwear);
        this.hwJ = (TextView) findViewById(a.f.ala_challenge_jinzhu_tv);
        this.hgH = (ImageView) findViewById(a.f.ala_challenge_jinzhu_empty);
    }

    public void setNeedCloseRecommendFloat(boolean z) {
        this.hvi = z;
    }

    public void a(boolean z, ba baVar, String str) {
        if (baVar == null) {
            if (!this.hwM || this.hwL != z) {
                this.hwL = z;
                this.hwM = true;
                m.a(this.hvv, " ", false, false);
                this.hwH.setVisibility(4);
                this.hgH.setVisibility(0);
                this.hgH.setImageResource(z ? a.e.icon_challenge_jinzhu_anchor_empty : a.e.icon_challenge_jinzhu_rival_empty);
            }
        } else if (baVar.aLL != null) {
            this.hwL = z;
            if (!z || !baVar.a(this.hwK)) {
                this.hwH.setVisibility(0);
                this.hgH.setVisibility(4);
                this.hwM = false;
                if (baVar.aLL != null) {
                    m.a(this.hvv, baVar.aLL.portrait, false, false);
                }
                this.hwK = baVar;
                this.hwL = z;
                Drawable background = this.hwI.getBackground();
                if (!(background instanceof GradientDrawable)) {
                    background = new GradientDrawable();
                }
                ((GradientDrawable) background).setShape(1);
                ((GradientDrawable) background).setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds28));
                if (baVar.Bj()) {
                    this.hwJ.setText("");
                    Q(z, true);
                    this.hwI.setVisibility(0);
                    ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_mvp));
                } else {
                    this.hwJ.setText("" + baVar.rank);
                    Q(z, false);
                    if (baVar.isFirst()) {
                        this.hwI.setVisibility(0);
                        if (z) {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_anchor_primary));
                        } else {
                            ((GradientDrawable) background).setStroke((int) TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()), getResources().getColor(a.c.ala_challenge_jinzhu_rival_primary));
                        }
                    } else {
                        this.hwI.setVisibility(8);
                    }
                }
                this.hwI.setBackgroundDrawable(background);
            }
        }
    }

    private void Q(boolean z, boolean z2) {
        if (this.hwJ != null) {
            ViewGroup.LayoutParams layoutParams = this.hwJ.getLayoutParams();
            if (z2) {
                this.hwJ.setBackgroundResource(a.e.icon_challenge_jinzhu_mvp);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds52);
            } else {
                Drawable background = this.hwJ.getBackground();
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
                this.hwJ.setBackgroundDrawable(background);
                layoutParams.width = getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            this.hwJ.setLayoutParams(layoutParams);
        }
    }
}
