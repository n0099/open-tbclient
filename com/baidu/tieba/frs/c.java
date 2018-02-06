package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class c {
    private List<FrsTabInfo> dDT;
    private final List<com.baidu.tbadk.mainTab.b> dDU = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public c(Context context, List<FrsTabInfo> list) {
        this.dDT = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.MV() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dDU) {
                if (bVar2 != null && bVar2.MV() != null && bVar2.MV().type == bVar.MV().type) {
                    return;
                }
            }
            this.dDU.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> auE() {
        return this.dDU;
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
