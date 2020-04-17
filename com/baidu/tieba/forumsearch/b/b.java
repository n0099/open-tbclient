package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gWQ = BdUniqueId.gen();
    private String gWL;
    private String gWM;
    private String gWN;
    private boolean gWO;
    private List<FrsTabInfo> gWP;
    private String gWq;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.gWq = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gWQ;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.gWL = searchForum.post_num;
            this.gWM = searchForum.concern_num;
            this.gWN = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.gWO = searchForum.has_concerned.intValue() != 0;
            this.gWP = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String bNx() {
        return this.gWM;
    }

    public String bNy() {
        return this.gWL;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String bNz() {
        return this.gWq;
    }

    public List<FrsTabInfo> bNA() {
        return this.gWP;
    }
}
