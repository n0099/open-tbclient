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
    private boolean eUK;
    private ArrayList<f> eWs;
    private ArrayList<d> eWt;
    private String otherParams;

    public AlaRankListFragmentAdapter(BaseActivity baseActivity, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2, String str5) {
        this.bjI = baseActivity;
        this.eUK = z;
        this.otherParams = str3;
        a(i, j, str, str2, str4, j2, str5);
    }

    private void a(int i, long j, String str, String str2, String str3, long j2, String str4) {
        this.eWt = new ArrayList<>();
        this.eWs = new ArrayList<>();
        f fVar = new f();
        fVar.fsw = this.bjI.getString(a.i.hour_rank_list_title);
        fVar.fsx = "hour";
        this.eWt.add(new com.baidu.tieba.ala.fragment.a(this.bjI, "hour", i, j, str, this.eUK, str2, this.otherParams, str3, j2, str4, fVar.fsw));
        this.eWs.add(fVar);
        f fVar2 = new f();
        fVar2.fsw = this.bjI.getString(a.i.rank_list_day_charm_title);
        fVar2.fsx = "charm_day";
        this.eWt.add(new com.baidu.tieba.ala.fragment.a(this.bjI, "charm_day", i, j, str, this.eUK, str2, this.otherParams, str3, j2, str4, fVar2.fsw));
        this.eWs.add(fVar2);
    }

    public int AD(String str) {
        if (this.eWt == null || StringUtils.isNull(str)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eWs.size()) {
                return -1;
            }
            if (!str.equals(this.eWs.get(i2).fsx)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.eWt != null) {
            return this.eWt.size();
        }
        return 0;
    }

    public ArrayList<d> getDataList() {
        return this.eWt;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void pp(int i) {
        if (!this.eUK && i >= 0 && i < this.eWs.size()) {
            f fVar = this.eWs.get(i);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_RANK_TAB);
                alaStaticItem.addParams("other_params", this.otherParams);
                if (fVar.fsx.equals(SdkStaticKeys.RANK_TYPE_FLOWER)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_FLOWER);
                } else if (fVar.fsx.equals(SdkStaticKeys.RANK_TYPE_CHARM)) {
                    alaStaticItem.addParams("type", SdkStaticKeys.RANK_TYPE_CHARM);
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }
}
