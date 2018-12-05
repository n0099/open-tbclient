package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean aXr;
    private int aXs;
    private String aXt;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.aXr = false;
        this.aXs = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.aXt = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z) {
        this.mForumImageUrl = str3;
        this.aXr = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.aXt = str4;
        this.aXs = 0;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.aXr = historyForumInfo.is_liveforum.intValue() == 1;
            this.aXs = historyForumInfo.unread_num.intValue();
            this.aXt = historyForumInfo.visit_time;
        }
    }

    public String LG() {
        return this.mForumImageUrl;
    }

    public boolean LH() {
        return this.aXr;
    }

    public int LI() {
        return this.aXs;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String LJ() {
        return this.aXt;
    }
}
