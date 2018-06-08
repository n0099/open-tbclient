package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dgz = BdUniqueId.gen();
    private String cRD;
    private String dge;
    private String dgv;
    private String dgw;
    private String dgx;
    private boolean dgy;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.dge = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dgz;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.cRD = searchForum.avatar;
            this.dgv = searchForum.post_num;
            this.dgw = searchForum.concern_num;
            this.dgx = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.dgy = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.cRD;
    }

    public String asJ() {
        return this.dgw;
    }

    public String asK() {
        return this.dgv;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String asL() {
        return this.dge;
    }
}
