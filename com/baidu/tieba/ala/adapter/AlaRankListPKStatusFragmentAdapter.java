package com.baidu.tieba.ala.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.data.f;
import com.baidu.tieba.ala.fragment.AlaChallengeHistoryListFragment;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlaRankListPKStatusFragmentAdapter extends FragmentPagerAdapter {
    private boolean edK;
    private ArrayList<f> efx;
    private ArrayList<Fragment> efy;
    private BaseFragmentActivity efz;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.efz = baseFragmentActivity;
        this.edK = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.efy = new ArrayList<>();
        this.efx = new ArrayList<>();
        this.efy.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.edK, str, this.otherParams, "", -1L, ""));
        f fVar = new f();
        fVar.evx = this.efz.getString(a.i.ala_rank_list_name_defend);
        fVar.evy = "guard";
        this.efx.add(fVar);
        this.efy.add(AlaChallengeHistoryListFragment.g(i, str, this.edK));
        f fVar2 = new f();
        fVar2.evx = this.efz.getString(a.i.ala_rank_list_name_history);
        fVar2.evy = "challenge_history";
        this.efx.add(fVar2);
    }

    public int xm(String str) {
        if (this.efy == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.efx.size()) {
                return -1;
            }
            if (!str.equals(this.efx.get(i2).evy)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.efy == null) {
            return null;
        }
        return this.efy.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.efy != null) {
            return this.efy.size();
        }
        return 0;
    }

    public String oi(int i) {
        if (this.efx != null && i >= 0 && i < this.efx.size()) {
            return this.efx.get(i).evx;
        }
        return null;
    }
}
