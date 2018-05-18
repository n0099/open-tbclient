package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class c {
    private String ZW;
    private String ZX;
    private List<FrsTabInfo> cXK;
    private final List<com.baidu.tbadk.mainTab.b> cXL = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public c(Context context, List<FrsTabInfo> list) {
        this.cXK = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Fw() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.cXL) {
                if (bVar2 != null && bVar2.Fw() != null && bVar2.Fw().type == bVar.Fw().type) {
                    return;
                }
            }
            this.cXL.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> aoW() {
        return this.cXL;
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

    public void cV(String str) {
        this.ZW = str;
    }

    public void cW(String str) {
        this.ZX = str;
    }
}
