package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dqX = BdUniqueId.gen();
    private String cXW;
    private String dqC;
    private String dqT;
    private String dqU;
    private String dqV;
    private boolean dqW;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.dqC = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dqX;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.cXW = searchForum.avatar;
            this.dqT = searchForum.post_num;
            this.dqU = searchForum.concern_num;
            this.dqV = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.dqW = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.cXW;
    }

    public String avl() {
        return this.dqU;
    }

    public String avm() {
        return this.dqT;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String avn() {
        return this.dqC;
    }
}
