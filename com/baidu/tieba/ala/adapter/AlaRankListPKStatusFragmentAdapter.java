package com.baidu.tieba.ala.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.f;
import com.baidu.tieba.ala.fragment.AlaChallengeHistoryListFragment;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaRankListPKStatusFragmentAdapter extends FragmentPagerAdapter {
    private boolean ehN;
    private ArrayList<f> ejA;
    private ArrayList<Fragment> ejB;
    private BaseFragmentActivity ejC;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.ejC = baseFragmentActivity;
        this.ehN = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.ejB = new ArrayList<>();
        this.ejA = new ArrayList<>();
        this.ejB.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.ehN, str, this.otherParams, "", -1L, ""));
        f fVar = new f();
        fVar.ezI = this.ejC.getString(a.i.ala_rank_list_name_defend);
        fVar.ezJ = "guard";
        this.ejA.add(fVar);
        this.ejB.add(AlaChallengeHistoryListFragment.g(i, str, this.ehN));
        f fVar2 = new f();
        fVar2.ezI = this.ejC.getString(a.i.ala_rank_list_name_history);
        fVar2.ezJ = "challenge_history";
        this.ejA.add(fVar2);
    }

    public int xG(String str) {
        if (this.ejB == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ejA.size()) {
                return -1;
            }
            if (!str.equals(this.ejA.get(i2).ezJ)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.ejB == null) {
            return null;
        }
        return this.ejB.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.ejB != null) {
            return this.ejB.size();
        }
        return 0;
    }

    public String oz(int i) {
        if (this.ejA != null && i >= 0 && i < this.ejA.size()) {
            return this.ejA.get(i).ezI;
        }
        return null;
    }
}
