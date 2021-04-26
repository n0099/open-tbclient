package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes4.dex */
public class ResponsedMemoryListMessage extends CustomResponsedMessage<List<ImMessageCenterPojo>> {
    public int type;

    public ResponsedMemoryListMessage(List<ImMessageCenterPojo> list, int i2) {
        super(2016007, list);
        this.type = i2;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
