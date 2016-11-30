package com.baidu.tieba.frs.utils;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static void a(ForumData forumData, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z, int i) {
        if (!com.baidu.tbadk.core.util.x.t(arrayList)) {
            Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.c) {
                    com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) next;
                    cVar.PD = new com.baidu.tbadk.core.data.b();
                    cVar.PD.OS = "FRS";
                    cVar.PD.OT = String.valueOf(z);
                    cVar.PD.pn = i;
                    if (forumData != null) {
                        cVar.PD.fid = forumData.getId();
                        cVar.PD.OU = forumData.getFirst_class();
                        cVar.PD.OV = forumData.getSecond_class();
                    }
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null) {
                        cVar.PD.OW = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
                    }
                    cVar.PD.extensionInfo = cVar.extensionInfo;
                    cVar.PD.OX = false;
                }
            }
        }
    }

    public static void a(com.baidu.tieba.frs.e.i iVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        ForumData aOk;
        if (!com.baidu.tbadk.core.util.x.t(list)) {
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tbadk.core.data.c) {
                    com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) vVar;
                    cVar.PD = new com.baidu.tbadk.core.data.b();
                    cVar.PD.OS = "FRS";
                    cVar.PD.OT = String.valueOf(false);
                    cVar.PD.pn = i;
                    if (iVar != null && iVar.afE() != null && (aOk = iVar.afE().aOk()) != null) {
                        cVar.PD.fid = aOk.getId();
                        cVar.PD.OU = aOk.getFirst_class();
                        cVar.PD.OV = aOk.getSecond_class();
                    }
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null) {
                        cVar.PD.OW = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
                    }
                    cVar.PD.extensionInfo = cVar.extensionInfo;
                    cVar.PD.OX = false;
                }
            }
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.f fVar, List<com.baidu.adp.widget.ListView.v> list, List<com.baidu.adp.widget.ListView.v> list2) {
        int[] iArr;
        int indexOf;
        if (fVar != null && com.baidu.tbadk.core.util.x.s(list) > 0 && com.baidu.tbadk.core.util.x.s(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.f.fBT) {
                com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(list, i);
                if (vVar != null && (indexOf = list2.indexOf(vVar)) >= 0) {
                    fVar.bv(i, indexOf);
                }
            }
        }
    }
}
