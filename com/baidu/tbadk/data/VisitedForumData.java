package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean aYe;
    private int aYf;
    private String aYg;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.aYe = false;
        this.aYf = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.aYg = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z) {
        this.mForumImageUrl = str3;
        this.aYe = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.aYg = str4;
        this.aYf = 0;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.aYe = historyForumInfo.is_liveforum.intValue() == 1;
            this.aYf = historyForumInfo.unread_num.intValue();
            this.aYg = historyForumInfo.visit_time;
        }
    }

    public String LY() {
        return this.mForumImageUrl;
    }

    public boolean LZ() {
        return this.aYe;
    }

    public int Ma() {
        return this.aYf;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String Mb() {
        return this.aYg;
    }
}
