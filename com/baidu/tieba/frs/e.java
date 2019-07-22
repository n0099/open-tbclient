package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String bJR;
    private String bJS;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> ftf;
    private final List<com.baidu.tbadk.mainTab.b> ftg = new LinkedList();
    private Context mContext;

    public e(Context context, List<FrsTabInfo> list) {
        this.ftf = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.atS() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.ftg) {
                if (bVar2 != null && bVar2.atS() != null && bVar2.atS().type == bVar.atS().type) {
                    return;
                }
            }
            this.ftg.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> bly() {
        return this.ftg;
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

    public void mH(String str) {
        this.bJR = str;
    }

    public void mI(String str) {
        this.bJS = str;
    }
}
