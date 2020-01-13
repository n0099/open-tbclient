package com.baidu.tieba.frs;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class e {
    private String cNZ;
    private String cOa;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private List<FrsTabInfo> glw;
    private final List<com.baidu.tbadk.mainTab.b> glx = new LinkedList();
    private Context mContext;
    private String mFrom;

    public e(Context context, List<FrsTabInfo> list) {
        this.glw = list;
        this.mContext = context;
    }

    public void b(com.baidu.tbadk.mainTab.b bVar) {
        if (bVar != null && bVar.aNy() != null) {
            for (com.baidu.tbadk.mainTab.b bVar2 : this.glx) {
                if (bVar2 != null && bVar2.aNy() != null && bVar2.aNy().type == bVar.aNy().type) {
                    return;
                }
            }
            this.glx.add(bVar);
        }
    }

    public List<com.baidu.tbadk.mainTab.b> bBQ() {
        return this.glx;
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

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    public void sv(String str) {
        this.cNZ = str;
    }

    public void sw(String str) {
        this.cOa = str;
    }
}
