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
    private boolean ehO;
    private ArrayList<f> ejB;
    private ArrayList<Fragment> ejC;
    private BaseFragmentActivity ejD;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.ejD = baseFragmentActivity;
        this.ehO = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.ejC = new ArrayList<>();
        this.ejB = new ArrayList<>();
        this.ejC.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.ehO, str, this.otherParams, "", -1L, ""));
        f fVar = new f();
        fVar.ezJ = this.ejD.getString(a.i.ala_rank_list_name_defend);
        fVar.ezK = "guard";
        this.ejB.add(fVar);
        this.ejC.add(AlaChallengeHistoryListFragment.g(i, str, this.ehO));
        f fVar2 = new f();
        fVar2.ezJ = this.ejD.getString(a.i.ala_rank_list_name_history);
        fVar2.ezK = "challenge_history";
        this.ejB.add(fVar2);
    }

    public int xG(String str) {
        if (this.ejC == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ejB.size()) {
                return -1;
            }
            if (!str.equals(this.ejB.get(i2).ezK)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.ejC == null) {
            return null;
        }
        return this.ejC.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.ejC != null) {
            return this.ejC.size();
        }
        return 0;
    }

    public String oz(int i) {
        if (this.ejB != null && i >= 0 && i < this.ejB.size()) {
            return this.ejB.get(i).ezJ;
        }
        return null;
    }
}
