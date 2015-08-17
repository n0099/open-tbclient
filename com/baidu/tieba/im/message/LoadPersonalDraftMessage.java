package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.message.LoadDraftMessage;
/* loaded from: classes.dex */
public class LoadPersonalDraftMessage extends LoadDraftMessage {
    public LoadPersonalDraftMessage(LoadDraftMessage.a aVar) {
        super(CmdConfigCustom.CMD_LOAD_DRAFT_PERSONAL, aVar);
    }
}
