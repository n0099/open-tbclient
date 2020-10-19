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
    private boolean eYc;
    private int eYd;
    private String eYe;
    private int eYf;
    private boolean eYg;
    private boolean eYh;
    private boolean eYi;
    private String eYj;
    private List<FrsTabItemData> eYk;
    private PostPrefixData eYl;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private int mLevel;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.eYc = false;
        this.eYd = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.eYe = "";
        this.mThemeColorInfo = null;
        this.eYf = 0;
        this.eYg = false;
        this.eYh = false;
        this.eYi = false;
        this.eYj = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.eYc = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.eYe = str4;
        this.eYd = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.eYf = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.eYc = historyForumInfo.is_liveforum.intValue() == 1;
            this.eYd = historyForumInfo.unread_num.intValue();
            this.eYe = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.eYf = historyForumInfo.follow_num.intValue();
            this.eYg = historyForumInfo.need_trans.booleanValue();
            this.mLevel = historyForumInfo.level_id.intValue();
            if (historyForumInfo.block_pop_info != null) {
                this.eYi = historyForumInfo.block_pop_info.can_post.intValue() == 1;
                this.eYj = historyForumInfo.block_pop_info.block_info;
            }
            if (!y.isEmpty(historyForumInfo.tab_info)) {
                this.eYk = new ArrayList();
                for (FrsTabInfo frsTabInfo : historyForumInfo.tab_info) {
                    if (frsTabInfo != null) {
                        this.eYk.add(new FrsTabItemData(frsTabInfo));
                    }
                }
            }
            if (historyForumInfo.has_postpre.booleanValue()) {
                this.eYl = new PostPrefixData();
                this.eYl.parserProtobuf(historyForumInfo.post_prefix);
            }
        }
    }

    public String buH() {
        return this.mForumImageUrl;
    }

    public boolean buI() {
        return this.eYc;
    }

    public int buJ() {
        return this.eYd;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public String buK() {
        return this.eYe;
    }

    public int buL() {
        return this.eYf;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean buM() {
        return this.eYg;
    }

    public void jy(boolean z) {
        this.eYh = z;
    }

    public boolean buN() {
        return this.eYh;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public boolean buO() {
        return this.eYi;
    }

    public String buP() {
        return this.eYj;
    }

    public List<FrsTabItemData> buQ() {
        return this.eYk;
    }

    public PostPrefixData buR() {
        return this.eYl;
    }
}
