package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes2.dex */
public class b {
    private List<a> dUK;
    private List<h> mDataList = new ArrayList();

    public List<a> aDy() {
        return this.dUK;
    }

    public List<h> getDataList() {
        return this.mDataList;
    }

    public List<a> bP(List<GodBanner> list) {
        if (this.dUK == null) {
            this.dUK = new ArrayList();
        }
        this.dUK.clear();
        if (w.z(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.dj(godBanner.pic_url);
                aVar.nu(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.dUK.add(aVar);
                if (w.y(this.dUK) == 5) {
                    break;
                }
            }
        }
        return this.dUK;
    }

    public boolean Kf() {
        return w.z(this.dUK) && w.z(this.mDataList);
    }
}
