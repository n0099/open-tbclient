package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hlI = BdUniqueId.gen();
    private String hlD;
    private String hlE;
    private String hlF;
    private boolean hlG;
    private List<FrsTabInfo> hlH;
    private String hli;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.hli = str;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hlI;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.hlD = searchForum.post_num;
            this.hlE = searchForum.concern_num;
            this.hlF = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.hlG = searchForum.has_concerned.intValue() != 0;
            this.hlH = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String bTR() {
        return this.hlE;
    }

    public String bTS() {
        return this.hlD;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String bTT() {
        return this.hli;
    }

    public List<FrsTabInfo> bTU() {
        return this.hlH;
    }
}
