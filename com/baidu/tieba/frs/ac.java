package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ac {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> gin;
    private final List<com.baidu.tbadk.mainTab.b> gio = new LinkedList();
    private String gmV;
    private Context mContext;

    public ac(Context context, List<FrsTabInfo> list) {
        this.gin = list;
        this.mContext = context;
    }

    public boolean sR(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.isEmpty(this.gin)) {
            for (FrsTabInfo frsTabInfo : this.gin) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bDd() {
        return this.gin;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.aNf() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.gio) {
                if (bVar2 != null && bVar2.aNf() != null && bVar2.aNf().type == bVar.aNf().type) {
                    return;
                }
            }
            this.gio.add(bVar);
        }
    }

    public void bDe() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.gin) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.gio.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.aNf() != null && frsTabInfo.tab_id.intValue() == next.aNf().type) {
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
            this.gin.removeAll(linkedList2);
        }
        this.gio.clear();
        if (!com.baidu.tbadk.core.util.v.isEmpty(linkedList)) {
            this.gio.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bAO() {
        return this.gio;
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

    public void AG(String str) {
        this.gmV = str;
    }
}
