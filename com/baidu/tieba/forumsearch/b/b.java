package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes8.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId jew = BdUniqueId.gen();
    private String ePk;
    private String jdX;
    private String jer;
    private String jes;
    private String jet;
    private boolean jeu;
    private List<FrsTabInfo> jev;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.jdX = str;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jew;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.ePk = searchForum.avatar;
            this.jer = searchForum.post_num;
            this.jes = searchForum.concern_num;
            this.jet = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.jeu = searchForum.has_concerned.intValue() != 0;
            this.jev = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.ePk;
    }

    public String cBe() {
        return this.jes;
    }

    public String cBf() {
        return this.jer;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String cBg() {
        return this.jdX;
    }

    public List<FrsTabInfo> cBh() {
        return this.jev;
    }
}
