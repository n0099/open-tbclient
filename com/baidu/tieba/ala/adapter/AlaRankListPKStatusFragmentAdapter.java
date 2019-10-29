package com.baidu.tieba.ala.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.fragment.AlaChallengeHistoryListFragment;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class AlaRankListPKStatusFragmentAdapter extends FragmentPagerAdapter {
    private boolean duG;
    private ArrayList<com.baidu.tieba.ala.data.b> dve;
    private ArrayList<Fragment> dvf;
    private BaseFragmentActivity dvg;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.dvg = baseFragmentActivity;
        this.duG = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.dvf = new ArrayList<>();
        this.dve = new ArrayList<>();
        this.dvf.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.duG, str, this.otherParams, "", -1L, ""));
        com.baidu.tieba.ala.data.b bVar = new com.baidu.tieba.ala.data.b();
        bVar.dGZ = this.dvg.getString(a.i.ala_rank_list_name_defend);
        bVar.dHa = "guard";
        this.dve.add(bVar);
        this.dvf.add(AlaChallengeHistoryListFragment.e(i, str, this.duG));
        com.baidu.tieba.ala.data.b bVar2 = new com.baidu.tieba.ala.data.b();
        bVar2.dGZ = this.dvg.getString(a.i.ala_rank_list_name_history);
        bVar2.dHa = "challenge_history";
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
}
