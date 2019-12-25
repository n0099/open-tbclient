package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String cNP;
    private String cNQ;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> gin;
    private final List<com.baidu.tbadk.mainTab.b> gio = new LinkedList();
    private Context mContext;
    private String mFrom;

    public e(Context context, List<FrsTabInfo> list) {
        this.gin = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.aNf() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.gio) {
                if (bVar2 != null && bVar2.aNf() != null && bVar2.aNf().type == bVar.aNf().type) {
                    return;
                }
            }
            this.gio.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> bAO() {
        return this.gio;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    public void ss(String str) {
        this.cNP = str;
    }

    public void st(String str) {
        this.cNQ = str;
    }
}
