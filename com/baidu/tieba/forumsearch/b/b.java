package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes24.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ini = BdUniqueId.gen();
    private String imJ;
    private String ind;
    private String ine;
    private String inf;
    private boolean ing;
    private List<FrsTabInfo> inh;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.imJ = str;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ini;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.ind = searchForum.post_num;
            this.ine = searchForum.concern_num;
            this.inf = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.ing = searchForum.has_concerned.intValue() != 0;
            this.inh = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String crr() {
        return this.ine;
    }

    public String crs() {
        return this.ind;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String crt() {
        return this.imJ;
    }

    public List<FrsTabInfo> cru() {
        return this.inh;
    }
}
