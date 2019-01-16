package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes6.dex */
public class b {
    private List<a> evE;
    private List<h> mDataList = new ArrayList();

    public List<a> aLC() {
        return this.evE;
    }

    public List<h> getDataList() {
        return this.mDataList;
    }

    public List<a> ck(List<GodBanner> list) {
        if (this.evE == null) {
            this.evE = new ArrayList();
        }
        this.evE.clear();
        if (v.I(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.es(godBanner.pic_url);
                aVar.pB(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.evE.add(aVar);
                if (v.H(this.evE) == 5) {
                    break;
                }
            }
        }
        return this.evE;
    }

    public boolean Pd() {
        return v.I(this.evE) && v.I(this.mDataList);
    }
}
