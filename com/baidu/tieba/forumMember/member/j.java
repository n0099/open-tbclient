package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes17.dex */
public class j implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hPb = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private v hPc;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hPb;
    }

    public v ckm() {
        return this.hPc;
    }

    public void a(v vVar) {
        this.hPc = vVar;
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
