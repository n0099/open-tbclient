package com.baidu.tieba.ala.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.fragment.AlaChallengeHistoryListFragment;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaRankListPKStatusFragmentAdapter extends FragmentPagerAdapter {
    private boolean fZk;
    private ArrayList<g> gaX;
    private ArrayList<Fragment> gaZ;
    private BaseFragmentActivity gba;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.gba = baseFragmentActivity;
        this.fZk = z;
        g(i, j, str);
    }

    private void g(int i, long j, String str) {
        this.gaZ = new ArrayList<>();
        this.gaX = new ArrayList<>();
        this.gaZ.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.fZk, str, this.otherParams, "", -1L, ""));
        g gVar = new g();
        gVar.gAh = this.gba.getString(a.h.ala_rank_list_name_defend);
        gVar.gAi = "guard";
        this.gaX.add(gVar);
        this.gaZ.add(AlaChallengeHistoryListFragment.j(i, str, this.fZk));
        g gVar2 = new g();
        gVar2.gAh = this.gba.getString(a.h.ala_rank_list_name_history);
        gVar2.gAi = "challenge_history";
        this.gaX.add(gVar2);
    }

    public int FR(String str) {
        if (this.gaZ == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.gaX.size()) {
                return -1;
            }
            if (!str.equals(this.gaX.get(i2).gAi)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.gaZ == null) {
            return null;
        }
        return this.gaZ.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.gaZ != null) {
            return this.gaZ.size();
        }
        return 0;
    }

    public String tB(int i) {
        if (this.gaX != null && i >= 0 && i < this.gaX.size()) {
            return this.gaX.get(i).gAh;
        }
        return null;
    }
}
