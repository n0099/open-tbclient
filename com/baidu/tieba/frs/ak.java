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
    private String gAR;
    private List<FrsTabInfo> hyV;
    private final List<com.baidu.tbadk.mainTab.b> hyW = new LinkedList();
    private Context mContext;

    public ak(Context context, List<FrsTabInfo> list) {
        this.hyV = list;
        this.mContext = context;
    }

    public boolean uO(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.w.isEmpty(this.hyV)) {
            for (FrsTabInfo frsTabInfo : this.hyV) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bXD() {
        return this.hyV;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.hyW) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.hyW.add(bVar);
        }
    }

    public void cae() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.hyV) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.hyW.iterator();
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
        if (!com.baidu.tbadk.core.util.w.isEmpty(linkedList2)) {
            this.hyV.removeAll(linkedList2);
        }
        this.hyW.clear();
        if (!com.baidu.tbadk.core.util.w.isEmpty(linkedList)) {
            this.hyW.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bXE() {
        return this.hyW;
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

    public void Dy(String str) {
        this.gAR = str;
    }

    public String caf() {
        return this.gAR;
    }
}
