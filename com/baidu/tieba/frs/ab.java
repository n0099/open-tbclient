package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ab {
    private List<FrsTabInfo> eXU;
    private final List<com.baidu.tbadk.mainTab.b> eXV = new LinkedList();
    private String fcD;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ab(Context context, List<FrsTabInfo> list) {
        this.eXU = list;
        this.mContext = context;
    }

    public boolean qp(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.T(this.eXU)) {
            for (FrsTabInfo frsTabInfo : this.eXU) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> beo() {
        return this.eXU;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.anH() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.eXV) {
                if (bVar2 != null && bVar2.anH() != null && bVar2.anH().type == bVar.anH().type) {
                    return;
                }
            }
            this.eXV.add(bVar);
        }
    }

    public void bep() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.eXU) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.eXV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.anH() != null && frsTabInfo.tab_id.intValue() == next.anH().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.T(linkedList2)) {
            this.eXU.removeAll(linkedList2);
        }
        this.eXV.clear();
        if (!com.baidu.tbadk.core.util.v.T(linkedList)) {
            this.eXV.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bca() {
        return this.eXV;
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

    public void uZ(String str) {
        this.fcD = str;
    }
}
