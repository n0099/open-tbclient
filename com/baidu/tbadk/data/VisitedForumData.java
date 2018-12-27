package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean aXu;
    private int aXv;
    private String aXw;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.aXu = false;
        this.aXv = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.aXw = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z) {
        this.mForumImageUrl = str3;
        this.aXu = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.aXw = str4;
        this.aXv = 0;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.aXu = historyForumInfo.is_liveforum.intValue() == 1;
            this.aXv = historyForumInfo.unread_num.intValue();
            this.aXw = historyForumInfo.visit_time;
        }
    }

    public String LH() {
        return this.mForumImageUrl;
    }

    public boolean LI() {
        return this.aXu;
    }

    public int LJ() {
        return this.aXv;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String LK() {
        return this.aXw;
    }
}
