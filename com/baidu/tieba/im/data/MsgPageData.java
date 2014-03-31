package com.baidu.tieba.im.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MsgPageData implements Serializable {
    private static final long serialVersionUID = -7666708726763728750L;
    private boolean isNewAdd = false;
    private int newAddNum = 0;
    private List<com.baidu.tieba.im.message.a.a> mChatMessages = new ArrayList();

    public boolean getIsNewAdd() {
        return this.isNewAdd;
    }

    public void setIsNewAdd(boolean z) {
        this.isNewAdd = z;
    }

    public List<com.baidu.tieba.im.message.a.a> getChatMessages() {
        return this.mChatMessages;
    }

    public void setChatMessages(List<com.baidu.tieba.im.message.a.a> list) {
        this.mChatMessages = list;
    }

    public int getNewAddNum() {
        return this.newAddNum;
    }

    public void setNewAddNum(int i) {
        this.newAddNum = i;
    }
}
