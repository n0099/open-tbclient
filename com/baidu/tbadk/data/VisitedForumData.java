package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean aKl;
    private int aKm;
    private String aKn;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.aKl = false;
        this.aKm = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.aKn = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z) {
        this.mForumImageUrl = str3;
        this.aKl = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.aKn = str4;
        this.aKm = 0;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.aKl = historyForumInfo.is_liveforum.intValue() == 1;
            this.aKm = historyForumInfo.unread_num.intValue();
            this.aKn = historyForumInfo.visit_time;
        }
    }

    public String GN() {
        return this.mForumImageUrl;
    }

    public boolean GO() {
        return this.aKl;
    }

    public int GP() {
        return this.aKm;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String GQ() {
        return this.aKn;
    }
}
