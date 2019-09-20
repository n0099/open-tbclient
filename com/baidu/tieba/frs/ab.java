package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ab {
    private String fAa;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> fvr;
    private final List<com.baidu.tbadk.mainTab.b> fvs = new LinkedList();
    private Context mContext;

    public ab(Context context, List<FrsTabInfo> list) {
        this.fvr = list;
        this.mContext = context;
    }

    public boolean rT(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.aa(this.fvr)) {
            for (FrsTabInfo frsTabInfo : this.fvr) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> boF() {
        return this.fvr;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.aug() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.fvs) {
                if (bVar2 != null && bVar2.aug() != null && bVar2.aug().type == bVar.aug().type) {
                    return;
                }
            }
            this.fvs.add(bVar);
        }
    }

    public void boG() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.fvr) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.fvs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.aug() != null && frsTabInfo.tab_id.intValue() == next.aug().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.aa(linkedList2)) {
            this.fvr.removeAll(linkedList2);
        }
        this.fvs.clear();
        if (!com.baidu.tbadk.core.util.v.aa(linkedList)) {
            this.fvs.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bmq() {
        return this.fvs;
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

    public void xx(String str) {
        this.fAa = str;
    }
}
