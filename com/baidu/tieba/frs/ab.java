package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ab {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> ftN;
    private final List<com.baidu.tbadk.mainTab.b> ftO = new LinkedList();
    private String fyy;
    private Context mContext;

    public ab(Context context, List<FrsTabInfo> list) {
        this.ftN = list;
        this.mContext = context;
    }

    public boolean qL(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.isEmpty(this.ftN)) {
            for (FrsTabInfo frsTabInfo : this.ftN) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> blH() {
        return this.ftN;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.avx() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.ftO) {
                if (bVar2 != null && bVar2.avx() != null && bVar2.avx().type == bVar.avx().type) {
                    return;
                }
            }
            this.ftO.add(bVar);
        }
    }

    public void blI() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.ftN) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.ftO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.avx() != null && frsTabInfo.tab_id.intValue() == next.avx().type) {
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
            this.ftN.removeAll(linkedList2);
        }
        this.ftO.clear();
        if (!com.baidu.tbadk.core.util.v.isEmpty(linkedList)) {
            this.ftO.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bju() {
        return this.ftO;
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

    public void vP(String str) {
        this.fyy = str;
    }
}
