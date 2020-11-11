package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes24.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId iFC = BdUniqueId.gen();
    private boolean iFA;
    private List<FrsTabInfo> iFB;
    private String iFd;
    private String iFx;
    private String iFy;
    private String iFz;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.iFd = str;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iFC;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.iFx = searchForum.post_num;
            this.iFy = searchForum.concern_num;
            this.iFz = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.iFA = searchForum.has_concerned.intValue() != 0;
            this.iFB = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String cwZ() {
        return this.iFy;
    }

    public String cxa() {
        return this.iFx;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String cxb() {
        return this.iFd;
    }

    public List<FrsTabInfo> cxc() {
        return this.iFB;
    }
}
