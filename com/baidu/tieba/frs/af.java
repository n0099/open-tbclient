package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class af {
    private final List<com.baidu.tbadk.mainTab.b> ctj = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public af(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Eu() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.ctj) {
                if (bVar2 != null && bVar2.Eu() != null && bVar2.Eu().type == bVar.Eu().type) {
                    return;
                }
            }
            this.ctj.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> aib() {
        return this.ctj;
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
