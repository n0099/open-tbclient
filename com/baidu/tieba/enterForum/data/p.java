package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class p {
    private ArrayList<o> gAp;

    public void bV(List<FrsTabInfo> list) {
        if (this.gAp == null) {
            this.gAp = new ArrayList<>();
        }
        this.gAp.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.gAp.add(new o(frsTabInfo));
                }
            }
        }
    }

    public ArrayList<o> bIa() {
        return this.gAp;
    }

    public boolean b(o oVar) {
        if (oVar == null) {
            return false;
        }
        if (v.isEmpty(this.gAp)) {
            return true;
        }
        Iterator<o> it = this.gAp.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (oVar.a(next)) {
                return oVar.bHY() > next.bHY();
            }
        }
        return true;
    }

    public boolean b(p pVar) {
        if (pVar == null || pVar.gAp == null || this.gAp.size() != pVar.gAp.size()) {
            return false;
        }
        for (int i = 0; i < this.gAp.size(); i++) {
            o oVar = this.gAp.get(i);
            o oVar2 = this.gAp.get(i);
            if (oVar == null || oVar2 == null || !oVar.a(oVar2)) {
                return false;
            }
        }
        return true;
    }
}
