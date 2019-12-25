package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.message.SaveDraftMessage;
/* loaded from: classes5.dex */
public class GroupSaveDraftMessage extends SaveDraftMessage {
    public GroupSaveDraftMessage(SaveDraftMessage.a aVar) {
        super(CmdConfigCustom.CMD_SAVE_DRAFT_GROUP, aVar);
    }
}
