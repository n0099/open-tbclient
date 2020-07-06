package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hya = BdUniqueId.gen();
    private String hxA;
    private String hxV;
    private String hxW;
    private String hxX;
    private boolean hxY;
    private List<FrsTabInfo> hxZ;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.hxA = str;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hya;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.hxV = searchForum.post_num;
            this.hxW = searchForum.concern_num;
            this.hxX = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.hxY = searchForum.has_concerned.intValue() != 0;
            this.hxZ = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String bWQ() {
        return this.hxW;
    }

    public String bWR() {
        return this.hxV;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String bWS() {
        return this.hxA;
    }

    public List<FrsTabInfo> bWT() {
        return this.hxZ;
    }
}
