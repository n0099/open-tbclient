package com.baidu.tieba.ala.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.fragment.AlaChallengeHistoryListFragment;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class AlaRankListPKStatusFragmentAdapter extends FragmentPagerAdapter {
    private boolean gpE;
    private ArrayList<g> grq;
    private ArrayList<Fragment> grs;
    private BaseFragmentActivity grt;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.grt = baseFragmentActivity;
        this.gpE = z;
        d(i, j, str);
    }

    private void d(int i, long j, String str) {
        this.grs = new ArrayList<>();
        this.grq = new ArrayList<>();
        this.grs.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.gpE, str, this.otherParams, "", -1L, ""));
        g gVar = new g();
        gVar.gSC = this.grt.getString(a.h.ala_rank_list_name_defend);
        gVar.gSD = "guard";
        this.grq.add(gVar);
        this.grs.add(AlaChallengeHistoryListFragment.i(i, str, this.gpE));
        g gVar2 = new g();
        gVar2.gSC = this.grt.getString(a.h.ala_rank_list_name_history);
        gVar2.gSD = "challenge_history";
        this.grq.add(gVar2);
    }

    public int Fr(String str) {
        if (this.grs == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.grq.size()) {
                return -1;
            }
            if (!str.equals(this.grq.get(i2).gSD)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.grs == null) {
            return null;
        }
        return this.grs.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.grs != null) {
            return this.grs.size();
        }
        return 0;
    }

    public String tp(int i) {
        if (this.grq != null && i >= 0 && i < this.grq.size()) {
            return this.grq.get(i).gSC;
        }
        return null;
    }
}
