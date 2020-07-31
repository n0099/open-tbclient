package com.baidu.tieba.ala.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.fragment.AlaChallengeHistoryListFragment;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaRankListPKStatusFragmentAdapter extends FragmentPagerAdapter {
    private boolean fkj;
    private ArrayList<g> flW;
    private ArrayList<Fragment> flY;
    private BaseFragmentActivity flZ;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.flZ = baseFragmentActivity;
        this.fkj = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.flY = new ArrayList<>();
        this.flW = new ArrayList<>();
        this.flY.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.fkj, str, this.otherParams, "", -1L, ""));
        g gVar = new g();
        gVar.fJn = this.flZ.getString(a.i.ala_rank_list_name_defend);
        gVar.fJo = "guard";
        this.flW.add(gVar);
        this.flY.add(AlaChallengeHistoryListFragment.i(i, str, this.fkj));
        g gVar2 = new g();
        gVar2.fJn = this.flZ.getString(a.i.ala_rank_list_name_history);
        gVar2.fJo = "challenge_history";
        this.flW.add(gVar2);
    }

    public int BH(String str) {
        if (this.flY == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.flW.size()) {
                return -1;
            }
            if (!str.equals(this.flW.get(i2).fJo)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.flY == null) {
            return null;
        }
        return this.flY.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.flY != null) {
            return this.flY.size();
        }
        return 0;
    }

    public String qf(int i) {
        if (this.flW != null && i >= 0 && i < this.flW.size()) {
            return this.flW.get(i).fJn;
        }
        return null;
    }
}
