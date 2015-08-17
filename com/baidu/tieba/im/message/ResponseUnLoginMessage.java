package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ResponseUnLoginMessage extends CustomResponsedMessage<Object> {
    public ResponseUnLoginMessage() {
        super(CmdConfigCustom.CMD_UN_LOGIN);
    }
}
