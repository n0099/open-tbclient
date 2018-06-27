package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ad {
    private List<FrsTabInfo> diU;
    private final List<com.baidu.tbadk.mainTab.b> diV = new LinkedList();
    private String dmL;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ad(Context context, List<FrsTabInfo> list) {
        this.diU = list;
        this.mContext = context;
    }

    public boolean ky(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.w.A(this.diU)) {
            for (FrsTabInfo frsTabInfo : this.diU) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> avg() {
        return this.diU;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Jt() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.diV) {
                if (bVar2 != null && bVar2.Jt() != null && bVar2.Jt().type == bVar.Jt().type) {
                    return;
                }
            }
            this.diV.add(bVar);
        }
    }

    public void avh() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.diU) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.diV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.Jt() != null && frsTabInfo.tab_id.intValue() == next.Jt().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.w.A(linkedList2)) {
            this.diU.removeAll(linkedList2);
        }
        this.diV.clear();
        if (!com.baidu.tbadk.core.util.w.A(linkedList)) {
            this.diV.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> att() {
        return this.diV;
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

    public void mw(String str) {
        this.dmL = str;
    }
}
