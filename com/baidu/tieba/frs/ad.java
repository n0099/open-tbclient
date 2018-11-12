package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ad {
    private List<FrsTabInfo> dAT;
    private final List<com.baidu.tbadk.mainTab.b> dAU = new LinkedList();
    private String dFg;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ad(Context context, List<FrsTabInfo> list) {
        this.dAT = list;
        this.mContext = context;
    }

    public boolean mb(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.I(this.dAT)) {
            for (FrsTabInfo frsTabInfo : this.dAT) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> aAO() {
        return this.dAT;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.ML() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dAU) {
                if (bVar2 != null && bVar2.ML() != null && bVar2.ML().type == bVar.ML().type) {
                    return;
                }
            }
            this.dAU.add(bVar);
        }
    }

    public void aAP() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.dAT) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.dAU.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.ML() != null && frsTabInfo.tab_id.intValue() == next.ML().type) {
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
            this.dAT.removeAll(linkedList2);
        }
        this.dAU.clear();
        if (!com.baidu.tbadk.core.util.v.I(linkedList)) {
            this.dAU.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> ayH() {
        return this.dAU;
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

    public void nD(String str) {
        this.dFg = str;
    }
}
