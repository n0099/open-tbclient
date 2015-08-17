package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ClearChatMsgResponsedMessage extends CustomResponsedMessage<Object> {
    public ClearChatMsgResponsedMessage() {
        super(CmdConfigCustom.CMD_DELETE_MSG);
    }
}
