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
    private boolean eir;
    private ArrayList<f> eke;
    private ArrayList<AlaRankListFragment> ekf;
    private BaseFragmentActivity ekg;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.ekg = baseFragmentActivity;
        this.eir = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.ekf = new ArrayList<>();
        this.eke = new ArrayList<>();
        f fVar = new f();
        this.ekf.add(AlaRankListFragment.a("hour", i, j, str, this.eir, str2, this.otherParams, str3, j2, str4));
        fVar.eAs = this.ekg.getString(a.i.hour_rank_list_title);
        fVar.eAt = "hour";
        this.eke.add(fVar);
        this.ekf.add(AlaRankListFragment.a("charm_day", i, j, str, this.eir, str2, this.otherParams, str3, j2, str4));
        f fVar2 = new f();
        fVar2.eAs = this.ekg.getString(a.i.rank_list_day_charm_title);
        fVar2.eAt = "charm_day";
        this.eke.add(fVar2);
    }

    public int xH(String str) {
        if (this.ekf == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eke.size()) {
                return -1;
            }
            if (!str.equals(this.eke.get(i2).eAt)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.ekf == null) {
            return null;
        }
        return this.ekf.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.ekf != null) {
            return this.ekf.size();
        }
        return 0;
    }

    public String oB(int i) {
        if (this.eke != null && i >= 0 && i < this.eke.size()) {
            return this.eke.get(i).eAs;
        }
        return null;
    }

    public void oC(int i) {
        if (!this.eir && i >= 0 && i < this.eke.size()) {
            f fVar = this.eke.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (fVar.eAt.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (fVar.eAt.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
