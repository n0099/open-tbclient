package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.tbadk.core.util.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class af {
    private List<FrsTabInfo> dAF;
    private final List<com.baidu.tbadk.mainTab.b> dAG = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public af(Context context, List<FrsTabInfo> list) {
        this.dAF = list;
        this.mContext = context;
    }

    public boolean nd(int i) {
        if (i < 100 && !v.E(this.dAF)) {
            for (FrsTabInfo frsTabInfo : this.dAF) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> avl() {
        return this.dAF;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Mn() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dAG) {
                if (bVar2 != null && bVar2.Mn() != null && bVar2.Mn().type == bVar.Mn().type) {
                    return;
                }
            }
            this.dAG.add(bVar);
        }
    }

    public void avm() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.dAF) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.dAG.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.Mn() != null && frsTabInfo.tab_id.intValue() == next.Mn().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!v.E(linkedList2)) {
            this.dAF.removeAll(linkedList2);
        }
        this.dAG.clear();
        if (!v.E(linkedList)) {
            this.dAG.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> atJ() {
        return this.dAG;
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
