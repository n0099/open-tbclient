package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class p {
    private ArrayList<o> gPk;

    public void bS(List<FrsTabInfo> list) {
        if (this.gPk == null) {
            this.gPk = new ArrayList<>();
        }
        this.gPk.clear();
        if (list != null) {
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null && !StringUtils.isNull(frsTabInfo.tab_code) && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    this.gPk.add(new o(frsTabInfo));
                }
            }
        }
    }

    public ArrayList<o> bOv() {
        return this.gPk;
    }

    public boolean b(o oVar) {
        if (oVar == null) {
            return false;
        }
        if (v.isEmpty(this.gPk)) {
            return true;
        }
        Iterator<o> it = this.gPk.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (oVar.a(next)) {
                return oVar.bOt() > next.bOt();
            }
        }
        return true;
    }

    public boolean b(p pVar) {
        if (pVar == null || pVar.gPk == null || this.gPk.size() != pVar.gPk.size()) {
            return false;
        }
        for (int i = 0; i < this.gPk.size(); i++) {
            o oVar = this.gPk.get(i);
            o oVar2 = this.gPk.get(i);
            if (oVar == null || oVar2 == null || !oVar.a(oVar2)) {
                return false;
            }
        }
        return true;
    }
}
