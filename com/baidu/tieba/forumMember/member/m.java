package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dpj = BdUniqueId.gen();
    private boolean dnR = false;
    private MemberGroupInfo dpk;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dpj;
    }

    public MemberGroupInfo auQ() {
        return this.dpk;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.dpk = memberGroupInfo;
    }

    public void fH(boolean z) {
        this.dnR = z;
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
