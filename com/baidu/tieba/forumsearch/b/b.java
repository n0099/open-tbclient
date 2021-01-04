package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes8.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId jdw = BdUniqueId.gen();
    private String eRJ;
    private String jcX;
    private String jdr;
    private String jds;
    private String jdt;
    private boolean jdu;
    private List<FrsTabInfo> jdv;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.jcX = str;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jdw;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.eRJ = searchForum.avatar;
            this.jdr = searchForum.post_num;
            this.jds = searchForum.concern_num;
            this.jdt = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.jdu = searchForum.has_concerned.intValue() != 0;
            this.jdv = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.eRJ;
    }

    public String cDK() {
        return this.jds;
    }

    public String cDL() {
        return this.jdr;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String cDM() {
        return this.jcX;
    }

    public List<FrsTabInfo> cDN() {
        return this.jdv;
    }
}
