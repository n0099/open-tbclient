package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean drA;
    private int drB;
    private String drC;
    private int drD;
    private boolean drE;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.drA = false;
        this.drB = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.drC = "";
        this.mThemeColorInfo = null;
        this.drD = 0;
        this.drE = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.drA = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.drC = str4;
        this.drB = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.drD = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.drA = historyForumInfo.is_liveforum.intValue() == 1;
            this.drB = historyForumInfo.unread_num.intValue();
            this.drC = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.drD = historyForumInfo.follow_num.intValue();
            this.drE = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String aLD() {
        return this.mForumImageUrl;
    }

    public boolean aLE() {
        return this.drA;
    }

    public int aLF() {
        return this.drB;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String aLG() {
        return this.drC;
    }

    public int aLH() {
        return this.drD;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean aLI() {
        return this.drE;
    }
}
