package com.baidu.tieba.ala.adapter;

import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.data.g;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private BaseActivity bVA;
    private boolean gpE;
    private ArrayList<g> grq;
    private ArrayList<d> grs;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseActivity baseActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        this.bVA = baseActivity;
        this.gpE = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.grs = new ArrayList<>();
        this.grq = new ArrayList<>();
        g gVar = new g();
        gVar.gSC = this.bVA.getString(a.h.hour_rank_list_title);
        gVar.gSD = "hour";
        this.grs.add(new com.baidu.tieba.ala.fragment.a(this.bVA, "hour", i, j, str, this.gpE, str2, this.otherParams, str3, j2, str4, gVar.gSC));
        this.grq.add(gVar);
        g gVar2 = new g();
        gVar2.gSC = this.bVA.getString(a.h.rank_list_day_charm_title);
        gVar2.gSD = "charm_day";
        this.grs.add(new com.baidu.tieba.ala.fragment.a(this.bVA, "charm_day", i, j, str, this.gpE, str2, this.otherParams, str3, j2, str4, gVar2.gSC));
        this.grq.add(gVar2);
    }

    public int Fr(String str) {
        if (this.grs == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.grq.size()) {
                return -1;
            }
            if (!str.equals(this.grq.get(i2).gSD)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.grs != null) {
            return this.grs.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.grs;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void to(int i) {
        if (!this.gpE && i >= 0 && i < this.grq.size()) {
            g gVar = this.grq.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (gVar.gSD.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (gVar.gSD.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
