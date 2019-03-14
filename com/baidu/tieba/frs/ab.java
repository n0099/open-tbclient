package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ab {
    private List<FrsTabInfo> eYi;
    private final List<com.baidu.tbadk.mainTab.b> eYj = new LinkedList();
    private String fcQ;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ab(Context context, List<FrsTabInfo> list) {
        this.eYi = list;
        this.mContext = context;
    }

    public boolean qt(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.T(this.eYi)) {
            for (FrsTabInfo frsTabInfo : this.eYi) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> beq() {
        return this.eYi;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.anK() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.eYj) {
                if (bVar2 != null && bVar2.anK() != null && bVar2.anK().type == bVar.anK().type) {
                    return;
                }
            }
            this.eYj.add(bVar);
        }
    }

    public void ber() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.eYi) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.eYj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.anK() != null && frsTabInfo.tab_id.intValue() == next.anK().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.T(linkedList2)) {
            this.eYi.removeAll(linkedList2);
        }
        this.eYj.clear();
        if (!com.baidu.tbadk.core.util.v.T(linkedList)) {
            this.eYj.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bcc() {
        return this.eYj;
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

    public void va(String str) {
        this.fcQ = str;
    }
}
