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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.live.view.ALALevelView;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
/* loaded from: classes3.dex */
public class CharmRankMedalItemView extends LinearLayout {
    public TextView aVs;
    public HeadImageView fpS;
    public ALALevelView fpU;
    public ImageView fpW;
    private View fpX;
    public TextView fpY;

    public CharmRankMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void setData(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null) {
            k.a(this.fpS, aLaCharmData.portrait, true, false);
            this.fpU.setupLevelIcon(aLaCharmData.level_id);
            this.aVs.setText(aLaCharmData.user_name);
            this.fpY.setText(String.format(getResources().getString(a.i.sdk_charm_rank_forward_diff), StringHelper.formatValue(aLaCharmData.forwardDiff)));
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
        this.fpS = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fpW = (ImageView) findViewById(a.g.iv_pendant);
        this.fpX = findViewById(a.g.layout_name);
        this.fpU = (ALALevelView) findViewById(a.g.level);
        this.aVs = (TextView) findViewById(a.g.tv_name);
        this.fpY = (TextView) findViewById(a.g.tv_content);
        this.fpS.setIsRound(true);
        this.fpS.setAutoChangeStyle(false);
        this.fpS.setDrawBorder(false);
        this.fpS.setDefaultBgResource(a.f.sdk_charm_rank_medal_avatar_default);
        this.fpS.setDefaultErrorResource(a.f.sdk_charm_rank_medal_avatar_default);
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(a.e.sdk_tbds12);
        this.fpU.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.sdk_CharmRankMedalItemView);
        int resourceId = obtainStyledAttributes.getResourceId(a.k.sdk_CharmRankMedalItemView_sdk_charm_rmi_pendant_src, -1);
        if (resourceId > 0) {
            this.fpW.setImageResource(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.k.sdk_CharmRankMedalItemView_sdk_charm_rmi_name_bg, -1);
        if (resourceId2 > 0) {
            this.fpX.setBackgroundResource(resourceId2);
        }
        obtainStyledAttributes.recycle();
    }
}
