package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class am {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private String hxu;
    private List<FrsTabInfo> iAC;
    private final List<com.baidu.tbadk.mainTab.b> iAD = new LinkedList();
    private Context mContext;

    public am(Context context, List<FrsTabInfo> list) {
        this.iAC = list;
        this.mContext = context;
    }

    public boolean yV(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.y.isEmpty(this.iAC)) {
            for (FrsTabInfo frsTabInfo : this.iAC) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bwJ() {
        return this.iAC;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.iAD) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.iAD.add(bVar);
        }
    }

    public void cxU() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.iAC) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.iAD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.getFragmentTabStructure() != null && frsTabInfo.tab_id.intValue() == next.getFragmentTabStructure().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(linkedList2)) {
            this.iAC.removeAll(linkedList2);
        }
        this.iAD.clear();
        if (!com.baidu.tbadk.core.util.y.isEmpty(linkedList)) {
            this.iAD.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> cvp() {
        return this.iAD;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    public String getForumGameLabel() {
        return this.forumGameLabel;
    }

    public void Ip(String str) {
        this.hxu = str;
    }

    public String cxV() {
        return this.hxu;
    }
}
