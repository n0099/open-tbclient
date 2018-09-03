package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String ahR;
    private String ahS;
    private List<FrsTabInfo> dlI;
    private final List<com.baidu.tbadk.mainTab.b> dlJ = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public e(Context context, List<FrsTabInfo> list) {
        this.dlI = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Jo() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dlJ) {
                if (bVar2 != null && bVar2.Jo() != null && bVar2.Jo().type == bVar.Jo().type) {
                    return;
                }
            }
            this.dlJ.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> atW() {
        return this.dlJ;
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

    public void du(String str) {
        this.ahR = str;
    }

    public void dv(String str) {
        this.ahS = str;
    }
}
