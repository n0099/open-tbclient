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
    private CharmRankMedalItemView gxu;
    private CharmRankMedalItemView gxv;
    private CharmRankMedalItemView gxw;
    private a gxx;

    /* loaded from: classes4.dex */
    public interface a {
        void a(ALaCharmData aLaCharmData);
    }

    public CharmRankTotalHeaderView(Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.gxx = aVar;
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
        if (this.gxx != null && (view.getTag() instanceof ALaCharmData)) {
            this.gxx.a((ALaCharmData) view.getTag());
        }
    }

    private void init() {
        setBackgroundColor(0);
        setPadding(0, 0, 0, getResources().getDimensionPixelOffset(a.d.sdk_ds20));
        LayoutInflater.from(getContext()).inflate(a.g.sdk_charm_rank_total_header, (ViewGroup) this, true);
        this.gxu = (CharmRankMedalItemView) findViewById(a.f.medal_first);
        this.gxv = (CharmRankMedalItemView) findViewById(a.f.medal_second);
        this.gxw = (CharmRankMedalItemView) findViewById(a.f.medal_third);
        ViewGroup.LayoutParams layoutParams = this.gxu.gxo.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds144);
            layoutParams.width = dimensionPixelOffset;
            layoutParams.height = dimensionPixelOffset;
            this.gxu.gxo.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.gxu.gxs.getLayoutParams();
        if (layoutParams2 != null) {
            int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(a.d.sdk_ds220);
            layoutParams2.width = dimensionPixelOffset2;
            layoutParams2.height = dimensionPixelOffset2;
            this.gxu.gxs.setLayoutParams(layoutParams2);
        }
    }

    private void setFirstMedal(ALaCharmData aLaCharmData) {
        this.gxu.setOnClickListener(this);
        this.gxu.setTag(aLaCharmData);
        this.gxu.setData(aLaCharmData);
        this.gxu.gxt.setVisibility(8);
    }

    private void setSecondMedal(ALaCharmData aLaCharmData) {
        this.gxv.setOnClickListener(this);
        this.gxv.setTag(aLaCharmData);
        this.gxv.setData(aLaCharmData);
    }

    private void setThirdMedal(ALaCharmData aLaCharmData) {
        this.gxw.setOnClickListener(this);
        this.gxw.setTag(aLaCharmData);
        this.gxw.setData(aLaCharmData);
    }
}
