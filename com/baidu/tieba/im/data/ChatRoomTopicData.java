package com.baidu.tieba.im.data;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ChatRoomTopicData implements Serializable {
    private static final long serialVersionUID = 1;
    private String mContent;
    private String mTitle;

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getContent() {
        return this.mContent;
    }
}
