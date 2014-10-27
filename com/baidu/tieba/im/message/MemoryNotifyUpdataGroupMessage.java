package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
public class MemoryNotifyUpdataGroupMessage extends CustomResponsedMessage<ImMessageCenterPojo> {
    public MemoryNotifyUpdataGroupMessage(ImMessageCenterPojo imMessageCenterPojo) {
        super(2016013, imMessageCenterPojo);
    }
}
