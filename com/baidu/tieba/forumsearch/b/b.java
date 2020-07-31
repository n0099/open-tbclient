package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes18.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hDO = BdUniqueId.gen();
    private String hDJ;
    private String hDK;
    private String hDL;
    private boolean hDM;
    private List<FrsTabInfo> hDN;
    private String hDo;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.hDo = str;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hDO;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.hDJ = searchForum.post_num;
            this.hDK = searchForum.concern_num;
            this.hDL = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.hDM = searchForum.has_concerned.intValue() != 0;
            this.hDN = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String caj() {
        return this.hDK;
    }

    public String cak() {
        return this.hDJ;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String cal() {
        return this.hDo;
    }

    public List<FrsTabInfo> cam() {
        return this.hDN;
    }
}
