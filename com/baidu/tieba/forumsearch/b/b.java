package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes8.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId jeK = BdUniqueId.gen();
    private String ePk;
    private String jeF;
    private String jeG;
    private String jeH;
    private boolean jeI;
    private List<FrsTabInfo> jeJ;
    private String jel;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.jel = str;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jeK;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.ePk = searchForum.avatar;
            this.jeF = searchForum.post_num;
            this.jeG = searchForum.concern_num;
            this.jeH = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.jeI = searchForum.has_concerned.intValue() != 0;
            this.jeJ = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.ePk;
    }

    public String cBl() {
        return this.jeG;
    }

    public String cBm() {
        return this.jeF;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String cBn() {
        return this.jel;
    }

    public List<FrsTabInfo> cBo() {
        return this.jeJ;
    }
}
