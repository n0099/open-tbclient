package com.baidu.tieba.capture;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class CaptureSupportStatic {
    static {
        MessageManager.getInstance().registerListener(new a(202006));
    }
}
