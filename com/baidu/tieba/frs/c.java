package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class c {
    private List<FrsTabInfo> dwe;
    private final List<com.baidu.tbadk.mainTab.b> dwf = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public c(Context context, List<FrsTabInfo> list) {
        this.dwe = list;
        this.mContext = context;
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

    public List<com.baidu.tbadk.mainTab.b> asG() {
        return this.dwf;
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
