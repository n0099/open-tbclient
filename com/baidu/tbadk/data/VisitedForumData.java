package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean aBP;
    private int aBQ;
    private String aBR;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.aBP = false;
        this.aBQ = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.aBR = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z) {
        this.mForumImageUrl = str3;
        this.aBP = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.aBR = str4;
        this.aBQ = 0;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.aBP = historyForumInfo.is_liveforum.intValue() == 1;
            this.aBQ = historyForumInfo.unread_num.intValue();
            this.aBR = historyForumInfo.visit_time;
        }
    }

    public String Dk() {
        return this.mForumImageUrl;
    }

    public boolean Dl() {
        return this.aBP;
    }

    public int Dm() {
        return this.aBQ;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String Dn() {
        return this.aBR;
    }
}
