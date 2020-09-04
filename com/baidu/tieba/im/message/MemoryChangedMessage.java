package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
public class MemoryChangedMessage extends CustomResponsedMessage<ImMessageCenterPojo> {
    public static final int TYPE_DELETE = 2;
    public static final int TYPE_INSERT_OR_UPDATE = 1;
    private boolean isFromServer;
    private int type;

    public MemoryChangedMessage(ImMessageCenterPojo imMessageCenterPojo, boolean z, int i) {
        super(CmdConfigCustom.MEMORY_CHANGED, imMessageCenterPojo);
        this.isFromServer = z;
        this.type = i;
    }

    public boolean isFromServer() {
        return this.isFromServer;
    }

    public int getType() {
        return this.type;
    }
}
