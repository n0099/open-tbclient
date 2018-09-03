package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dle = BdUniqueId.gen();
    private String cSf;
    private String dkJ;
    private String dla;
    private String dlb;
    private String dlc;
    private boolean dld;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.dkJ = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dle;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.cSf = searchForum.avatar;
            this.dla = searchForum.post_num;
            this.dlb = searchForum.concern_num;
            this.dlc = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.dld = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.cSf;
    }

    public String atx() {
        return this.dlb;
    }

    public String aty() {
        return this.dla;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String atz() {
        return this.dkJ;
    }
}
