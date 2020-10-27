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
    private String fgA;
    private int fgB;
    private boolean fgC;
    private boolean fgD;
    private boolean fgE;
    private String fgF;
    private List<FrsTabItemData> fgG;
    private PostPrefixData fgH;
    private boolean fgy;
    private int fgz;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private int mLevel;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.fgy = false;
        this.fgz = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.fgA = "";
        this.mThemeColorInfo = null;
        this.fgB = 0;
        this.fgC = false;
        this.fgD = false;
        this.fgE = false;
        this.fgF = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.fgy = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.fgA = str4;
        this.fgz = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.fgB = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.fgy = historyForumInfo.is_liveforum.intValue() == 1;
            this.fgz = historyForumInfo.unread_num.intValue();
            this.fgA = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.fgB = historyForumInfo.follow_num.intValue();
            this.fgC = historyForumInfo.need_trans.booleanValue();
            this.mLevel = historyForumInfo.level_id.intValue();
            if (historyForumInfo.block_pop_info != null) {
                this.fgE = historyForumInfo.block_pop_info.can_post.intValue() == 1;
                this.fgF = historyForumInfo.block_pop_info.block_info;
            }
            if (!y.isEmpty(historyForumInfo.tab_info)) {
                this.fgG = new ArrayList();
                for (FrsTabInfo frsTabInfo : historyForumInfo.tab_info) {
                    if (frsTabInfo != null) {
                        this.fgG.add(new FrsTabItemData(frsTabInfo));
                    }
                }
            }
            if (historyForumInfo.has_postpre.booleanValue()) {
                this.fgH = new PostPrefixData();
                this.fgH.parserProtobuf(historyForumInfo.post_prefix);
            }
        }
    }

    public String bwA() {
        return this.mForumImageUrl;
    }

    public boolean bwB() {
        return this.fgy;
    }

    public int bwC() {
        return this.fgz;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String bwD() {
        return this.fgA;
    }

    public int bwE() {
        return this.fgB;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean bwF() {
        return this.fgC;
    }

    public void jL(boolean z) {
        this.fgD = z;
    }

    public boolean bwG() {
        return this.fgD;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public boolean bwH() {
        return this.fgE;
    }

    public String bwI() {
        return this.fgF;
    }

    public List<FrsTabItemData> bwJ() {
        return this.fgG;
    }

    public PostPrefixData bwK() {
        return this.fgH;
    }
}
