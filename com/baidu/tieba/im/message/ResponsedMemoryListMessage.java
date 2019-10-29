package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
public class ResponsedMemoryListMessage extends CustomResponsedMessage<List<ImMessageCenterPojo>> {
    private int type;

    public ResponsedMemoryListMessage(List<ImMessageCenterPojo> list, int i) {
        super(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, list);
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
