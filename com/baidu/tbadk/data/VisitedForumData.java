package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean aLh;
    private int aLi;
    private String aLj;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.aLh = false;
        this.aLi = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.aLj = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z) {
        this.mForumImageUrl = str3;
        this.aLh = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.aLj = str4;
        this.aLi = 0;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.aLh = historyForumInfo.is_liveforum.intValue() == 1;
            this.aLi = historyForumInfo.unread_num.intValue();
            this.aLj = historyForumInfo.visit_time;
        }
    }

    public String Hf() {
        return this.mForumImageUrl;
    }

    public boolean Hg() {
        return this.aLh;
    }

    public int Hh() {
        return this.aLi;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String Hi() {
        return this.aLj;
    }
}
