package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ad {
    private List<FrsTabInfo> dlK;
    private final List<com.baidu.tbadk.mainTab.b> dlL = new LinkedList();
    private String dpD;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ad(Context context, List<FrsTabInfo> list) {
        this.dlK = list;
        this.mContext = context;
    }

    public boolean kJ(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.w.z(this.dlK)) {
            for (FrsTabInfo frsTabInfo : this.dlK) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> avL() {
        return this.dlK;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Jo() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dlL) {
                if (bVar2 != null && bVar2.Jo() != null && bVar2.Jo().type == bVar.Jo().type) {
                    return;
                }
            }
            this.dlL.add(bVar);
        }
    }

    public void avM() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.dlK) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.dlL.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.Jo() != null && frsTabInfo.tab_id.intValue() == next.Jo().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.w.z(linkedList2)) {
            this.dlK.removeAll(linkedList2);
        }
        this.dlL.clear();
        if (!com.baidu.tbadk.core.util.w.z(linkedList)) {
            this.dlL.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> atX() {
        return this.dlL;
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

    public void mv(String str) {
        this.dpD = str;
    }
}
