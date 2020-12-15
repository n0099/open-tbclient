package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes24.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId iRk = BdUniqueId.gen();
    private String eHR;
    private String iQL;
    private String iRf;
    private String iRg;
    private String iRh;
    private boolean iRi;
    private List<FrsTabInfo> iRj;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.iQL = str;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iRk;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.eHR = searchForum.avatar;
            this.iRf = searchForum.post_num;
            this.iRg = searchForum.concern_num;
            this.iRh = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.iRi = searchForum.has_concerned.intValue() != 0;
            this.iRj = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.eHR;
    }

    public String cAR() {
        return this.iRg;
    }

    public String cAS() {
        return this.iRf;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String cAT() {
        return this.iQL;
    }

    public List<FrsTabInfo> cAU() {
        return this.iRj;
    }
}
