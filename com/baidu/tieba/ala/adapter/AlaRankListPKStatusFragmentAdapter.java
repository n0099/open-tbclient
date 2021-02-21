package com.baidu.tieba.ala.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.fragment.AlaChallengeHistoryListFragment;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class AlaRankListPKStatusFragmentAdapter extends FragmentPagerAdapter {
    private boolean gpS;
    private ArrayList<g> grE;
    private ArrayList<Fragment> grG;
    private BaseFragmentActivity grH;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.grH = baseFragmentActivity;
        this.gpS = z;
        d(i, j, str);
    }

    private void d(int i, long j, String str) {
        this.grG = new ArrayList<>();
        this.grE = new ArrayList<>();
        this.grG.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.gpS, str, this.otherParams, "", -1L, ""));
        g gVar = new g();
        gVar.gSQ = this.grH.getString(a.h.ala_rank_list_name_defend);
        gVar.gSR = "guard";
        this.grE.add(gVar);
        this.grG.add(AlaChallengeHistoryListFragment.i(i, str, this.gpS));
        g gVar2 = new g();
        gVar2.gSQ = this.grH.getString(a.h.ala_rank_list_name_history);
        gVar2.gSR = "challenge_history";
        this.grE.add(gVar2);
    }

    public int Fs(String str) {
        if (this.grG == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.grE.size()) {
                return -1;
            }
            if (!str.equals(this.grE.get(i2).gSR)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.grG == null) {
            return null;
        }
        return this.grG.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.grG != null) {
            return this.grG.size();
        }
        return 0;
    }

    public String tp(int i) {
        if (this.grE != null && i >= 0 && i < this.grE.size()) {
            return this.grE.get(i).gSQ;
        }
        return null;
    }
}
