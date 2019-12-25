package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes7.dex */
public class ClearGroupInfoCacheMessage extends CustomMessage<String> {
    public ClearGroupInfoCacheMessage() {
        super(CmdConfigCustom.CMD_CLEAR_GROUP_INFO);
    }
}
