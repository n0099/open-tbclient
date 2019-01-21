package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ad {
    private List<FrsTabInfo> dKQ;
    private final List<com.baidu.tbadk.mainTab.b> dKR = new LinkedList();
    private String dPd;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ad(Context context, List<FrsTabInfo> list) {
        this.dKQ = list;
        this.mContext = context;
    }

    public boolean mF(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.I(this.dKQ)) {
            for (FrsTabInfo frsTabInfo : this.dKQ) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> aDK() {
        return this.dKQ;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Oh() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dKR) {
                if (bVar2 != null && bVar2.Oh() != null && bVar2.Oh().type == bVar.Oh().type) {
                    return;
                }
            }
            this.dKR.add(bVar);
        }
    }

    public void aDL() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.dKQ) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.dKR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.Oh() != null && frsTabInfo.tab_id.intValue() == next.Oh().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.I(linkedList2)) {
            this.dKQ.removeAll(linkedList2);
        }
        this.dKR.clear();
        if (!com.baidu.tbadk.core.util.v.I(linkedList)) {
            this.dKR.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> aBD() {
        return this.dKR;
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

    public void ox(String str) {
        this.dPd = str;
    }
}
