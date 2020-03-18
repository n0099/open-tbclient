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
    private boolean eir;
    private ArrayList<f> eke;
    private ArrayList<Fragment> ekf;
    private BaseFragmentActivity ekg;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.ekg = baseFragmentActivity;
        this.eir = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.ekf = new ArrayList<>();
        this.eke = new ArrayList<>();
        this.ekf.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.eir, str, this.otherParams, "", -1L, ""));
        f fVar = new f();
        fVar.eAs = this.ekg.getString(a.i.ala_rank_list_name_defend);
        fVar.eAt = "guard";
        this.eke.add(fVar);
        this.ekf.add(AlaChallengeHistoryListFragment.g(i, str, this.eir));
        f fVar2 = new f();
        fVar2.eAs = this.ekg.getString(a.i.ala_rank_list_name_history);
        fVar2.eAt = "challenge_history";
        this.eke.add(fVar2);
    }

    public int xH(String str) {
        if (this.ekf == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eke.size()) {
                return -1;
            }
            if (!str.equals(this.eke.get(i2).eAt)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.ekf == null) {
            return null;
        }
        return this.ekf.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.ekf != null) {
            return this.ekf.size();
        }
        return 0;
    }

    public String oB(int i) {
        if (this.eke != null && i >= 0 && i < this.eke.size()) {
            return this.eke.get(i).eAs;
        }
        return null;
    }
}
