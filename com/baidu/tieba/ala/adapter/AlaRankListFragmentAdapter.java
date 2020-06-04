package com.baidu.tieba.ala.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.f;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaRankListFragmentAdapter extends PagerAdapter {
    private BaseActivity bjI;
    private boolean eUV;
    private ArrayList<f> eWD;
    private ArrayList<d> eWE;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseActivity baseActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        this.bjI = baseActivity;
        this.eUV = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.eWE = new ArrayList<>();
        this.eWD = new ArrayList<>();
        f fVar = new f();
        fVar.fsH = this.bjI.getString(a.i.hour_rank_list_title);
        fVar.fsI = "hour";
        this.eWE.add(new com.baidu.tieba.ala.fragment.a(this.bjI, "hour", i, j, str, this.eUV, str2, this.otherParams, str3, j2, str4, fVar.fsH));
        this.eWD.add(fVar);
        f fVar2 = new f();
        fVar2.fsH = this.bjI.getString(a.i.rank_list_day_charm_title);
        fVar2.fsI = "charm_day";
        this.eWE.add(new com.baidu.tieba.ala.fragment.a(this.bjI, "charm_day", i, j, str, this.eUV, str2, this.otherParams, str3, j2, str4, fVar2.fsH));
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

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.eWE != null) {
            return this.eWE.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.eWE;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void pr(int i) {
        if (!this.eUV && i >= 0 && i < this.eWD.size()) {
            f fVar = this.eWD.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (fVar.fsI.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (fVar.fsI.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
