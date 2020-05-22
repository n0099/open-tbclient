package com.baidu.tieba.ala.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.f;
import com.baidu.tieba.ala.fragment.AlaChallengeHistoryListFragment;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaRankListPKStatusFragmentAdapter extends FragmentPagerAdapter {
    private boolean eUK;
    private ArrayList<f> eWs;
    private ArrayList<Fragment> eWt;
    private BaseFragmentActivity eWu;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.eWu = baseFragmentActivity;
        this.eUK = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.eWt = new ArrayList<>();
        this.eWs = new ArrayList<>();
        this.eWt.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.eUK, str, this.otherParams, "", -1L, ""));
        f fVar = new f();
        fVar.fsw = this.eWu.getString(a.i.ala_rank_list_name_defend);
        fVar.fsx = "guard";
        this.eWs.add(fVar);
        this.eWt.add(AlaChallengeHistoryListFragment.i(i, str, this.eUK));
        f fVar2 = new f();
        fVar2.fsw = this.eWu.getString(a.i.ala_rank_list_name_history);
        fVar2.fsx = "challenge_history";
        this.eWs.add(fVar2);
    }

    public int AD(String str) {
        if (this.eWt == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eWs.size()) {
                return -1;
            }
            if (!str.equals(this.eWs.get(i2).fsx)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.eWt == null) {
            return null;
        }
        return this.eWt.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.eWt != null) {
            return this.eWt.size();
        }
        return 0;
    }

    public String pq(int i) {
        if (this.eWs != null && i >= 0 && i < this.eWs.size()) {
            return this.eWs.get(i).fsw;
        }
        return null;
    }
}
