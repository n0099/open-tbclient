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
    public TextView aFA;
    private View aYm;
    public HeadImageView gxo;
    public ALALevelView gxq;
    public ImageView gxs;
    public TextView gxt;

    public CharmRankMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void setData(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null) {
            l.a(this.gxo, aLaCharmData.portrait, true, false);
            this.gxq.setupLevelIcon(aLaCharmData.level_id);
            this.aFA.setText(aLaCharmData.user_name);
            this.gxt.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(aLaCharmData.forwardDiff)));
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
        this.gxo = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gxs = (ImageView) findViewById(a.f.iv_pendant);
        this.aYm = findViewById(a.f.layout_name);
        this.gxq = (ALALevelView) findViewById(a.f.level);
        this.aFA = (TextView) findViewById(a.f.tv_name);
        this.gxt = (TextView) findViewById(a.f.tv_content);
        this.gxo.setIsRound(true);
        this.gxo.setAutoChangeStyle(false);
        this.gxo.setDrawBorder(false);
        this.gxo.setDefaultBgResource(a.e.sdk_charm_rank_medal_avatar_default);
        this.gxo.setDefaultErrorResource(a.e.sdk_charm_rank_medal_avatar_default);
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(a.d.sdk_tbds12);
        this.gxq.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.sdk_CharmRankMedalItemView);
        int resourceId = obtainStyledAttributes.getResourceId(a.j.sdk_CharmRankMedalItemView_sdk_charm_rmi_pendant_src, -1);
        if (resourceId > 0) {
            this.gxs.setImageResource(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.j.sdk_CharmRankMedalItemView_sdk_charm_rmi_name_bg, -1);
        if (resourceId2 > 0) {
            this.aYm.setBackgroundResource(resourceId2);
        }
        obtainStyledAttributes.recycle();
    }
}
