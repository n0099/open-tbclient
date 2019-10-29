package com.baidu.tieba.ala.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class AlaRankListFragmentAdapter extends FragmentPagerAdapter {
    private boolean duG;
    private ArrayList<com.baidu.tieba.ala.data.b> dve;
    private ArrayList<AlaRankListFragment> dvf;
    private BaseFragmentActivity dvg;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.dvg = baseFragmentActivity;
        this.duG = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.dvf = new ArrayList<>();
        this.dve = new ArrayList<>();
        com.baidu.tieba.ala.data.b bVar = new com.baidu.tieba.ala.data.b();
        this.dvf.add(AlaRankListFragment.a("hour", i, j, str, this.duG, str2, this.otherParams, str3, j2, str4));
        bVar.dGZ = this.dvg.getString(a.i.hour_rank_list_title);
        bVar.dHa = "hour";
        this.dve.add(bVar);
        this.dvf.add(AlaRankListFragment.a("charm_day", i, j, str, this.duG, str2, this.otherParams, str3, j2, str4));
        com.baidu.tieba.ala.data.b bVar2 = new com.baidu.tieba.ala.data.b();
        bVar2.dGZ = this.dvg.getString(a.i.rank_list_day_charm_title);
        bVar2.dHa = "charm_day";
        this.dve.add(bVar2);
    }

    public int sB(String str) {
        if (this.dvf == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dve.size()) {
                return -1;
            }
            if (!str.equals(this.dve.get(i2).dHa)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.dvf == null) {
            return null;
        }
        return this.dvf.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.dvf != null) {
            return this.dvf.size();
        }
        return 0;
    }

    public String ma(int i) {
        if (this.dve != null && i >= 0 && i < this.dve.size()) {
            return this.dve.get(i).dGZ;
        }
        return null;
    }

    public void mb(int i) {
        if (!this.duG && i >= 0 && i < this.dve.size()) {
            com.baidu.tieba.ala.data.b bVar = this.dve.get(i);
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
            alaStaticItem.addParams("other_params", this.otherParams);
            if (bVar.dHa.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
            } else if (bVar.dHa.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }
}
