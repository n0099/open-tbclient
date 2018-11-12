package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class m implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dyD = BdUniqueId.gen();
    private boolean dxm = false;
    private MemberGroupInfo dyE;
    private String forumId;
    private String forumName;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dyD;
    }

    public MemberGroupInfo axK() {
        return this.dyE;
    }

    public void a(MemberGroupInfo memberGroupInfo) {
        this.dyE = memberGroupInfo;
    }

    public void gj(boolean z) {
        this.dxm = z;
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
