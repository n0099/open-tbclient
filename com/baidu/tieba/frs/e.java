package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String atA;
    private String atB;
    private List<FrsTabInfo> dKg;
    private final List<com.baidu.tbadk.mainTab.b> dKh = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public e(Context context, List<FrsTabInfo> list) {
        this.dKg = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.NQ() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dKh) {
                if (bVar2 != null && bVar2.NQ() != null && bVar2.NQ().type == bVar.NQ().type) {
                    return;
                }
            }
            this.dKh.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> aBg() {
        return this.dKh;
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

    public void eu(String str) {
        this.atA = str;
    }

    public void ev(String str) {
        this.atB = str;
    }
}
