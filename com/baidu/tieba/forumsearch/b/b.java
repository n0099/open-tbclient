package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes24.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId izF = BdUniqueId.gen();
    private String izA;
    private String izB;
    private String izC;
    private boolean izD;
    private List<FrsTabInfo> izE;
    private String izg;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.izg = str;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return izF;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.izA = searchForum.post_num;
            this.izB = searchForum.concern_num;
            this.izC = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.izD = searchForum.has_concerned.intValue() != 0;
            this.izE = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String cuy() {
        return this.izB;
    }

    public String cuz() {
        return this.izA;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String cuA() {
        return this.izg;
    }

    public List<FrsTabInfo> cuB() {
        return this.izE;
    }
}
