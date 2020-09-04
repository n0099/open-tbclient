package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean eJJ;
    private int eJK;
    private String eJL;
    private int eJM;
    private boolean eJN;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.eJJ = false;
        this.eJK = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.eJL = "";
        this.mThemeColorInfo = null;
        this.eJM = 0;
        this.eJN = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.eJJ = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.eJL = str4;
        this.eJK = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.eJM = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.eJJ = historyForumInfo.is_liveforum.intValue() == 1;
            this.eJK = historyForumInfo.unread_num.intValue();
            this.eJL = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.eJM = historyForumInfo.follow_num.intValue();
            this.eJN = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String brd() {
        return this.mForumImageUrl;
    }

    public boolean bre() {
        return this.eJJ;
    }

    public int brf() {
        return this.eJK;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String brg() {
        return this.eJL;
    }

    public int brh() {
        return this.eJM;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean bri() {
        return this.eJN;
    }
}
