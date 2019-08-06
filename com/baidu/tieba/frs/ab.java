package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ab {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> ftE;
    private final List<com.baidu.tbadk.mainTab.b> ftF = new LinkedList();
    private String fyn;
    private Context mContext;

    public ab(Context context, List<FrsTabInfo> list) {
        this.ftE = list;
        this.mContext = context;
    }

    public boolean rQ(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.aa(this.ftE)) {
            for (FrsTabInfo frsTabInfo : this.ftE) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bnU() {
        return this.ftE;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.atU() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.ftF) {
                if (bVar2 != null && bVar2.atU() != null && bVar2.atU().type == bVar.atU().type) {
                    return;
                }
            }
            this.ftF.add(bVar);
        }
    }

    public void bnV() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.ftE) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.ftF.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.atU() != null && frsTabInfo.tab_id.intValue() == next.atU().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.aa(linkedList2)) {
            this.ftE.removeAll(linkedList2);
        }
        this.ftF.clear();
        if (!com.baidu.tbadk.core.util.v.aa(linkedList)) {
            this.ftF.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> blF() {
        return this.ftF;
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

    public void wY(String str) {
        this.fyn = str;
    }
}
