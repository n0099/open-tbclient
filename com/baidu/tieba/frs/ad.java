package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ad {
    private List<FrsTabInfo> dlI;
    private final List<com.baidu.tbadk.mainTab.b> dlJ = new LinkedList();
    private String dpB;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ad(Context context, List<FrsTabInfo> list) {
        this.dlI = list;
        this.mContext = context;
    }

    public boolean kI(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.w.z(this.dlI)) {
            for (FrsTabInfo frsTabInfo : this.dlI) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> avK() {
        return this.dlI;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Jo() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dlJ) {
                if (bVar2 != null && bVar2.Jo() != null && bVar2.Jo().type == bVar.Jo().type) {
                    return;
                }
            }
            this.dlJ.add(bVar);
        }
    }

    public void avL() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.dlI) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.dlJ.iterator();
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
            this.dlI.removeAll(linkedList2);
        }
        this.dlJ.clear();
        if (!com.baidu.tbadk.core.util.w.z(linkedList)) {
            this.dlJ.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> atW() {
        return this.dlJ;
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

    public void mx(String str) {
        this.dpB = str;
    }
}
