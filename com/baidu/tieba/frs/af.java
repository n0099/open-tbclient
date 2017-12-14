package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class af {
    private List<FrsTabInfo> cKm;
    private final List<com.baidu.tbadk.mainTab.b> cKn = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public af(Context context, List<FrsTabInfo> list) {
        this.cKm = list;
        this.mContext = context;
    }

    public boolean jZ(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.w(this.cKm)) {
            for (FrsTabInfo frsTabInfo : this.cKm) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> amA() {
        return this.cKm;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Fa() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.cKn) {
                if (bVar2 != null && bVar2.Fa() != null && bVar2.Fa().type == bVar.Fa().type) {
                    return;
                }
            }
            this.cKn.add(bVar);
        }
    }

    public void amB() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.cKm) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.cKn.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.Fa() != null && frsTabInfo.tab_id.intValue() == next.Fa().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.w(linkedList2)) {
            this.cKm.removeAll(linkedList2);
        }
        this.cKn.clear();
        if (!com.baidu.tbadk.core.util.v.w(linkedList)) {
            this.cKn.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> amC() {
        return this.cKn;
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
