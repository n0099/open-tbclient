package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes23.dex */
public class j implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId iPh = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private w iPi;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iPh;
    }

    public w cAy() {
        return this.iPi;
    }

    public void a(w wVar) {
        this.iPi = wVar;
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
