package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes22.dex */
public class j implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hWh = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private v hWi;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hWh;
    }

    public v cnA() {
        return this.hWi;
    }

    public void a(v vVar) {
        this.hWi = vVar;
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
