package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String bBw;
    private String bBx;
    private List<FrsTabInfo> eYi;
    private final List<com.baidu.tbadk.mainTab.b> eYj = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public e(Context context, List<FrsTabInfo> list) {
        this.eYi = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.anK() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.eYj) {
                if (bVar2 != null && bVar2.anK() != null && bVar2.anK().type == bVar.anK().type) {
                    return;
                }
            }
            this.eYj.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> bcc() {
        return this.eYj;
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
        this.bBw = str;
    }

    public void ls(String str) {
        this.bBx = str;
    }
}
