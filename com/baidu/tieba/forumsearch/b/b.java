package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fsU = BdUniqueId.gen();
    private String eWy;
    private String fsQ;
    private String fsR;
    private String fsS;
    private boolean fsT;
    private String fsx;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.fsx = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fsU;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.eWy = searchForum.avatar;
            this.fsQ = searchForum.post_num;
            this.fsR = searchForum.concern_num;
            this.fsS = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.fsT = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.eWy;
    }

    public String bla() {
        return this.fsR;
    }

    public String blb() {
        return this.fsQ;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String blc() {
        return this.fsx;
    }
}
