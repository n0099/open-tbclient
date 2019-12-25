package com.baidu.tieba.ala.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.tieba.ala.data.f;
import com.baidu.tieba.ala.fragment.AlaRankListFragment;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlaRankListFragmentAdapter extends FragmentPagerAdapter {
    private boolean edC;
    private ArrayList<f> efp;
    private ArrayList<AlaRankListFragment> efq;
    private BaseFragmentActivity efr;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseFragmentActivity baseFragmentActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        super(baseFragmentActivity.getSupportFragmentManager());
        this.efr = baseFragmentActivity;
        this.edC = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.efq = new ArrayList<>();
        this.efp = new ArrayList<>();
        f fVar = new f();
        this.efq.add(AlaRankListFragment.a("hour", i, j, str, this.edC, str2, this.otherParams, str3, j2, str4));
        fVar.eum = this.efr.getString(a.i.hour_rank_list_title);
        fVar.eun = "hour";
        this.efp.add(fVar);
        this.efq.add(AlaRankListFragment.a("charm_day", i, j, str, this.edC, str2, this.otherParams, str3, j2, str4));
        f fVar2 = new f();
        fVar2.eum = this.efr.getString(a.i.rank_list_day_charm_title);
        fVar2.eun = "charm_day";
        this.efp.add(fVar2);
    }

    public int xi(String str) {
        if (this.efq == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.efp.size()) {
                return -1;
            }
            if (!str.equals(this.efp.get(i2).eun)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.efq == null) {
            return null;
        }
        return this.efq.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.efq != null) {
            return this.efq.size();
        }
        return 0;
    }

    public String oi(int i) {
        if (this.efp != null && i >= 0 && i < this.efp.size()) {
            return this.efp.get(i).eum;
        }
        return null;
    }

    public void oj(int i) {
        if (!this.edC && i >= 0 && i < this.efp.size()) {
            f fVar = this.efp.get(i);
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
            alaStaticItem.addParams("other_params", this.otherParams);
            if (fVar.eun.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
            } else if (fVar.eun.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }
}
