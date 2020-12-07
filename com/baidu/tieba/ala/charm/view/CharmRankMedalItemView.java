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
    public TextView aGv;
    private View aZR;
    public HeadImageView gFG;
    public ALALevelView gFI;
    public ImageView gFM;
    public TextView gFN;

    public CharmRankMedalItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void setData(ALaCharmData aLaCharmData) {
        if (aLaCharmData != null) {
            l.a(this.gFG, aLaCharmData.portrait, true, false);
            this.gFI.setupLevelIcon(aLaCharmData.level_id);
            this.aGv.setText(aLaCharmData.user_name);
            this.gFN.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(aLaCharmData.forwardDiff)));
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
        this.gFG = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gFM = (ImageView) findViewById(a.f.iv_pendant);
        this.aZR = findViewById(a.f.layout_name);
        this.gFI = (ALALevelView) findViewById(a.f.level);
        this.aGv = (TextView) findViewById(a.f.tv_name);
        this.gFN = (TextView) findViewById(a.f.tv_content);
        this.gFG.setIsRound(true);
        this.gFG.setAutoChangeStyle(false);
        this.gFG.setDrawBorder(false);
        this.gFG.setDefaultBgResource(a.e.sdk_charm_rank_medal_avatar_default);
        this.gFG.setDefaultErrorResource(a.e.sdk_charm_rank_medal_avatar_default);
        int dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_tbds7);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(a.d.sdk_tbds12);
        this.gFI.setTextLayoutParams(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.sdk_CharmRankMedalItemView);
        int resourceId = obtainStyledAttributes.getResourceId(a.j.sdk_CharmRankMedalItemView_sdk_charm_rmi_pendant_src, -1);
        if (resourceId > 0) {
            this.gFM.setImageResource(resourceId);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(a.j.sdk_CharmRankMedalItemView_sdk_charm_rmi_name_bg, -1);
        if (resourceId2 > 0) {
            this.aZR.setBackgroundResource(resourceId2);
        }
        obtainStyledAttributes.recycle();
    }
}
