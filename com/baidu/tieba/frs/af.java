package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class af {
    private List<FrsTabInfo> dDK;
    private final List<com.baidu.tbadk.mainTab.b> dDL = new LinkedList();
    private String dHp;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public af(Context context, List<FrsTabInfo> list) {
        this.dDK = list;
        this.mContext = context;
    }

    public boolean nb(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.E(this.dDK)) {
            for (FrsTabInfo frsTabInfo : this.dDK) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> awp() {
        return this.dDK;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.MV() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dDL) {
                if (bVar2 != null && bVar2.MV() != null && bVar2.MV().type == bVar.MV().type) {
                    return;
                }
            }
            this.dDL.add(bVar);
        }
    }

    public void awq() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.dDK) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.dDL.iterator();
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
            this.dDK.removeAll(linkedList2);
        }
        this.dDL.clear();
        if (!com.baidu.tbadk.core.util.v.E(linkedList)) {
            this.dDL.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> auE() {
        return this.dDL;
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
        this.dHp = str;
    }
}
