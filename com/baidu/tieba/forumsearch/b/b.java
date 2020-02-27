package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gmM = BdUniqueId.gen();
    private String gmI;
    private String gmJ;
    private String gmK;
    private boolean gmL;
    private String gmn;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.gmn = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gmM;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.gmI = searchForum.post_num;
            this.gmJ = searchForum.concern_num;
            this.gmK = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.gmL = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String bCO() {
        return this.gmJ;
    }

    public String bCP() {
        return this.gmI;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String bCQ() {
        return this.gmn;
    }
}
