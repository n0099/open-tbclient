package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class m {
    public static final <T extends IntentConfig> void a(T t) {
        a(2002001, t);
    }

    public static final <T extends IntentConfig> void a(int i, T t) {
        MessageManager.getInstance().sendMessage(new CustomMessage(i, t));
    }
}
