package com.baidu.tbadk.coreExtra.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class SettingsSyncMessage extends CustomMessage<String> {
    public SettingsSyncMessage() {
        super(CmdConfigCustom.MSG_SETTINGS_SYNC);
    }
}
