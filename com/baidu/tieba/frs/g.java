package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class g {
    private String ePd;
    private String ePe;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> iZM;
    private final List<com.baidu.tbadk.mainTab.b> iZN = new LinkedList();
    private Context mContext;
    private String mFrom;

    public g(Context context, List<FrsTabInfo> list) {
        this.iZM = list;
        this.mContext = context;
    }

    public List<FrsTabInfo> bAA() {
        return this.iZM;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.getFragmentTabStructure() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.iZN) {
                if (bVar2 != null && bVar2.getFragmentTabStructure() != null && bVar2.getFragmentTabStructure().type == bVar.getFragmentTabStructure().type) {
                    return;
                }
            }
            this.iZN.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> cAM() {
        return this.iZN;
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

    public void zW(String str) {
        this.ePd = str;
    }

    public void zX(String str) {
        this.ePe = str;
    }
}
