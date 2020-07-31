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
    private BaseActivity bpg;
    private boolean fkj;
    private ArrayList<g> flW;
    private ArrayList<d> flY;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseActivity baseActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        this.bpg = baseActivity;
        this.fkj = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.flY = new ArrayList<>();
        this.flW = new ArrayList<>();
        g gVar = new g();
        gVar.fJn = this.bpg.getString(a.i.hour_rank_list_title);
        gVar.fJo = "hour";
        this.flY.add(new com.baidu.tieba.ala.fragment.a(this.bpg, "hour", i, j, str, this.fkj, str2, this.otherParams, str3, j2, str4, gVar.fJn));
        this.flW.add(gVar);
        g gVar2 = new g();
        gVar2.fJn = this.bpg.getString(a.i.rank_list_day_charm_title);
        gVar2.fJo = "charm_day";
        this.flY.add(new com.baidu.tieba.ala.fragment.a(this.bpg, "charm_day", i, j, str, this.fkj, str2, this.otherParams, str3, j2, str4, gVar2.fJn));
        this.flW.add(gVar2);
    }

    public int BH(String str) {
        if (this.flY == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.flW.size()) {
                return -1;
            }
            if (!str.equals(this.flW.get(i2).fJo)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.flY != null) {
            return this.flY.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.flY;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void qe(int i) {
        if (!this.fkj && i >= 0 && i < this.flW.size()) {
            g gVar = this.flW.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (gVar.fJo.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (gVar.fJo.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
