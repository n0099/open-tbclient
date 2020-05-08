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
    private boolean eIl;
    private ArrayList<f> eJV;
    private ArrayList<Fragment> eJW;
    private BaseFragmentActivity eJX;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.eJX = baseFragmentActivity;
        this.eIl = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.eJW = new ArrayList<>();
        this.eJV = new ArrayList<>();
        this.eJW.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.eIl, str, this.otherParams, "", -1L, ""));
        f fVar = new f();
        fVar.feR = this.eJX.getString(a.i.ala_rank_list_name_defend);
        fVar.feS = "guard";
        this.eJV.add(fVar);
        this.eJW.add(AlaChallengeHistoryListFragment.h(i, str, this.eIl));
        f fVar2 = new f();
        fVar2.feR = this.eJX.getString(a.i.ala_rank_list_name_history);
        fVar2.feS = "challenge_history";
        this.eJV.add(fVar2);
    }

    public int yX(String str) {
        if (this.eJW == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eJV.size()) {
                return -1;
            }
            if (!str.equals(this.eJV.get(i2).feS)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.eJW == null) {
            return null;
        }
        return this.eJW.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.eJW != null) {
            return this.eJW.size();
        }
        return 0;
    }

    public String oO(int i) {
        if (this.eJV != null && i >= 0 && i < this.eJV.size()) {
            return this.eJV.get(i).feR;
        }
        return null;
    }
}
