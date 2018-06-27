package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId diq = BdUniqueId.gen();
    private String cPz;
    private String dhV;
    private String dim;
    private String din;
    private String dio;
    private boolean dip;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.dhV = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return diq;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.cPz = searchForum.avatar;
            this.dim = searchForum.post_num;
            this.din = searchForum.concern_num;
            this.dio = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.dip = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.cPz;
    }

    public String asU() {
        return this.din;
    }

    public String asV() {
        return this.dim;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String asW() {
        return this.dhV;
    }
}
