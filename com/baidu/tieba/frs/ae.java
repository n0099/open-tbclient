package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ae {
    private List<FrsTabInfo> cti;
    private final List<com.baidu.tbadk.mainTab.b> ctj = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ae(Context context, List<FrsTabInfo> list) {
        this.cti = list;
        this.mContext = context;
    }

    public boolean jk(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.u(this.cti)) {
            for (FrsTabInfo frsTabInfo : this.cti) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> ahZ() {
        return this.cti;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Eu() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.ctj) {
                if (bVar2 != null && bVar2.Eu() != null && bVar2.Eu().type == bVar.Eu().type) {
                    return;
                }
            }
            this.ctj.add(bVar);
        }
    }

    public void aia() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.cti) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.ctj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.Eu() != null && frsTabInfo.tab_id.intValue() == next.Eu().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.u(linkedList2)) {
            this.cti.removeAll(linkedList2);
        }
        this.ctj.clear();
        if (!com.baidu.tbadk.core.util.v.u(linkedList)) {
            this.ctj.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> aib() {
        return this.ctj;
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
