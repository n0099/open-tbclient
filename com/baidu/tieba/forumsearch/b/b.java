package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gnb = BdUniqueId.gen();
    private String gmC;
    private String gmX;
    private String gmY;
    private String gmZ;
    private boolean gna;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.gmC = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gnb;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.gmX = searchForum.post_num;
            this.gmY = searchForum.concern_num;
            this.gmZ = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.gna = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String bCR() {
        return this.gmY;
    }

    public String bCS() {
        return this.gmX;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String bCT() {
        return this.gmC;
    }
}
