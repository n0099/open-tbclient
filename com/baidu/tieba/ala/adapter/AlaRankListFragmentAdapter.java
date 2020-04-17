package com.baidu.tieba.ala.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.f;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaRankListFragmentAdapter extends FragmentPagerAdapter {
    private boolean eIg;
    private ArrayList<f> eJQ;
    private ArrayList<AlaRankListFragment> eJR;
    private BaseFragmentActivity eJS;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.eJS = baseFragmentActivity;
        this.eIg = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.eJR = new ArrayList<>();
        this.eJQ = new ArrayList<>();
        f fVar = new f();
        this.eJR.add(AlaRankListFragment.a("hour", i, j, str, this.eIg, str2, this.otherParams, str3, j2, str4));
        fVar.feM = this.eJS.getString(a.i.hour_rank_list_title);
        fVar.feN = "hour";
        this.eJQ.add(fVar);
        this.eJR.add(AlaRankListFragment.a("charm_day", i, j, str, this.eIg, str2, this.otherParams, str3, j2, str4));
        f fVar2 = new f();
        fVar2.feM = this.eJS.getString(a.i.rank_list_day_charm_title);
        fVar2.feN = "charm_day";
        this.eJQ.add(fVar2);
    }

    public int yU(String str) {
        if (this.eJR == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eJQ.size()) {
                return -1;
            }
            if (!str.equals(this.eJQ.get(i2).feN)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.eJR == null) {
            return null;
        }
        return this.eJR.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.eJR != null) {
            return this.eJR.size();
        }
        return 0;
    }

    public String oO(int i) {
        if (this.eJQ != null && i >= 0 && i < this.eJQ.size()) {
            return this.eJQ.get(i).feM;
        }
        return null;
    }

    public void oP(int i) {
        if (!this.eIg && i >= 0 && i < this.eJQ.size()) {
            f fVar = this.eJQ.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (fVar.feN.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (fVar.feN.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
