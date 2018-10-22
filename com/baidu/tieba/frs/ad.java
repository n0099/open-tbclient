package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ad {
    private String dDQ;
    private List<FrsTabInfo> dzC;
    private final List<com.baidu.tbadk.mainTab.b> dzD = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ad(Context context, List<FrsTabInfo> list) {
        this.dzC = list;
        this.mContext = context;
    }

    public boolean lJ(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.J(this.dzC)) {
            for (FrsTabInfo frsTabInfo : this.dzC) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> aBr() {
        return this.dzC;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.MC() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dzD) {
                if (bVar2 != null && bVar2.MC() != null && bVar2.MC().type == bVar.MC().type) {
                    return;
                }
            }
            this.dzD.add(bVar);
        }
    }

    public void aBs() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.dzC) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.dzD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.MC() != null && frsTabInfo.tab_id.intValue() == next.MC().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.J(linkedList2)) {
            this.dzC.removeAll(linkedList2);
        }
        this.dzD.clear();
        if (!com.baidu.tbadk.core.util.v.J(linkedList)) {
            this.dzD.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> azk() {
        return this.dzD;
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

    public void nC(String str) {
        this.dDQ = str;
    }
}
