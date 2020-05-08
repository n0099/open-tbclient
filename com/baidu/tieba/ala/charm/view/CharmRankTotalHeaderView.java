package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
import java.util.List;
/* loaded from: classes3.dex */
public class CharmRankTotalHeaderView extends RelativeLayout implements View.OnClickListener {
    private CharmRankMedalItemView fcw;
    private CharmRankMedalItemView fcx;
    private CharmRankMedalItemView fcy;
    private a fcz;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ALaCharmData aLaCharmData);
    }

    public CharmRankTotalHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.fcz = aVar;
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
        if (this.fcz != null && (view.getTag() instanceof ALaCharmData)) {
            this.fcz.a((ALaCharmData) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, 0, 0, getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        LayoutInflater.from(getContext()).inflate(a.h.sdk_charm_rank_total_header, (ViewGroup) this, true);
        this.fcw = (CharmRankMedalItemView) findViewById(a.g.medal_first);
        this.fcx = (CharmRankMedalItemView) findViewById(a.g.medal_second);
        this.fcy = (CharmRankMedalItemView) findViewById(a.g.medal_third);
        ViewGroup.LayoutParams layoutParams = this.fcw.fcp.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds144);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
            this.fcw.fcp.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.fcw.fct.getLayoutParams();
        if (layoutParams2 != null) {
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.e.sdk_ds220);
            layoutParams2.width = dimensionPixelOffset2;
            layoutParams2.height = dimensionPixelOffset2;
            this.fcw.fct.setLayoutParams(layoutParams2);
        }
    }

    private void setFirstMedal(ALaCharmData aLaCharmData) {
        this.fcw.setOnClickListener(this);
        this.fcw.setTag(aLaCharmData);
        this.fcw.setData(aLaCharmData);
        this.fcw.fcv.setVisibility(8);
    }

    private void setSecondMedal(ALaCharmData aLaCharmData) {
        this.fcx.setOnClickListener(this);
        this.fcx.setTag(aLaCharmData);
        this.fcx.setData(aLaCharmData);
    }

    private void setThirdMedal(ALaCharmData aLaCharmData) {
        this.fcy.setOnClickListener(this);
        this.fcy.setTag(aLaCharmData);
        this.fcy.setData(aLaCharmData);
    }
}
