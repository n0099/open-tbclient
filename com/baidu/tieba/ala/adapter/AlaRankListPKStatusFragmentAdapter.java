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
    private boolean fLd;
    private ArrayList<g> fMR;
    private ArrayList<Fragment> fMT;
    private BaseFragmentActivity fMU;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.fMU = baseFragmentActivity;
        this.fLd = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.fMT = new ArrayList<>();
        this.fMR = new ArrayList<>();
        this.fMT.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.fLd, str, this.otherParams, "", -1L, ""));
        g gVar = new g();
        gVar.gkp = this.fMU.getString(a.i.ala_rank_list_name_defend);
        gVar.gkq = "guard";
        this.fMR.add(gVar);
        this.fMT.add(AlaChallengeHistoryListFragment.j(i, str, this.fLd));
        g gVar2 = new g();
        gVar2.gkp = this.fMU.getString(a.i.ala_rank_list_name_history);
        gVar2.gkq = "challenge_history";
        this.fMR.add(gVar2);
    }

    public int Fk(String str) {
        if (this.fMT == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fMR.size()) {
                return -1;
            }
            if (!str.equals(this.fMR.get(i2).gkq)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.fMT == null) {
            return null;
        }
        return this.fMT.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.fMT != null) {
            return this.fMT.size();
        }
        return 0;
    }

    public String th(int i) {
        if (this.fMR != null && i >= 0 && i < this.fMR.size()) {
            return this.fMR.get(i).gkp;
        }
        return null;
    }
}
