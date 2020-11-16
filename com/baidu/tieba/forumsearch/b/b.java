package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes23.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId iGq = BdUniqueId.gen();
    private String iFR;
    private String iGl;
    private String iGm;
    private String iGn;
    private boolean iGo;
    private List<FrsTabInfo> iGp;
    private String mAvatar;
    private long mForumId;
    private String mForumName;
    private String mIntro;

    public b(String str) {
        this.iFR = str;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iGq;
    }

    public void a(SearchForum searchForum) {
        if (searchForum != null) {
            this.mForumId = searchForum.forum_id.longValue();
            this.mForumName = searchForum.forum_name;
            this.mAvatar = searchForum.avatar;
            this.iGl = searchForum.post_num;
            this.iGm = searchForum.concern_num;
            this.iGn = searchForum.slogan;
            this.mIntro = searchForum.intro;
            this.iGo = searchForum.has_concerned.intValue() != 0;
            this.iGp = searchForum.tab_info;
        }
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String cwB() {
        return this.iGm;
    }

    public String cwC() {
        return this.iGl;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public String cwD() {
        return this.iFR;
    }

    public List<FrsTabInfo> cwE() {
        return this.iGp;
    }
}
