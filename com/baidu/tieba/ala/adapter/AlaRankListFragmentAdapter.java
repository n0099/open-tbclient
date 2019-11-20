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
    private boolean dtP;
    private ArrayList<com.baidu.tieba.ala.data.b> dun;
    private ArrayList<AlaRankListFragment> duo;
    private BaseFragmentActivity dup;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.dup = baseFragmentActivity;
        this.dtP = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.duo = new ArrayList<>();
        this.dun = new ArrayList<>();
        com.baidu.tieba.ala.data.b bVar = new com.baidu.tieba.ala.data.b();
        this.duo.add(AlaRankListFragment.a("hour", i, j, str, this.dtP, str2, this.otherParams, str3, j2, str4));
        bVar.dGi = this.dup.getString(a.i.hour_rank_list_title);
        bVar.dGj = "hour";
        this.dun.add(bVar);
        this.duo.add(AlaRankListFragment.a("charm_day", i, j, str, this.dtP, str2, this.otherParams, str3, j2, str4));
        com.baidu.tieba.ala.data.b bVar2 = new com.baidu.tieba.ala.data.b();
        bVar2.dGi = this.dup.getString(a.i.rank_list_day_charm_title);
        bVar2.dGj = "charm_day";
        this.dun.add(bVar2);
    }

    public int sB(String str) {
        if (this.duo == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dun.size()) {
                return -1;
            }
            if (!str.equals(this.dun.get(i2).dGj)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.duo == null) {
            return null;
        }
        return this.duo.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.duo != null) {
            return this.duo.size();
        }
        return 0;
    }

    public String lZ(int i) {
        if (this.dun != null && i >= 0 && i < this.dun.size()) {
            return this.dun.get(i).dGi;
        }
        return null;
    }

    public void ma(int i) {
        if (!this.dtP && i >= 0 && i < this.dun.size()) {
            com.baidu.tieba.ala.data.b bVar = this.dun.get(i);
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
            alaStaticItem.addParams("other_params", this.otherParams);
            if (bVar.dGj.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
            } else if (bVar.dGj.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }
}
