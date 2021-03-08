package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ai {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private String iaP;
    private List<FrsTabInfo> jhp;
    private final List<com.baidu.tbadk.mainTab.b> jhq = new LinkedList();
    private Context mContext;

    public ai(Context context, List<FrsTabInfo> list) {
        this.jhp = list;
        this.mContext = context;
    }

    public boolean zc(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.y.isEmpty(this.jhp)) {
            for (FrsTabInfo frsTabInfo : this.jhp) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bAV() {
        return this.jhp;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.jhq) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.jhq.add(bVar);
        }
    }

    public void cES() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.jhp) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.jhq.iterator();
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
        if (!com.baidu.tbadk.core.util.y.isEmpty(linkedList2)) {
            this.jhp.removeAll(linkedList2);
        }
        this.jhq.clear();
        if (!com.baidu.tbadk.core.util.y.isEmpty(linkedList)) {
            this.jhq.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> cCk() {
        return this.jhq;
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

    public void Iw(String str) {
        this.iaP = str;
    }

    public String cET() {
        return this.iaP;
    }
}
