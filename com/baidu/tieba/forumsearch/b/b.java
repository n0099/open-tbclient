package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gnK = BdUniqueId.gen();
    private String gnF;
    private String gnG;
    private String gnH;
    private boolean gnI;
    private List<FrsTabInfo> gnJ;
    private String gnk;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.gnk = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gnK;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.gnF = searchForum.post_num;
            this.gnG = searchForum.concern_num;
            this.gnH = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.gnI = searchForum.has_concerned.intValue() != 0;
            this.gnJ = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String bCX() {
        return this.gnG;
    }

    public String bCY() {
        return this.gnF;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String bCZ() {
        return this.gnk;
    }

    public List<FrsTabInfo> bDa() {
        return this.gnJ;
    }
}
