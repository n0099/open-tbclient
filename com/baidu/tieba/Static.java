package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
/* loaded from: classes.dex */
public class Static {
    private static final CustomMessageListener Sc = new ab(0);

    static {
        aj.wh();
        MessageManager.getInstance().registerListener(2005009, Sc);
        MessageManager.getInstance().registerListener(2005010, Sc);
        MessageManager.getInstance().registerListener(2005011, Sc);
        MessageManager.getInstance().registerListener(2005012, Sc);
        MessageManager.getInstance().registerListener(2005013, Sc);
        MessageManager.getInstance().registerListener(2005015, Sc);
    }
}
