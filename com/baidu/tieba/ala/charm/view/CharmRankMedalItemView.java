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
    public HeadImageView fqd;
    public ALALevelView fqf;
    public ImageView fqh;
    private View fqi;
    public TextView fqj;

    public CharmRankMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void setData(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null) {
            k.a(this.fqd, aLaCharmData.portrait, true, false);
            this.fqf.setupLevelIcon(aLaCharmData.level_id);
            this.aVs.setText(aLaCharmData.user_name);
            this.fqj.setText(String.format(getResources().getString(a.i.sdk_charm_rank_forward_diff), StringHelper.formatValue(aLaCharmData.forwardDiff)));
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
        this.fqd = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fqh = (ImageView) findViewById(a.g.iv_pendant);
        this.fqi = findViewById(a.g.layout_name);
        this.fqf = (ALALevelView) findViewById(a.g.level);
        this.aVs = (TextView) findViewById(a.g.tv_name);
        this.fqj = (TextView) findViewById(a.g.tv_content);
        this.fqd.setIsRound(true);
        this.fqd.setAutoChangeStyle(false);
        this.fqd.setDrawBorder(false);
        this.fqd.setDefaultBgResource(a.f.sdk_charm_rank_medal_avatar_default);
        this.fqd.setDefaultErrorResource(a.f.sdk_charm_rank_medal_avatar_default);
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_tbds7);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(a.e.sdk_tbds12);
        this.fqf.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.sdk_CharmRankMedalItemView);
        int resourceId = obtainStyledAttributes.getResourceId(a.k.sdk_CharmRankMedalItemView_sdk_charm_rmi_pendant_src, -1);
        if (resourceId > 0) {
            this.fqh.setImageResource(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.k.sdk_CharmRankMedalItemView_sdk_charm_rmi_name_bg, -1);
        if (resourceId2 > 0) {
            this.fqi.setBackgroundResource(resourceId2);
        }
        obtainStyledAttributes.recycle();
    }
}
