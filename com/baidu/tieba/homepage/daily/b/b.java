package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes4.dex */
public class b {
    private List<a> fYP;
    private List<m> mDataList = new ArrayList();

    public List<a> btb() {
        return this.fYP;
    }

    public List<m> getDataList() {
        return this.mDataList;
    }

    public List<a> cA(List<GodBanner> list) {
        if (this.fYP == null) {
            this.fYP = new ArrayList();
        }
        this.fYP.clear();
        if (v.aa(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.mk(godBanner.pic_url);
                aVar.xt(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.fYP.add(aVar);
                if (v.Z(this.fYP) == 5) {
                    break;
                }
            }
        }
        return this.fYP;
    }

    public boolean atJ() {
        return v.aa(this.fYP) && v.aa(this.mDataList);
    }
}
