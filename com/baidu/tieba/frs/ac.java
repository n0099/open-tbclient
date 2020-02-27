package com.baidu.tieba.frs;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class ac {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> gnx;
    private final List<com.baidu.tbadk.mainTab.b> gny = new LinkedList();
    private String gsf;
    private Context mContext;

    public ac(Context context, List<FrsTabInfo> list) {
        this.gnx = list;
        this.mContext = context;
    }

    public boolean tc(int i) {
        if (i < 100 && !com.baidu.tbadk.core.util.v.isEmpty(this.gnx)) {
            for (FrsTabInfo frsTabInfo : this.gnx) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> bDs() {
        return this.gnx;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.gny) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.gny.add(bVar);
        }
    }

    public void bFI() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.gnx) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.gny.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.getFragmentTabStructure() != null && frsTabInfo.tab_id.intValue() == next.getFragmentTabStructure().type) {
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
            this.gnx.removeAll(linkedList2);
        }
        this.gny.clear();
        if (!com.baidu.tbadk.core.util.v.isEmpty(linkedList)) {
            this.gny.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> bDt() {
        return this.gny;
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

    public void Bg(String str) {
        this.gsf = str;
    }
}
