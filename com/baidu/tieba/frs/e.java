package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String bIQ;
    private String bIR;
    private List<FrsTabInfo> fof;
    private final List<com.baidu.tbadk.mainTab.b> fog = new LinkedList();
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private Context mContext;

    public e(Context context, List<FrsTabInfo> list) {
        this.fof = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.asK() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.fog) {
                if (bVar2 != null && bVar2.asK() != null && bVar2.asK().type == bVar.asK().type) {
                    return;
                }
            }
            this.fog.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> bjt() {
        return this.fog;
    }

    public void setForumName(String str) {
        this.forumName = str;
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

    public void mx(String str) {
        this.bIQ = str;
    }

    public void my(String str) {
        this.bIR = str;
    }
}
