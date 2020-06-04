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
    private boolean eUV;
    private ArrayList<f> eWD;
    private ArrayList<Fragment> eWE;
    private BaseFragmentActivity eWF;
    private String otherParams;

    public AlaRankListPKStatusFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, boolean z, String str) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.otherParams = "";
        this.eWF = baseFragmentActivity;
        this.eUV = z;
        b(i, j, str);
    }

    private void b(int i, long j, String str) {
        this.eWE = new ArrayList<>();
        this.eWD = new ArrayList<>();
        this.eWE.add(AlaRankListFragment.a("guard", i, TbadkCoreApplication.getCurrentAccountId(), TbadkCoreApplication.getCurrentAccountName(), this.eUV, str, this.otherParams, "", -1L, ""));
        f fVar = new f();
        fVar.fsH = this.eWF.getString(a.i.ala_rank_list_name_defend);
        fVar.fsI = "guard";
        this.eWD.add(fVar);
        this.eWE.add(AlaChallengeHistoryListFragment.i(i, str, this.eUV));
        f fVar2 = new f();
        fVar2.fsH = this.eWF.getString(a.i.ala_rank_list_name_history);
        fVar2.fsI = "challenge_history";
        this.eWD.add(fVar2);
    }

    public int AD(String str) {
        if (this.eWE == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eWD.size()) {
                return -1;
            }
            if (!str.equals(this.eWD.get(i2).fsI)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.eWE == null) {
            return null;
        }
        return this.eWE.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.eWE != null) {
            return this.eWE.size();
        }
        return 0;
    }

    public String ps(int i) {
        if (this.eWD != null && i >= 0 && i < this.eWD.size()) {
            return this.eWD.get(i).fsH;
        }
        return null;
    }
}
