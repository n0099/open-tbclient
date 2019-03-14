package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eXC = BdUniqueId.gen();
    private String eBQ;
    private String eXA;
    private boolean eXB;
    private String eXh;
    private String eXy;
    private String eXz;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.eXh = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eXC;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.eBQ = searchForum.avatar;
            this.eXy = searchForum.post_num;
            this.eXz = searchForum.concern_num;
            this.eXA = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.eXB = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.eBQ;
    }

    public String bbA() {
        return this.eXz;
    }

    public String bbB() {
        return this.eXy;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String bbC() {
        return this.eXh;
    }
}
