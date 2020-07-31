package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes16.dex */
public class j {
    private ArrayList<i> hhz;

    public void cg(List<FrsTabInfo> list) {
        if (this.hhz == null) {
            this.hhz = new ArrayList<>();
        }
        this.hhz.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.hhz.add(new i(frsTabInfo));
                }
            }
        }
    }

    public ArrayList<i> bUL() {
        return this.hhz;
    }

    public boolean b(i iVar) {
        if (iVar == null) {
            return false;
        }
        if (x.isEmpty(this.hhz)) {
            return true;
        }
        Iterator<i> it = this.hhz.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (iVar.a(next)) {
                return iVar.bUJ() > next.bUJ();
            }
        }
        return true;
    }

    public boolean b(j jVar) {
        if (jVar == null || jVar.hhz == null || this.hhz.size() != jVar.hhz.size()) {
            return false;
        }
        for (int i = 0; i < this.hhz.size(); i++) {
            i iVar = this.hhz.get(i);
            i iVar2 = this.hhz.get(i);
            if (iVar == null || iVar2 == null || !iVar.a(iVar2)) {
                return false;
            }
        }
        return true;
    }
}
