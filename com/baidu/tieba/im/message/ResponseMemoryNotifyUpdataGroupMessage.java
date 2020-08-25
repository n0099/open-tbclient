package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes2.dex */
public class ResponseMemoryNotifyUpdataGroupMessage extends CustomResponsedMessage<ImMessageCenterPojo> {
    public ResponseMemoryNotifyUpdataGroupMessage(ImMessageCenterPojo imMessageCenterPojo) {
        super(CmdConfigCustom.MEMORY_RESPONSE_NOTIFY_UPDATA_GROUP, imMessageCenterPojo);
    }
}
