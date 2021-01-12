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
    public int jLU;

    private a() {
    }

    public static a rC(boolean z) {
        if (z && cLz()) {
            return new a();
        }
        return null;
    }

    public static boolean cLz() {
        return com.baidu.tbadk.a.d.biJ();
    }

    public static void aw(Activity activity) {
        if (com.baidu.tbadk.a.d.biJ()) {
            List<bz> KD = com.baidu.tieba.h.a.cLv().KD("6051001535-87847998");
            if (x.isEmpty(KD) || KD.size() < 3) {
                com.baidu.tieba.h.a.cLv().b(activity, "6051001535-87847998", new a.d() { // from class: com.baidu.tieba.funad.a.1
                    @Override // com.baidu.tieba.h.a.d
                    public void a(String str, n nVar) {
                        a.AR(0);
                    }

                    @Override // com.baidu.tieba.h.a.d
                    public void onError(String str) {
                        a.AR(1);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void AR(int i) {
        aq.AM("c14005").an("obj_source", 6).dW("obj_type", PageStayDurationConstants.PageName.FRS).an("obj_locate", i).bsu();
    }

    public void q(List<com.baidu.adp.widget.ListView.n> list, boolean z) {
        int i;
        int cLx = com.baidu.tieba.h.a.cLv().cLx();
        if (z) {
            int cLw = com.baidu.tieba.h.a.cLv().cLw() - 1;
            Iterator<com.baidu.adp.widget.ListView.n> it = list.iterator();
            while (true) {
                i = cLw;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n next = it.next();
                if (!(next instanceof bz)) {
                    cLw = i;
                } else if (((bz) next).bns() != 1) {
                    break;
                } else {
                    cLw = i + 1;
                }
            }
        } else {
            i = this.jLU;
        }
        this.jLU = a(i, cLx, list);
    }

    private int a(int i, int i2, List<com.baidu.adp.widget.ListView.n> list) {
        if (list == null || list.size() == 0 || i > list.size() - 1) {
            return 0;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            bz bzVar = new bz();
            n nVar = new n(null);
            nVar.xX(true);
            bzVar.eRU = nVar;
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
