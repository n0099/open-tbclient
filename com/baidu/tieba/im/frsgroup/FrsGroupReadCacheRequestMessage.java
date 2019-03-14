package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes5.dex */
public class FrsGroupReadCacheRequestMessage extends CustomMessage<Object> {
    private String forumName;
    private int type;

    public FrsGroupReadCacheRequestMessage() {
        super(2001204);
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }
}
