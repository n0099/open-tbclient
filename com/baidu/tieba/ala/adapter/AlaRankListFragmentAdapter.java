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
    private boolean eIl;
    private ArrayList<f> eJV;
    private ArrayList<AlaRankListFragment> eJW;
    private BaseFragmentActivity eJX;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.eJX = baseFragmentActivity;
        this.eIl = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.eJW = new ArrayList<>();
        this.eJV = new ArrayList<>();
        f fVar = new f();
        this.eJW.add(AlaRankListFragment.a("hour", i, j, str, this.eIl, str2, this.otherParams, str3, j2, str4));
        fVar.feR = this.eJX.getString(a.i.hour_rank_list_title);
        fVar.feS = "hour";
        this.eJV.add(fVar);
        this.eJW.add(AlaRankListFragment.a("charm_day", i, j, str, this.eIl, str2, this.otherParams, str3, j2, str4));
        f fVar2 = new f();
        fVar2.feR = this.eJX.getString(a.i.rank_list_day_charm_title);
        fVar2.feS = "charm_day";
        this.eJV.add(fVar2);
    }

    public int yX(String str) {
        if (this.eJW == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eJV.size()) {
                return -1;
            }
            if (!str.equals(this.eJV.get(i2).feS)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.eJW == null) {
            return null;
        }
        return this.eJW.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.eJW != null) {
            return this.eJW.size();
        }
        return 0;
    }

    public String oO(int i) {
        if (this.eJV != null && i >= 0 && i < this.eJV.size()) {
            return this.eJV.get(i).feR;
        }
        return null;
    }

    public void oP(int i) {
        if (!this.eIl && i >= 0 && i < this.eJV.size()) {
            f fVar = this.eJV.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (fVar.feS.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (fVar.feS.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
