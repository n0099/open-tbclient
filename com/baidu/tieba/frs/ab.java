package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ab {
    private List<FrsTabInfo> cXK;
    private final List<com.baidu.tbadk.mainTab.b> cXL = new LinkedList();
    private String dbo;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ab(Context context, List<FrsTabInfo> list) {
        this.cXK = list;
        this.mContext = context;
    }

    public boolean kn(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.w(this.cXK)) {
            for (FrsTabInfo frsTabInfo : this.cXK) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> aqH() {
        return this.cXK;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Fw() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.cXL) {
                if (bVar2 != null && bVar2.Fw() != null && bVar2.Fw().type == bVar.Fw().type) {
                    return;
                }
            }
            this.cXL.add(bVar);
        }
    }

    public void aqI() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.cXK) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.cXL.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.Fw() != null && frsTabInfo.tab_id.intValue() == next.Fw().type) {
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
            this.cXK.removeAll(linkedList2);
        }
        this.cXL.clear();
        if (!com.baidu.tbadk.core.util.v.w(linkedList)) {
            this.cXL.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> aoW() {
        return this.cXL;
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

    public void lP(String str) {
        this.dbo = str;
    }
}
