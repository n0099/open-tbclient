package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ae {
    private final List<com.baidu.tbadk.mainTab.b> clU = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ae(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EX() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.clU) {
                if (bVar2 != null && bVar2.EX() != null && bVar2.EX().type == bVar.EX().type) {
                    return;
                }
            }
            this.clU.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> agk() {
        return this.clU;
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
