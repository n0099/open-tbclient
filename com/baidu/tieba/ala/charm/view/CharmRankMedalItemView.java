package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.m;
import com.baidu.live.view.ALALevelView;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
/* loaded from: classes10.dex */
public class CharmRankMedalItemView extends LinearLayout {
    public TextView aBZ;
    private View aWK;
    public HeadImageView gMN;
    public ALALevelView gMP;
    public ImageView gMT;
    public TextView gMU;

    public CharmRankMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void setData(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null) {
            m.a(this.gMN, aLaCharmData.portrait, true, false);
            this.gMP.setupLevelIcon(aLaCharmData.level_id);
            this.aBZ.setText(aLaCharmData.user_name);
            this.gMU.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(aLaCharmData.forwardDiff)));
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
        this.gMN = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gMT = (ImageView) findViewById(a.f.iv_pendant);
        this.aWK = findViewById(a.f.layout_name);
        this.gMP = (ALALevelView) findViewById(a.f.level);
        this.aBZ = (TextView) findViewById(a.f.tv_name);
        this.gMU = (TextView) findViewById(a.f.tv_content);
        this.gMN.setIsRound(true);
        this.gMN.setAutoChangeStyle(false);
        this.gMN.setDrawBorder(false);
        this.gMN.setDefaultBgResource(a.e.sdk_charm_rank_medal_avatar_default);
        this.gMN.setDefaultErrorResource(a.e.sdk_charm_rank_medal_avatar_default);
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(a.d.sdk_tbds12);
        this.gMP.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.sdk_CharmRankMedalItemView);
        int resourceId = obtainStyledAttributes.getResourceId(a.j.sdk_CharmRankMedalItemView_sdk_charm_rmi_pendant_src, -1);
        if (resourceId > 0) {
            this.gMT.setImageResource(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.j.sdk_CharmRankMedalItemView_sdk_charm_rmi_name_bg, -1);
        if (resourceId2 > 0) {
            this.aWK.setBackgroundResource(resourceId2);
        }
        obtainStyledAttributes.recycle();
    }
}
