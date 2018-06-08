package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ab {
    private List<FrsTabInfo> dgX;
    private final List<com.baidu.tbadk.mainTab.b> dgY = new LinkedList();
    private String dkE;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ab(Context context, List<FrsTabInfo> list) {
        this.dgX = list;
        this.mContext = context;
    }

    public boolean ks(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.w.z(this.dgX)) {
            for (FrsTabInfo frsTabInfo : this.dgX) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> auM() {
        return this.dgX;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Jb() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dgY) {
                if (bVar2 != null && bVar2.Jb() != null && bVar2.Jb().type == bVar.Jb().type) {
                    return;
                }
            }
            this.dgY.add(bVar);
        }
    }

    public void auN() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.dgX) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.dgY.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.Jb() != null && frsTabInfo.tab_id.intValue() == next.Jb().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.w.z(linkedList2)) {
            this.dgX.removeAll(linkedList2);
        }
        this.dgY.clear();
        if (!com.baidu.tbadk.core.util.w.z(linkedList)) {
            this.dgY.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> atc() {
        return this.dgY;
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

    public void mw(String str) {
        this.dkE = str;
    }
}
