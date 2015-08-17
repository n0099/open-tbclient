package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewMsgArriveRequestMessage extends CustomMessage<Integer> {
    public NewMsgArriveRequestMessage(int i) {
        super((int) CmdConfigCustom.MSG_NEW, Integer.valueOf(i));
    }
}
