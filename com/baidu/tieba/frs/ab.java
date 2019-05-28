package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ab {
    private List<FrsTabInfo> fog;
    private final List<com.baidu.tbadk.mainTab.b> foh = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private String fsS;
    private Context mContext;

    public ab(Context context, List<FrsTabInfo> list) {
        this.fog = list;
        this.mContext = context;
    }

    public boolean rw(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.aa(this.fog)) {
            for (FrsTabInfo frsTabInfo : this.fog) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> blJ() {
        return this.fog;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.asK() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.foh) {
                if (bVar2 != null && bVar2.asK() != null && bVar2.asK().type == bVar.asK().type) {
                    return;
                }
            }
            this.foh.add(bVar);
        }
    }

    public void blK() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.fog) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.foh.iterator();
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
            this.fog.removeAll(linkedList2);
        }
        this.foh.clear();
        if (!com.baidu.tbadk.core.util.v.aa(linkedList)) {
            this.foh.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bjw() {
        return this.foh;
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
        this.fsS = str;
    }
}
