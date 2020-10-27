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
    private boolean fTu;
    private ArrayList<g> fVg;
    private ArrayList<Fragment> fVi;
    private BaseFragmentActivity fVj;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.fVj = baseFragmentActivity;
        this.fTu = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.fVi = new ArrayList<>();
        this.fVg = new ArrayList<>();
        this.fVi.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.fTu, str, this.otherParams, "", -1L, ""));
        g gVar = new g();
        gVar.gut = this.fVj.getString(a.i.ala_rank_list_name_defend);
        gVar.guu = "guard";
        this.fVg.add(gVar);
        this.fVi.add(AlaChallengeHistoryListFragment.j(i, str, this.fTu));
        g gVar2 = new g();
        gVar2.gut = this.fVj.getString(a.i.ala_rank_list_name_history);
        gVar2.guu = "challenge_history";
        this.fVg.add(gVar2);
    }

    public int FD(String str) {
        if (this.fVi == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fVg.size()) {
                return -1;
            }
            if (!str.equals(this.fVg.get(i2).guu)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.fVi == null) {
            return null;
        }
        return this.fVi.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.fVi != null) {
            return this.fVi.size();
        }
        return 0;
    }

    public String tr(int i) {
        if (this.fVg != null && i >= 0 && i < this.fVg.size()) {
            return this.fVg.get(i).gut;
        }
        return null;
    }
}
