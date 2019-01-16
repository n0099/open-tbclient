package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dKl = BdUniqueId.gen();
    private String dJQ;
    private String dKh;
    private String dKi;
    private String dKj;
    private boolean dKk;
    private String drD;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.dJQ = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dKl;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.drD = searchForum.avatar;
            this.dKh = searchForum.post_num;
            this.dKi = searchForum.concern_num;
            this.dKj = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.dKk = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.drD;
    }

    public String aBb() {
        return this.dKi;
    }

    public String aBc() {
        return this.dKh;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String aBd() {
        return this.dJQ;
    }
}
