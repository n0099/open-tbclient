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
    private boolean fvJ;
    private ArrayList<g> fxw;
    private ArrayList<Fragment> fxy;
    private BaseFragmentActivity fxz;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.fxz = baseFragmentActivity;
        this.fvJ = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.fxy = new ArrayList<>();
        this.fxw = new ArrayList<>();
        this.fxy.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.fvJ, str, this.otherParams, "", -1L, ""));
        g gVar = new g();
        gVar.fUI = this.fxz.getString(a.i.ala_rank_list_name_defend);
        gVar.fUJ = "guard";
        this.fxw.add(gVar);
        this.fxy.add(AlaChallengeHistoryListFragment.h(i, str, this.fvJ));
        g gVar2 = new g();
        gVar2.fUI = this.fxz.getString(a.i.ala_rank_list_name_history);
        gVar2.fUJ = "challenge_history";
        this.fxw.add(gVar2);
    }

    public int Ec(String str) {
        if (this.fxy == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fxw.size()) {
                return -1;
            }
            if (!str.equals(this.fxw.get(i2).fUJ)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.fxy == null) {
            return null;
        }
        return this.fxy.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.fxy != null) {
            return this.fxy.size();
        }
        return 0;
    }

    public String sr(int i) {
        if (this.fxw != null && i >= 0 && i < this.fxw.size()) {
            return this.fxw.get(i).fUI;
        }
        return null;
    }
}
