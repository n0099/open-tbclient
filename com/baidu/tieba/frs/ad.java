package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ad {
    private List<FrsTabInfo> ckL;
    private final List<com.baidu.tbadk.mainTab.b> ckM = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ad(Context context, List<FrsTabInfo> list) {
        this.ckL = list;
        this.mContext = context;
    }

    public boolean iN(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.u.v(this.ckL)) {
            for (FrsTabInfo frsTabInfo : this.ckL) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> agb() {
        return this.ckL;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EP() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.ckM) {
                if (bVar2 != null && bVar2.EP() != null && bVar2.EP().type == bVar.EP().type) {
                    return;
                }
            }
            this.ckM.add(bVar);
        }
    }

    public void agc() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.ckL) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.ckM.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.EP() != null && frsTabInfo.tab_id.intValue() == next.EP().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.u.v(linkedList2)) {
            this.ckL.removeAll(linkedList2);
        }
        this.ckM.clear();
        if (!com.baidu.tbadk.core.util.u.v(linkedList)) {
            this.ckM.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> agd() {
        return this.ckM;
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
}
