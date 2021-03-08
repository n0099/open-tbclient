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
    private BaseActivity bXa;
    private boolean grB;
    private ArrayList<g> gtn;
    private ArrayList<d> gtp;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseActivity baseActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        this.bXa = baseActivity;
        this.grB = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.gtp = new ArrayList<>();
        this.gtn = new ArrayList<>();
        g gVar = new g();
        gVar.gUz = this.bXa.getString(a.h.hour_rank_list_title);
        gVar.gUA = "hour";
        this.gtp.add(new com.baidu.tieba.ala.fragment.a(this.bXa, "hour", i, j, str, this.grB, str2, this.otherParams, str3, j2, str4, gVar.gUz));
        this.gtn.add(gVar);
        g gVar2 = new g();
        gVar2.gUz = this.bXa.getString(a.h.rank_list_day_charm_title);
        gVar2.gUA = "charm_day";
        this.gtp.add(new com.baidu.tieba.ala.fragment.a(this.bXa, "charm_day", i, j, str, this.grB, str2, this.otherParams, str3, j2, str4, gVar2.gUz));
        this.gtn.add(gVar2);
    }

    public int FB(String str) {
        if (this.gtp == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.gtn.size()) {
                return -1;
            }
            if (!str.equals(this.gtn.get(i2).gUA)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.gtp != null) {
            return this.gtp.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.gtp;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void tq(int i) {
        if (!this.grB && i >= 0 && i < this.gtn.size()) {
            g gVar = this.gtn.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (gVar.gUA.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (gVar.gUA.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
