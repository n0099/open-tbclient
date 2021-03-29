package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes3.dex */
public class ResponseMemoryNotifyUpdataGroupMessage extends CustomResponsedMessage<ImMessageCenterPojo> {
    public ResponseMemoryNotifyUpdataGroupMessage(ImMessageCenterPojo imMessageCenterPojo) {
        super(2016014, imMessageCenterPojo);
    }
}
