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
    private boolean grB;
    private ArrayList<g> gtn;
    private ArrayList<Fragment> gtp;
    private BaseFragmentActivity gtq;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.gtq = baseFragmentActivity;
        this.grB = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.gtp = new ArrayList<>();
        this.gtn = new ArrayList<>();
        this.gtp.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.grB, str, this.otherParams, "", -1L, ""));
        g gVar = new g();
        gVar.gUz = this.gtq.getString(a.h.ala_rank_list_name_defend);
        gVar.gUA = "guard";
        this.gtn.add(gVar);
        this.gtp.add(AlaChallengeHistoryListFragment.i(i, str, this.grB));
        g gVar2 = new g();
        gVar2.gUz = this.gtq.getString(a.h.ala_rank_list_name_history);
        gVar2.gUA = "challenge_history";
        this.gtn.add(gVar2);
    }

    public int FB(String str) {
        if (this.gtp == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.gtn.size()) {
                return -1;
            }
            if (!str.equals(this.gtn.get(i2).gUA)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.gtp == null) {
            return null;
        }
        return this.gtp.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.gtp != null) {
            return this.gtp.size();
        }
        return 0;
    }

    public String tr(int i) {
        if (this.gtn != null && i >= 0 && i < this.gtn.size()) {
            return this.gtn.get(i).gUz;
        }
        return null;
    }
}
