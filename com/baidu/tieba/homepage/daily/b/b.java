package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes4.dex */
public class b {
    private List<a> gdM;
    private List<m> mDataList = new ArrayList();

    public List<a> bvd() {
        return this.gdM;
    }

    public List<m> getDataList() {
        return this.mDataList;
    }

    public List<a> cB(List<GodBanner> list) {
        if (this.gdM == null) {
            this.gdM = new ArrayList();
        }
        this.gdM.clear();
        if (v.aa(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.mv(godBanner.pic_url);
                aVar.xY(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.gdM.add(aVar);
                if (v.Z(this.gdM) == 5) {
                    break;
                }
            }
        }
        return this.gdM;
    }

    public boolean auR() {
        return v.aa(this.gdM) && v.aa(this.mDataList);
    }
}
