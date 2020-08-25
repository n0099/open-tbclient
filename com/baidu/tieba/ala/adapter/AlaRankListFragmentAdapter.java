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
/* loaded from: classes7.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private BaseActivity buT;
    private boolean fvF;
    private ArrayList<g> fxs;
    private ArrayList<d> fxu;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseActivity baseActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        this.buT = baseActivity;
        this.fvF = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.fxu = new ArrayList<>();
        this.fxs = new ArrayList<>();
        g gVar = new g();
        gVar.fUE = this.buT.getString(a.i.hour_rank_list_title);
        gVar.fUF = "hour";
        this.fxu.add(new com.baidu.tieba.ala.fragment.a(this.buT, "hour", i, j, str, this.fvF, str2, this.otherParams, str3, j2, str4, gVar.fUE));
        this.fxs.add(gVar);
        g gVar2 = new g();
        gVar2.fUE = this.buT.getString(a.i.rank_list_day_charm_title);
        gVar2.fUF = "charm_day";
        this.fxu.add(new com.baidu.tieba.ala.fragment.a(this.buT, "charm_day", i, j, str, this.fvF, str2, this.otherParams, str3, j2, str4, gVar2.fUE));
        this.fxs.add(gVar2);
    }

    public int Eb(String str) {
        if (this.fxu == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fxs.size()) {
                return -1;
            }
            if (!str.equals(this.fxs.get(i2).fUF)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.fxu != null) {
            return this.fxu.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.fxu;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void sq(int i) {
        if (!this.fvF && i >= 0 && i < this.fxs.size()) {
            g gVar = this.fxs.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (gVar.fUF.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (gVar.fUF.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
