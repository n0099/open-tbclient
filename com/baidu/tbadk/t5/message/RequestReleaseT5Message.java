package com.baidu.tbadk.t5.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class RequestReleaseT5Message extends CustomMessage<Object> {
    public RequestReleaseT5Message() {
        super(CmdConfigCustom.CMD_RELEASE_T5);
    }
}
