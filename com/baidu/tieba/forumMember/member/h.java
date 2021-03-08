package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes7.dex */
public class h implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId jes = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private w jet;

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jes;
    }

    public w cAZ() {
        return this.jet;
    }

    public void a(w wVar) {
        this.jet = wVar;
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
