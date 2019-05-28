package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fnw = BdUniqueId.gen();
    private String eRo;
    private String fmZ;
    private String fns;
    private String fnt;
    private String fnu;
    private boolean fnv;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.fmZ = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fnw;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.eRo = searchForum.avatar;
            this.fns = searchForum.post_num;
            this.fnt = searchForum.concern_num;
            this.fnu = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.fnv = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.eRo;
    }

    public String biR() {
        return this.fnt;
    }

    public String biS() {
        return this.fns;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String biT() {
        return this.fmZ;
    }
}
