package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class af {
    private final List<com.baidu.tbadk.mainTab.b> cKd = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public af(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.EZ() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.cKd) {
                if (bVar2 != null && bVar2.EZ() != null && bVar2.EZ().type == bVar.EZ().type) {
                    return;
                }
            }
            this.cKd.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> amt() {
        return this.cKd;
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
