package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class ClearChatMsgResponsedMessage extends CustomResponsedMessage<Object> {
    public ClearChatMsgResponsedMessage() {
        super(CmdConfigCustom.CMD_DELETE_MSG);
    }
}
