package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gkL = BdUniqueId.gen();
    private String gkH;
    private String gkI;
    private String gkJ;
    private boolean gkK;
    private String gkm;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.gkm = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gkL;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.gkH = searchForum.post_num;
            this.gkI = searchForum.concern_num;
            this.gkJ = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.gkK = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String bBm() {
        return this.gkI;
    }

    public String bBn() {
        return this.gkH;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String bBo() {
        return this.gkm;
    }
}
