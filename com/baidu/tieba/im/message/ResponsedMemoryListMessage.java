package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes3.dex */
public class ResponsedMemoryListMessage extends CustomResponsedMessage<List<ImMessageCenterPojo>> {
    public int type;

    public ResponsedMemoryListMessage(List<ImMessageCenterPojo> list, int i) {
        super(2016007, list);
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
