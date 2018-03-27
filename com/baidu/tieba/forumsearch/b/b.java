package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dDn = BdUniqueId.gen();
    private String dCS;
    private String dDj;
    private String dDk;
    private String dDl;
    private boolean dDm;
    private String dpc;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.dCS = str;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dDn;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.dpc = searchForum.avatar;
            this.dDj = searchForum.post_num;
            this.dDk = searchForum.concern_num;
            this.dDl = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.dDm = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.dpc;
    }

    public String auq() {
        return this.dDk;
    }

    public String aur() {
        return this.dDj;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String aus() {
        return this.dCS;
    }
}
