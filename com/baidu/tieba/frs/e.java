package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String cbl;
    private String cbm;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> ftN;
    private final List<com.baidu.tbadk.mainTab.b> ftO = new LinkedList();
    private Context mContext;

    public e(Context context, List<FrsTabInfo> list) {
        this.ftN = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.avx() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.ftO) {
                if (bVar2 != null && bVar2.avx() != null && bVar2.avx().type == bVar.avx().type) {
                    return;
                }
            }
            this.ftO.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> bju() {
        return this.ftO;
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

    public void nh(String str) {
        this.cbl = str;
    }

    public void ni(String str) {
        this.cbm = str;
    }
}
