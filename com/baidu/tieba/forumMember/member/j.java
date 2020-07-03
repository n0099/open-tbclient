package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes10.dex */
public class j implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hwa = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private u hwb;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hwa;
    }

    public u bWw() {
        return this.hwb;
    }

    public void a(u uVar) {
        this.hwb = uVar;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }
}
