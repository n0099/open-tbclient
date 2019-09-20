package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String bKu;
    private String bKv;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> fvr;
    private final List<com.baidu.tbadk.mainTab.b> fvs = new LinkedList();
    private Context mContext;

    public e(Context context, List<FrsTabInfo> list) {
        this.fvr = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.aug() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.fvs) {
                if (bVar2 != null && bVar2.aug() != null && bVar2.aug().type == bVar.aug().type) {
                    return;
                }
            }
            this.fvs.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> bmq() {
        return this.fvs;
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

    public void mJ(String str) {
        this.bKu = str;
    }

    public void mK(String str) {
        this.bKv = str;
    }
}
