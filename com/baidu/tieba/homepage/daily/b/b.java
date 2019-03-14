package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes4.dex */
public class b {
    private List<a> fId;
    private List<m> mDataList = new ArrayList();

    public List<a> blE() {
        return this.fId;
    }

    public List<m> getDataList() {
        return this.mDataList;
    }

    public List<a> cv(List<GodBanner> list) {
        if (this.fId == null) {
            this.fId = new ArrayList();
        }
        this.fId.clear();
        if (v.T(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.lf(godBanner.pic_url);
                aVar.wd(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.fId.add(aVar);
                if (v.S(this.fId) == 5) {
                    break;
                }
            }
        }
        return this.fId;
    }

    public boolean aoI() {
        return v.T(this.fId) && v.T(this.mDataList);
    }
}
