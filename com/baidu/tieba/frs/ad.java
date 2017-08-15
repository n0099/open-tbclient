package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ad {
    private List<FrsTabInfo> cmF;
    private final List<com.baidu.tbadk.mainTab.b> cmG = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ad(Context context, List<FrsTabInfo> list) {
        this.cmF = list;
        this.mContext = context;
    }

    public boolean iP(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.u.v(this.cmF)) {
            for (FrsTabInfo frsTabInfo : this.cmF) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> agD() {
        return this.cmF;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EX() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.cmG) {
                if (bVar2 != null && bVar2.EX() != null && bVar2.EX().type == bVar.EX().type) {
                    return;
                }
            }
            this.cmG.add(bVar);
        }
    }

    public void agE() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.cmF) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.cmG.iterator();
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
            this.cmF.removeAll(linkedList2);
        }
        this.cmG.clear();
        if (!com.baidu.tbadk.core.util.u.v(linkedList)) {
            this.cmG.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> agF() {
        return this.cmG;
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
