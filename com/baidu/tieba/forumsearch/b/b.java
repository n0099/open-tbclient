package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fnv = BdUniqueId.gen();
    private String eRn;
    private String fmY;
    private String fnr;
    private String fns;
    private String fnt;
    private boolean fnu;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.fmY = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fnv;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.eRn = searchForum.avatar;
            this.fnr = searchForum.post_num;
            this.fns = searchForum.concern_num;
            this.fnt = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.fnu = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.eRn;
    }

    public String biO() {
        return this.fns;
    }

    public String biP() {
        return this.fnr;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String biQ() {
        return this.fmY;
    }
}
