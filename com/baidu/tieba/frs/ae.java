package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ae {
    private final List<com.baidu.tbadk.mainTab.b> dKh = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ae(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.NQ() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.dKh) {
                if (bVar2 != null && bVar2.NQ() != null && bVar2.NQ().type == bVar.NQ().type) {
                    return;
                }
            }
            this.dKh.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> aBg() {
        return this.dKh;
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
