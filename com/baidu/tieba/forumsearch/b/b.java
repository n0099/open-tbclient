package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes24.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId iRi = BdUniqueId.gen();
    private String eHR;
    private String iQJ;
    private String iRd;
    private String iRe;
    private String iRf;
    private boolean iRg;
    private List<FrsTabInfo> iRh;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.iQJ = str;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iRi;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.eHR = searchForum.avatar;
            this.iRd = searchForum.post_num;
            this.iRe = searchForum.concern_num;
            this.iRf = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.iRg = searchForum.has_concerned.intValue() != 0;
            this.iRh = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.eHR;
    }

    public String cAQ() {
        return this.iRe;
    }

    public String cAR() {
        return this.iRd;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String cAS() {
        return this.iQJ;
    }

    public List<FrsTabInfo> cAT() {
        return this.iRh;
    }
}
