package com.baidu.tieba.frs;

import android.content.Context;
import com.baidu.tbadk.core.util.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class af {
    private List<FrsTabInfo> dwe;
    private final List<com.baidu.tbadk.mainTab.b> dwf = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public af(Context context, List<FrsTabInfo> list) {
        this.dwe = list;
        this.mContext = context;
    }

    public boolean na(int i) {
        if (i < 100 && !v.G(this.dwe)) {
            for (FrsTabInfo frsTabInfo : this.dwe) {
                if (frsTabInfo.tab_id.intValue() == i) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<FrsTabInfo> aui() {
        return this.dwe;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Mz() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dwf) {
                if (bVar2 != null && bVar2.Mz() != null && bVar2.Mz().type == bVar.Mz().type) {
                    return;
                }
            }
            this.dwf.add(bVar);
        }
    }

    public void auj() {
        boolean z;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (FrsTabInfo frsTabInfo : this.dwe) {
            Iterator<com.baidu.tbadk.mainTab.b> it = this.dwf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                com.baidu.tbadk.mainTab.b next = it.next();
                if (next.Mz() != null && frsTabInfo.tab_id.intValue() == next.Mz().type) {
                    linkedList.add(next);
                    z = true;
                    break;
                }
            }
            if (!z) {
                linkedList2.add(frsTabInfo);
            }
        }
        if (!v.G(linkedList2)) {
            this.dwe.removeAll(linkedList2);
        }
        this.dwf.clear();
        if (!v.G(linkedList)) {
            this.dwf.addAll(linkedList);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public List<com.baidu.tbadk.mainTab.b> asG() {
        return this.dwf;
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
