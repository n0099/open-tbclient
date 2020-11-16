package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.HistoryForumInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes.dex */
public class VisitedForumData extends OrmObject {
    private int flA;
    private String flB;
    private int flC;
    private boolean flD;
    private boolean flE;
    private boolean flF;
    private String flG;
    private List<FrsTabItemData> flH;
    private PostPrefixData flI;
    private boolean flz;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private int mLevel;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.flz = false;
        this.flA = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.flB = "";
        this.mThemeColorInfo = null;
        this.flC = 0;
        this.flD = false;
        this.flE = false;
        this.flF = false;
        this.flG = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.flz = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.flB = str4;
        this.flA = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.flC = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.flz = historyForumInfo.is_liveforum.intValue() == 1;
            this.flA = historyForumInfo.unread_num.intValue();
            this.flB = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.flC = historyForumInfo.follow_num.intValue();
            this.flD = historyForumInfo.need_trans.booleanValue();
            this.mLevel = historyForumInfo.level_id.intValue();
            if (historyForumInfo.block_pop_info != null) {
                this.flF = historyForumInfo.block_pop_info.can_post.intValue() == 1;
                this.flG = historyForumInfo.block_pop_info.block_info;
            }
            if (!y.isEmpty(historyForumInfo.tab_info)) {
                this.flH = new ArrayList();
                for (FrsTabInfo frsTabInfo : historyForumInfo.tab_info) {
                    if (frsTabInfo != null) {
                        this.flH.add(new FrsTabItemData(frsTabInfo));
                    }
                }
            }
            if (historyForumInfo.has_postpre.booleanValue()) {
                this.flI = new PostPrefixData();
                this.flI.parserProtobuf(historyForumInfo.post_prefix);
            }
        }
    }

    public String byp() {
        return this.mForumImageUrl;
    }

    public boolean byq() {
        return this.flz;
    }

    public int byr() {
        return this.flA;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String bys() {
        return this.flB;
    }

    public int byt() {
        return this.flC;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean byu() {
        return this.flD;
    }

    public void jV(boolean z) {
        this.flE = z;
    }

    public boolean byv() {
        return this.flE;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public boolean byw() {
        return this.flF;
    }

    public String byx() {
        return this.flG;
    }

    public List<FrsTabItemData> byy() {
        return this.flH;
    }

    public PostPrefixData byz() {
        return this.flI;
    }
}
