package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes6.dex */
public class b {
    private List<a> euY;
    private List<h> mDataList = new ArrayList();

    public List<a> aLe() {
        return this.euY;
    }

    public List<h> getDataList() {
        return this.mDataList;
    }

    public List<a> cj(List<GodBanner> list) {
        if (this.euY == null) {
            this.euY = new ArrayList();
        }
        this.euY.clear();
        if (v.I(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.ej(godBanner.pic_url);
                aVar.pl(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.euY.add(aVar);
                if (v.H(this.euY) == 5) {
                    break;
                }
            }
        }
        return this.euY;
    }

    public boolean OL() {
        return v.I(this.euY) && v.I(this.mDataList);
    }
}
