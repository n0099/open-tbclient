package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ae {
    private List<FrsTabInfo> ctu;
    private final List<com.baidu.tbadk.mainTab.b> ctv = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ae(Context context, List<FrsTabInfo> list) {
        this.ctu = list;
        this.mContext = context;
    }

    public boolean jl(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.u(this.ctu)) {
            for (FrsTabInfo frsTabInfo : this.ctu) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> aie() {
        return this.ctu;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EA() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.ctv) {
                if (bVar2 != null && bVar2.EA() != null && bVar2.EA().type == bVar.EA().type) {
                    return;
                }
            }
            this.ctv.add(bVar);
        }
    }

    public void aif() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.ctu) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.ctv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.EA() != null && frsTabInfo.tab_id.intValue() == next.EA().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!com.baidu.tbadk.core.util.v.u(linkedList2)) {
            this.ctu.removeAll(linkedList2);
        }
        this.ctv.clear();
        if (!com.baidu.tbadk.core.util.v.u(linkedList)) {
            this.ctv.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> aig() {
        return this.ctv;
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
