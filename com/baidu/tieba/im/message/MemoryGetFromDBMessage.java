package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes3.dex */
public class MemoryGetFromDBMessage extends CustomResponsedMessage<List<ImMessageCenterPojo>> {
    public String uid;

    public MemoryGetFromDBMessage(List<ImMessageCenterPojo> list, String str) {
        super(2016008, list);
        this.uid = str;
    }

    public String getUid() {
        return this.uid;
    }
}
