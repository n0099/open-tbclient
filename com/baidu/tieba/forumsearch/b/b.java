package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fuH = BdUniqueId.gen();
    private String eYe;
    private String fuD;
    private String fuE;
    private String fuF;
    private boolean fuG;
    private String fuk;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.fuk = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fuH;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.eYe = searchForum.avatar;
            this.fuD = searchForum.post_num;
            this.fuE = searchForum.concern_num;
            this.fuF = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.fuG = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.eYe;
    }

    public String blL() {
        return this.fuE;
    }

    public String blM() {
        return this.fuD;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String blN() {
        return this.fuk;
    }
}
