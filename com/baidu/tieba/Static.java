package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
/* loaded from: classes.dex */
public class Static {
    private static final CustomMessageListener a = new aa(0);

    static {
        ai.a();
        MessageManager.getInstance().registerListener(2005009, a);
        MessageManager.getInstance().registerListener(2005010, a);
        MessageManager.getInstance().registerListener(2005011, a);
        MessageManager.getInstance().registerListener(2005012, a);
        MessageManager.getInstance().registerListener(2005013, a);
        MessageManager.getInstance().registerListener(2005015, a);
    }
}
