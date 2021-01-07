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
    private boolean fCI;
    private int fCJ;
    private String fCK;
    private int fCL;
    private boolean fCM;
    private int fCN;
    private boolean fCO;
    private boolean fCP;
    private String fCQ;
    private List<FrsTabItemData> fCR;
    private PostPrefixData fCS;
    public boolean isForumBusinessAccount;
    private String mForumId;
    private String mForumImageUrl;
    private String mForumName;
    private ThemeColorInfo mThemeColorInfo;

    public VisitedForumData() {
        this.mForumImageUrl = "";
        this.fCI = false;
        this.fCJ = 0;
        this.mForumName = "";
        this.mForumId = "";
        this.fCK = "";
        this.mThemeColorInfo = null;
        this.fCL = 0;
        this.fCM = false;
        this.fCO = false;
        this.fCP = false;
        this.fCQ = "";
    }

    public VisitedForumData(String str, String str2, String str3, String str4, boolean z, ThemeColorInfo themeColorInfo, int i) {
        this.mForumImageUrl = str3;
        this.fCI = z;
        this.mForumName = str2;
        this.mForumId = str;
        this.fCK = str4;
        this.fCJ = 0;
        this.mThemeColorInfo = themeColorInfo;
        this.fCL = i;
    }

    public void a(HistoryForumInfo historyForumInfo) {
        if (historyForumInfo != null) {
            this.mForumImageUrl = historyForumInfo.avatar;
            this.mForumId = String.valueOf(historyForumInfo.forum_id);
            this.mForumName = historyForumInfo.forum_name;
            this.fCI = historyForumInfo.is_liveforum.intValue() == 1;
            this.fCJ = historyForumInfo.unread_num.intValue();
            this.fCK = historyForumInfo.visit_time;
            this.mThemeColorInfo = historyForumInfo.theme_color;
            this.fCL = historyForumInfo.follow_num.intValue();
            this.fCM = historyForumInfo.need_trans.booleanValue();
            this.fCN = historyForumInfo.level_id.intValue();
            if (historyForumInfo.block_pop_info != null) {
                this.fCP = historyForumInfo.block_pop_info.can_post.intValue() == 1;
                this.fCQ = historyForumInfo.block_pop_info.block_info;
            }
            if (!x.isEmpty(historyForumInfo.tab_info)) {
                this.fCR = new ArrayList();
                for (FrsTabInfo frsTabInfo : historyForumInfo.tab_info) {
                    if (frsTabInfo != null) {
                        this.fCR.add(new FrsTabItemData(frsTabInfo));
                    }
                }
            }
            if (historyForumInfo.has_postpre.booleanValue()) {
                this.fCS = new PostPrefixData();
                this.fCS.parserProtobuf(historyForumInfo.post_prefix);
            }
            this.isForumBusinessAccount = historyForumInfo.is_forum_business_account.intValue() == 1;
        }
    }

    public String bEl() {
        return this.mForumImageUrl;
    }

    public boolean bEm() {
        return this.fCI;
    }

    public int bEn() {
        return this.fCJ;
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

    public String bEo() {
        return this.fCK;
    }

    public int bEp() {
        return this.fCL;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public boolean bEq() {
        return this.fCM;
    }

    public void kH(boolean z) {
        this.fCO = z;
    }

    public boolean bEr() {
        return this.fCO;
    }

    public int getLevel() {
        return this.fCN;
    }

    public boolean bEs() {
        return this.fCP;
    }

    public String bEt() {
        return this.fCQ;
    }

    public List<FrsTabItemData> bEu() {
        return this.fCR;
    }

    public PostPrefixData bEv() {
        return this.fCS;
    }
}
