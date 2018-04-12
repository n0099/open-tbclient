package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class c {
    private String ZW;
    private String ZX;
    private List<FrsTabInfo> cWG;
    private final List<com.baidu.tbadk.mainTab.b> cWH = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public c(Context context, List<FrsTabInfo> list) {
        this.cWG = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Fy() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.cWH) {
                if (bVar2 != null && bVar2.Fy() != null && bVar2.Fy().type == bVar.Fy().type) {
                    return;
                }
            }
            this.cWH.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> aoX() {
        return this.cWH;
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
