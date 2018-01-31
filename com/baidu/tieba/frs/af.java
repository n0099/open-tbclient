package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.tbadk.core.util.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class af {
    private List<FrsTabInfo> dBa;
    private final List<com.baidu.tbadk.mainTab.b> dBb = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public af(Context context, List<FrsTabInfo> list) {
        this.dBa = list;
        this.mContext = context;
    }

    public boolean nd(int i) {
        if (i < 100 && !v.E(this.dBa)) {
            for (FrsTabInfo frsTabInfo : this.dBa) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> avq() {
        return this.dBa;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Mp() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dBb) {
                if (bVar2 != null && bVar2.Mp() != null && bVar2.Mp().type == bVar.Mp().type) {
                    return;
                }
            }
            this.dBb.add(bVar);
        }
    }

    public void avr() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.dBa) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.dBb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.Mp() != null && frsTabInfo.tab_id.intValue() == next.Mp().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!v.E(linkedList2)) {
            this.dBa.removeAll(linkedList2);
        }
        this.dBb.clear();
        if (!v.E(linkedList)) {
            this.dBb.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> atO() {
        return this.dBb;
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
