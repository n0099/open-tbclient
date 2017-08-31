package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ad {
    private List<FrsTabInfo> csa;
    private final List<com.baidu.tbadk.mainTab.b> csb = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ad(Context context, List<FrsTabInfo> list) {
        this.csa = list;
        this.mContext = context;
    }

    public boolean jb(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.v(this.csa)) {
            for (FrsTabInfo frsTabInfo : this.csa) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> ahV() {
        return this.csa;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EV() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.csb) {
                if (bVar2 != null && bVar2.EV() != null && bVar2.EV().type == bVar.EV().type) {
                    return;
                }
            }
            this.csb.add(bVar);
        }
    }

    public void ahW() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.csa) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.csb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.EV() != null && frsTabInfo.tab_id.intValue() == next.EV().type) {
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
            this.csa.removeAll(linkedList2);
        }
        this.csb.clear();
        if (!com.baidu.tbadk.core.util.v.v(linkedList)) {
            this.csb.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> ahX() {
        return this.csb;
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
