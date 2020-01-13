package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ad {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private final List<com.baidu.tbadk.mainTab.b> glx = new LinkedList();
    private Context mContext;

    public ad(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.aNy() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.glx) {
                if (bVar2 != null && bVar2.aNy() != null && bVar2.aNy().type == bVar.aNy().type) {
                    return;
                }
            }
            this.glx.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> bBQ() {
        return this.glx;
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
