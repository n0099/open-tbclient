package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes4.dex */
public class b {
    private List<a> geD;
    private List<m> mDataList = new ArrayList();

    public List<a> bvq() {
        return this.geD;
    }

    public List<m> getDataList() {
        return this.mDataList;
    }

    public List<a> cA(List<GodBanner> list) {
        if (this.geD == null) {
            this.geD = new ArrayList();
        }
        this.geD.clear();
        if (v.aa(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.mv(godBanner.pic_url);
                aVar.xZ(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.geD.add(aVar);
                if (v.Z(this.geD) == 5) {
                    break;
                }
            }
        }
        return this.geD;
    }

    public boolean auT() {
        return v.aa(this.geD) && v.aa(this.mDataList);
    }
}
