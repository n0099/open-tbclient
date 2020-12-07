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
    private boolean ftc;
    private int ftd;
    private String fte;
    private int ftf;
    private boolean ftg;
    private int fth;
    private boolean fti;
    private boolean ftj;
    private String ftk;
    private List<FrsTabItemData> ftl;
    private PostPrefixData ftm;
    public boolean isForumBusinessAccount;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.ftc = false;
        this.ftd = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.fte = "";
        this.mThemeColorInfo = null;
        this.ftf = 0;
        this.ftg = false;
        this.fti = false;
        this.ftj = false;
        this.ftk = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.ftc = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.fte = str4;
        this.ftd = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.ftf = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.ftc = historyForumInfo.is_liveforum.intValue() == 1;
            this.ftd = historyForumInfo.unread_num.intValue();
            this.fte = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.ftf = historyForumInfo.follow_num.intValue();
            this.ftg = historyForumInfo.need_trans.booleanValue();
            this.fth = historyForumInfo.level_id.intValue();
            if (historyForumInfo.block_pop_info != null) {
                this.ftj = historyForumInfo.block_pop_info.can_post.intValue() == 1;
                this.ftk = historyForumInfo.block_pop_info.block_info;
            }
            if (!y.isEmpty(historyForumInfo.tab_info)) {
                this.ftl = new ArrayList();
                for (FrsTabInfo frsTabInfo : historyForumInfo.tab_info) {
                    if (frsTabInfo != null) {
                        this.ftl.add(new FrsTabItemData(frsTabInfo));
                    }
                }
            }
            if (historyForumInfo.has_postpre.booleanValue()) {
                this.ftm = new PostPrefixData();
                this.ftm.parserProtobuf(historyForumInfo.post_prefix);
            }
            this.isForumBusinessAccount = historyForumInfo.is_forum_business_account.intValue() == 1;
        }
    }

    public String bBP() {
        return this.mForumImageUrl;
    }

    public boolean bBQ() {
        return this.ftc;
    }

    public int bBR() {
        return this.ftd;
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

    public String bBS() {
        return this.fte;
    }

    public int bBT() {
        return this.ftf;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean bBU() {
        return this.ftg;
    }

    public void kl(boolean z) {
        this.fti = z;
    }

    public boolean bBV() {
        return this.fti;
    }

    public int getLevel() {
        return this.fth;
    }

    public boolean bBW() {
        return this.ftj;
    }

    public String bBX() {
        return this.ftk;
    }

    public List<FrsTabItemData> bBY() {
        return this.ftl;
    }

    public PostPrefixData bBZ() {
        return this.ftm;
    }
}
