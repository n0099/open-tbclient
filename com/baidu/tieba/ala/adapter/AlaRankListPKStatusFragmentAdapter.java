package com.baidu.tieba.ala.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.data.f;
import com.baidu.tieba.ala.fragment.AlaChallengeHistoryListFragment;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaRankListPKStatusFragmentAdapter extends FragmentPagerAdapter {
    private boolean ffg;
    private ArrayList<f> fgO;
    private ArrayList<Fragment> fgQ;
    private BaseFragmentActivity fgR;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.fgR = baseFragmentActivity;
        this.ffg = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.fgQ = new ArrayList<>();
        this.fgO = new ArrayList<>();
        this.fgQ.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.ffg, str, this.otherParams, "", -1L, ""));
        f fVar = new f();
        fVar.fDS = this.fgR.getString(a.i.ala_rank_list_name_defend);
        fVar.fDT = "guard";
        this.fgO.add(fVar);
        this.fgQ.add(AlaChallengeHistoryListFragment.i(i, str, this.ffg));
        f fVar2 = new f();
        fVar2.fDS = this.fgR.getString(a.i.ala_rank_list_name_history);
        fVar2.fDT = "challenge_history";
        this.fgO.add(fVar2);
    }

    public int AW(String str) {
        if (this.fgQ == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fgO.size()) {
                return -1;
            }
            if (!str.equals(this.fgO.get(i2).fDT)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.fgQ == null) {
            return null;
        }
        return this.fgQ.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.fgQ != null) {
            return this.fgQ.size();
        }
        return 0;
    }

    public String pQ(int i) {
        if (this.fgO != null && i >= 0 && i < this.fgO.size()) {
            return this.fgO.get(i).fDS;
        }
        return null;
    }
}
