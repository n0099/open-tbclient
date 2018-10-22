package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String apm;
    private String apn;
    private List<FrsTabInfo> dzC;
    private final List<com.baidu.tbadk.mainTab.b> dzD = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public e(Context context, List<FrsTabInfo> list) {
        this.dzC = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.MC() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dzD) {
                if (bVar2 != null && bVar2.MC() != null && bVar2.MC().type == bVar.MC().type) {
                    return;
                }
            }
            this.dzD.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> azk() {
        return this.dzD;
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

    public void ec(String str) {
        this.apm = str;
    }

    public void ed(String str) {
        this.apn = str;
    }
}
