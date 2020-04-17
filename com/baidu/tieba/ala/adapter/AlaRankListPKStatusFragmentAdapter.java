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
    private boolean eIg;
    private ArrayList<f> eJQ;
    private ArrayList<Fragment> eJR;
    private BaseFragmentActivity eJS;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.eJS = baseFragmentActivity;
        this.eIg = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.eJR = new ArrayList<>();
        this.eJQ = new ArrayList<>();
        this.eJR.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.eIg, str, this.otherParams, "", -1L, ""));
        f fVar = new f();
        fVar.feM = this.eJS.getString(a.i.ala_rank_list_name_defend);
        fVar.feN = "guard";
        this.eJQ.add(fVar);
        this.eJR.add(AlaChallengeHistoryListFragment.h(i, str, this.eIg));
        f fVar2 = new f();
        fVar2.feM = this.eJS.getString(a.i.ala_rank_list_name_history);
        fVar2.feN = "challenge_history";
        this.eJQ.add(fVar2);
    }

    public int yU(String str) {
        if (this.eJR == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eJQ.size()) {
                return -1;
            }
            if (!str.equals(this.eJQ.get(i2).feN)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.eJR == null) {
            return null;
        }
        return this.eJR.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.eJR != null) {
            return this.eJR.size();
        }
        return 0;
    }

    public String oO(int i) {
        if (this.eJQ != null && i >= 0 && i < this.eJQ.size()) {
            return this.eJQ.get(i).feM;
        }
        return null;
    }
}
