package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes2.dex */
public class MemoryGetFromDBMessage extends CustomResponsedMessage<List<ImMessageCenterPojo>> {
    private String uid;

    public MemoryGetFromDBMessage(List<ImMessageCenterPojo> list, String str) {
        super(CmdConfigCustom.MEMORY_GET_FROM_DB, list);
        this.uid = str;
    }

    public String getUid() {
        return this.uid;
    }
}
