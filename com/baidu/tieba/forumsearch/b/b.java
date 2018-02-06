package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dDw = BdUniqueId.gen();
    private String dDb;
    private String dDs;
    private String dDt;
    private String dDu;
    private boolean dDv;
    private String dpl;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.dDb = str;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dDw;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.dpl = searchForum.avatar;
            this.dDs = searchForum.post_num;
            this.dDt = searchForum.concern_num;
            this.dDu = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.dDv = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.dpl;
    }

    public String auq() {
        return this.dDt;
    }

    public String aur() {
        return this.dDs;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String aus() {
        return this.dDb;
    }
}
