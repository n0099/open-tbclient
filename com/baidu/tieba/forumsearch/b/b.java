package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dlg = BdUniqueId.gen();
    private String cSi;
    private String dkL;
    private String dlc;
    private String dld;
    private String dle;
    private boolean dlf;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.dkL = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dlg;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.cSi = searchForum.avatar;
            this.dlc = searchForum.post_num;
            this.dld = searchForum.concern_num;
            this.dle = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.dlf = searchForum.has_concerned.intValue() != 0;
        }
    }

    public String getAvatar() {
        return this.cSi;
    }

    public String aty() {
        return this.dld;
    }

    public String atz() {
        return this.dlc;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String atA() {
        return this.dkL;
    }
}
