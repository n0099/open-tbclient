package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eXo = BdUniqueId.gen();
    private String eBB;
    private String eWT;
    private String eXk;
    private String eXl;
    private String eXm;
    private boolean eXn;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.eWT = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eXo;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.eBB = searchForum.avatar;
            this.eXk = searchForum.post_num;
            this.eXl = searchForum.concern_num;
            this.eXm = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.eXn = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.eBB;
    }

    public String bby() {
        return this.eXl;
    }

    public String bbz() {
        return this.eXk;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String bbA() {
        return this.eWT;
    }
}
