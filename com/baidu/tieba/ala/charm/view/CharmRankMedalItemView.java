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
import com.baidu.live.utils.k;
import com.baidu.live.view.ALALevelView;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
/* loaded from: classes7.dex */
public class CharmRankMedalItemView extends LinearLayout {
    public TextView aAR;
    public HeadImageView fRT;
    public ALALevelView fRV;
    public ImageView fRX;
    private View fRY;
    public TextView fRZ;

    public CharmRankMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void setData(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null) {
            k.a(this.fRT, aLaCharmData.portrait, true, false);
            this.fRV.setupLevelIcon(aLaCharmData.level_id);
            this.aAR.setText(aLaCharmData.user_name);
            this.fRZ.setText(String.format(getResources().getString(a.i.sdk_charm_rank_forward_diff), StringHelper.formatValue(aLaCharmData.forwardDiff)));
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
        this.fRT = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fRX = (ImageView) findViewById(a.g.iv_pendant);
        this.fRY = findViewById(a.g.layout_name);
        this.fRV = (ALALevelView) findViewById(a.g.level);
        this.aAR = (TextView) findViewById(a.g.tv_name);
        this.fRZ = (TextView) findViewById(a.g.tv_content);
        this.fRT.setIsRound(true);
        this.fRT.setAutoChangeStyle(false);
        this.fRT.setDrawBorder(false);
        this.fRT.setDefaultBgResource(a.f.sdk_charm_rank_medal_avatar_default);
        this.fRT.setDefaultErrorResource(a.f.sdk_charm_rank_medal_avatar_default);
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(a.e.sdk_tbds12);
        this.fRV.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.sdk_CharmRankMedalItemView);
        int resourceId = obtainStyledAttributes.getResourceId(a.k.sdk_CharmRankMedalItemView_sdk_charm_rmi_pendant_src, -1);
        if (resourceId > 0) {
            this.fRX.setImageResource(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.k.sdk_CharmRankMedalItemView_sdk_charm_rmi_name_bg, -1);
        if (resourceId2 > 0) {
            this.fRY.setBackgroundResource(resourceId2);
        }
        obtainStyledAttributes.recycle();
    }
}
