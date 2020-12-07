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
    private BaseActivity bQN;
    private boolean ghc;
    private ArrayList<g> giP;
    private ArrayList<d> giR;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseActivity baseActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        this.bQN = baseActivity;
        this.ghc = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.giR = new ArrayList<>();
        this.giP = new ArrayList<>();
        g gVar = new g();
        gVar.gIK = this.bQN.getString(a.h.hour_rank_list_title);
        gVar.gIL = "hour";
        this.giR.add(new com.baidu.tieba.ala.fragment.a(this.bQN, "hour", i, j, str, this.ghc, str2, this.otherParams, str3, j2, str4, gVar.gIK));
        this.giP.add(gVar);
        g gVar2 = new g();
        gVar2.gIK = this.bQN.getString(a.h.rank_list_day_charm_title);
        gVar2.gIL = "charm_day";
        this.giR.add(new com.baidu.tieba.ala.fragment.a(this.bQN, "charm_day", i, j, str, this.ghc, str2, this.otherParams, str3, j2, str4, gVar2.gIK));
        this.giP.add(gVar2);
    }

    public int Gg(String str) {
        if (this.giR == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.giP.size()) {
                return -1;
            }
            if (!str.equals(this.giP.get(i2).gIL)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.giR != null) {
            return this.giR.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.giR;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void uC(int i) {
        if (!this.ghc && i >= 0 && i < this.giP.size()) {
            g gVar = this.giP.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (gVar.gIL.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (gVar.gIL.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
