package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ag {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private String gob;
    private List<FrsTabInfo> hmE;
    private final List<com.baidu.tbadk.mainTab.b> hmF = new LinkedList();
    private Context mContext;

    public ag(Context context, List<FrsTabInfo> list) {
        this.hmE = list;
        this.mContext = context;
    }

    public boolean uj(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.isEmpty(this.hmE)) {
            for (FrsTabInfo frsTabInfo : this.hmE) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bUx() {
        return this.hmE;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.hmF) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.hmF.add(bVar);
        }
    }

    public void bWU() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.hmE) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.hmF.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.getFragmentTabStructure() != null && frsTabInfo.tab_id.intValue() == next.getFragmentTabStructure().type) {
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
            this.hmE.removeAll(linkedList2);
        }
        this.hmF.clear();
        if (!com.baidu.tbadk.core.util.v.isEmpty(linkedList)) {
            this.hmF.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bUy() {
        return this.hmF;
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

    public void CX(String str) {
        this.gob = str;
    }

    public String bWV() {
        return this.gob;
    }
}
