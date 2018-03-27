package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId dBJ = BdUniqueId.gen();
    private boolean dAu = false;
    private MemberGroupInfo dBK;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dBJ;
    }

    public MemberGroupInfo atV() {
        return this.dBK;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.dBK = memberGroupInfo;
    }

    public void fE(boolean z) {
        this.dAu = z;
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
