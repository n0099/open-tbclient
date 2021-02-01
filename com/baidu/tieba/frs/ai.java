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
    private String hYS;
    private List<FrsTabInfo> jfs;
    private final List<com.baidu.tbadk.mainTab.b> jft = new LinkedList();
    private Context mContext;

    public ai(Context context, List<FrsTabInfo> list) {
        this.jfs = list;
        this.mContext = context;
    }

    public boolean zb(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.y.isEmpty(this.jfs)) {
            for (FrsTabInfo frsTabInfo : this.jfs) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bAS() {
        return this.jfs;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.jft) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.jft.add(bVar);
        }
    }

    public void cEF() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.jfs) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.jft.iterator();
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
            this.jfs.removeAll(linkedList2);
        }
        this.jft.clear();
        if (!com.baidu.tbadk.core.util.y.isEmpty(linkedList)) {
            this.jft.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> cBX() {
        return this.jft;
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

    public void Im(String str) {
        this.hYS = str;
    }

    public String cEG() {
        return this.hYS;
    }
}
