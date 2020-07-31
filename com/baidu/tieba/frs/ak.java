package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ak {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private String gGo;
    private List<FrsTabInfo> hEK;
    private final List<com.baidu.tbadk.mainTab.b> hEL = new LinkedList();
    private Context mContext;

    public ak(Context context, List<FrsTabInfo> list) {
        this.hEK = list;
        this.mContext = context;
    }

    public boolean vg(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.x.isEmpty(this.hEK)) {
            for (FrsTabInfo frsTabInfo : this.hEK) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> cba() {
        return this.hEK;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.hEL) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.hEL.add(bVar);
        }
    }

    public void cdC() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.hEK) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.hEL.iterator();
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
        if (!com.baidu.tbadk.core.util.x.isEmpty(linkedList2)) {
            this.hEK.removeAll(linkedList2);
        }
        this.hEL.clear();
        if (!com.baidu.tbadk.core.util.x.isEmpty(linkedList)) {
            this.hEL.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> cbb() {
        return this.hEL;
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

    public void Ej(String str) {
        this.gGo = str;
    }

    public String cdD() {
        return this.gGo;
    }
}
