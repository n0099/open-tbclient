package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String akr;
    private String aks;
    private List<FrsTabInfo> drB;
    private final List<com.baidu.tbadk.mainTab.b> drC = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public e(Context context, List<FrsTabInfo> list) {
        this.drB = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.KE() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.drC) {
                if (bVar2 != null && bVar2.KE() != null && bVar2.KE().type == bVar.KE().type) {
                    return;
                }
            }
            this.drC.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> avN() {
        return this.drC;
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

    public void dM(String str) {
        this.akr = str;
    }

    public void dN(String str) {
        this.aks = str;
    }
}
