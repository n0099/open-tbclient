package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes4.dex */
public class b {
    private List<a> fYM;
    private List<m> mDataList = new ArrayList();

    public List<a> bsX() {
        return this.fYM;
    }

    public List<m> getDataList() {
        return this.mDataList;
    }

    public List<a> cA(List<GodBanner> list) {
        if (this.fYM == null) {
            this.fYM = new ArrayList();
        }
        this.fYM.clear();
        if (v.aa(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.ml(godBanner.pic_url);
                aVar.xr(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.fYM.add(aVar);
                if (v.Z(this.fYM) == 5) {
                    break;
                }
            }
        }
        return this.fYM;
    }

    public boolean atJ() {
        return v.aa(this.fYM) && v.aa(this.mDataList);
    }
}
