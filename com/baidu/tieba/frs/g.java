package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class g {
    private String eJU;
    private String eJV;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> iSh;
    private final List<com.baidu.tbadk.mainTab.b> iSi = new LinkedList();
    private Context mContext;
    private String mFrom;

    public g(Context context, List<FrsTabInfo> list) {
        this.iSh = list;
        this.mContext = context;
    }

    public List<FrsTabInfo> bBY() {
        return this.iSh;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.iSi) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.iSi.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> cBK() {
        return this.iSi;
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

    public void Bj(String str) {
        this.eJU = str;
    }

    public void Bk(String str) {
        this.eJV = str;
    }
}
