package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean aYf;
    private int aYg;
    private String aYh;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.aYf = false;
        this.aYg = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.aYh = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z) {
        this.mForumImageUrl = str3;
        this.aYf = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.aYh = str4;
        this.aYg = 0;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.aYf = historyForumInfo.is_liveforum.intValue() == 1;
            this.aYg = historyForumInfo.unread_num.intValue();
            this.aYh = historyForumInfo.visit_time;
        }
    }

    public String LY() {
        return this.mForumImageUrl;
    }

    public boolean LZ() {
        return this.aYf;
    }

    public int Ma() {
        return this.aYg;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String Mb() {
        return this.aYh;
    }
}
