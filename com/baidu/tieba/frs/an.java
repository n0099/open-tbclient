package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class an {
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private final List<com.baidu.tbadk.mainTab.b> hSa = new LinkedList();
    private Context mContext;

    public an(Context context) {
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.hSa) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.hSa.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> clx() {
        return this.hSa;
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
