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
    private List<FrsTabInfo> ftf;
    private final List<com.baidu.tbadk.mainTab.b> ftg = new LinkedList();
    private String fxO;
    private Context mContext;

    public ab(Context context, List<FrsTabInfo> list) {
        this.ftf = list;
        this.mContext = context;
    }

    public boolean rO(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.aa(this.ftf)) {
            for (FrsTabInfo frsTabInfo : this.ftf) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bnK() {
        return this.ftf;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.atS() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.ftg) {
                if (bVar2 != null && bVar2.atS() != null && bVar2.atS().type == bVar.atS().type) {
                    return;
                }
            }
            this.ftg.add(bVar);
        }
    }

    public void bnL() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.ftf) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.ftg.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.atS() != null && frsTabInfo.tab_id.intValue() == next.atS().type) {
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
            this.ftf.removeAll(linkedList2);
        }
        this.ftg.clear();
        if (!com.baidu.tbadk.core.util.v.aa(linkedList)) {
            this.ftg.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bly() {
        return this.ftg;
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

    public void wX(String str) {
        this.fxO = str;
    }
}
