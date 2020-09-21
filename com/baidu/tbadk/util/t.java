package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class t {
    public static final <T extends IntentConfig> void b(T t) {
        a(CmdConfigCustom.START_GO_ACTION, t);
    }

    public static final <T extends IntentConfig> void a(int i, T t) {
        MessageManager.getInstance().sendMessage(new CustomMessage(i, t));
    }
}
