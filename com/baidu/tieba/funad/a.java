package com.baidu.tieba.funad;

import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.cb;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    public int jSU;

    private a() {
    }

    public static a rM(boolean z) {
        if (z && cNn()) {
            return new a();
        }
        return null;
    }

    public static boolean cNn() {
        return com.baidu.tbadk.a.d.biV();
    }

    public void r(List<n> list, boolean z) {
        int i;
        int cNl = com.baidu.tieba.h.a.cNj().cNl();
        if (z) {
            int cNk = com.baidu.tieba.h.a.cNj().cNk() - 1;
            Iterator<n> it = list.iterator();
            while (true) {
                i = cNk;
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if (!(next instanceof cb)) {
                    cNk = i;
                } else if (((cb) next).bnL() != 1) {
                    break;
                } else {
                    cNk = i + 1;
                }
            }
        } else {
            i = this.jSU;
        }
        this.jSU = a(i, cNl, list);
    }

    private int a(int i, int i2, List<n> list) {
        if (list == null || list.size() == 0 || i > list.size() - 1) {
            return 0;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            cb cbVar = new cb();
            com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n(null);
            nVar.yq(true);
            cbVar.eUi = nVar;
            list.add(i, cbVar);
            i = i + i2 + 1;
            if (i > list.size() - 1) {
                return (i - (list.size() - 1)) - 1;
            }
        }
        return 0;
    }

    public static boolean a(FrsTabInfo frsTabInfo, int i) {
        if (TbadkApplication.getCurrentAccountInfo() != null && TbadkApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
            return false;
        }
        if (frsTabInfo != null && 505 == frsTabInfo.tab_id.intValue() && 91 == frsTabInfo.tab_type.intValue()) {
            return false;
        }
        return ((frsTabInfo != null && 502 == frsTabInfo.tab_id.intValue() && 91 == frsTabInfo.tab_type.intValue()) || i == 2) ? false : true;
    }
}
