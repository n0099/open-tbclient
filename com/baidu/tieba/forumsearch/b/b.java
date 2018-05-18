package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cXm = BdUniqueId.gen();
    private String cIw;
    private String cWR;
    private String cXi;
    private String cXj;
    private String cXk;
    private boolean cXl;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.cWR = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cXm;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.cIw = searchForum.avatar;
            this.cXi = searchForum.post_num;
            this.cXj = searchForum.concern_num;
            this.cXk = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.cXl = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.cIw;
    }

    public String aoE() {
        return this.cXj;
    }

    public String aoF() {
        return this.cXi;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String aoG() {
        return this.cWR;
    }
}
