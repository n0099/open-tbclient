package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean aLn;
    private int aLo;
    private String aLp;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.aLn = false;
        this.aLo = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.aLp = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z) {
        this.mForumImageUrl = str3;
        this.aLn = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.aLp = str4;
        this.aLo = 0;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.aLn = historyForumInfo.is_liveforum.intValue() == 1;
            this.aLo = historyForumInfo.unread_num.intValue();
            this.aLp = historyForumInfo.visit_time;
        }
    }

    public String Hb() {
        return this.mForumImageUrl;
    }

    public boolean Hc() {
        return this.aLn;
    }

    public int Hd() {
        return this.aLo;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String He() {
        return this.aLp;
    }
}
