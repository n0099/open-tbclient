package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes2.dex */
public class b {
    private List<a> ebY;
    private List<h> mDataList = new ArrayList();

    public List<a> aFI() {
        return this.ebY;
    }

    public List<h> getDataList() {
        return this.mDataList;
    }

    public List<a> bQ(List<GodBanner> list) {
        if (this.ebY == null) {
            this.ebY = new ArrayList();
        }
        this.ebY.clear();
        if (v.z(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.dB(godBanner.pic_url);
                aVar.ob(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.ebY.add(aVar);
                if (v.y(this.ebY) == 5) {
                    break;
                }
            }
        }
        return this.ebY;
    }

    public boolean Lz() {
        return v.z(this.ebY) && v.z(this.mDataList);
    }
}
