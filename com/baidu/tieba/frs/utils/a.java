package com.baidu.tieba.frs.utils;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static void a(ForumData forumData, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z, int i) {
        if (!x.t(arrayList)) {
            Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.c) {
                    com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) next;
                    cVar.Pz = new com.baidu.tbadk.core.data.b();
                    cVar.Pz.OO = "FRS";
                    cVar.Pz.OP = String.valueOf(z);
                    cVar.Pz.pn = i;
                    if (forumData != null) {
                        cVar.Pz.fid = forumData.getId();
                        cVar.Pz.OQ = forumData.getFirst_class();
                        cVar.Pz.OR = forumData.getSecond_class();
                    }
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null) {
                        cVar.Pz.OS = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
                    }
                    cVar.Pz.extensionInfo = cVar.extensionInfo;
                    cVar.Pz.OT = false;
                }
            }
        }
    }

    public static void a(com.baidu.tieba.frs.d.i iVar, List<com.baidu.adp.widget.ListView.v> list, int i) {
        ForumData aIk;
        if (!x.t(list)) {
            for (com.baidu.adp.widget.ListView.v vVar : list) {
                if (vVar instanceof com.baidu.tbadk.core.data.c) {
                    com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) vVar;
                    cVar.Pz = new com.baidu.tbadk.core.data.b();
                    cVar.Pz.OO = "FRS";
                    cVar.Pz.OP = String.valueOf(false);
                    cVar.Pz.pn = i;
                    if (iVar != null && iVar.ZZ() != null && (aIk = iVar.ZZ().aIk()) != null) {
                        cVar.Pz.fid = aIk.getId();
                        cVar.Pz.OQ = aIk.getFirst_class();
                        cVar.Pz.OR = aIk.getSecond_class();
                    }
                    AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                    if (currentAccountObj != null) {
                        cVar.Pz.OS = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
                    }
                    cVar.Pz.extensionInfo = cVar.extensionInfo;
                    cVar.Pz.OT = false;
                }
            }
        }
    }

    public static void a(com.baidu.tieba.tbadkCore.data.f fVar, List<com.baidu.adp.widget.ListView.v> list, List<com.baidu.adp.widget.ListView.v> list2) {
        int[] iArr;
        int indexOf;
        if (fVar != null && x.s(list) > 0 && x.s(list2) > 0) {
            for (int i : com.baidu.tieba.tbadkCore.data.f.ffY) {
                com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) x.c(list, i);
                if (vVar != null && (indexOf = list2.indexOf(vVar)) >= 0) {
                    fVar.bk(i, indexOf);
                }
            }
        }
    }
}
