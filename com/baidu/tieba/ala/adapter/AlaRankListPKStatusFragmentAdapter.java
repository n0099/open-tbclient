package com.baidu.tieba.ala.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.data.f;
import com.baidu.tieba.ala.fragment.AlaChallengeHistoryListFragment;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlaRankListPKStatusFragmentAdapter extends FragmentPagerAdapter {
    private boolean edC;
    private ArrayList<f> efp;
    private ArrayList<Fragment> efq;
    private BaseFragmentActivity efr;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.efr = baseFragmentActivity;
        this.edC = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.efq = new ArrayList<>();
        this.efp = new ArrayList<>();
        this.efq.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.edC, str, this.otherParams, "", -1L, ""));
        f fVar = new f();
        fVar.eum = this.efr.getString(a.i.ala_rank_list_name_defend);
        fVar.eun = "guard";
        this.efp.add(fVar);
        this.efq.add(AlaChallengeHistoryListFragment.g(i, str, this.edC));
        f fVar2 = new f();
        fVar2.eum = this.efr.getString(a.i.ala_rank_list_name_history);
        fVar2.eun = "challenge_history";
        this.efp.add(fVar2);
    }

    public int xi(String str) {
        if (this.efq == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.efp.size()) {
                return -1;
            }
            if (!str.equals(this.efp.get(i2).eun)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.efq == null) {
            return null;
        }
        return this.efq.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.efq != null) {
            return this.efq.size();
        }
        return 0;
    }

    public String oi(int i) {
        if (this.efp != null && i >= 0 && i < this.efp.size()) {
            return this.efp.get(i).eum;
        }
        return null;
    }
}
