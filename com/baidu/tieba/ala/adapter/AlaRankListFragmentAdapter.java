package com.baidu.tieba.ala.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.data.f;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlaRankListFragmentAdapter extends FragmentPagerAdapter {
    private boolean edK;
    private ArrayList<f> efx;
    private ArrayList<AlaRankListFragment> efy;
    private BaseFragmentActivity efz;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.efz = baseFragmentActivity;
        this.edK = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.efy = new ArrayList<>();
        this.efx = new ArrayList<>();
        f fVar = new f();
        this.efy.add(AlaRankListFragment.a("hour", i, j, str, this.edK, str2, this.otherParams, str3, j2, str4));
        fVar.evx = this.efz.getString(a.i.hour_rank_list_title);
        fVar.evy = "hour";
        this.efx.add(fVar);
        this.efy.add(AlaRankListFragment.a("charm_day", i, j, str, this.edK, str2, this.otherParams, str3, j2, str4));
        f fVar2 = new f();
        fVar2.evx = this.efz.getString(a.i.rank_list_day_charm_title);
        fVar2.evy = "charm_day";
        this.efx.add(fVar2);
    }

    public int xm(String str) {
        if (this.efy == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.efx.size()) {
                return -1;
            }
            if (!str.equals(this.efx.get(i2).evy)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.efy == null) {
            return null;
        }
        return this.efy.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.efy != null) {
            return this.efy.size();
        }
        return 0;
    }

    public String oi(int i) {
        if (this.efx != null && i >= 0 && i < this.efx.size()) {
            return this.efx.get(i).evx;
        }
        return null;
    }

    public void oj(int i) {
        if (!this.edK && i >= 0 && i < this.efx.size()) {
            f fVar = this.efx.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (fVar.evy.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (fVar.evy.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
