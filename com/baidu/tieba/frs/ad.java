package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ad {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private String fut;
    private List<FrsTabInfo> gow;
    private final List<com.baidu.tbadk.mainTab.b> gox = new LinkedList();
    private Context mContext;

    public ad(Context context, List<FrsTabInfo> list) {
        this.gow = list;
        this.mContext = context;
    }

    public boolean te(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.isEmpty(this.gow)) {
            for (FrsTabInfo frsTabInfo : this.gow) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bDD() {
        return this.gow;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.gox) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.gox.add(bVar);
        }
    }

    public void bFV() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.gow) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.gox.iterator();
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
        if (!com.baidu.tbadk.core.util.v.isEmpty(linkedList2)) {
            this.gow.removeAll(linkedList2);
        }
        this.gox.clear();
        if (!com.baidu.tbadk.core.util.v.isEmpty(linkedList)) {
            this.gox.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bDE() {
        return this.gox;
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

    public void zG(String str) {
        this.fut = str;
    }

    public String bFW() {
        return this.fut;
    }
}
