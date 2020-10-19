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
    public TextView aEC;
    private View aVz;
    public ImageView ghB;
    public TextView ghC;
    public HeadImageView ghx;
    public ALALevelView ghz;

    public CharmRankMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void setData(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null) {
            l.a(this.ghx, aLaCharmData.portrait, true, false);
            this.ghz.setupLevelIcon(aLaCharmData.level_id);
            this.aEC.setText(aLaCharmData.user_name);
            this.ghC.setText(String.format(getResources().getString(a.i.sdk_charm_rank_forward_diff), StringHelper.formatValue(aLaCharmData.forwardDiff)));
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
        this.ghx = (HeadImageView) findViewById(a.g.iv_avatar);
        this.ghB = (ImageView) findViewById(a.g.iv_pendant);
        this.aVz = findViewById(a.g.layout_name);
        this.ghz = (ALALevelView) findViewById(a.g.level);
        this.aEC = (TextView) findViewById(a.g.tv_name);
        this.ghC = (TextView) findViewById(a.g.tv_content);
        this.ghx.setIsRound(true);
        this.ghx.setAutoChangeStyle(false);
        this.ghx.setDrawBorder(false);
        this.ghx.setDefaultBgResource(a.f.sdk_charm_rank_medal_avatar_default);
        this.ghx.setDefaultErrorResource(a.f.sdk_charm_rank_medal_avatar_default);
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(a.e.sdk_tbds12);
        this.ghz.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.sdk_CharmRankMedalItemView);
        int resourceId = obtainStyledAttributes.getResourceId(a.k.sdk_CharmRankMedalItemView_sdk_charm_rmi_pendant_src, -1);
        if (resourceId > 0) {
            this.ghB.setImageResource(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.k.sdk_CharmRankMedalItemView_sdk_charm_rmi_name_bg, -1);
        if (resourceId2 > 0) {
            this.aVz.setBackgroundResource(resourceId2);
        }
        obtainStyledAttributes.recycle();
    }
}
