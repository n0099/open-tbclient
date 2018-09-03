package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean aLk;
    private int aLl;
    private String aLm;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.aLk = false;
        this.aLl = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.aLm = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z) {
        this.mForumImageUrl = str3;
        this.aLk = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.aLm = str4;
        this.aLl = 0;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.aLk = historyForumInfo.is_liveforum.intValue() == 1;
            this.aLl = historyForumInfo.unread_num.intValue();
            this.aLm = historyForumInfo.visit_time;
        }
    }

    public String Hb() {
        return this.mForumImageUrl;
    }

    public boolean Hc() {
        return this.aLk;
    }

    public int Hd() {
        return this.aLl;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String He() {
        return this.aLm;
    }
}
