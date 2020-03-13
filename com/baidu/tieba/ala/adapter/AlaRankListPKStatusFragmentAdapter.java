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
    private boolean eib;
    private ArrayList<f> ejO;
    private ArrayList<Fragment> ejP;
    private BaseFragmentActivity ejQ;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.ejQ = baseFragmentActivity;
        this.eib = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.ejP = new ArrayList<>();
        this.ejO = new ArrayList<>();
        this.ejP.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.eib, str, this.otherParams, "", -1L, ""));
        f fVar = new f();
        fVar.ezW = this.ejQ.getString(a.i.ala_rank_list_name_defend);
        fVar.ezX = "guard";
        this.ejO.add(fVar);
        this.ejP.add(AlaChallengeHistoryListFragment.g(i, str, this.eib));
        f fVar2 = new f();
        fVar2.ezW = this.ejQ.getString(a.i.ala_rank_list_name_history);
        fVar2.ezX = "challenge_history";
        this.ejO.add(fVar2);
    }

    public int xH(String str) {
        if (this.ejP == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ejO.size()) {
                return -1;
            }
            if (!str.equals(this.ejO.get(i2).ezX)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.ejP == null) {
            return null;
        }
        return this.ejP.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.ejP != null) {
            return this.ejP.size();
        }
        return 0;
    }

    public String oz(int i) {
        if (this.ejO != null && i >= 0 && i < this.ejO.size()) {
            return this.ejO.get(i).ezW;
        }
        return null;
    }
}
