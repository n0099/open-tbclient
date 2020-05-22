package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class p {
    private ArrayList<o> gOZ;

    public void bS(List<FrsTabInfo> list) {
        if (this.gOZ == null) {
            this.gOZ = new ArrayList<>();
        }
        this.gOZ.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.gOZ.add(new o(frsTabInfo));
                }
            }
        }
    }

    public ArrayList<o> bOt() {
        return this.gOZ;
    }

    public boolean b(o oVar) {
        if (oVar == null) {
            return false;
        }
        if (v.isEmpty(this.gOZ)) {
            return true;
        }
        Iterator<o> it = this.gOZ.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (oVar.a(next)) {
                return oVar.bOr() > next.bOr();
            }
        }
        return true;
    }

    public boolean b(p pVar) {
        if (pVar == null || pVar.gOZ == null || this.gOZ.size() != pVar.gOZ.size()) {
            return false;
        }
        for (int i = 0; i < this.gOZ.size(); i++) {
            o oVar = this.gOZ.get(i);
            o oVar2 = this.gOZ.get(i);
            if (oVar == null || oVar2 == null || !oVar.a(oVar2)) {
                return false;
            }
        }
        return true;
    }
}
