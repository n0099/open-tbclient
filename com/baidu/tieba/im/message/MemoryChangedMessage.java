package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes3.dex */
public class MemoryChangedMessage extends CustomResponsedMessage<ImMessageCenterPojo> {
    public static final int TYPE_DELETE = 2;
    public static final int TYPE_INSERT_OR_UPDATE = 1;
    public boolean isFromServer;
    public int type;

    public MemoryChangedMessage(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        super(2016004, imMessageCenterPojo);
        this.isFromServer = z;
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public boolean isFromServer() {
        return this.isFromServer;
    }
}
