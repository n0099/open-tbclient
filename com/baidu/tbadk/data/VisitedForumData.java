package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean aTe;
    private int aTf;
    private String aTg;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.aTe = false;
        this.aTf = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.aTg = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z) {
        this.mForumImageUrl = str3;
        this.aTe = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.aTg = str4;
        this.aTf = 0;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.aTe = historyForumInfo.is_liveforum.intValue() == 1;
            this.aTf = historyForumInfo.unread_num.intValue();
            this.aTg = historyForumInfo.visit_time;
        }
    }

    public String Kq() {
        return this.mForumImageUrl;
    }

    public boolean Kr() {
        return this.aTe;
    }

    public int Ks() {
        return this.aTf;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String Kt() {
        return this.aTg;
    }
}
