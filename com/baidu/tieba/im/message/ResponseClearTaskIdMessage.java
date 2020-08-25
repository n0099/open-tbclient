package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class ResponseClearTaskIdMessage extends CustomResponsedMessage<Object> {
    public ResponseClearTaskIdMessage() {
        super(CmdConfigCustom.CMD_CLEAR_TASK_ID);
    }
}
