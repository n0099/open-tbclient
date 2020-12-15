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
    private boolean ghe;
    private ArrayList<g> giR;
    private ArrayList<d> giT;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseActivity baseActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        this.bQN = baseActivity;
        this.ghe = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.giT = new ArrayList<>();
        this.giR = new ArrayList<>();
        g gVar = new g();
        gVar.gIM = this.bQN.getString(a.h.hour_rank_list_title);
        gVar.gIN = "hour";
        this.giT.add(new com.baidu.tieba.ala.fragment.a(this.bQN, "hour", i, j, str, this.ghe, str2, this.otherParams, str3, j2, str4, gVar.gIM));
        this.giR.add(gVar);
        g gVar2 = new g();
        gVar2.gIM = this.bQN.getString(a.h.rank_list_day_charm_title);
        gVar2.gIN = "charm_day";
        this.giT.add(new com.baidu.tieba.ala.fragment.a(this.bQN, "charm_day", i, j, str, this.ghe, str2, this.otherParams, str3, j2, str4, gVar2.gIM));
        this.giR.add(gVar2);
    }

    public int Gg(String str) {
        if (this.giT == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.giR.size()) {
                return -1;
            }
            if (!str.equals(this.giR.get(i2).gIN)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.giT != null) {
            return this.giT.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.giT;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void uC(int i) {
        if (!this.ghe && i >= 0 && i < this.giR.size()) {
            g gVar = this.giR.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (gVar.gIN.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (gVar.gIN.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
