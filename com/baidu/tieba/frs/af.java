package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class af {
    private List<FrsTabInfo> dDH;
    private final List<com.baidu.tbadk.mainTab.b> dDI = new LinkedList();
    private String dHk;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public af(Context context, List<FrsTabInfo> list) {
        this.dDH = list;
        this.mContext = context;
    }

    public boolean nb(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.E(this.dDH)) {
            for (FrsTabInfo frsTabInfo : this.dDH) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> awn() {
        return this.dDH;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.MU() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dDI) {
                if (bVar2 != null && bVar2.MU() != null && bVar2.MU().type == bVar.MU().type) {
                    return;
                }
            }
            this.dDI.add(bVar);
        }
    }

    public void awo() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.dDH) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.dDI.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.MU() != null && frsTabInfo.tab_id.intValue() == next.MU().type) {
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
            this.dDH.removeAll(linkedList2);
        }
        this.dDI.clear();
        if (!com.baidu.tbadk.core.util.v.E(linkedList)) {
            this.dDI.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> auD() {
        return this.dDI;
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
        this.dHk = str;
    }
}
