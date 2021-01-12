package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private boolean fya;
    private int fyb;
    private String fyc;
    private int fyd;
    private boolean fye;
    private int fyf;
    private boolean fyg;
    private boolean fyh;
    private String fyi;
    private List<FrsTabItemData> fyj;
    private PostPrefixData fyk;
    public boolean isForumBusinessAccount;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.fya = false;
        this.fyb = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.fyc = "";
        this.mThemeColorInfo = null;
        this.fyd = 0;
        this.fye = false;
        this.fyg = false;
        this.fyh = false;
        this.fyi = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.fya = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.fyc = str4;
        this.fyb = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.fyd = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.fya = historyForumInfo.is_liveforum.intValue() == 1;
            this.fyb = historyForumInfo.unread_num.intValue();
            this.fyc = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.fyd = historyForumInfo.follow_num.intValue();
            this.fye = historyForumInfo.need_trans.booleanValue();
            this.fyf = historyForumInfo.level_id.intValue();
            if (historyForumInfo.block_pop_info != null) {
                this.fyh = historyForumInfo.block_pop_info.can_post.intValue() == 1;
                this.fyi = historyForumInfo.block_pop_info.block_info;
            }
            if (!x.isEmpty(historyForumInfo.tab_info)) {
                this.fyj = new ArrayList();
                for (FrsTabInfo frsTabInfo : historyForumInfo.tab_info) {
                    if (frsTabInfo != null) {
                        this.fyj.add(new FrsTabItemData(frsTabInfo));
                    }
                }
            }
            if (historyForumInfo.has_postpre.booleanValue()) {
                this.fyk = new PostPrefixData();
                this.fyk.parserProtobuf(historyForumInfo.post_prefix);
            }
            this.isForumBusinessAccount = historyForumInfo.is_forum_business_account.intValue() == 1;
        }
    }

    public String bAr() {
        return this.mForumImageUrl;
    }

    public boolean bAs() {
        return this.fya;
    }

    public int bAt() {
        return this.fyb;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String bAu() {
        return this.fyc;
    }

    public int bAv() {
        return this.fyd;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean bAw() {
        return this.fye;
    }

    public void kD(boolean z) {
        this.fyg = z;
    }

    public boolean bAx() {
        return this.fyg;
    }

    public int getLevel() {
        return this.fyf;
    }

    public boolean bAy() {
        return this.fyh;
    }

    public String bAz() {
        return this.fyi;
    }

    public List<FrsTabItemData> bAA() {
        return this.fyj;
    }

    public PostPrefixData bAB() {
        return this.fyk;
    }
}
