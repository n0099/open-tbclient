package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ad {
    private List<FrsTabInfo> drB;
    private final List<com.baidu.tbadk.mainTab.b> drC = new LinkedList();
    private String dvP;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ad(Context context, List<FrsTabInfo> list) {
        this.drB = list;
        this.mContext = context;
    }

    public boolean ll(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.z(this.drB)) {
            for (FrsTabInfo frsTabInfo : this.drB) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> axV() {
        return this.drB;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.KE() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.drC) {
                if (bVar2 != null && bVar2.KE() != null && bVar2.KE().type == bVar.KE().type) {
                    return;
                }
            }
            this.drC.add(bVar);
        }
    }

    public void axW() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.drB) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.drC.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.KE() != null && frsTabInfo.tab_id.intValue() == next.KE().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.z(linkedList2)) {
            this.drB.removeAll(linkedList2);
        }
        this.drC.clear();
        if (!com.baidu.tbadk.core.util.v.z(linkedList)) {
            this.drC.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> avN() {
        return this.drC;
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

    public void na(String str) {
        this.dvP = str;
    }
}
