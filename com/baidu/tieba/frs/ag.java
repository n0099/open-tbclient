package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ag {
    private String fYW;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> gXH;
    private final List<com.baidu.tbadk.mainTab.b> gXI = new LinkedList();
    private Context mContext;

    public ag(Context context, List<FrsTabInfo> list) {
        this.gXH = list;
        this.mContext = context;
    }

    public boolean tC(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.isEmpty(this.gXH)) {
            for (FrsTabInfo frsTabInfo : this.gXH) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bOa() {
        return this.gXH;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.gXI) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.gXI.add(bVar);
        }
    }

    public void bQw() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.gXH) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.gXI.iterator();
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
            this.gXH.removeAll(linkedList2);
        }
        this.gXI.clear();
        if (!com.baidu.tbadk.core.util.v.isEmpty(linkedList)) {
            this.gXI.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bOb() {
        return this.gXI;
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

    public void Bo(String str) {
        this.fYW = str;
    }

    public String bQx() {
        return this.fYW;
    }
}
