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
    private boolean eib;
    private ArrayList<f> ejO;
    private ArrayList<AlaRankListFragment> ejP;
    private BaseFragmentActivity ejQ;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.ejQ = baseFragmentActivity;
        this.eib = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.ejP = new ArrayList<>();
        this.ejO = new ArrayList<>();
        f fVar = new f();
        this.ejP.add(AlaRankListFragment.a("hour", i, j, str, this.eib, str2, this.otherParams, str3, j2, str4));
        fVar.ezW = this.ejQ.getString(a.i.hour_rank_list_title);
        fVar.ezX = "hour";
        this.ejO.add(fVar);
        this.ejP.add(AlaRankListFragment.a("charm_day", i, j, str, this.eib, str2, this.otherParams, str3, j2, str4));
        f fVar2 = new f();
        fVar2.ezW = this.ejQ.getString(a.i.rank_list_day_charm_title);
        fVar2.ezX = "charm_day";
        this.ejO.add(fVar2);
    }

    public int xH(String str) {
        if (this.ejP == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ejO.size()) {
                return -1;
            }
            if (!str.equals(this.ejO.get(i2).ezX)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.ejP == null) {
            return null;
        }
        return this.ejP.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.ejP != null) {
            return this.ejP.size();
        }
        return 0;
    }

    public String oz(int i) {
        if (this.ejO != null && i >= 0 && i < this.ejO.size()) {
            return this.ejO.get(i).ezW;
        }
        return null;
    }

    public void oA(int i) {
        if (!this.eib && i >= 0 && i < this.ejO.size()) {
            f fVar = this.ejO.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (fVar.ezX.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (fVar.ezX.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
