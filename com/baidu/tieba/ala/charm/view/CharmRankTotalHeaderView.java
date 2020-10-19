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
    private CharmRankMedalItemView ghD;
    private CharmRankMedalItemView ghE;
    private CharmRankMedalItemView ghF;
    private a ghG;

    /* loaded from: classes4.dex */
    public interface a {
        void a(ALaCharmData aLaCharmData);
    }

    public CharmRankTotalHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.ghG = aVar;
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
        if (this.ghG != null && (view.getTag() instanceof ALaCharmData)) {
            this.ghG.a((ALaCharmData) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, 0, 0, getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        LayoutInflater.from(getContext()).inflate(a.h.sdk_charm_rank_total_header, (ViewGroup) this, true);
        this.ghD = (CharmRankMedalItemView) findViewById(a.g.medal_first);
        this.ghE = (CharmRankMedalItemView) findViewById(a.g.medal_second);
        this.ghF = (CharmRankMedalItemView) findViewById(a.g.medal_third);
        ViewGroup.LayoutParams layoutParams = this.ghD.ghx.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds144);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
            this.ghD.ghx.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.ghD.ghB.getLayoutParams();
        if (layoutParams2 != null) {
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.e.sdk_ds220);
            layoutParams2.width = dimensionPixelOffset2;
            layoutParams2.height = dimensionPixelOffset2;
            this.ghD.ghB.setLayoutParams(layoutParams2);
        }
    }

    private void setFirstMedal(ALaCharmData aLaCharmData) {
        this.ghD.setOnClickListener(this);
        this.ghD.setTag(aLaCharmData);
        this.ghD.setData(aLaCharmData);
        this.ghD.ghC.setVisibility(8);
    }

    private void setSecondMedal(ALaCharmData aLaCharmData) {
        this.ghE.setOnClickListener(this);
        this.ghE.setTag(aLaCharmData);
        this.ghE.setData(aLaCharmData);
    }

    private void setThirdMedal(ALaCharmData aLaCharmData) {
        this.ghF.setOnClickListener(this);
        this.ghF.setTag(aLaCharmData);
        this.ghF.setData(aLaCharmData);
    }
}
