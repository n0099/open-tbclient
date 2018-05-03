package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cWf = BdUniqueId.gen();
    private String cHn;
    private String cVK;
    private String cWb;
    private String cWc;
    private String cWd;
    private boolean cWe;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.cVK = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cWf;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.cHn = searchForum.avatar;
            this.cWb = searchForum.post_num;
            this.cWc = searchForum.concern_num;
            this.cWd = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.cWe = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.cHn;
    }

    public String aoF() {
        return this.cWc;
    }

    public String aoG() {
        return this.cWb;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String aoH() {
        return this.cVK;
    }
}
