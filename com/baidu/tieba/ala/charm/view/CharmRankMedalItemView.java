package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.l;
import com.baidu.live.view.ALALevelView;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
/* loaded from: classes4.dex */
public class CharmRankMedalItemView extends LinearLayout {
    public TextView aBx;
    private View aSo;
    public HeadImageView fVe;
    public ALALevelView fVg;
    public ImageView fVi;
    public TextView fVj;

    public CharmRankMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void setData(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null) {
            l.a(this.fVe, aLaCharmData.portrait, true, false);
            this.fVg.setupLevelIcon(aLaCharmData.level_id);
            this.aBx.setText(aLaCharmData.user_name);
            this.fVj.setText(String.format(getResources().getString(a.i.sdk_charm_rank_forward_diff), StringHelper.formatValue(aLaCharmData.forwardDiff)));
        }
    }

    private void init(AttributeSet attributeSet) {
        initView();
        initAttrs(attributeSet);
    }

    private void initView() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.h.sdk_charm_rank_medal_item, (ViewGroup) this, true);
        this.fVe = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fVi = (ImageView) findViewById(a.g.iv_pendant);
        this.aSo = findViewById(a.g.layout_name);
        this.fVg = (ALALevelView) findViewById(a.g.level);
        this.aBx = (TextView) findViewById(a.g.tv_name);
        this.fVj = (TextView) findViewById(a.g.tv_content);
        this.fVe.setIsRound(true);
        this.fVe.setAutoChangeStyle(false);
        this.fVe.setDrawBorder(false);
        this.fVe.setDefaultBgResource(a.f.sdk_charm_rank_medal_avatar_default);
        this.fVe.setDefaultErrorResource(a.f.sdk_charm_rank_medal_avatar_default);
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(a.e.sdk_tbds12);
        this.fVg.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.sdk_CharmRankMedalItemView);
        int resourceId = obtainStyledAttributes.getResourceId(a.k.sdk_CharmRankMedalItemView_sdk_charm_rmi_pendant_src, -1);
        if (resourceId > 0) {
            this.fVi.setImageResource(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.k.sdk_CharmRankMedalItemView_sdk_charm_rmi_name_bg, -1);
        if (resourceId2 > 0) {
            this.aSo.setBackgroundResource(resourceId2);
        }
        obtainStyledAttributes.recycle();
    }
}
