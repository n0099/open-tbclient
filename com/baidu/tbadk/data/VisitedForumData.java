package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean aOC;
    private int aOD;
    private String aOE;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.aOC = false;
        this.aOD = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.aOE = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z) {
        this.mForumImageUrl = str3;
        this.aOC = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.aOE = str4;
        this.aOD = 0;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.aOC = historyForumInfo.is_liveforum.intValue() == 1;
            this.aOD = historyForumInfo.unread_num.intValue();
            this.aOE = historyForumInfo.visit_time;
        }
    }

    public String Ir() {
        return this.mForumImageUrl;
    }

    public boolean Is() {
        return this.aOC;
    }

    public int It() {
        return this.aOD;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String Iu() {
        return this.aOE;
    }
}
