package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ag {
    private final List<com.baidu.tbadk.mainTab.b> cKn = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ag(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Fa() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.cKn) {
                if (bVar2 != null && bVar2.Fa() != null && bVar2.Fa().type == bVar.Fa().type) {
                    return;
                }
            }
            this.cKn.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> amB() {
        return this.cKn;
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
