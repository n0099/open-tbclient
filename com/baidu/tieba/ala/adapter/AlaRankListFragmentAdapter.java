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
    private boolean ehN;
    private ArrayList<f> ejA;
    private ArrayList<AlaRankListFragment> ejB;
    private BaseFragmentActivity ejC;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.ejC = baseFragmentActivity;
        this.ehN = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.ejB = new ArrayList<>();
        this.ejA = new ArrayList<>();
        f fVar = new f();
        this.ejB.add(AlaRankListFragment.a("hour", i, j, str, this.ehN, str2, this.otherParams, str3, j2, str4));
        fVar.ezI = this.ejC.getString(a.i.hour_rank_list_title);
        fVar.ezJ = "hour";
        this.ejA.add(fVar);
        this.ejB.add(AlaRankListFragment.a("charm_day", i, j, str, this.ehN, str2, this.otherParams, str3, j2, str4));
        f fVar2 = new f();
        fVar2.ezI = this.ejC.getString(a.i.rank_list_day_charm_title);
        fVar2.ezJ = "charm_day";
        this.ejA.add(fVar2);
    }

    public int xG(String str) {
        if (this.ejB == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ejA.size()) {
                return -1;
            }
            if (!str.equals(this.ejA.get(i2).ezJ)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.ejB == null) {
            return null;
        }
        return this.ejB.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.ejB != null) {
            return this.ejB.size();
        }
        return 0;
    }

    public String oz(int i) {
        if (this.ejA != null && i >= 0 && i < this.ejA.size()) {
            return this.ejA.get(i).ezI;
        }
        return null;
    }

    public void oA(int i) {
        if (!this.ehN && i >= 0 && i < this.ejA.size()) {
            f fVar = this.ejA.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (fVar.ezJ.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (fVar.ezJ.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
