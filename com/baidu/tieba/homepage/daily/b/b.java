package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes4.dex */
public class b {
    private List<a> ggu;
    private List<m> mDataList = new ArrayList();

    public List<a> bwe() {
        return this.ggu;
    }

    public List<m> getDataList() {
        return this.mDataList;
    }

    public List<a> cA(List<GodBanner> list) {
        if (this.ggu == null) {
            this.ggu = new ArrayList();
        }
        this.ggu.clear();
        if (v.aa(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.mx(godBanner.pic_url);
                aVar.yy(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.ggu.add(aVar);
                if (v.Z(this.ggu) == 5) {
                    break;
                }
            }
        }
        return this.ggu;
    }

    public boolean avf() {
        return v.aa(this.ggu) && v.aa(this.mDataList);
    }
}
