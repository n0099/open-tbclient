package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean aTU;
    private int aTV;
    private String aTW;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.aTU = false;
        this.aTV = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.aTW = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z) {
        this.mForumImageUrl = str3;
        this.aTU = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.aTW = str4;
        this.aTV = 0;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.aTU = historyForumInfo.is_liveforum.intValue() == 1;
            this.aTV = historyForumInfo.unread_num.intValue();
            this.aTW = historyForumInfo.visit_time;
        }
    }

    public String KC() {
        return this.mForumImageUrl;
    }

    public boolean KD() {
        return this.aTU;
    }

    public int KE() {
        return this.aTV;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String KF() {
        return this.aTW;
    }
}
