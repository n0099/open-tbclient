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
import com.baidu.tieba.ala.data.f;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private BaseActivity boL;
    private boolean ffg;
    private ArrayList<f> fgO;
    private ArrayList<d> fgQ;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseActivity baseActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        this.boL = baseActivity;
        this.ffg = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.fgQ = new ArrayList<>();
        this.fgO = new ArrayList<>();
        f fVar = new f();
        fVar.fDS = this.boL.getString(a.i.hour_rank_list_title);
        fVar.fDT = "hour";
        this.fgQ.add(new com.baidu.tieba.ala.fragment.a(this.boL, "hour", i, j, str, this.ffg, str2, this.otherParams, str3, j2, str4, fVar.fDS));
        this.fgO.add(fVar);
        f fVar2 = new f();
        fVar2.fDS = this.boL.getString(a.i.rank_list_day_charm_title);
        fVar2.fDT = "charm_day";
        this.fgQ.add(new com.baidu.tieba.ala.fragment.a(this.boL, "charm_day", i, j, str, this.ffg, str2, this.otherParams, str3, j2, str4, fVar2.fDS));
        this.fgO.add(fVar2);
    }

    public int AW(String str) {
        if (this.fgQ == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fgO.size()) {
                return -1;
            }
            if (!str.equals(this.fgO.get(i2).fDT)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.fgQ != null) {
            return this.fgQ.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.fgQ;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void pP(int i) {
        if (!this.ffg && i >= 0 && i < this.fgO.size()) {
            f fVar = this.fgO.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (fVar.fDT.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (fVar.fDT.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
