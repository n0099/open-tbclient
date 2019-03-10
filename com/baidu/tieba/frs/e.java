package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String bBu;
    private String bBv;
    private List<FrsTabInfo> eYj;
    private final List<com.baidu.tbadk.mainTab.b> eYk = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public e(Context context, List<FrsTabInfo> list) {
        this.eYj = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.anL() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.eYk) {
                if (bVar2 != null && bVar2.anL() != null && bVar2.anL().type == bVar.anL().type) {
                    return;
                }
            }
            this.eYk.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> bcd() {
        return this.eYk;
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

    public void lr(String str) {
        this.bBu = str;
    }

    public void ls(String str) {
        this.bBv = str;
    }
}
