package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gWW = BdUniqueId.gen();
    private String gWR;
    private String gWS;
    private String gWT;
    private boolean gWU;
    private List<FrsTabInfo> gWV;
    private String gWw;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.gWw = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gWW;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.gWR = searchForum.post_num;
            this.gWS = searchForum.concern_num;
            this.gWT = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.gWU = searchForum.has_concerned.intValue() != 0;
            this.gWV = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String bNv() {
        return this.gWS;
    }

    public String bNw() {
        return this.gWR;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String bNx() {
        return this.gWw;
    }

    public List<FrsTabInfo> bNy() {
        return this.gWV;
    }
}
