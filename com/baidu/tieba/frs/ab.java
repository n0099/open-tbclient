package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ab {
    private List<FrsTabInfo> eYj;
    private final List<com.baidu.tbadk.mainTab.b> eYk = new LinkedList();
    private String fcR;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ab(Context context, List<FrsTabInfo> list) {
        this.eYj = list;
        this.mContext = context;
    }

    public boolean qt(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.T(this.eYj)) {
            for (FrsTabInfo frsTabInfo : this.eYj) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> beq() {
        return this.eYj;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.anL() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.eYk) {
                if (bVar2 != null && bVar2.anL() != null && bVar2.anL().type == bVar.anL().type) {
                    return;
                }
            }
            this.eYk.add(bVar);
        }
    }

    public void ber() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.eYj) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.eYk.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.anL() != null && frsTabInfo.tab_id.intValue() == next.anL().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.T(linkedList2)) {
            this.eYj.removeAll(linkedList2);
        }
        this.eYk.clear();
        if (!com.baidu.tbadk.core.util.v.T(linkedList)) {
            this.eYk.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bcc() {
        return this.eYk;
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

    public void vb(String str) {
        this.fcR = str;
    }
}
