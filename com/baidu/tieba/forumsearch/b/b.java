package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hlT = BdUniqueId.gen();
    private String hlO;
    private String hlP;
    private String hlQ;
    private boolean hlR;
    private List<FrsTabInfo> hlS;
    private String hlt;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.hlt = str;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hlT;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.hlO = searchForum.post_num;
            this.hlP = searchForum.concern_num;
            this.hlQ = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.hlR = searchForum.has_concerned.intValue() != 0;
            this.hlS = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String bTT() {
        return this.hlP;
    }

    public String bTU() {
        return this.hlO;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String bTV() {
        return this.hlt;
    }

    public List<FrsTabInfo> bTW() {
        return this.hlS;
    }
}
