package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class af {
    private final List<com.baidu.tbadk.mainTab.b> cAZ = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public af(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.ES() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.cAZ) {
                if (bVar2 != null && bVar2.ES() != null && bVar2.ES().type == bVar.ES().type) {
                    return;
                }
            }
            this.cAZ.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> akx() {
        return this.cAZ;
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
