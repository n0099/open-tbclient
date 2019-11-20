package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ftd = BdUniqueId.gen();
    private String eZY;
    private String fsG;
    private String fsZ;
    private String fta;
    private String ftb;
    private boolean ftc;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.fsG = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ftd;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.eZY = searchForum.avatar;
            this.fsZ = searchForum.post_num;
            this.fta = searchForum.concern_num;
            this.ftb = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.ftc = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.eZY;
    }

    public String biP() {
        return this.fta;
    }

    public String biQ() {
        return this.fsZ;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String biR() {
        return this.fsG;
    }
}
