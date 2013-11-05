package com.baidu.tieba.im.data;

import com.baidu.tieba.im.message.ChatMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MsgPageData implements Serializable {
    private boolean isNewAdd = false;
    private int newAddNum = 0;
    private List<ChatMessage> mChatMessages = new ArrayList();

    public boolean getIsNewAdd() {
        return this.isNewAdd;
    }

    public void setIsNewAdd(boolean z) {
        this.isNewAdd = z;
    }

    public List<ChatMessage> getChatMessages() {
        return this.mChatMessages;
    }

    public void setChatMessages(List<ChatMessage> list) {
        this.mChatMessages = list;
    }

    public int getNewAddNum() {
        return this.newAddNum;
    }

    public void setNewAddNum(int i) {
        this.newAddNum = i;
    }
}
