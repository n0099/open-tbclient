package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cWi = BdUniqueId.gen();
    private String cHq;
    private String cVN;
    private String cWe;
    private String cWf;
    private String cWg;
    private boolean cWh;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.cVN = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cWi;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.cHq = searchForum.avatar;
            this.cWe = searchForum.post_num;
            this.cWf = searchForum.concern_num;
            this.cWg = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.cWh = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.cHq;
    }

    public String aoF() {
        return this.cWf;
    }

    public String aoG() {
        return this.cWe;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String aoH() {
        return this.cVN;
    }
}
