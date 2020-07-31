package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class g {
    private String dSv;
    private String dSw;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> hEK;
    private final List<com.baidu.tbadk.mainTab.b> hEL = new LinkedList();
    private Context mContext;
    private String mFrom;

    public g(Context context, List<FrsTabInfo> list) {
        this.hEK = list;
        this.mContext = context;
    }

    public List<FrsTabInfo> cba() {
        return this.hEK;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.hEL) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.hEL.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> cbb() {
        return this.hEL;
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

    public void xe(String str) {
        this.dSv = str;
    }

    public void xf(String str) {
        this.dSw = str;
    }
}
