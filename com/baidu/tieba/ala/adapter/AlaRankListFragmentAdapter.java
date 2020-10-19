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
    private BaseActivity bEO;
    private boolean fLd;
    private ArrayList<g> fMR;
    private ArrayList<d> fMT;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseActivity baseActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        this.bEO = baseActivity;
        this.fLd = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.fMT = new ArrayList<>();
        this.fMR = new ArrayList<>();
        g gVar = new g();
        gVar.gkp = this.bEO.getString(a.i.hour_rank_list_title);
        gVar.gkq = "hour";
        this.fMT.add(new com.baidu.tieba.ala.fragment.a(this.bEO, "hour", i, j, str, this.fLd, str2, this.otherParams, str3, j2, str4, gVar.gkp));
        this.fMR.add(gVar);
        g gVar2 = new g();
        gVar2.gkp = this.bEO.getString(a.i.rank_list_day_charm_title);
        gVar2.gkq = "charm_day";
        this.fMT.add(new com.baidu.tieba.ala.fragment.a(this.bEO, "charm_day", i, j, str, this.fLd, str2, this.otherParams, str3, j2, str4, gVar2.gkp));
        this.fMR.add(gVar2);
    }

    public int Fk(String str) {
        if (this.fMT == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fMR.size()) {
                return -1;
            }
            if (!str.equals(this.fMR.get(i2).gkq)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.fMT != null) {
            return this.fMT.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.fMT;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void tg(int i) {
        if (!this.fLd && i >= 0 && i < this.fMR.size()) {
            g gVar = this.fMR.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (gVar.gkq.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (gVar.gkq.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
