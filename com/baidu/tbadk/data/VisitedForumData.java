package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean dvV;
    private int dvW;
    private String dvX;
    private int dvY;
    private boolean dvZ;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.dvV = false;
        this.dvW = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.dvX = "";
        this.mThemeColorInfo = null;
        this.dvY = 0;
        this.dvZ = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.dvV = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.dvX = str4;
        this.dvW = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.dvY = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.dvV = historyForumInfo.is_liveforum.intValue() == 1;
            this.dvW = historyForumInfo.unread_num.intValue();
            this.dvX = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.dvY = historyForumInfo.follow_num.intValue();
            this.dvZ = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String aOc() {
        return this.mForumImageUrl;
    }

    public boolean aOd() {
        return this.dvV;
    }

    public int aOe() {
        return this.dvW;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String aOf() {
        return this.dvX;
    }

    public int aOg() {
        return this.dvY;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean aOh() {
        return this.dvZ;
    }
}
