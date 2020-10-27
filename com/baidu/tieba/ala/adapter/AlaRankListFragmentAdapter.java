package com.baidu.tieba.ala.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
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
/* loaded from: classes4.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private BaseActivity bHN;
    private boolean fTu;
    private ArrayList<g> fVg;
    private ArrayList<d> fVi;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseActivity baseActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        this.bHN = baseActivity;
        this.fTu = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.fVi = new ArrayList<>();
        this.fVg = new ArrayList<>();
        g gVar = new g();
        gVar.gut = this.bHN.getString(a.i.hour_rank_list_title);
        gVar.guu = "hour";
        this.fVi.add(new com.baidu.tieba.ala.fragment.a(this.bHN, "hour", i, j, str, this.fTu, str2, this.otherParams, str3, j2, str4, gVar.gut));
        this.fVg.add(gVar);
        g gVar2 = new g();
        gVar2.gut = this.bHN.getString(a.i.rank_list_day_charm_title);
        gVar2.guu = "charm_day";
        this.fVi.add(new com.baidu.tieba.ala.fragment.a(this.bHN, "charm_day", i, j, str, this.fTu, str2, this.otherParams, str3, j2, str4, gVar2.gut));
        this.fVg.add(gVar2);
    }

    public int FD(String str) {
        if (this.fVi == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fVg.size()) {
                return -1;
            }
            if (!str.equals(this.fVg.get(i2).guu)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.fVi != null) {
            return this.fVi.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.fVi;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void tq(int i) {
        if (!this.fTu && i >= 0 && i < this.fVg.size()) {
            g gVar = this.fVg.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (gVar.guu.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (gVar.guu.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
