package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dJC = BdUniqueId.gen();
    private String dJA;
    private boolean dJB;
    private String dJh;
    private String dJy;
    private String dJz;
    private String dqR;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.dJh = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dJC;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.dqR = searchForum.avatar;
            this.dJy = searchForum.post_num;
            this.dJz = searchForum.concern_num;
            this.dJA = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.dJB = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.dqR;
    }

    public String aAE() {
        return this.dJz;
    }

    public String aAF() {
        return this.dJy;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String aAG() {
        return this.dJh;
    }
}
