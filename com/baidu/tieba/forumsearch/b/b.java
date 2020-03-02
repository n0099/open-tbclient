package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gmO = BdUniqueId.gen();
    private String gmK;
    private String gmL;
    private String gmM;
    private boolean gmN;
    private String gmp;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.gmp = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gmO;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.gmK = searchForum.post_num;
            this.gmL = searchForum.concern_num;
            this.gmM = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.gmN = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String bCQ() {
        return this.gmL;
    }

    public String bCR() {
        return this.gmK;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String bCS() {
        return this.gmp;
    }
}
