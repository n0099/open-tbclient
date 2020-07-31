package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean ezh;
    private int ezi;
    private String ezj;
    private int ezk;
    private boolean ezl;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.ezh = false;
        this.ezi = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.ezj = "";
        this.mThemeColorInfo = null;
        this.ezk = 0;
        this.ezl = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.ezh = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.ezj = str4;
        this.ezi = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.ezk = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.ezh = historyForumInfo.is_liveforum.intValue() == 1;
            this.ezi = historyForumInfo.unread_num.intValue();
            this.ezj = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.ezk = historyForumInfo.follow_num.intValue();
            this.ezl = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String biq() {
        return this.mForumImageUrl;
    }

    public boolean bir() {
        return this.ezh;
    }

    public int bis() {
        return this.ezi;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String bit() {
        return this.ezj;
    }

    public int biu() {
        return this.ezk;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean biv() {
        return this.ezl;
    }
}
