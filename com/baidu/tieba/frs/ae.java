package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ae {
    private List<FrsTabInfo> cKc;
    private final List<com.baidu.tbadk.mainTab.b> cKd = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ae(Context context, List<FrsTabInfo> list) {
        this.cKc = list;
        this.mContext = context;
    }

    public boolean jX(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.w(this.cKc)) {
            for (FrsTabInfo frsTabInfo : this.cKc) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> amr() {
        return this.cKc;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EZ() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.cKd) {
                if (bVar2 != null && bVar2.EZ() != null && bVar2.EZ().type == bVar.EZ().type) {
                    return;
                }
            }
            this.cKd.add(bVar);
        }
    }

    public void ams() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.cKc) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.cKd.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.EZ() != null && frsTabInfo.tab_id.intValue() == next.EZ().type) {
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
            this.cKc.removeAll(linkedList2);
        }
        this.cKd.clear();
        if (!com.baidu.tbadk.core.util.v.w(linkedList)) {
            this.cKd.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> amt() {
        return this.cKd;
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
