package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes7.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId iYP = BdUniqueId.gen();
    private String eMY;
    private String iYK;
    private String iYL;
    private String iYM;
    private boolean iYN;
    private List<FrsTabInfo> iYO;
    private String iYq;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.iYq = str;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iYP;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.eMY = searchForum.avatar;
            this.iYK = searchForum.post_num;
            this.iYL = searchForum.concern_num;
            this.iYM = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.iYN = searchForum.has_concerned.intValue() != 0;
            this.iYO = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.eMY;
    }

    public String czT() {
        return this.iYL;
    }

    public String czU() {
        return this.iYK;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String czV() {
        return this.iYq;
    }

    public List<FrsTabInfo> czW() {
        return this.iYO;
    }
}
