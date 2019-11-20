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
    private boolean dtP;
    private ArrayList<com.baidu.tieba.ala.data.b> dun;
    private ArrayList<Fragment> duo;
    private BaseFragmentActivity dup;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.dup = baseFragmentActivity;
        this.dtP = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.duo = new ArrayList<>();
        this.dun = new ArrayList<>();
        this.duo.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.dtP, str, this.otherParams, "", -1L, ""));
        com.baidu.tieba.ala.data.b bVar = new com.baidu.tieba.ala.data.b();
        bVar.dGi = this.dup.getString(a.i.ala_rank_list_name_defend);
        bVar.dGj = "guard";
        this.dun.add(bVar);
        this.duo.add(AlaChallengeHistoryListFragment.e(i, str, this.dtP));
        com.baidu.tieba.ala.data.b bVar2 = new com.baidu.tieba.ala.data.b();
        bVar2.dGi = this.dup.getString(a.i.ala_rank_list_name_history);
        bVar2.dGj = "challenge_history";
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
}
