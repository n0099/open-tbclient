package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes6.dex */
public class b {
    private List<a> ejS;
    private List<h> mDataList = new ArrayList();

    public List<a> aJa() {
        return this.ejS;
    }

    public List<h> getDataList() {
        return this.mDataList;
    }

    public List<a> cg(List<GodBanner> list) {
        if (this.ejS == null) {
            this.ejS = new ArrayList();
        }
        this.ejS.clear();
        if (v.J(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.dR(godBanner.pic_url);
                aVar.oF(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.ejS.add(aVar);
                if (v.I(this.ejS) == 5) {
                    break;
                }
            }
        }
        return this.ejS;
    }

    public boolean Nx() {
        return v.J(this.ejS) && v.J(this.mDataList);
    }
}
