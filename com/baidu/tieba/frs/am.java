package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class am {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private String gWC;
    private List<FrsTabInfo> hZf;
    private final List<com.baidu.tbadk.mainTab.b> hZg = new LinkedList();
    private Context mContext;

    public am(Context context, List<FrsTabInfo> list) {
        this.hZf = list;
        this.mContext = context;
    }

    public boolean xW(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.y.isEmpty(this.hZf)) {
            for (FrsTabInfo frsTabInfo : this.hZf) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bsg() {
        return this.hZf;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.hZg) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.hZg.add(bVar);
        }
    }

    public void crp() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.hZf) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.hZg.iterator();
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
            this.hZf.removeAll(linkedList2);
        }
        this.hZg.clear();
        if (!com.baidu.tbadk.core.util.y.isEmpty(linkedList)) {
            this.hZg.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> coK() {
        return this.hZg;
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

    public void Hc(String str) {
        this.gWC = str;
    }

    public String crq() {
        return this.gWC;
    }
}
