package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class c {
    private List<FrsTabInfo> dAF;
    private final List<com.baidu.tbadk.mainTab.b> dAG = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public c(Context context, List<FrsTabInfo> list) {
        this.dAF = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Mn() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dAG) {
                if (bVar2 != null && bVar2.Mn() != null && bVar2.Mn().type == bVar.Mn().type) {
                    return;
                }
            }
            this.dAG.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> atJ() {
        return this.dAG;
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
