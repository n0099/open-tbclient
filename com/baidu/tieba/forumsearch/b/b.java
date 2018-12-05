package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dGO = BdUniqueId.gen();
    private String dGK;
    private String dGL;
    private String dGM;
    private boolean dGN;
    private String dGt;
    private String doa;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.dGt = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dGO;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.doa = searchForum.avatar;
            this.dGK = searchForum.post_num;
            this.dGL = searchForum.concern_num;
            this.dGM = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.dGN = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.doa;
    }

    public String azP() {
        return this.dGL;
    }

    public String azQ() {
        return this.dGK;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String azR() {
        return this.dGt;
    }
}
