package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public class i {
    public static final <T extends com.baidu.tbadk.core.frameworkData.c> void c(T t) {
        a(2002001, t);
    }

    public static final <T extends com.baidu.tbadk.core.frameworkData.c> void a(int i, T t) {
        MessageManager.getInstance().sendMessage(new CustomMessage(i, t));
    }
}
