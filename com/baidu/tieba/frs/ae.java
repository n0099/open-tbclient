package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ae {
    private final List<com.baidu.tbadk.mainTab.b> diV = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public ae(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.Jt() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.diV) {
                if (bVar2 != null && bVar2.Jt() != null && bVar2.Jt().type == bVar.Jt().type) {
                    return;
                }
            }
            this.diV.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> att() {
        return this.diV;
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
