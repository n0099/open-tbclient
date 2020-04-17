package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class p {
    private ArrayList<o> gAj;

    public void bV(List<FrsTabInfo> list) {
        if (this.gAj == null) {
            this.gAj = new ArrayList<>();
        }
        this.gAj.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.gAj.add(new o(frsTabInfo));
                }
            }
        }
    }

    public ArrayList<o> bIb() {
        return this.gAj;
    }

    public boolean b(o oVar) {
        if (oVar == null) {
            return false;
        }
        if (v.isEmpty(this.gAj)) {
            return true;
        }
        Iterator<o> it = this.gAj.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (oVar.a(next)) {
                return oVar.bHZ() > next.bHZ();
            }
        }
        return true;
    }

    public boolean b(p pVar) {
        if (pVar == null || pVar.gAj == null || this.gAj.size() != pVar.gAj.size()) {
            return false;
        }
        for (int i = 0; i < this.gAj.size(); i++) {
            o oVar = this.gAj.get(i);
            o oVar2 = this.gAj.get(i);
            if (oVar == null || oVar2 == null || !oVar.a(oVar2)) {
                return false;
            }
        }
        return true;
    }
}
