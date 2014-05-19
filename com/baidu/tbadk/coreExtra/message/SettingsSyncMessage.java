package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class SettingsSyncMessage extends CustomMessage<String> {
    public SettingsSyncMessage() {
        super(MessageTypes.MSG_SETTINGS_SYNC);
    }
}
