package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes5.dex */
public class ForumMemberReadCacheRequestMessage extends CustomMessage<Object> {
    private String forumName;

    public ForumMemberReadCacheRequestMessage() {
        super(2003009);
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }
}
