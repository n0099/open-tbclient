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
    private boolean fAq;
    private int fAr;
    private String fAs;
    private int fAt;
    private boolean fAu;
    private boolean fAv;
    private boolean fAw;
    private String fAx;
    private List<FrsTabItemData> fAy;
    private PostPrefixData fAz;
    public boolean isForumBusinessAccount;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private int mLevel;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.fAq = false;
        this.fAr = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.fAs = "";
        this.mThemeColorInfo = null;
        this.fAt = 0;
        this.fAu = false;
        this.fAv = false;
        this.fAw = false;
        this.fAx = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.fAq = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.fAs = str4;
        this.fAr = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.fAt = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.fAq = historyForumInfo.is_liveforum.intValue() == 1;
            this.fAr = historyForumInfo.unread_num.intValue();
            this.fAs = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.fAt = historyForumInfo.follow_num.intValue();
            this.fAu = historyForumInfo.need_trans.booleanValue();
            this.mLevel = historyForumInfo.level_id.intValue();
            if (historyForumInfo.block_pop_info != null) {
                this.fAw = historyForumInfo.block_pop_info.can_post.intValue() == 1;
                this.fAx = historyForumInfo.block_pop_info.block_info;
            }
            if (!y.isEmpty(historyForumInfo.tab_info)) {
                this.fAy = new ArrayList();
                for (FrsTabInfo frsTabInfo : historyForumInfo.tab_info) {
                    if (frsTabInfo != null) {
                        this.fAy.add(new FrsTabItemData(frsTabInfo));
                    }
                }
            }
            if (historyForumInfo.has_postpre.booleanValue()) {
                this.fAz = new PostPrefixData();
                this.fAz.parserProtobuf(historyForumInfo.post_prefix);
            }
            this.isForumBusinessAccount = historyForumInfo.is_forum_business_account.intValue() == 1;
        }
    }

    public String bAJ() {
        return this.mForumImageUrl;
    }

    public boolean bAK() {
        return this.fAq;
    }

    public int bAL() {
        return this.fAr;
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

    public String bAM() {
        return this.fAs;
    }

    public int bAN() {
        return this.fAt;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean bAO() {
        return this.fAu;
    }

    public void kG(boolean z) {
        this.fAv = z;
    }

    public boolean bAP() {
        return this.fAv;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public boolean bAQ() {
        return this.fAw;
    }

    public String bAR() {
        return this.fAx;
    }

    public List<FrsTabItemData> bAS() {
        return this.fAy;
    }

    public PostPrefixData bAT() {
        return this.fAz;
    }
}
