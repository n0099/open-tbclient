package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class c {
    private List<FrsTabInfo> dDH;
    private final List<com.baidu.tbadk.mainTab.b> dDI = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public c(Context context, List<FrsTabInfo> list) {
        this.dDH = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.MU() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dDI) {
                if (bVar2 != null && bVar2.MU() != null && bVar2.MU().type == bVar.MU().type) {
                    return;
                }
            }
            this.dDI.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> auD() {
        return this.dDI;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }
}
