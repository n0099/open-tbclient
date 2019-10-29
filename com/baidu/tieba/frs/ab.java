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
    private List<FrsTabInfo> fuE;
    private final List<com.baidu.tbadk.mainTab.b> fuF = new LinkedList();
    private String fzp;
    private Context mContext;

    public ab(Context context, List<FrsTabInfo> list) {
        this.fuE = list;
        this.mContext = context;
    }

    public boolean qM(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.isEmpty(this.fuE)) {
            for (FrsTabInfo frsTabInfo : this.fuE) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> blJ() {
        return this.fuE;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.avz() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.fuF) {
                if (bVar2 != null && bVar2.avz() != null && bVar2.avz().type == bVar.avz().type) {
                    return;
                }
            }
            this.fuF.add(bVar);
        }
    }

    public void blK() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.fuE) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.fuF.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.avz() != null && frsTabInfo.tab_id.intValue() == next.avz().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(linkedList2)) {
            this.fuE.removeAll(linkedList2);
        }
        this.fuF.clear();
        if (!com.baidu.tbadk.core.util.v.isEmpty(linkedList)) {
            this.fuF.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bjw() {
        return this.fuF;
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

    public void vP(String str) {
        this.fzp = str;
    }
}
