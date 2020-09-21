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
    private ArrayList<g> fAI;
    private ArrayList<Fragment> fAK;
    private BaseFragmentActivity fAL;
    private boolean fyU;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.fAL = baseFragmentActivity;
        this.fyU = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.fAK = new ArrayList<>();
        this.fAI = new ArrayList<>();
        this.fAK.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.fyU, str, this.otherParams, "", -1L, ""));
        g gVar = new g();
        gVar.fXX = this.fAL.getString(a.i.ala_rank_list_name_defend);
        gVar.fXY = "guard";
        this.fAI.add(gVar);
        this.fAK.add(AlaChallengeHistoryListFragment.h(i, str, this.fyU));
        g gVar2 = new g();
        gVar2.fXX = this.fAL.getString(a.i.ala_rank_list_name_history);
        gVar2.fXY = "challenge_history";
        this.fAI.add(gVar2);
    }

    public int Ez(String str) {
        if (this.fAK == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fAI.size()) {
                return -1;
            }
            if (!str.equals(this.fAI.get(i2).fXY)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.fAK == null) {
            return null;
        }
        return this.fAK.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.fAK != null) {
            return this.fAK.size();
        }
        return 0;
    }

    public String sJ(int i) {
        if (this.fAI != null && i >= 0 && i < this.fAI.size()) {
            return this.fAI.get(i).fXX;
        }
        return null;
    }
}
