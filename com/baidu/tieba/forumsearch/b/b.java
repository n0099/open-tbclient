package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ftU = BdUniqueId.gen();
    private String faP;
    private String ftQ;
    private String ftR;
    private String ftS;
    private boolean ftT;
    private String ftx;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.ftx = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ftU;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.faP = searchForum.avatar;
            this.ftQ = searchForum.post_num;
            this.ftR = searchForum.concern_num;
            this.ftS = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.ftT = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.faP;
    }

    public String biR() {
        return this.ftR;
    }

    public String biS() {
        return this.ftQ;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String biT() {
        return this.ftx;
    }
}
