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
    private List<FrsTabInfo> glw;
    private final List<com.baidu.tbadk.mainTab.b> glx = new LinkedList();
    private String gqe;
    private Context mContext;

    public ac(Context context, List<FrsTabInfo> list) {
        this.glw = list;
        this.mContext = context;
    }

    public boolean sW(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.isEmpty(this.glw)) {
            for (FrsTabInfo frsTabInfo : this.glw) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bEf() {
        return this.glw;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.aNy() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.glx) {
                if (bVar2 != null && bVar2.aNy() != null && bVar2.aNy().type == bVar.aNy().type) {
                    return;
                }
            }
            this.glx.add(bVar);
        }
    }

    public void bEg() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.glw) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.glx.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.aNy() != null && frsTabInfo.tab_id.intValue() == next.aNy().type) {
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
            this.glw.removeAll(linkedList2);
        }
        this.glx.clear();
        if (!com.baidu.tbadk.core.util.v.isEmpty(linkedList)) {
            this.glx.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bBQ() {
        return this.glx;
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

    public void AQ(String str) {
        this.gqe = str;
    }
}
