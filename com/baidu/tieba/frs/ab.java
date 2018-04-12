package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ab {
    private List<FrsTabInfo> cWG;
    private final List<com.baidu.tbadk.mainTab.b> cWH = new LinkedList();
    private String dai;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ab(Context context, List<FrsTabInfo> list) {
        this.cWG = list;
        this.mContext = context;
    }

    public boolean kp(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.w(this.cWG)) {
            for (FrsTabInfo frsTabInfo : this.cWG) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> aqI() {
        return this.cWG;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Fy() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.cWH) {
                if (bVar2 != null && bVar2.Fy() != null && bVar2.Fy().type == bVar.Fy().type) {
                    return;
                }
            }
            this.cWH.add(bVar);
        }
    }

    public void aqJ() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.cWG) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.cWH.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.Fy() != null && frsTabInfo.tab_id.intValue() == next.Fy().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.w(linkedList2)) {
            this.cWG.removeAll(linkedList2);
        }
        this.cWH.clear();
        if (!com.baidu.tbadk.core.util.v.w(linkedList)) {
            this.cWH.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> aoX() {
        return this.cWH;
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

    public void lM(String str) {
        this.dai = str;
    }
}
