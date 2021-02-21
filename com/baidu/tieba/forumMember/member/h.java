package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes8.dex */
public class h implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jcJ = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private w jcK;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jcJ;
    }

    public w cAT() {
        return this.jcK;
    }

    public void a(w wVar) {
        this.jcK = wVar;
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
