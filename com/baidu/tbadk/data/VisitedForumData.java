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
    private boolean eLV;
    private int eLW;
    private String eLX;
    private int eLY;
    private boolean eLZ;
    private boolean eMa;
    private boolean eMb;
    private String eMc;
    private List<FrsTabItemData> eMd;
    private PostPrefixData eMe;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private int mLevel;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.eLV = false;
        this.eLW = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.eLX = "";
        this.mThemeColorInfo = null;
        this.eLY = 0;
        this.eLZ = false;
        this.eMa = false;
        this.eMb = false;
        this.eMc = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.eLV = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.eLX = str4;
        this.eLW = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.eLY = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.eLV = historyForumInfo.is_liveforum.intValue() == 1;
            this.eLW = historyForumInfo.unread_num.intValue();
            this.eLX = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.eLY = historyForumInfo.follow_num.intValue();
            this.eLZ = historyForumInfo.need_trans.booleanValue();
            this.mLevel = historyForumInfo.level_id.intValue();
            if (historyForumInfo.block_pop_info != null) {
                this.eMb = historyForumInfo.block_pop_info.can_post.intValue() == 1;
                this.eMc = historyForumInfo.block_pop_info.block_info;
            }
            if (!y.isEmpty(historyForumInfo.tab_info)) {
                this.eMd = new ArrayList();
                for (FrsTabInfo frsTabInfo : historyForumInfo.tab_info) {
                    if (frsTabInfo != null) {
                        this.eMd.add(new FrsTabItemData(frsTabInfo));
                    }
                }
            }
            if (historyForumInfo.has_postpre.booleanValue()) {
                this.eMe = new PostPrefixData();
                this.eMe.parserProtobuf(historyForumInfo.post_prefix);
            }
        }
    }

    public String brX() {
        return this.mForumImageUrl;
    }

    public boolean brY() {
        return this.eLV;
    }

    public int brZ() {
        return this.eLW;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String bsa() {
        return this.eLX;
    }

    public int bsb() {
        return this.eLY;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean bsc() {
        return this.eLZ;
    }

    public void ja(boolean z) {
        this.eMa = z;
    }

    public boolean bsd() {
        return this.eMa;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public boolean bse() {
        return this.eMb;
    }

    public String bsf() {
        return this.eMc;
    }

    public List<FrsTabItemData> bsg() {
        return this.eMd;
    }

    public PostPrefixData bsh() {
        return this.eMe;
    }
}
