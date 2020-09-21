package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes23.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hYi = BdUniqueId.gen();
    private String hXJ;
    private String hYd;
    private String hYe;
    private String hYf;
    private boolean hYg;
    private List<FrsTabInfo> hYh;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.hXJ = str;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hYi;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.hYd = searchForum.post_num;
            this.hYe = searchForum.concern_num;
            this.hYf = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.hYg = searchForum.has_concerned.intValue() != 0;
            this.hYh = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String cnT() {
        return this.hYe;
    }

    public String cnU() {
        return this.hYd;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String cnV() {
        return this.hXJ;
    }

    public List<FrsTabInfo> cnW() {
        return this.hYh;
    }
}
