package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dDk = BdUniqueId.gen();
    private String dCP;
    private String dDg;
    private String dDh;
    private String dDi;
    private boolean dDj;
    private String doZ;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.dCP = str;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dDk;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.doZ = searchForum.avatar;
            this.dDg = searchForum.post_num;
            this.dDh = searchForum.concern_num;
            this.dDi = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.dDj = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.doZ;
    }

    public String aup() {
        return this.dDh;
    }

    public String auq() {
        return this.dDg;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String aur() {
        return this.dCP;
    }
}
