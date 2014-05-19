package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class GroupSaveDraftMessage extends SaveDraftMessage {
    public GroupSaveDraftMessage(g gVar) {
        super(MessageTypes.CMD_SAVE_DRAFT_GROUP, gVar);
    }
}
