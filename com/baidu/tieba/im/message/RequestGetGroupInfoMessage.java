package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class RequestGetGroupInfoMessage extends CustomResponsedMessage<Long> {
    public RequestGetGroupInfoMessage(Long l) {
        super(CmdConfigCustom.CMD_GET_GROUP_INFO, l);
    }
}
