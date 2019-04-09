package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String bBA;
    private String bBB;
    private List<FrsTabInfo> eXV;
    private final List<com.baidu.tbadk.mainTab.b> eXW = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public e(Context context, List<FrsTabInfo> list) {
        this.eXV = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.anH() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.eXW) {
                if (bVar2 != null && bVar2.anH() != null && bVar2.anH().type == bVar.anH().type) {
                    return;
                }
            }
            this.eXW.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> bca() {
        return this.eXW;
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

    public void ls(String str) {
        this.bBA = str;
    }

    public void lt(String str) {
        this.bBB = str;
    }
}
