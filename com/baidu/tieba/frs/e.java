package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String drE;
    private String drF;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> gXH;
    private final List<com.baidu.tbadk.mainTab.b> gXI = new LinkedList();
    private Context mContext;
    private String mFrom;

    public e(Context context, List<FrsTabInfo> list) {
        this.gXH = list;
        this.mContext = context;
    }

    public List<FrsTabInfo> bOa() {
        return this.gXH;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.gXI) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.gXI.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> bOb() {
        return this.gXI;
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

    public void ub(String str) {
        this.drE = str;
    }

    public void uc(String str) {
        this.drF = str;
    }
}
