package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ac {
    private final List<com.baidu.tbadk.mainTab.b> dgY = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ac(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Jb() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dgY) {
                if (bVar2 != null && bVar2.Jb() != null && bVar2.Jb().type == bVar.Jb().type) {
                    return;
                }
            }
            this.dgY.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> atc() {
        return this.dgY;
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
