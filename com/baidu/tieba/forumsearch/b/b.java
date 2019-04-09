package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eXp = BdUniqueId.gen();
    private String eBC;
    private String eWU;
    private String eXl;
    private String eXm;
    private String eXn;
    private boolean eXo;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.eWU = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eXp;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.eBC = searchForum.avatar;
            this.eXl = searchForum.post_num;
            this.eXm = searchForum.concern_num;
            this.eXn = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.eXo = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.eBC;
    }

    public String bby() {
        return this.eXm;
    }

    public String bbz() {
        return this.eXl;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String bbA() {
        return this.eWU;
    }
}
