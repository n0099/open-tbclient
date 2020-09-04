package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes17.dex */
public class j implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hPh = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private v hPi;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hPh;
    }

    public v ckn() {
        return this.hPi;
    }

    public void a(v vVar) {
        this.hPi = vVar;
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
