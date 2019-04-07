package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GodBanner;
/* loaded from: classes4.dex */
public class b {
    private List<a> fHR;
    private List<m> mDataList = new ArrayList();

    public List<a> blB() {
        return this.fHR;
    }

    public List<m> getDataList() {
        return this.mDataList;
    }

    public List<a> cs(List<GodBanner> list) {
        if (this.fHR == null) {
            this.fHR = new ArrayList();
        }
        this.fHR.clear();
        if (v.T(list)) {
            return null;
        }
        for (GodBanner godBanner : list) {
            if (godBanner != null && !StringUtils.isNull(godBanner.pic_url)) {
                a aVar = new a();
                aVar.lg(godBanner.pic_url);
                aVar.wc(godBanner.link_url);
                aVar.setTitle(godBanner.intro);
                this.fHR.add(aVar);
                if (v.S(this.fHR) == 5) {
                    break;
                }
            }
        }
        return this.fHR;
    }

    public boolean aoF() {
        return v.T(this.fHR) && v.T(this.mDataList);
    }
}
