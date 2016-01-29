package com.baidu.tieba.im.push;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.squareup.wire.Wire;
import java.util.LinkedList;
import protobuf.PushMessage.PushMessageResIdl;
/* loaded from: classes.dex */
public class PushResponseMessage extends ResponsePullMessage {
    public PushResponseMessage() {
        super(202009);
    }

    @Override // com.baidu.tieba.im.message.ResponsePullMessage
    protected boolean isPulledMessage() {
        return false;
    }

    @Override // com.baidu.tieba.im.message.ResponsePullMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        BdLog.e("cmd " + i);
        PushMessageResIdl pushMessageResIdl = (PushMessageResIdl) new Wire(new Class[0]).parseFrom(bArr, PushMessageResIdl.class);
        if (pushMessageResIdl.data != null && pushMessageResIdl.data.msgs != null && pushMessageResIdl.data.msgs.data != null && pushMessageResIdl.data.msgs.data.msgInfo != null) {
            TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp().getApplicationContext(), "push_content_receive", null);
            setGroupMsg(new LinkedList());
            MessageUtils.generatePushData(getGroupMsg(), 30, pushMessageResIdl.data.msgs.data.msgInfo, pushMessageResIdl.data.msgs.data.groupId);
        }
    }
}
