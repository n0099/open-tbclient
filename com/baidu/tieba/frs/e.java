package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String atA;
    private String atB;
    private List<FrsTabInfo> dHs;
    private final List<com.baidu.tbadk.mainTab.b> dHt = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public e(Context context, List<FrsTabInfo> list) {
        this.dHs = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.NP() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dHt) {
                if (bVar2 != null && bVar2.NP() != null && bVar2.NP().type == bVar.NP().type) {
                    return;
                }
            }
            this.dHt.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> aAr() {
        return this.dHt;
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

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    public void eu(String str) {
        this.atA = str;
    }

    public void ev(String str) {
        this.atB = str;
    }
}
