package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes4.dex */
public class b {
    private List<a> gfa;
    private List<m> mDataList = new ArrayList();

    public List<a> bth() {
        return this.gfa;
    }

    public List<m> getDataList() {
        return this.mDataList;
    }

    public List<a> cN(List<GodBanner> list) {
        if (this.gfa == null) {
            this.gfa = new ArrayList();
        }
        this.gfa.clear();
        if (v.isEmpty(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.mU(godBanner.pic_url);
                aVar.wR(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.gfa.add(aVar);
                if (v.getCount(this.gfa) == 5) {
                    break;
                }
            }
        }
        return this.gfa;
    }

    public boolean we() {
        return v.isEmpty(this.gfa) && v.isEmpty(this.mDataList);
    }
}
