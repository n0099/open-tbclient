package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String aqa;
    private String aqb;
    private List<FrsTabInfo> dAT;
    private final List<com.baidu.tbadk.mainTab.b> dAU = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public e(Context context, List<FrsTabInfo> list) {
        this.dAT = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.ML() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dAU) {
                if (bVar2 != null && bVar2.ML() != null && bVar2.ML().type == bVar.ML().type) {
                    return;
                }
            }
            this.dAU.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> ayH() {
        return this.dAU;
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
        this.aqa = str;
    }

    public void ed(String str) {
        this.aqb = str;
    }
}
