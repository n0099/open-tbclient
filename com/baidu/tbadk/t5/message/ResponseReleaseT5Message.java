package com.baidu.tbadk.t5.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ResponseReleaseT5Message extends CustomResponsedMessage<Object> {
    public ResponseReleaseT5Message() {
        super(CmdConfigCustom.CMD_RELEASE_T5);
    }
}
