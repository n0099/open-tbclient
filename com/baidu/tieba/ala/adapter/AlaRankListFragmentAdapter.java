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
    private BaseActivity byl;
    private ArrayList<g> fAI;
    private ArrayList<d> fAK;
    private boolean fyU;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseActivity baseActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        this.byl = baseActivity;
        this.fyU = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.fAK = new ArrayList<>();
        this.fAI = new ArrayList<>();
        g gVar = new g();
        gVar.fXX = this.byl.getString(a.i.hour_rank_list_title);
        gVar.fXY = "hour";
        this.fAK.add(new com.baidu.tieba.ala.fragment.a(this.byl, "hour", i, j, str, this.fyU, str2, this.otherParams, str3, j2, str4, gVar.fXX));
        this.fAI.add(gVar);
        g gVar2 = new g();
        gVar2.fXX = this.byl.getString(a.i.rank_list_day_charm_title);
        gVar2.fXY = "charm_day";
        this.fAK.add(new com.baidu.tieba.ala.fragment.a(this.byl, "charm_day", i, j, str, this.fyU, str2, this.otherParams, str3, j2, str4, gVar2.fXX));
        this.fAI.add(gVar2);
    }

    public int Ez(String str) {
        if (this.fAK == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fAI.size()) {
                return -1;
            }
            if (!str.equals(this.fAI.get(i2).fXY)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.fAK != null) {
            return this.fAK.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.fAK;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void sI(int i) {
        if (!this.fyU && i >= 0 && i < this.fAI.size()) {
            g gVar = this.fAI.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (gVar.fXY.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (gVar.fXY.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
