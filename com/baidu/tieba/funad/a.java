package com.baidu.tieba.funad;

import android.app.Activity;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.h.a;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a {
    public int jQA;

    private a() {
    }

    public static a rG(boolean z) {
        if (z && cPr()) {
            return new a();
        }
        return null;
    }

    public static boolean cPr() {
        return com.baidu.tbadk.a.d.bmD();
    }

    public static void aw(Activity activity) {
        if (com.baidu.tbadk.a.d.bmD()) {
            List<bz> LM = com.baidu.tieba.h.a.cPn().LM("6051001001-2043781376");
            if (x.isEmpty(LM) || LM.size() < 3) {
                com.baidu.tieba.h.a.cPn().b(activity, "6051001001-2043781376", new a.d() { // from class: com.baidu.tieba.funad.a.1
                    @Override // com.baidu.tieba.h.a.d
                    public void a(String str, n nVar) {
                        a.Cx(0);
                    }

                    @Override // com.baidu.tieba.h.a.d
                    public void onError(String str) {
                        a.Cx(1);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Cx(int i) {
        aq.BX("c14005").an("obj_source", 6).dX("obj_type", PageStayDurationConstants.PageName.FRS).an("obj_locate", i).bwo();
    }

    public void q(List<com.baidu.adp.widget.ListView.n> list, boolean z) {
        int i;
        int cPp = com.baidu.tieba.h.a.cPn().cPp();
        if (z) {
            int cPo = com.baidu.tieba.h.a.cPn().cPo() - 1;
            Iterator<com.baidu.adp.widget.ListView.n> it = list.iterator();
            while (true) {
                i = cPo;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n next = it.next();
                if (!(next instanceof bz)) {
                    cPo = i;
                } else if (((bz) next).brm() != 1) {
                    break;
                } else {
                    cPo = i + 1;
                }
            }
        } else {
            i = this.jQA;
        }
        this.jQA = a(i, cPp, list);
    }

    private int a(int i, int i2, List<com.baidu.adp.widget.ListView.n> list) {
        if (list == null || list.size() == 0 || i > list.size() - 1) {
            return 0;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            bz bzVar = new bz();
            n nVar = new n(null);
            nVar.yb(true);
            bzVar.eWF = nVar;
            list.add(i, bzVar);
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
