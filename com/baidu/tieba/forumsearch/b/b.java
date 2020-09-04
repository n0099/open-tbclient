package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes18.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hRi = BdUniqueId.gen();
    private String hQJ;
    private String hRd;
    private String hRe;
    private String hRf;
    private boolean hRg;
    private List<FrsTabInfo> hRh;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.hQJ = str;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hRi;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.hRd = searchForum.post_num;
            this.hRe = searchForum.concern_num;
            this.hRf = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.hRg = searchForum.has_concerned.intValue() != 0;
            this.hRh = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String ckG() {
        return this.hRe;
    }

    public String ckH() {
        return this.hRd;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String ckI() {
        return this.hQJ;
    }

    public List<FrsTabInfo> ckJ() {
        return this.hRh;
    }
}
