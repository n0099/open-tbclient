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
/* loaded from: classes10.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private BaseActivity bRI;
    private boolean gmV;
    private ArrayList<g> goH;
    private ArrayList<d> goJ;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseActivity baseActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        this.bRI = baseActivity;
        this.gmV = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.goJ = new ArrayList<>();
        this.goH = new ArrayList<>();
        g gVar = new g();
        gVar.gPS = this.bRI.getString(a.h.hour_rank_list_title);
        gVar.gPT = "hour";
        this.goJ.add(new com.baidu.tieba.ala.fragment.a(this.bRI, "hour", i, j, str, this.gmV, str2, this.otherParams, str3, j2, str4, gVar.gPS));
        this.goH.add(gVar);
        g gVar2 = new g();
        gVar2.gPS = this.bRI.getString(a.h.rank_list_day_charm_title);
        gVar2.gPT = "charm_day";
        this.goJ.add(new com.baidu.tieba.ala.fragment.a(this.bRI, "charm_day", i, j, str, this.gmV, str2, this.otherParams, str3, j2, str4, gVar2.gPS));
        this.goH.add(gVar2);
    }

    public int ET(String str) {
        if (this.goJ == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.goH.size()) {
                return -1;
            }
            if (!str.equals(this.goH.get(i2).gPT)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.goJ != null) {
            return this.goJ.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.goJ;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void ti(int i) {
        if (!this.gmV && i >= 0 && i < this.goH.size()) {
            g gVar = this.goH.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (gVar.gPT.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (gVar.gPT.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
