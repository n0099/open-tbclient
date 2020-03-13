package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ac {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> gnM;
    private final List<com.baidu.tbadk.mainTab.b> gnN = new LinkedList();
    private String gsu;
    private Context mContext;

    public ac(Context context, List<FrsTabInfo> list) {
        this.gnM = list;
        this.mContext = context;
    }

    public boolean tc(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.isEmpty(this.gnM)) {
            for (FrsTabInfo frsTabInfo : this.gnM) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bDv() {
        return this.gnM;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.gnN) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.gnN.add(bVar);
        }
    }

    public void bFL() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.gnM) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.gnN.iterator();
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
            this.gnM.removeAll(linkedList2);
        }
        this.gnN.clear();
        if (!com.baidu.tbadk.core.util.v.isEmpty(linkedList)) {
            this.gnN.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bDw() {
        return this.gnN;
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

    public void Bh(String str) {
        this.gsu = str;
    }
}
