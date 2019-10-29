package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes4.dex */
public class b {
    private List<a> gfR;
    private List<m> mDataList = new ArrayList();

    public List<a> btj() {
        return this.gfR;
    }

    public List<m> getDataList() {
        return this.mDataList;
    }

    public List<a> cN(List<GodBanner> list) {
        if (this.gfR == null) {
            this.gfR = new ArrayList();
        }
        this.gfR.clear();
        if (v.isEmpty(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.mU(godBanner.pic_url);
                aVar.wR(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.gfR.add(aVar);
                if (v.getCount(this.gfR) == 5) {
                    break;
                }
            }
        }
        return this.gfR;
    }

    public boolean wd() {
        return v.isEmpty(this.gfR) && v.isEmpty(this.mDataList);
    }
}
