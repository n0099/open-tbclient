package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dKm = BdUniqueId.gen();
    private String dJR;
    private String dKi;
    private String dKj;
    private String dKk;
    private boolean dKl;
    private String drE;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.dJR = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dKm;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.drE = searchForum.avatar;
            this.dKi = searchForum.post_num;
            this.dKj = searchForum.concern_num;
            this.dKk = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.dKl = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.drE;
    }

    public String aBb() {
        return this.dKj;
    }

    public String aBc() {
        return this.dKi;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String aBd() {
        return this.dJR;
    }
}
