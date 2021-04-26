package com.baidu.tieba.im.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MsgPageData extends OrmObject implements Serializable {
    public static final long serialVersionUID = -7666708726763728750L;
    public boolean isNewAdd = false;
    public int newAddNum = 0;
    public List<ChatMessage> mChatMessages = new ArrayList();

    public List<ChatMessage> getChatMessages() {
        return this.mChatMessages;
    }

    public boolean getIsNewAdd() {
        return this.isNewAdd;
    }

    public int getNewAddNum() {
        return this.newAddNum;
    }

    public void setChatMessages(List<ChatMessage> list) {
        this.mChatMessages = list;
    }

    public void setIsNewAdd(boolean z) {
        this.isNewAdd = z;
    }

    public void setNewAddNum(int i2) {
        this.newAddNum = i2;
    }
}
