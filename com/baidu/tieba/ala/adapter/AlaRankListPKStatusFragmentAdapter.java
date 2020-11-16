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
    private boolean fYR;
    private ArrayList<g> gaE;
    private ArrayList<Fragment> gaG;
    private BaseFragmentActivity gaH;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.gaH = baseFragmentActivity;
        this.fYR = z;
        g(i, j, str);
    }

    private void g(int i, long j, String str) {
        this.gaG = new ArrayList<>();
        this.gaE = new ArrayList<>();
        this.gaG.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.fYR, str, this.otherParams, "", -1L, ""));
        g gVar = new g();
        gVar.gzO = this.gaH.getString(a.h.ala_rank_list_name_defend);
        gVar.gzP = "guard";
        this.gaE.add(gVar);
        this.gaG.add(AlaChallengeHistoryListFragment.j(i, str, this.fYR));
        g gVar2 = new g();
        gVar2.gzO = this.gaH.getString(a.h.ala_rank_list_name_history);
        gVar2.gzP = "challenge_history";
        this.gaE.add(gVar2);
    }

    public int Fs(String str) {
        if (this.gaG == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.gaE.size()) {
                return -1;
            }
            if (!str.equals(this.gaE.get(i2).gzP)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.gaG == null) {
            return null;
        }
        return this.gaG.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.gaG != null) {
            return this.gaG.size();
        }
        return 0;
    }

    public String tZ(int i) {
        if (this.gaE != null && i >= 0 && i < this.gaE.size()) {
            return this.gaE.get(i).gzO;
        }
        return null;
    }
}
