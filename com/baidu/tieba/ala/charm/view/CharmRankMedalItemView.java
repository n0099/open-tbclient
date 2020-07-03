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
/* loaded from: classes3.dex */
public class CharmRankMedalItemView extends LinearLayout {
    public TextView aXZ;
    public HeadImageView fBo;
    public ALALevelView fBq;
    public ImageView fBs;
    private View fBt;
    public TextView fBu;

    public CharmRankMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void setData(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null) {
            k.a(this.fBo, aLaCharmData.portrait, true, false);
            this.fBq.setupLevelIcon(aLaCharmData.level_id);
            this.aXZ.setText(aLaCharmData.user_name);
            this.fBu.setText(String.format(getResources().getString(a.i.sdk_charm_rank_forward_diff), StringHelper.formatValue(aLaCharmData.forwardDiff)));
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
        this.fBo = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fBs = (ImageView) findViewById(a.g.iv_pendant);
        this.fBt = findViewById(a.g.layout_name);
        this.fBq = (ALALevelView) findViewById(a.g.level);
        this.aXZ = (TextView) findViewById(a.g.tv_name);
        this.fBu = (TextView) findViewById(a.g.tv_content);
        this.fBo.setIsRound(true);
        this.fBo.setAutoChangeStyle(false);
        this.fBo.setDrawBorder(false);
        this.fBo.setDefaultBgResource(a.f.sdk_charm_rank_medal_avatar_default);
        this.fBo.setDefaultErrorResource(a.f.sdk_charm_rank_medal_avatar_default);
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(a.e.sdk_tbds12);
        this.fBq.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.sdk_CharmRankMedalItemView);
        int resourceId = obtainStyledAttributes.getResourceId(a.k.sdk_CharmRankMedalItemView_sdk_charm_rmi_pendant_src, -1);
        if (resourceId > 0) {
            this.fBs.setImageResource(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.k.sdk_CharmRankMedalItemView_sdk_charm_rmi_name_bg, -1);
        if (resourceId2 > 0) {
            this.fBt.setBackgroundResource(resourceId2);
        }
        obtainStyledAttributes.recycle();
    }
}
