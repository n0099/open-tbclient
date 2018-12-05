package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes6.dex */
public class b {
    private List<a> esh;
    private List<h> mDataList = new ArrayList();

    public List<a> aKp() {
        return this.esh;
    }

    public List<h> getDataList() {
        return this.mDataList;
    }

    public List<a> ci(List<GodBanner> list) {
        if (this.esh == null) {
            this.esh = new ArrayList();
        }
        this.esh.clear();
        if (v.I(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.ej(godBanner.pic_url);
                aVar.pi(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.esh.add(aVar);
                if (v.H(this.esh) == 5) {
                    break;
                }
            }
        }
        return this.esh;
    }

    public boolean OK() {
        return v.I(this.esh) && v.I(this.mDataList);
    }
}
