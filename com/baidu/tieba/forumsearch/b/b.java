package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dAp = BdUniqueId.gen();
    private String dAl;
    private String dAm;
    private String dAn;
    private boolean dAo;
    private String dhs;
    private String dzU;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.dzU = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dAp;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.dhs = searchForum.avatar;
            this.dAl = searchForum.post_num;
            this.dAm = searchForum.concern_num;
            this.dAn = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.dAo = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.dhs;
    }

    public String ayf() {
        return this.dAm;
    }

    public String ayg() {
        return this.dAl;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String ayh() {
        return this.dzU;
    }
}
