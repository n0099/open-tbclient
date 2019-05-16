package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ab {
    private List<FrsTabInfo> fof;
    private final List<com.baidu.tbadk.mainTab.b> fog = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private String fsR;
    private Context mContext;

    public ab(Context context, List<FrsTabInfo> list) {
        this.fof = list;
        this.mContext = context;
    }

    public boolean rw(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.aa(this.fof)) {
            for (FrsTabInfo frsTabInfo : this.fof) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> blG() {
        return this.fof;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.asK() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.fog) {
                if (bVar2 != null && bVar2.asK() != null && bVar2.asK().type == bVar.asK().type) {
                    return;
                }
            }
            this.fog.add(bVar);
        }
    }

    public void blH() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.fof) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.fog.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.asK() != null && frsTabInfo.tab_id.intValue() == next.asK().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.aa(linkedList2)) {
            this.fof.removeAll(linkedList2);
        }
        this.fog.clear();
        if (!com.baidu.tbadk.core.util.v.aa(linkedList)) {
            this.fog.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bjt() {
        return this.fog;
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

    public void wt(String str) {
        this.fsR = str;
    }
}
