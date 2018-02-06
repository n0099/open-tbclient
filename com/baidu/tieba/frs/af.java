package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class af {
    private List<FrsTabInfo> dDT;
    private final List<com.baidu.tbadk.mainTab.b> dDU = new LinkedList();
    private String dHw;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public af(Context context, List<FrsTabInfo> list) {
        this.dDT = list;
        this.mContext = context;
    }

    public boolean nb(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.E(this.dDT)) {
            for (FrsTabInfo frsTabInfo : this.dDT) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> awo() {
        return this.dDT;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.MV() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dDU) {
                if (bVar2 != null && bVar2.MV() != null && bVar2.MV().type == bVar.MV().type) {
                    return;
                }
            }
            this.dDU.add(bVar);
        }
    }

    public void awp() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.dDT) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.dDU.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.MV() != null && frsTabInfo.tab_id.intValue() == next.MV().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.E(linkedList2)) {
            this.dDT.removeAll(linkedList2);
        }
        this.dDU.clear();
        if (!com.baidu.tbadk.core.util.v.E(linkedList)) {
            this.dDU.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> auE() {
        return this.dDU;
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

    public void lJ(String str) {
        this.dHw = str;
    }
}
