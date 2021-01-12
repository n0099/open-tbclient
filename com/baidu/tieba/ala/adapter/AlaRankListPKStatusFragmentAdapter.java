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
/* loaded from: classes10.dex */
public class AlaRankListPKStatusFragmentAdapter extends FragmentPagerAdapter {
    private boolean gmV;
    private ArrayList<g> goH;
    private ArrayList<Fragment> goJ;
    private BaseFragmentActivity goK;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.goK = baseFragmentActivity;
        this.gmV = z;
        i(i, j, str);
    }

    private void i(int i, long j, String str) {
        this.goJ = new ArrayList<>();
        this.goH = new ArrayList<>();
        this.goJ.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.gmV, str, this.otherParams, "", -1L, ""));
        g gVar = new g();
        gVar.gPS = this.goK.getString(a.h.ala_rank_list_name_defend);
        gVar.gPT = "guard";
        this.goH.add(gVar);
        this.goJ.add(AlaChallengeHistoryListFragment.j(i, str, this.gmV));
        g gVar2 = new g();
        gVar2.gPS = this.goK.getString(a.h.ala_rank_list_name_history);
        gVar2.gPT = "challenge_history";
        this.goH.add(gVar2);
    }

    public int ET(String str) {
        if (this.goJ == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.goH.size()) {
                return -1;
            }
            if (!str.equals(this.goH.get(i2).gPT)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.goJ == null) {
            return null;
        }
        return this.goJ.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.goJ != null) {
            return this.goJ.size();
        }
        return 0;
    }

    public String tj(int i) {
        if (this.goH != null && i >= 0 && i < this.goH.size()) {
            return this.goH.get(i).gPS;
        }
        return null;
    }
}
