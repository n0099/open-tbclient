package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes2.dex */
public class b {
    private List<a> dUF;
    private List<h> mDataList = new ArrayList();

    public List<a> aDv() {
        return this.dUF;
    }

    public List<h> getDataList() {
        return this.mDataList;
    }

    public List<a> bP(List<GodBanner> list) {
        if (this.dUF == null) {
            this.dUF = new ArrayList();
        }
        this.dUF.clear();
        if (w.z(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.dj(godBanner.pic_url);
                aVar.nw(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.dUF.add(aVar);
                if (w.y(this.dUF) == 5) {
                    break;
                }
            }
        }
        return this.dUF;
    }

    public boolean Kj() {
        return w.z(this.dUF) && w.z(this.mDataList);
    }
}
