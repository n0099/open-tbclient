package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ag {
    private final List<com.baidu.tbadk.mainTab.b> dDL = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ag(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.MV() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dDL) {
                if (bVar2 != null && bVar2.MV() != null && bVar2.MV().type == bVar.MV().type) {
                    return;
                }
            }
            this.dDL.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> auE() {
        return this.dDL;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String getForumName() {
        return this.forumName;
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

    public String getForumGameLabel() {
        return this.forumGameLabel;
    }
}
