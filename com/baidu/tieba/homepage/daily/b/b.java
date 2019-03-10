package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes4.dex */
public class b {
    private List<a> fIe;
    private List<m> mDataList = new ArrayList();

    public List<a> blF() {
        return this.fIe;
    }

    public List<m> getDataList() {
        return this.mDataList;
    }

    public List<a> cv(List<GodBanner> list) {
        if (this.fIe == null) {
            this.fIe = new ArrayList();
        }
        this.fIe.clear();
        if (v.T(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.lf(godBanner.pic_url);
                aVar.wf(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.fIe.add(aVar);
                if (v.S(this.fIe) == 5) {
                    break;
                }
            }
        }
        return this.fIe;
    }

    public boolean aoJ() {
        return v.T(this.fIe) && v.T(this.mDataList);
    }
}
