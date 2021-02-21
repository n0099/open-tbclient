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
/* loaded from: classes11.dex */
public class CharmRankMedalItemView extends LinearLayout {
    public TextView aDM;
    private View aZQ;
    public HeadImageView gPH;
    public ALALevelView gPJ;
    public ImageView gPN;
    public TextView gPO;

    public CharmRankMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void setData(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null) {
            m.a(this.gPH, aLaCharmData.portrait, true, false);
            this.gPJ.setupLevelIcon(aLaCharmData.level_id);
            this.aDM.setText(aLaCharmData.user_name);
            this.gPO.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(aLaCharmData.forwardDiff)));
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
        this.gPH = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gPN = (ImageView) findViewById(a.f.iv_pendant);
        this.aZQ = findViewById(a.f.layout_name);
        this.gPJ = (ALALevelView) findViewById(a.f.level);
        this.aDM = (TextView) findViewById(a.f.tv_name);
        this.gPO = (TextView) findViewById(a.f.tv_content);
        this.gPH.setIsRound(true);
        this.gPH.setAutoChangeStyle(false);
        this.gPH.setDrawBorder(false);
        this.gPH.setDefaultBgResource(a.e.sdk_charm_rank_medal_avatar_default);
        this.gPH.setDefaultErrorResource(a.e.sdk_charm_rank_medal_avatar_default);
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(a.d.sdk_tbds12);
        this.gPJ.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.sdk_CharmRankMedalItemView);
        int resourceId = obtainStyledAttributes.getResourceId(a.j.sdk_CharmRankMedalItemView_sdk_charm_rmi_pendant_src, -1);
        if (resourceId > 0) {
            this.gPN.setImageResource(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.j.sdk_CharmRankMedalItemView_sdk_charm_rmi_name_bg, -1);
        if (resourceId2 > 0) {
            this.aZQ.setBackgroundResource(resourceId2);
        }
        obtainStyledAttributes.recycle();
    }
}
