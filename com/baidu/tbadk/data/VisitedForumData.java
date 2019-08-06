package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean crf;
    private int crg;
    private String crh;
    private int cri;
    private boolean crj;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.crf = false;
        this.crg = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.crh = "";
        this.mThemeColorInfo = null;
        this.cri = 0;
        this.crj = false;
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.crf = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.crh = str4;
        this.crg = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.cri = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.crf = historyForumInfo.is_liveforum.intValue() == 1;
            this.crg = historyForumInfo.unread_num.intValue();
            this.crh = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.cri = historyForumInfo.follow_num.intValue();
            this.crj = historyForumInfo.need_trans.booleanValue();
        }
    }

    public String arH() {
        return this.mForumImageUrl;
    }

    public boolean arI() {
        return this.crf;
    }

    public int arJ() {
        return this.crg;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String arK() {
        return this.crh;
    }

    public int arL() {
        return this.cri;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean arM() {
        return this.crj;
    }
}
