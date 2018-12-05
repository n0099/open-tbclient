package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ad {
    private List<FrsTabInfo> dHs;
    private final List<com.baidu.tbadk.mainTab.b> dHt = new LinkedList();
    private String dLF;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ad(Context context, List<FrsTabInfo> list) {
        this.dHs = list;
        this.mContext = context;
    }

    public boolean mr(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.I(this.dHs)) {
            for (FrsTabInfo frsTabInfo : this.dHs) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> aCy() {
        return this.dHs;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.NP() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dHt) {
                if (bVar2 != null && bVar2.NP() != null && bVar2.NP().type == bVar.NP().type) {
                    return;
                }
            }
            this.dHt.add(bVar);
        }
    }

    public void aCz() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.dHs) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.dHt.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.NP() != null && frsTabInfo.tab_id.intValue() == next.NP().type) {
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
            this.dHs.removeAll(linkedList2);
        }
        this.dHt.clear();
        if (!com.baidu.tbadk.core.util.v.I(linkedList)) {
            this.dHt.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> aAr() {
        return this.dHt;
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

    public void oc(String str) {
        this.dLF = str;
    }
}
