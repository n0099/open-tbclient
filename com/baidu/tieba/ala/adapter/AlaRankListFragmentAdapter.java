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
/* loaded from: classes11.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private BaseActivity bWu;
    private boolean grC;
    private ArrayList<g> gto;
    private ArrayList<d> gtq;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseActivity baseActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        this.bWu = baseActivity;
        this.grC = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.gtq = new ArrayList<>();
        this.gto = new ArrayList<>();
        g gVar = new g();
        gVar.gUy = this.bWu.getString(a.h.hour_rank_list_title);
        gVar.gUz = "hour";
        this.gtq.add(new com.baidu.tieba.ala.fragment.a(this.bWu, "hour", i, j, str, this.grC, str2, this.otherParams, str3, j2, str4, gVar.gUy));
        this.gto.add(gVar);
        g gVar2 = new g();
        gVar2.gUy = this.bWu.getString(a.h.rank_list_day_charm_title);
        gVar2.gUz = "charm_day";
        this.gtq.add(new com.baidu.tieba.ala.fragment.a(this.bWu, "charm_day", i, j, str, this.grC, str2, this.otherParams, str3, j2, str4, gVar2.gUy));
        this.gto.add(gVar2);
    }

    public int Gf(String str) {
        if (this.gtq == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.gto.size()) {
                return -1;
            }
            if (!str.equals(this.gto.get(i2).gUz)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.gtq != null) {
            return this.gtq.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.gtq;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void uO(int i) {
        if (!this.grC && i >= 0 && i < this.gto.size()) {
            g gVar = this.gto.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (gVar.gUz.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (gVar.gUz.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
