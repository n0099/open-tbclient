package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
public class MemoryNotifyUpdataGroupMessage extends CustomResponsedMessage<ImMessageCenterPojo> {
    public MemoryNotifyUpdataGroupMessage(ImMessageCenterPojo imMessageCenterPojo) {
        super(CmdConfigCustom.MEMORY_NOTIFY_UPDATA_GROUP, imMessageCenterPojo);
    }
}
