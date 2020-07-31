package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
import java.util.List;
/* loaded from: classes4.dex */
public class CharmRankTotalHeaderView extends RelativeLayout implements View.OnClickListener {
    private CharmRankMedalItemView fGF;
    private CharmRankMedalItemView fGG;
    private CharmRankMedalItemView fGH;
    private a fGI;

    /* loaded from: classes4.dex */
    public interface a {
        void a(ALaCharmData aLaCharmData);
    }

    public CharmRankTotalHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.fGI = aVar;
    }

    public void setData(List<ALaCharmData> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            setFirstMedal(list.get(0));
            if (size > 1) {
                setSecondMedal(list.get(1));
                if (size > 2) {
                    setThirdMedal(list.get(2));
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fGI != null && (view.getTag() instanceof ALaCharmData)) {
            this.fGI.a((ALaCharmData) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, 0, 0, getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        LayoutInflater.from(getContext()).inflate(a.h.sdk_charm_rank_total_header, (ViewGroup) this, true);
        this.fGF = (CharmRankMedalItemView) findViewById(a.g.medal_first);
        this.fGG = (CharmRankMedalItemView) findViewById(a.g.medal_second);
        this.fGH = (CharmRankMedalItemView) findViewById(a.g.medal_third);
        ViewGroup.LayoutParams layoutParams = this.fGF.fGy.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds144);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
            this.fGF.fGy.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.fGF.fGC.getLayoutParams();
        if (layoutParams2 != null) {
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.e.sdk_ds220);
            layoutParams2.width = dimensionPixelOffset2;
            layoutParams2.height = dimensionPixelOffset2;
            this.fGF.fGC.setLayoutParams(layoutParams2);
        }
    }

    private void setFirstMedal(ALaCharmData aLaCharmData) {
        this.fGF.setOnClickListener(this);
        this.fGF.setTag(aLaCharmData);
        this.fGF.setData(aLaCharmData);
        this.fGF.fGE.setVisibility(8);
    }

    private void setSecondMedal(ALaCharmData aLaCharmData) {
        this.fGG.setOnClickListener(this);
        this.fGG.setTag(aLaCharmData);
        this.fGG.setData(aLaCharmData);
    }

    private void setThirdMedal(ALaCharmData aLaCharmData) {
        this.fGH.setOnClickListener(this);
        this.fGH.setTag(aLaCharmData);
        this.fGH.setData(aLaCharmData);
    }
}
