package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fsv = BdUniqueId.gen();
    private String eWo;
    private String frY;
    private String fsr;
    private String fss;
    private String fst;
    private boolean fsu;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.frY = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fsv;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.eWo = searchForum.avatar;
            this.fsr = searchForum.post_num;
            this.fss = searchForum.concern_num;
            this.fst = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.fsu = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.eWo;
    }

    public String bkT() {
        return this.fss;
    }

    public String bkU() {
        return this.fsr;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String bkV() {
        return this.frY;
    }
}
