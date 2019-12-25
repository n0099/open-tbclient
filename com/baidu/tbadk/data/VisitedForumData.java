package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean dro;
    private int drp;
    private String drq;
    private int drr;
    private boolean drt;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.dro = false;
        this.drp = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.drq = "";
        this.mThemeColorInfo = null;
        this.drr = 0;
        this.drt = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.dro = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.drq = str4;
        this.drp = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.drr = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.dro = historyForumInfo.is_liveforum.intValue() == 1;
            this.drp = historyForumInfo.unread_num.intValue();
            this.drq = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.drr = historyForumInfo.follow_num.intValue();
            this.drt = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String aLk() {
        return this.mForumImageUrl;
    }

    public boolean aLl() {
        return this.dro;
    }

    public int aLm() {
        return this.drp;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String aLn() {
        return this.drq;
    }

    public int aLo() {
        return this.drr;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean aLp() {
        return this.drt;
    }
}
