package com.baidu.tbadk.coreExtra.download;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class CancelDownloadMessage extends CustomResponsedMessage<Boolean> {
    public CancelDownloadMessage(Boolean bool) {
        super(MessageTypes.CMD_CANCEL_FILE_DOWNLOAD, bool);
    }
}
