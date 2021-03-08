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
    private boolean fBP;
    private int fBQ;
    private String fBR;
    private int fBS;
    private boolean fBT;
    private boolean fBU;
    private boolean fBV;
    private String fBW;
    private List<FrsTabItemData> fBX;
    private PostPrefixData fBY;
    public boolean isForumBusinessAccount;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private int mLevel;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.fBP = false;
        this.fBQ = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.fBR = "";
        this.mThemeColorInfo = null;
        this.fBS = 0;
        this.fBT = false;
        this.fBU = false;
        this.fBV = false;
        this.fBW = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.fBP = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.fBR = str4;
        this.fBQ = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.fBS = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.fBP = historyForumInfo.is_liveforum.intValue() == 1;
            this.fBQ = historyForumInfo.unread_num.intValue();
            this.fBR = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.fBS = historyForumInfo.follow_num.intValue();
            this.fBT = historyForumInfo.need_trans.booleanValue();
            this.mLevel = historyForumInfo.level_id.intValue();
            if (historyForumInfo.block_pop_info != null) {
                this.fBV = historyForumInfo.block_pop_info.can_post.intValue() == 1;
                this.fBW = historyForumInfo.block_pop_info.block_info;
            }
            if (!y.isEmpty(historyForumInfo.tab_info)) {
                this.fBX = new ArrayList();
                for (FrsTabInfo frsTabInfo : historyForumInfo.tab_info) {
                    if (frsTabInfo != null) {
                        this.fBX.add(new FrsTabItemData(frsTabInfo));
                    }
                }
            }
            if (historyForumInfo.has_postpre.booleanValue()) {
                this.fBY = new PostPrefixData();
                this.fBY.parserProtobuf(historyForumInfo.post_prefix);
            }
            this.isForumBusinessAccount = historyForumInfo.is_forum_business_account.intValue() == 1;
        }
    }

    public String bAM() {
        return this.mForumImageUrl;
    }

    public boolean bAN() {
        return this.fBP;
    }

    public int bAO() {
        return this.fBQ;
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

    public String bAP() {
        return this.fBR;
    }

    public int bAQ() {
        return this.fBS;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean bAR() {
        return this.fBT;
    }

    public void kG(boolean z) {
        this.fBU = z;
    }

    public boolean bAS() {
        return this.fBU;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public boolean bAT() {
        return this.fBV;
    }

    public String bAU() {
        return this.fBW;
    }

    public List<FrsTabItemData> bAV() {
        return this.fBX;
    }

    public PostPrefixData bAW() {
        return this.fBY;
    }
}
