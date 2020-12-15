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
    private boolean ghe;
    private ArrayList<g> giR;
    private ArrayList<Fragment> giT;
    private BaseFragmentActivity giU;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.giU = baseFragmentActivity;
        this.ghe = z;
        g(i, j, str);
    }

    private void g(int i, long j, String str) {
        this.giT = new ArrayList<>();
        this.giR = new ArrayList<>();
        this.giT.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.ghe, str, this.otherParams, "", -1L, ""));
        g gVar = new g();
        gVar.gIM = this.giU.getString(a.h.ala_rank_list_name_defend);
        gVar.gIN = "guard";
        this.giR.add(gVar);
        this.giT.add(AlaChallengeHistoryListFragment.j(i, str, this.ghe));
        g gVar2 = new g();
        gVar2.gIM = this.giU.getString(a.h.ala_rank_list_name_history);
        gVar2.gIN = "challenge_history";
        this.giR.add(gVar2);
    }

    public int Gg(String str) {
        if (this.giT == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.giR.size()) {
                return -1;
            }
            if (!str.equals(this.giR.get(i2).gIN)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.giT == null) {
            return null;
        }
        return this.giT.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.giT != null) {
            return this.giT.size();
        }
        return 0;
    }

    public String uD(int i) {
        if (this.giR != null && i >= 0 && i < this.giR.size()) {
            return this.giR.get(i).gIM;
        }
        return null;
    }
}
