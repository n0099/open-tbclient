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
    private boolean ghc;
    private ArrayList<g> giP;
    private ArrayList<Fragment> giR;
    private BaseFragmentActivity giS;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.giS = baseFragmentActivity;
        this.ghc = z;
        g(i, j, str);
    }

    private void g(int i, long j, String str) {
        this.giR = new ArrayList<>();
        this.giP = new ArrayList<>();
        this.giR.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.ghc, str, this.otherParams, "", -1L, ""));
        g gVar = new g();
        gVar.gIK = this.giS.getString(a.h.ala_rank_list_name_defend);
        gVar.gIL = "guard";
        this.giP.add(gVar);
        this.giR.add(AlaChallengeHistoryListFragment.j(i, str, this.ghc));
        g gVar2 = new g();
        gVar2.gIK = this.giS.getString(a.h.ala_rank_list_name_history);
        gVar2.gIL = "challenge_history";
        this.giP.add(gVar2);
    }

    public int Gg(String str) {
        if (this.giR == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.giP.size()) {
                return -1;
            }
            if (!str.equals(this.giP.get(i2).gIL)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.giR == null) {
            return null;
        }
        return this.giR.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.giR != null) {
            return this.giR.size();
        }
        return 0;
    }

    public String uD(int i) {
        if (this.giP != null && i >= 0 && i < this.giP.size()) {
            return this.giP.get(i).gIK;
        }
        return null;
    }
}
