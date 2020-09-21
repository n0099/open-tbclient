package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes22.dex */
public class m implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hWs = BdUniqueId.gen();
    private String forumId;
    private String forumName;
    private boolean hVb = false;
    private MemberGroupInfo hWt;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hWs;
    }

    public MemberGroupInfo cnB() {
        return this.hWt;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.hWt = memberGroupInfo;
    }

    public void oc(boolean z) {
        this.hVb = z;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }
}
