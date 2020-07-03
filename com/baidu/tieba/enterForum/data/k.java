package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class k {
    private ArrayList<j> hbT;

    public void cb(List<FrsTabInfo> list) {
        if (this.hbT == null) {
            this.hbT = new ArrayList<>();
        }
        this.hbT.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.hbT.add(new j(frsTabInfo));
                }
            }
        }
    }

    public ArrayList<j> bRy() {
        return this.hbT;
    }

    public boolean b(j jVar) {
        if (jVar == null) {
            return false;
        }
        if (w.isEmpty(this.hbT)) {
            return true;
        }
        Iterator<j> it = this.hbT.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (jVar.a(next)) {
                return jVar.bRw() > next.bRw();
            }
        }
        return true;
    }

    public boolean b(k kVar) {
        if (kVar == null || kVar.hbT == null || this.hbT.size() != kVar.hbT.size()) {
            return false;
        }
        for (int i = 0; i < this.hbT.size(); i++) {
            j jVar = this.hbT.get(i);
            j jVar2 = this.hbT.get(i);
            if (jVar == null || jVar2 == null || !jVar.a(jVar2)) {
                return false;
            }
        }
        return true;
    }
}
