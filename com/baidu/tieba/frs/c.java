package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class c {
    private List<FrsTabInfo> dBa;
    private final List<com.baidu.tbadk.mainTab.b> dBb = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public c(Context context, List<FrsTabInfo> list) {
        this.dBa = list;
        this.mContext = context;
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

    public List<com.baidu.tbadk.mainTab.b> atO() {
        return this.dBb;
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
