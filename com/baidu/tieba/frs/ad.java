package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ad {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private final List<com.baidu.tbadk.mainTab.b> gio = new LinkedList();
    private Context mContext;

    public ad(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.aNf() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.gio) {
                if (bVar2 != null && bVar2.aNf() != null && bVar2.aNf().type == bVar.aNf().type) {
                    return;
                }
            }
            this.gio.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> bAO() {
        return this.gio;
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
