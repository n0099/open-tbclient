package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ad {
    private List<FrsTabInfo> dKg;
    private final List<com.baidu.tbadk.mainTab.b> dKh = new LinkedList();
    private String dOt;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ad(Context context, List<FrsTabInfo> list) {
        this.dKg = list;
        this.mContext = context;
    }

    public boolean mE(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.I(this.dKg)) {
            for (FrsTabInfo frsTabInfo : this.dKg) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> aDn() {
        return this.dKg;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.NQ() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dKh) {
                if (bVar2 != null && bVar2.NQ() != null && bVar2.NQ().type == bVar.NQ().type) {
                    return;
                }
            }
            this.dKh.add(bVar);
        }
    }

    public void aDo() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.dKg) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.dKh.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.NQ() != null && frsTabInfo.tab_id.intValue() == next.NQ().type) {
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
            this.dKg.removeAll(linkedList2);
        }
        this.dKh.clear();
        if (!com.baidu.tbadk.core.util.v.I(linkedList)) {
            this.dKh.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> aBg() {
        return this.dKh;
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

    public void og(String str) {
        this.dOt = str;
    }
}
