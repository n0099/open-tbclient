package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class am {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private String gSQ;
    private List<FrsTabInfo> hRZ;
    private final List<com.baidu.tbadk.mainTab.b> hSa = new LinkedList();
    private Context mContext;

    public am(Context context, List<FrsTabInfo> list) {
        this.hRZ = list;
        this.mContext = context;
    }

    public boolean xx(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.y.isEmpty(this.hRZ)) {
            for (FrsTabInfo frsTabInfo : this.hRZ) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> clw() {
        return this.hRZ;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.hSa) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.hSa.add(bVar);
        }
    }

    public void cob() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.hRZ) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.hSa.iterator();
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
            this.hRZ.removeAll(linkedList2);
        }
        this.hSa.clear();
        if (!com.baidu.tbadk.core.util.y.isEmpty(linkedList)) {
            this.hSa.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> clx() {
        return this.hSa;
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

    public void GI(String str) {
        this.gSQ = str;
    }

    public String coc() {
        return this.gSQ;
    }
}
