package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean aBO;
    private int aBP;
    private String aBQ;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.aBO = false;
        this.aBP = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.aBQ = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z) {
        this.mForumImageUrl = str3;
        this.aBO = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.aBQ = str4;
        this.aBP = 0;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.aBO = historyForumInfo.is_liveforum.intValue() == 1;
            this.aBP = historyForumInfo.unread_num.intValue();
            this.aBQ = historyForumInfo.visit_time;
        }
    }

    public String Dm() {
        return this.mForumImageUrl;
    }

    public boolean Dn() {
        return this.aBO;
    }

    public int Do() {
        return this.aBP;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String Dp() {
        return this.aBQ;
    }
}
