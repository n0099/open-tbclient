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
/* loaded from: classes7.dex */
public class AlaRankListPKStatusFragmentAdapter extends FragmentPagerAdapter {
    private boolean fvF;
    private ArrayList<g> fxs;
    private ArrayList<Fragment> fxu;
    private BaseFragmentActivity fxv;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.fxv = baseFragmentActivity;
        this.fvF = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.fxu = new ArrayList<>();
        this.fxs = new ArrayList<>();
        this.fxu.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.fvF, str, this.otherParams, "", -1L, ""));
        g gVar = new g();
        gVar.fUE = this.fxv.getString(a.i.ala_rank_list_name_defend);
        gVar.fUF = "guard";
        this.fxs.add(gVar);
        this.fxu.add(AlaChallengeHistoryListFragment.h(i, str, this.fvF));
        g gVar2 = new g();
        gVar2.fUE = this.fxv.getString(a.i.ala_rank_list_name_history);
        gVar2.fUF = "challenge_history";
        this.fxs.add(gVar2);
    }

    public int Eb(String str) {
        if (this.fxu == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fxs.size()) {
                return -1;
            }
            if (!str.equals(this.fxs.get(i2).fUF)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.fxu == null) {
            return null;
        }
        return this.fxu.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.fxu != null) {
            return this.fxu.size();
        }
        return 0;
    }

    public String sr(int i) {
        if (this.fxs != null && i >= 0 && i < this.fxs.size()) {
            return this.fxs.get(i).fUE;
        }
        return null;
    }
}
