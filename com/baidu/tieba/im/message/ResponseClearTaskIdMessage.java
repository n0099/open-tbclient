package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ResponseClearTaskIdMessage extends CustomResponsedMessage<Object> {
    public ResponseClearTaskIdMessage() {
        super(CmdConfigCustom.CMD_CLEAR_TASK_ID);
    }
}
