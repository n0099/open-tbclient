package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ac {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private final List<com.baidu.tbadk.mainTab.b> fuF = new LinkedList();
    private Context mContext;

    public ac(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.avz() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.fuF) {
                if (bVar2 != null && bVar2.avz() != null && bVar2.avz().type == bVar.avz().type) {
                    return;
                }
            }
            this.fuF.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> bjw() {
        return this.fuF;
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
