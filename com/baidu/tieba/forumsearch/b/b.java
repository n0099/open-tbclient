package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes8.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ghB = BdUniqueId.gen();
    private String eqU;
    private boolean ghA;
    private String ghc;
    private String ghx;
    private String ghy;
    private String ghz;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.ghc = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ghB;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.eqU = searchForum.avatar;
            this.ghx = searchForum.post_num;
            this.ghy = searchForum.concern_num;
            this.ghz = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.ghA = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.eqU;
    }

    public String bAk() {
        return this.ghy;
    }

    public String bAl() {
        return this.ghx;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String bAm() {
        return this.ghc;
    }
}
