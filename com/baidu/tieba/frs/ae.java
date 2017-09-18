package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ae {
    private final List<com.baidu.tbadk.mainTab.b> csT = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ae(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EV() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.csT) {
                if (bVar2 != null && bVar2.EV() != null && bVar2.EV().type == bVar.EV().type) {
                    return;
                }
            }
            this.csT.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> aii() {
        return this.csT;
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
