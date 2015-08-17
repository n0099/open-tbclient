package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.message.SaveDraftMessage;
/* loaded from: classes.dex */
public class GroupSaveDraftMessage extends SaveDraftMessage {
    public GroupSaveDraftMessage(SaveDraftMessage.a aVar) {
        super(CmdConfigCustom.CMD_SAVE_DRAFT_GROUP, aVar);
    }
}
