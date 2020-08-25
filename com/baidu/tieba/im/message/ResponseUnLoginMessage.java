package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class ResponseUnLoginMessage extends CustomResponsedMessage<Object> {
    public ResponseUnLoginMessage() {
        super(CmdConfigCustom.CMD_UN_LOGIN);
    }
}
