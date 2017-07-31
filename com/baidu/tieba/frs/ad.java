package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ad {
    private List<FrsTabInfo> clT;
    private final List<com.baidu.tbadk.mainTab.b> clU = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ad(Context context, List<FrsTabInfo> list) {
        this.clT = list;
        this.mContext = context;
    }

    public boolean iN(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.u.v(this.clT)) {
            for (FrsTabInfo frsTabInfo : this.clT) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> agi() {
        return this.clT;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EX() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.clU) {
                if (bVar2 != null && bVar2.EX() != null && bVar2.EX().type == bVar.EX().type) {
                    return;
                }
            }
            this.clU.add(bVar);
        }
    }

    public void agj() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.clT) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.clU.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.EX() != null && frsTabInfo.tab_id.intValue() == next.EX().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.u.v(linkedList2)) {
            this.clT.removeAll(linkedList2);
        }
        this.clU.clear();
        if (!com.baidu.tbadk.core.util.u.v(linkedList)) {
            this.clU.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> agk() {
        return this.clU;
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
}
