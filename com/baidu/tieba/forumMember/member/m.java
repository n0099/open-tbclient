package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dxl = BdUniqueId.gen();
    private boolean dvU = false;
    private MemberGroupInfo dxm;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dxl;
    }

    public MemberGroupInfo ayn() {
        return this.dxm;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.dxm = memberGroupInfo;
    }

    public void fZ(boolean z) {
        this.dvU = z;
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
