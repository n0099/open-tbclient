package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class ClearGroupInfoCacheMessage extends CustomMessage<String> {
    public ClearGroupInfoCacheMessage() {
        super(MessageTypes.CMD_CLEAR_GROUP_INFO);
    }
}
