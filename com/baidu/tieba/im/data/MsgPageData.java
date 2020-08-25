package com.baidu.tieba.im.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MsgPageData extends OrmObject implements Serializable {
    private static final long serialVersionUID = -7666708726763728750L;
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
