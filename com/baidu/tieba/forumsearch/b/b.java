package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dyY = BdUniqueId.gen();
    private String dgn;
    private String dyD;
    private String dyU;
    private String dyV;
    private String dyW;
    private boolean dyX;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.dyD = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dyY;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.dgn = searchForum.avatar;
            this.dyU = searchForum.post_num;
            this.dyV = searchForum.concern_num;
            this.dyW = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.dyX = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.dgn;
    }

    public String ayH() {
        return this.dyV;
    }

    public String ayI() {
        return this.dyU;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String ayJ() {
        return this.dyD;
    }
}
