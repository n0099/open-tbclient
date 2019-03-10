package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ac {
    private final List<com.baidu.tbadk.mainTab.b> eYk = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ac(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.anL() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.eYk) {
                if (bVar2 != null && bVar2.anL() != null && bVar2.anL().type == bVar.anL().type) {
                    return;
                }
            }
            this.eYk.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> bcd() {
        return this.eYk;
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
