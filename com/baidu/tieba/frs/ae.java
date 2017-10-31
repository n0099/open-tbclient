package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ae {
    private List<FrsTabInfo> cAF;
    private final List<com.baidu.tbadk.mainTab.b> cAG = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ae(Context context, List<FrsTabInfo> list) {
        this.cAF = list;
        this.mContext = context;
    }

    public boolean jA(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.v(this.cAF)) {
            for (FrsTabInfo frsTabInfo : this.cAF) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> akh() {
        return this.cAF;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EG() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.cAG) {
                if (bVar2 != null && bVar2.EG() != null && bVar2.EG().type == bVar.EG().type) {
                    return;
                }
            }
            this.cAG.add(bVar);
        }
    }

    public void aki() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.cAF) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.cAG.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.EG() != null && frsTabInfo.tab_id.intValue() == next.EG().type) {
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
            this.cAF.removeAll(linkedList2);
        }
        this.cAG.clear();
        if (!com.baidu.tbadk.core.util.v.v(linkedList)) {
            this.cAG.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> akj() {
        return this.cAG;
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
