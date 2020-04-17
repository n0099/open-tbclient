package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String drA;
    private String drB;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> gXB;
    private final List<com.baidu.tbadk.mainTab.b> gXC = new LinkedList();
    private Context mContext;
    private String mFrom;

    public e(Context context, List<FrsTabInfo> list) {
        this.gXB = list;
        this.mContext = context;
    }

    public List<FrsTabInfo> bOb() {
        return this.gXB;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.gXC) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.gXC.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> bOc() {
        return this.gXC;
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

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    public void tY(String str) {
        this.drA = str;
    }

    public void tZ(String str) {
        this.drB = str;
    }
}
