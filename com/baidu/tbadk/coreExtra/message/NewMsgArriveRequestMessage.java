package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public class NewMsgArriveRequestMessage extends CustomMessage<Integer> {
    public NewMsgArriveRequestMessage(int i) {
        super(2012111, Integer.valueOf(i));
    }
}
