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
    public TextView aDP;
    private View aWB;
    public HeadImageView gwV;
    public ALALevelView gwX;
    public ImageView gwZ;
    public TextView gxa;

    public CharmRankMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void setData(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null) {
            l.a(this.gwV, aLaCharmData.portrait, true, false);
            this.gwX.setupLevelIcon(aLaCharmData.level_id);
            this.aDP.setText(aLaCharmData.user_name);
            this.gxa.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(aLaCharmData.forwardDiff)));
        }
    }

    private void init(AttributeSet attributeSet) {
        initView();
        initAttrs(attributeSet);
    }

    private void initView() {
        setBackgroundColor(0);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(a.g.sdk_charm_rank_medal_item, (ViewGroup) this, true);
        this.gwV = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gwZ = (ImageView) findViewById(a.f.iv_pendant);
        this.aWB = findViewById(a.f.layout_name);
        this.gwX = (ALALevelView) findViewById(a.f.level);
        this.aDP = (TextView) findViewById(a.f.tv_name);
        this.gxa = (TextView) findViewById(a.f.tv_content);
        this.gwV.setIsRound(true);
        this.gwV.setAutoChangeStyle(false);
        this.gwV.setDrawBorder(false);
        this.gwV.setDefaultBgResource(a.e.sdk_charm_rank_medal_avatar_default);
        this.gwV.setDefaultErrorResource(a.e.sdk_charm_rank_medal_avatar_default);
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(a.d.sdk_tbds12);
        this.gwX.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.sdk_CharmRankMedalItemView);
        int resourceId = obtainStyledAttributes.getResourceId(a.j.sdk_CharmRankMedalItemView_sdk_charm_rmi_pendant_src, -1);
        if (resourceId > 0) {
            this.gwZ.setImageResource(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.j.sdk_CharmRankMedalItemView_sdk_charm_rmi_name_bg, -1);
        if (resourceId2 > 0) {
            this.aWB.setBackgroundResource(resourceId2);
        }
        obtainStyledAttributes.recycle();
    }
}
