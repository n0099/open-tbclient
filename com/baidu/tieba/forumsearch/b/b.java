package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes7.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId jgt = BdUniqueId.gen();
    private String eQL;
    private String jfU;
    private String jgo;
    private String jgp;
    private String jgq;
    private boolean jgr;
    private List<FrsTabInfo> jgs;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.jfU = str;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jgt;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.eQL = searchForum.avatar;
            this.jgo = searchForum.post_num;
            this.jgp = searchForum.concern_num;
            this.jgq = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.jgr = searchForum.has_concerned.intValue() != 0;
            this.jgs = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.eQL;
    }

    public String cBr() {
        return this.jgp;
    }

    public String cBs() {
        return this.jgo;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String cBt() {
        return this.jfU;
    }

    public List<FrsTabInfo> cBu() {
        return this.jgs;
    }
}
