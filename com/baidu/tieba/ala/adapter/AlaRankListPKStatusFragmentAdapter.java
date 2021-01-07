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
    private boolean grC;
    private ArrayList<g> gto;
    private ArrayList<Fragment> gtq;
    private BaseFragmentActivity gtr;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.gtr = baseFragmentActivity;
        this.grC = z;
        i(i, j, str);
    }

    private void i(int i, long j, String str) {
        this.gtq = new ArrayList<>();
        this.gto = new ArrayList<>();
        this.gtq.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.grC, str, this.otherParams, "", -1L, ""));
        g gVar = new g();
        gVar.gUy = this.gtr.getString(a.h.ala_rank_list_name_defend);
        gVar.gUz = "guard";
        this.gto.add(gVar);
        this.gtq.add(AlaChallengeHistoryListFragment.j(i, str, this.grC));
        g gVar2 = new g();
        gVar2.gUy = this.gtr.getString(a.h.ala_rank_list_name_history);
        gVar2.gUz = "challenge_history";
        this.gto.add(gVar2);
    }

    public int Ge(String str) {
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

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.gtq == null) {
            return null;
        }
        return this.gtq.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.gtq != null) {
            return this.gtq.size();
        }
        return 0;
    }

    public String uP(int i) {
        if (this.gto != null && i >= 0 && i < this.gto.size()) {
            return this.gto.get(i).gUy;
        }
        return null;
    }
}
