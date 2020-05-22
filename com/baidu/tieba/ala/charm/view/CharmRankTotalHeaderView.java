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
    private CharmRankMedalItemView fpZ;
    private CharmRankMedalItemView fqa;
    private CharmRankMedalItemView fqb;
    private a fqc;

    /* loaded from: classes3.dex */
    public interface a {
        void a(ALaCharmData aLaCharmData);
    }

    public CharmRankTotalHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.fqc = aVar;
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
        if (this.fqc != null && (view.getTag() instanceof ALaCharmData)) {
            this.fqc.a((ALaCharmData) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, 0, 0, getResources().getDimensionPixelOffset(a.e.sdk_ds20));
        LayoutInflater.from(getContext()).inflate(a.h.sdk_charm_rank_total_header, (ViewGroup) this, true);
        this.fpZ = (CharmRankMedalItemView) findViewById(a.g.medal_first);
        this.fqa = (CharmRankMedalItemView) findViewById(a.g.medal_second);
        this.fqb = (CharmRankMedalItemView) findViewById(a.g.medal_third);
        ViewGroup.LayoutParams layoutParams = this.fpZ.fpS.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds144);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
            this.fpZ.fpS.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.fpZ.fpW.getLayoutParams();
        if (layoutParams2 != null) {
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.e.sdk_ds220);
            layoutParams2.width = dimensionPixelOffset2;
            layoutParams2.height = dimensionPixelOffset2;
            this.fpZ.fpW.setLayoutParams(layoutParams2);
        }
    }

    private void setFirstMedal(ALaCharmData aLaCharmData) {
        this.fpZ.setOnClickListener(this);
        this.fpZ.setTag(aLaCharmData);
        this.fpZ.setData(aLaCharmData);
        this.fpZ.fpY.setVisibility(8);
    }

    private void setSecondMedal(ALaCharmData aLaCharmData) {
        this.fqa.setOnClickListener(this);
        this.fqa.setTag(aLaCharmData);
        this.fqa.setData(aLaCharmData);
    }

    private void setThirdMedal(ALaCharmData aLaCharmData) {
        this.fqb.setOnClickListener(this);
        this.fqb.setTag(aLaCharmData);
        this.fqb.setData(aLaCharmData);
    }
}
