package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean crZ;
    private int csa;
    private String csb;
    private int csc;
    private boolean csd;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.crZ = false;
        this.csa = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.csb = "";
        this.mThemeColorInfo = null;
        this.csc = 0;
        this.csd = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.crZ = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.csb = str4;
        this.csa = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.csc = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.crZ = historyForumInfo.is_liveforum.intValue() == 1;
            this.csa = historyForumInfo.unread_num.intValue();
            this.csb = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.csc = historyForumInfo.follow_num.intValue();
            this.csd = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String arT() {
        return this.mForumImageUrl;
    }

    public boolean arU() {
        return this.crZ;
    }

    public int arV() {
        return this.csa;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String arW() {
        return this.csb;
    }

    public int arX() {
        return this.csc;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean arY() {
        return this.csd;
    }
}
