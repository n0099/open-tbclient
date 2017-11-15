package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ae {
    private List<FrsTabInfo> cAY;
    private final List<com.baidu.tbadk.mainTab.b> cAZ = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ae(Context context, List<FrsTabInfo> list) {
        this.cAY = list;
        this.mContext = context;
    }

    public boolean jz(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.v(this.cAY)) {
            for (FrsTabInfo frsTabInfo : this.cAY) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> akv() {
        return this.cAY;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.ES() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.cAZ) {
                if (bVar2 != null && bVar2.ES() != null && bVar2.ES().type == bVar.ES().type) {
                    return;
                }
            }
            this.cAZ.add(bVar);
        }
    }

    public void akw() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.cAY) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.cAZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.ES() != null && frsTabInfo.tab_id.intValue() == next.ES().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.v(linkedList2)) {
            this.cAY.removeAll(linkedList2);
        }
        this.cAZ.clear();
        if (!com.baidu.tbadk.core.util.v.v(linkedList)) {
            this.cAZ.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> akx() {
        return this.cAZ;
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
