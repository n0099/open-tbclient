package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class c {
    private String aib;
    private String aic;
    private List<FrsTabInfo> dgX;
    private final List<com.baidu.tbadk.mainTab.b> dgY = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public c(Context context, List<FrsTabInfo> list) {
        this.dgX = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Jb() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dgY) {
                if (bVar2 != null && bVar2.Jb() != null && bVar2.Jb().type == bVar.Jb().type) {
                    return;
                }
            }
            this.dgY.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> atc() {
        return this.dgY;
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

    public void du(String str) {
        this.aib = str;
    }

    public void dv(String str) {
        this.aic = str;
    }
}
