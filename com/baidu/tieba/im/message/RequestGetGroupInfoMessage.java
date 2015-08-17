package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class RequestGetGroupInfoMessage extends CustomResponsedMessage<Long> {
    public RequestGetGroupInfoMessage(Long l) {
        super(CmdConfigCustom.CMD_GET_GROUP_INFO, l);
    }
}
