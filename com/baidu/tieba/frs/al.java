package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class al {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private String hMH;
    private List<FrsTabInfo> iSh;
    private final List<com.baidu.tbadk.mainTab.b> iSi = new LinkedList();
    private Context mContext;

    public al(Context context, List<FrsTabInfo> list) {
        this.iSh = list;
        this.mContext = context;
    }

    public boolean Al(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.y.isEmpty(this.iSh)) {
            for (FrsTabInfo frsTabInfo : this.iSh) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bBY() {
        return this.iSh;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.iSi) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.iSi.add(bVar);
        }
    }

    public void cEp() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.iSh) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.iSi.iterator();
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
            this.iSh.removeAll(linkedList2);
        }
        this.iSi.clear();
        if (!com.baidu.tbadk.core.util.y.isEmpty(linkedList)) {
            this.iSi.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> cBK() {
        return this.iSi;
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

    public void IW(String str) {
        this.hMH = str;
    }

    public String cEq() {
        return this.hMH;
    }
}
