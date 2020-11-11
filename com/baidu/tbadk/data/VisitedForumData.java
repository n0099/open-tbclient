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
    private List<FrsTabItemData> fmA;
    private PostPrefixData fmB;
    private boolean fms;
    private int fmt;
    private String fmu;
    private int fmv;
    private boolean fmw;
    private boolean fmx;
    private boolean fmy;
    private String fmz;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private int mLevel;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.fms = false;
        this.fmt = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.fmu = "";
        this.mThemeColorInfo = null;
        this.fmv = 0;
        this.fmw = false;
        this.fmx = false;
        this.fmy = false;
        this.fmz = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.fms = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.fmu = str4;
        this.fmt = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.fmv = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.fms = historyForumInfo.is_liveforum.intValue() == 1;
            this.fmt = historyForumInfo.unread_num.intValue();
            this.fmu = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.fmv = historyForumInfo.follow_num.intValue();
            this.fmw = historyForumInfo.need_trans.booleanValue();
            this.mLevel = historyForumInfo.level_id.intValue();
            if (historyForumInfo.block_pop_info != null) {
                this.fmy = historyForumInfo.block_pop_info.can_post.intValue() == 1;
                this.fmz = historyForumInfo.block_pop_info.block_info;
            }
            if (!y.isEmpty(historyForumInfo.tab_info)) {
                this.fmA = new ArrayList();
                for (FrsTabInfo frsTabInfo : historyForumInfo.tab_info) {
                    if (frsTabInfo != null) {
                        this.fmA.add(new FrsTabItemData(frsTabInfo));
                    }
                }
            }
            if (historyForumInfo.has_postpre.booleanValue()) {
                this.fmB = new PostPrefixData();
                this.fmB.parserProtobuf(historyForumInfo.post_prefix);
            }
        }
    }

    public String byZ() {
        return this.mForumImageUrl;
    }

    public boolean bza() {
        return this.fms;
    }

    public int bzb() {
        return this.fmt;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String bzc() {
        return this.fmu;
    }

    public int bzd() {
        return this.fmv;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean bze() {
        return this.fmw;
    }

    public void jU(boolean z) {
        this.fmx = z;
    }

    public boolean bzf() {
        return this.fmx;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public boolean bzg() {
        return this.fmy;
    }

    public String bzh() {
        return this.fmz;
    }

    public List<FrsTabItemData> bzi() {
        return this.fmA;
    }

    public PostPrefixData bzj() {
        return this.fmB;
    }
}
