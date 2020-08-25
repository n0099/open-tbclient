package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes18.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hRc = BdUniqueId.gen();
    private String hQD;
    private String hQX;
    private String hQY;
    private String hQZ;
    private boolean hRa;
    private List<FrsTabInfo> hRb;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.hQD = str;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hRc;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.hQX = searchForum.post_num;
            this.hQY = searchForum.concern_num;
            this.hQZ = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.hRa = searchForum.has_concerned.intValue() != 0;
            this.hRb = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String ckF() {
        return this.hQY;
    }

    public String ckG() {
        return this.hQX;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String ckH() {
        return this.hQD;
    }

    public List<FrsTabInfo> ckI() {
        return this.hRb;
    }
}
